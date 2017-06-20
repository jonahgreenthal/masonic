<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.apache.commons.lang3.Validate" %>
<%@ page import="com.siliconage.util.WebDataFilter" %>
<%@ page import="com.opal.ImplicitTableDatabaseQuery" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.PacketSetFactory" %>
<%@ page import="com.masonic.application.Question" %>
<%@ page import="com.masonic.application.QuestionStatus" %>
<%@ page import="com.masonic.application.QuestionStatusFactory" %>
<%@ page import="com.masonic.application.TeamQuestion" %>
<%@ page import="com.masonic.application.TeamQuestionFactory" %>
<%@ page import="com.masonic.application.Tossup" %>
<%@ page import="com.masonic.application.TossupFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.HTMLUtility" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Home" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"home\") %>" />
	<jsp:param name="h1" value="Questions" />
</jsp:include><%

Collection<PacketSet> lclSelectedPacketSetsFromRequest = Validate.notNull(PacketSetFactory.getInstance().multipleFromHttpRequest(request));
boolean lclShowUnused = request.getParameter("packet_set_code") == null || Boolean.parseBoolean(request.getParameter("unused"));

Set<PacketSet> lclSelectedPacketSets = new HashSet<>(lclSelectedPacketSetsFromRequest);
if (lclSelectedPacketSets.isEmpty()) {
	PacketSetFactory.getInstance().acquireForQuery(lclSelectedPacketSets, new ImplicitTableDatabaseQuery("completed = false"));
}

Collection<QuestionStatus> lclSelectedStatusesFromRequest = Validate.notNull(QuestionStatusFactory.getInstance().multipleFromHttpRequest(request));

Set<QuestionStatus> lclSelectedStatuses = new HashSet<>(lclSelectedStatusesFromRequest);
if (lclSelectedStatuses.isEmpty()) {
	QuestionStatusFactory.getInstance().acquireAll(lclSelectedStatuses);
}


List<Tossup> lclTUs = TossupFactory.getInstance().streamAll()
	.filter(argQ -> argQ.isUnused() ? lclShowUnused : lclSelectedPacketSets.contains(argQ.getPlacement().getPacketSet()))
	.filter(argQ -> lclSelectedStatuses.contains(argQ.getStatus()))
	.sorted(Question.UpdatedComparator.getInstance().reversed().thenComparing(Question.PLACEMENT_COMPARATOR))
	.collect(Collectors.toList());
boolean lclAnyTUNote = lclTUs.stream().anyMatch(argTU -> argTU.getInternalNote() != null);

List<TeamQuestion> lclTQs = TeamQuestionFactory.getInstance().streamAll()
	.filter(argQ -> argQ.isUnused() ? lclShowUnused : lclSelectedPacketSets.contains(argQ.getPlacement().getPacketSet()))
	.filter(argQ -> lclSelectedStatuses.contains(argQ.getStatus()))
	.sorted(Question.UpdatedComparator.getInstance().reversed().thenComparing(Question.PLACEMENT_COMPARATOR))
	.collect(Collectors.toList());
boolean lclAnyTQNote = lclTQs.stream().anyMatch(argTQ -> argTQ.getInternalNote() != null);

boolean lclMultiplePacketSetsShown = lclSelectedPacketSets.size() > 1 ? true : lclShowUnused;

DateTimeFormatter lclUpdatedDTF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

%><div class="row hide-for-medium">
	<div class="small-12 columns">
		<p><a href="#team-questions">Jump to team questions</a></p>
	</div>
</div>

<form action="index.jsp" method="get">
	<div class="row">
		<div class="small-12 medium-6 columns">
			<h3>Show questions used in&hellip;</h3><%
			List<PacketSet> lclPSes = PacketSetFactory.getInstance().streamAll()
				.filter(argPS -> argPS.getPacketCount() > 0)
				.sorted()
				.collect(Collectors.toList());
			
			for (PacketSet lclPS : lclPSes) {
				%><label>
					<input type="checkbox" name="packet_set_code" value="<%= lclPS.getCode() %>"<%= lclSelectedPacketSets.contains(lclPS) ? " checked=\"checked\"" : "" %>>&nbsp;<%= lclPS.getName() %>
				</label><%
			}
			
			%><label>
				<input type="checkbox" name="unused" value="<%= HTMLUtility.DEFAULT_TRUE_STRING %>"<%= lclShowUnused ? " checked=\"checked\"" : "" %> />&nbsp;[unused]
			</label>
		</div>
		<div class="small-12 medium-6 columns">
			<h3>Show questions whose status is&hellip;</h3><%
			QuestionStatus[] lclStatuses = QuestionStatusFactory.getInstance().createAllArray();
			Arrays.sort(lclStatuses);
			
			for (QuestionStatus lclS : lclStatuses) {
				%><label>
					<input type="checkbox" name="question_status_code" value="<%= lclS.getCode() %>"<%= lclSelectedStatuses.contains(lclS) ? " checked=\"checked\"" : "" %>>&nbsp;<%= lclS.getName() %></label>
				</label><%
			}
		%></div>
		<div class="small-12 columns">
			<input type="submit" class="tiny" value="Reload" />
		</div>
	</div>
</form>

<div class="row">
	<div class="small-12 large-6 columns">
		<h2 id="tossups">Tossups (<%= lclTUs.size() %>)</h2>
		<table class="responsive full-width">
			<thead>
				<th>Label</th>
				<th>Cat</th>
				<th>Status</th>
				<%= lclAnyTUNote ? "<th>Note?</th>" : "" %>
				<%= lclMultiplePacketSetsShown ? "<th>Use</th>" : "" %>
			</thead>
			<tbody class="small"><%
				for (Tossup lclTU : lclTUs) {
					%><tr>
						<td><a href="tossup-edit.jsp?question_id=<%= lclTU.getId() %>"><%= lclTU.getLabel() %></a></td>
						<td><span title="<%= lclTU.getCategory().getName() %>"><%= lclTU.getCategory().getShortName() %></span></td>
						<td><span title="Last updated: <%= lclUpdatedDTF.format(lclTU.getUpdated()) %>"><%= lclTU.getStatus().getShortName() %></span></td><%
						if (lclAnyTUNote) {
							%><td><%= lclTU.getInternalNote() == null ? "&nbsp;" : "<span title=\"" + WebDataFilter.scrub(lclTU.getInternalNote()) + "\">Yes</span>" %></td><%
						}
						if (lclMultiplePacketSetsShown) {
							%><td><%= lclTU.isUsed() ? lclTU.getPlacement().getPacketSet().getShortName() : "-" %></td><%
						}
					%></tr><%
				}
			%></tbody>
		</table>
	</div>
	
	<div class="small-12 large-6 columns">
		<h2 id="team-questions">Team Questions (<%= lclTQs.size() %>)</h2>
		<table class="responsive full-width">
			<thead>
				<th>Label</th>
				<th>Cat</th>
				<th>Status</th>
				<%= lclAnyTQNote ? "<th>Note?</th>" : "" %>
				<%= lclMultiplePacketSetsShown ? "<th>Use</th>" : "" %>
			</thead>
			<tbody class="small"><%
				for (TeamQuestion lclTQ : lclTQs) {
					%><tr>
						<td><a href="team-question-edit.jsp?question_id=<%= lclTQ.getId() %>"><%= lclTQ.getLabel() %></a></td>
						<td><span title="<%= lclTQ.getCategory().getName() %>"><%= lclTQ.getCategory().getShortName() %></span></td>
						<td><span title="Last updated: <%= lclUpdatedDTF.format(lclTQ.getUpdated()) %>"><%= lclTQ.getStatus().getShortName() %></span></td><%
						if (lclAnyTQNote) {
							%><td><%= lclTQ.getInternalNote() == null ? "&nbsp;" : "<span title=\"" + WebDataFilter.scrub(lclTQ.getInternalNote()) + "\">Yes</span>" %></td><%
						}
						if (lclMultiplePacketSetsShown) {
							%><td><%= lclTQ.isUsed() ? lclTQ.getPlacement().getPacketSet().getShortName() : "-" %></td><%
						}
					%></tr><%
				}
			%></tbody>
		</table>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />