<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.siliconage.util.WebDataFilter" %>
<%@ page import="com.masonic.application.Question" %>
<%@ page import="com.masonic.application.TeamQuestion" %>
<%@ page import="com.masonic.application.TeamQuestionFactory" %>
<%@ page import="com.masonic.application.Tossup" %>
<%@ page import="com.masonic.application.TossupFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.opalforms.compare.QuestionPlacementComparator" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Home" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"home\") %>" />
	<jsp:param name="h1" value="Questions" />
</jsp:include>

<div class="row hide-for-large-up">
	<div class="small-12 columns">
		<p><a href="#team-questions">Jump to team questions</a></p>
	</div>
</div>

<div class="row">
	<div class="small-12 large-5 columns">
		<h2 id="tossups">Tossups</h2>
		<table class="responsive full-width">
			<thead>
				<th>Label</th>
				<th>Category</th>
				<th>Status</th>
				<th>Note?</th>
				<th>Use</th>
			</thead>
			<tbody class="small"><%
				List<Tossup> lclTUs = TossupFactory.getInstance().acquireAll(new ArrayList<>());
				lclTUs.sort(Question.UpdatedComparator.getInstance().reversed().thenComparing(QuestionPlacementComparator.getInstance()));
				
				DateTimeFormatter lclUpdatedDTF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
				
				for (Tossup lclTU : lclTUs) {
					%><tr>
						<td><a href="tossup-edit.jsp?question_id=<%= lclTU.getId() %>"><%= lclTU.getLabel() %></a></td>
						<td><%= lclTU.getCategory().getShortName() %></td>
						<td><span title="Last updated: <%= lclUpdatedDTF.format(lclTU.getUpdated()) %>"><%= lclTU.getStatus().getShortName() %></span></td>
						<td><%= lclTU.getInternalNote() == null ? "&nbsp;" : "<span class=\"stealth-tool-tip\" title=\"" + WebDataFilter.scrub(lclTU.getInternalNote()) + "\">yes</span>" %></td>
						<td><%= lclTU.isUsed() ? lclTU.getPlacement().getPacketSet().getShortName() : "-" %></td>
					</tr><%
				}
			%></tbody>
		</table>
	</div>
	
	<div class="show-for-large-only large-2 columns"><!-- spacer for between the columns --></div>
	
	<div class="small-12 large-5 columns">
		<h2 id="team-questions">Team Questions</h2>
		<table class="responsive full-width">
			<thead>
				<th>Label</th>
				<th>Category</th>
				<th>Updated</th>
				<th>Note?</th>
				<th>Use</th>
			</thead>
			<tbody class="small"><%
				List<TeamQuestion> lclTQs = TeamQuestionFactory.getInstance().acquireAll(new ArrayList<>());
				lclTQs.sort(Question.UpdatedComparator.getInstance().reversed().thenComparing(QuestionPlacementComparator.getInstance()));
				
				for (TeamQuestion lclTQ : lclTQs) {
					%><tr>
						<td><a href="team-question-edit.jsp?question_id=<%= lclTQ.getId() %>"><%= lclTQ.getLabel() %></a></td>
						<td><%= lclTQ.getCategory().getShortName() %></td>
						<td><span title="Last updated: <%= lclUpdatedDTF.format(lclTQ.getUpdated()) %>"><%= lclTQ.getStatus().getShortName() %></span></td>
						<td><%= lclTQ.getInternalNote() == null ? "&nbsp;" : "<span class=\"stealth-tool-tip\" title=\"" + WebDataFilter.scrub(lclTQ.getInternalNote()) + "\">yes</span>" %></td>
						<td><%= lclTQ.isUsed() ? lclTQ.getPlacement().getPacketSet().getShortName() : "-" %></td>
					</tr><%
				}
			%></tbody>
		</table>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />