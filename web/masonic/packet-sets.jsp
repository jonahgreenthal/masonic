<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.siliconage.util.WebDataFilter" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.PacketSetFactory" %>
<%@ page import="com.masonic.menu.Menus" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Packet Sets" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"packet-sets\") %>" />
	<jsp:param name="h1" value="Packet Sets" />
</jsp:include>

<div class="row">
	<div class="small-12 columns">
		<table class="responsive full-width">
			<thead>
				<th>Name</th>
				<th>Packets</th>
				<th>Deadline</th>
				<th>Note</th>
				<th>Output</th>
			</thead>
			<tbody><%
				List<PacketSet> lclPSes = PacketSetFactory.getInstance().acquireAll(new ArrayList<>());
				lclPSes.sort(PacketSet.StandardComparator.getInstance());
				
				DateTimeFormatter lclDF = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
				
				for (PacketSet lclPS : lclPSes) {
					%><tr>
						<td><a href="packet-set-edit.jsp?packet_set_code=<%= lclPS.getCode() %>"><%= lclPS.getName() %></a></td>
						<td><%= lclPS.getPacketCount() %></td>
						<td><%= lclDF.format(lclPS.getDeadline()) %></td>
						<td><%= lclPS.getNote() == null ? "&nbsp;" : WebDataFilter.scrubForHTMLDisplay(lclPS.getNote()) %></td>
						<td><%
							if (lclPS.isCompleted()) {
								%><a href="packet-set-output.jsp?packet_set_code=<%= lclPS.getCode() %>">Output</a><%
							} else {
								%>incomplete<%
							}
						%></td>
					</tr><%
				}
			%></tbody>
			<tfoot>
				<tr>
					<td><a href="packet-set-edit.jsp">New</a></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />