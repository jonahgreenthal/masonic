<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.apache.commons.lang3.Validate" %>
<%@ page import="org.apache.commons.lang3.tuple.Pair" %>
<%@ page import="com.siliconage.util.Tally" %>
<%@ page import="com.siliconage.util.WebDataFilter" %>
<%@ page import="com.opal.DatabaseQuery" %>
<%@ page import="com.opal.ImplicitTableDatabaseQuery" %>
<%@ page import="com.masonic.application.*" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.Utility" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Progress" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"progress\") %>" />
	<jsp:param name="h1" value="Progress" />
</jsp:include><%

List<PacketSet> lclIncompleteSets = PacketSetFactory.getInstance().acquireForQuery(
	new ArrayList<>(),
	new ImplicitTableDatabaseQuery("completed = false ORDER BY deadline")
);

if (lclIncompleteSets.isEmpty()) {
	%><div class="row">
		<div class="small-12 columns">
			<p>All packet sets are marked as complete.</p>
		</div>
	</div><%
} else {
	Collection<QuestionStatus> lclChosenStatuses = QuestionStatusFactory.getInstance().multipleFromHttpRequest(request);
	if (lclChosenStatuses.isEmpty()) {
		lclChosenStatuses = QuestionStatusFactory.getInstance().acquireAll(new ArrayList<>());
		lclChosenStatuses.remove(QuestionStatusFactory.ANSWER_CHOSEN());
	}
	Validate.notEmpty(lclChosenStatuses);
	
	QuestionStatus[] lclAllStatuses = QuestionStatusFactory.getInstance().createAllArray();
	Arrays.sort(lclAllStatuses);
	
	%><div class="row">
		<div class="small-12 columns text-center">
			<form action="progress.jsp" method="get">
				<p>
					Consider questions whose status is...
					&nbsp;&nbsp;&nbsp;&nbsp;<%
					for (QuestionStatus lclS : lclAllStatuses) {
						%><label class="my-inline">
							<input type="checkbox" name="question_status_code" value="<%= lclS.getCode() %>"<%= lclChosenStatuses.contains(lclS) ? " checked=\"checked\"" : "" %> />&nbsp;<%= lclS.getName() %>
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;<%
					}
					%><input type="submit" value="Recalculate" />
				</p>
			</form>
		</div>
	</div><%
	
	List<Question> lclUnusedQuestions = QuestionFactory.getInstance().acquireForQuery(
		new ArrayList<>(),
		new DatabaseQuery(
			"SELECT Q.* FROM Question Q WHERE " +
			"( " +
				"id NOT IN (SELECT question_id FROM Placement WHERE question_id IS NOT NULL) OR " +
				"id IN (SELECT question_id FROM Placement PL JOIN Section S ON PL.section_id = S.id JOIN Packet P ON S.packet_id = P.id JOIN Packet_Set PS ON P.packet_set_code= PS.code WHERE PS.completed = false) " + 
			") AND question_status_code IN (" + Utility.nParameters(lclChosenStatuses.size()) + ")",
			lclChosenStatuses.stream().map(QuestionStatus::getCode).collect(Collectors.toList())
		)
	);
	
	Tally<Category> lclTUWritten = new Tally<>();
	Tally<Category> lclTQWritten = new Tally<>();
	for (Question lclQ : lclUnusedQuestions) {
		if (lclQ instanceof Tossup) {
			lclTUWritten.tally(lclQ.getCategory());
		} else if (lclQ instanceof TeamQuestion) {
			lclTQWritten.tally(lclQ.getCategory());
		} else {
			throw new IllegalArgumentException("Unknown question type " + lclQ.getQuestionType().getCode() + " for question #" + lclQ.getId());
		}
	}
	
	Tally<Category> lclTUNeeded = new Tally<>();
	Tally<Category> lclTQNeeded = new Tally<>();
	for (PacketSet lclPS : lclIncompleteSets) {
		for (Packet lclP : lclPS.createPacketArray()) {
			for (Section lclS : lclP.createSectionArray()) {
				for (Placement lclPL : lclS.createPlacementArray()) {
					if (lclS.getQuestionType() == QuestionTypeFactory.TOSSUP()) {
						lclTUNeeded.tally(lclPL.getCategory());
					} else if (lclS.getQuestionType() == QuestionTypeFactory.TEAM_QUESTION()) {
						lclTQNeeded.tally(lclPL.getCategory());
					} else {
						throw new IllegalArgumentException("Unknown question type " + lclS.getQuestionType().getCode() + " for section #" + lclS.getId());
					}
				}
			}
		}
	}
	
	Set<Category> lclAllRelevantCategories = new HashSet<>(lclTUNeeded.keyList());
	lclAllRelevantCategories.addAll(lclTQNeeded.keyList());
	
	List<CategoryGroup> lclCategoryGroups = lclAllRelevantCategories.stream()
		.map(Category::getCategoryGroup)
		.distinct()
		.sorted(CategoryGroup.SequenceComparator.getInstance())
		.collect(Collectors.toList());
	
	 %><div class="row">
		<div class="small-12 columns"><%
			if (lclIncompleteSets.size() > 1) {
				%><p>The following packet sets are currently being worked on:</p>
				<ol><%
					for (PacketSet lclPS : lclIncompleteSets) {
						%><li><%= lclPS.getName() %>, which is due on <%= DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(lclPS.getDeadline()) %></li><%
					}
				%></ol><%
			}
			
			NumberFormat lclPct = new DecimalFormat("0.0%");
			NumberFormat lclIntPct = new DecimalFormat("#%");
			
			for (CategoryGroup lclCG : lclCategoryGroups) {
				%><h2><%= lclCG.getName() %></h2>
				<table class="responsive full-width">
					<thead>
						<tr>
							<th>&nbsp;</th><!-- Category -->
							
							<th colspan="4">Tossups</th>
							
							<th>&nbsp;</th><!-- spacer -->
							
							<th colspan="4">Team Questions</th>
						</tr>
						<tr>
							<th style="width: 20%">Category</th>
							
							<th style="width:  5%">Written</th>
							<th style="width:  5%">Needed</th>
							<th style="width: 10%">Completion</th>
							<th style="width: 15%">&nbsp;</th><!-- progress bar -->
							
							<th style="width: 10%">&nbsp;</th><!-- spacer -->
							
							<th style="width:  5%">Written</th>
							<th style="width:  5%">Needed</th>
							<th style="width: 10%">Completion</th>
							<th style="width: 15%">&nbsp;</th><!-- progress bar -->
						</tr>
					</thead>
					<tbody><%
						Category[] lclCs = lclCG.createCategoryArray();
						Arrays.sort(lclCs, Category.StandardComparator.getInstance());
						
						int lclTUWrittenThisCG = 0;
						int lclTUNeededThisCG = 0;
						int lclTQWrittenThisCG = 0;
						int lclTQNeededThisCG = 0;
						for (Category lclC : lclCs) {
							if (lclAllRelevantCategories.contains(lclC)) {
								Validate.isTrue(lclTUWritten.get(lclC) >= 0);
								Validate.isTrue(lclTQWritten.get(lclC) >= 0);
								Validate.isTrue(lclTUNeeded.get(lclC) + lclTQNeeded.get(lclC) > 0);
								
								int lclTUWrittenThisCategory = lclTUWritten.get(lclC);
								int lclTUNeededThisCategory = lclTUNeeded.get(lclC);
								int lclTQWrittenThisCategory = lclTQWritten.get(lclC);
								int lclTQNeededThisCategory = lclTQNeeded.get(lclC);
								
								double lclTUCompletion = 1.0d * lclTUWrittenThisCategory / lclTUNeededThisCategory;
								double lclTQCompletion = 1.0d * lclTQWrittenThisCategory / lclTQNeededThisCategory;
								
								String lclWorstClass = determineClass(lclTUCompletion, lclTQCompletion);
								
								%><tr>
									<td class="<%= lclWorstClass %>"><%= lclC.getName() %></td><%
									
									if (lclTUNeededThisCategory > 0) {
										String lclTUClass = determineClass(lclTUCompletion);
										%><td class="<%= lclTUClass %>"><%= lclTUWrittenThisCategory %></td>
										<td class="<%= lclTUClass %>"><%= lclTUNeededThisCategory %></td>
										<td class="<%= lclTUClass %>"><%= lclPct.format(lclTUCompletion) %></td>
										<td class="<%= lclTUClass %>">
											<div class="progress">
												<span class="meter" style="width: <%= lclIntPct.format(lclTUCompletion) %>;"></span>
											</div>
										</td><%
									} else {
										%><td class="info" colspan="4">&nbsp;</td><%
									}
									
									%><td>&nbsp;</td><!-- spacer --><%
									
									if (lclTQNeededThisCategory > 0) {
										String lclTQClass = determineClass(lclTQCompletion);
										%><td class="<%= lclTQClass %>"><%= lclTQWrittenThisCategory %></td>
										<td class="<%= lclTQClass %>"><%= lclTQNeededThisCategory %></td>
										<td class="<%= lclTQClass %>"><%= lclPct.format(lclTQCompletion) %></td>
										<td class="<%= lclTQClass %>">
											<div class="progress">
												<span class="meter" style="width: <%= lclIntPct.format(lclTQCompletion) %>;"></span>
											</div>
										</td><%
									} else {
										%><td class="info" colspan="4">&nbsp;</td><%
									}
								%></tr><%
								
								lclTUWrittenThisCG += lclTUWrittenThisCategory;
								lclTUNeededThisCG += lclTUNeededThisCategory;
								lclTQWrittenThisCG += lclTQWrittenThisCategory;
								lclTQNeededThisCG += lclTQNeededThisCategory;
							}
						}
					%></tbody><%
					if (lclCs.length > 1) {
						Validate.isTrue(lclTUWrittenThisCG >= 0);
						Validate.isTrue(lclTQWrittenThisCG >= 0);
						Validate.isTrue(lclTUNeededThisCG + lclTQNeededThisCG > 0);
						
						double lclTUCompletion = 1.0d * lclTUWrittenThisCG / lclTUNeededThisCG;
						double lclTQCompletion = 1.0d * lclTQWrittenThisCG / lclTQNeededThisCG;
						
						String lclWorstClass = determineClass(lclTUCompletion, lclTQCompletion);
						
						%><tfoot>
							<tr>
								<th class="<%= lclWorstClass %>"><%= lclCG.getName() %> Total</th><%
								
								if (lclTUNeededThisCG > 0) {
									String lclTUClass = determineClass(lclTUCompletion);
									%><th><%= lclTUWrittenThisCG %></th>
									<th><%= lclTUNeededThisCG %></th>
									<th><%= lclPct.format(lclTUCompletion) %></th>
									<td>
										<div class="progress">
											<span class="meter" style="width: <%= lclIntPct.format(lclTUCompletion) %>;"></span>
										</div>
									</td><%
								} else {
									%><td class="info" colspan="4">&nbsp;</td><%
								}
								
								%><td>&nbsp;</td><!-- spacer --><%
								
								if (lclTQNeededThisCG > 0) {
									String lclTQClass = determineClass(lclTQCompletion);
									%><th><%= lclTQWrittenThisCG %></th>
									<th><%= lclTQNeededThisCG %></th>
									<th><%= lclPct.format(lclTQCompletion) %></th>
									<td>
										<div class="progress">
											<span class="meter" style="width: <%= lclIntPct.format(lclTQCompletion) %>;"></span>
										</div>
									</td><%
								} else {
									%><td class="info" colspan="4">&nbsp;</td><%
								}
							%></tr>
						</tfoot><%
					}
				%></table><%
			}
			
			if (lclAllRelevantCategories.size() > 1) {
				int lclTotalTUWritten = lclTUWritten.getTotal();
				int lclTotalTUNeeded = lclTUNeeded.getTotal();
				int lclTotalTQWritten = lclTQWritten.getTotal();
				int lclTotalTQNeeded = lclTQNeeded.getTotal();
				
				double lclTUCompletion = 1.0d * lclTotalTUWritten / lclTotalTUNeeded;
				double lclTQCompletion = 1.0d * lclTotalTQWritten / lclTotalTQNeeded;
				
				String lclWorstClass = determineClass(lclTUCompletion, lclTQCompletion);
				
				%><h2>Total</h2>
				<table class="responsive full-width">
					<thead>
						<tr>
							<th>&nbsp;</th><!-- Category -->
							<th colspan="4">Tossups</th>
							<th colspan="4">Team Questions</th>
						</tr>
						<tr>
							<th style="width: 20%">Category</th>
							<th style="width:  5%">Written</th>
							<th style="width:  5%">Needed</th>
							<th style="width:  5%">Completion</th>
							<th style="width: 25%">&nbsp;</th>
							<th style="width:  5%">Written</th>
							<th style="width:  5%">Needed</th>
							<th style="width:  5%">Completion</th>
							<th style="width: 25%">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="<%= lclWorstClass %>">&nbsp;</td><%
							
							if (lclTotalTUNeeded > 0) {
								String lclTUClass = determineClass(lclTUCompletion);
								%><td class="<%= lclTUClass %>"><%= lclTotalTUWritten %></td>
								<td class="<%= lclTUClass %>"><%= lclTotalTUNeeded %></td>
								<td class="<%= lclTUClass %>"><%= lclPct.format(lclTUCompletion) %></td>
								<td class="<%= lclTUClass %>">
									<div class="progress">
										<span class="meter" style="width: <%= lclIntPct.format(lclTUCompletion) %>;"></span>
									</div>
								</td><%
							} else {
								%><td colspan="4">&nbsp;</td><%
							}
							
							%><td>&nbsp;</td><!-- spacer --><%
							
							if (lclTotalTQNeeded > 0) {
								String lclTQClass = determineClass(lclTQCompletion);
								%><td class="<%= lclTQClass %>"><%= lclTotalTQWritten %></td>
								<td class="<%= lclTQClass %>"><%= lclTotalTQNeeded %></td>
								<td class="<%= lclTQClass %>"><%= lclPct.format(lclTQCompletion) %></td>
								<td class="<%= lclTQClass %>">
									<div class="progress">
										<span class="meter" style="width: <%= lclIntPct.format(lclTQCompletion) %>;"></span>
									</div>
								</td><%
							} else {
								%><td colspan="4">&nbsp;</td><%
							}
						%></tr>
					</tbody>
				</table><%
			}
		%></div>
	 </div><%
}

%><jsp:include page="/template/footer.jsp" />

<%!

private String determineClass(double argCompletion) {
	Validate.isTrue(Double.compare(argCompletion, 0.0d) >= 0, "Completion is " + argCompletion + " but it should be nonnegative"); // argCompletion must be nonnegative
	Validate.isTrue(Double.compare(argCompletion, 1.0d) <= 0, "Completion is " + argCompletion + " but it should be less than or equal to 1"); // argCompletion must be <= 1
	
	if (Double.compare(argCompletion, 0.0d) == 0) {
		return "warning";
	} else if (Double.compare(argCompletion, 1.0d) == 0) {
		return "success";
	} else {
		return "info";
	}
}

private String determineClass(double argTUCompletion, double argTQCompletion) {
	if (Double.isNaN(argTUCompletion)) {
		if (Double.isNaN(argTQCompletion)) {
			throw new IllegalArgumentException("At least one of the completion proportions must be a real number");
		} else {
			return determineClass(argTQCompletion);
		}
	} else if (Double.isNaN(argTQCompletion)) {
		// At this point argTUCompletion cannot be NaN
		return determineClass(argTUCompletion);
	} else {
		return determineClass(Math.min(argTUCompletion, argTQCompletion));
	}
}

%>