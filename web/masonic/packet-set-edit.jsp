<%@ page import="com.opal.cma.OpalForm" %>
<%@ page import="com.opal.cma.OpalMainForm" %>
<%@ page import="com.masonic.application.Packet" %>
<%@ page import="com.masonic.application.PacketFactory" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.PacketSetFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.HTMLUtility" %>

<%
OpalMainForm<PacketSet> lclOF = OpalForm.create(
	session,
	request,
	"/OpalFormController",
	PacketSetFactory.getInstance(),
	"packet_set_code"
);
lclOF.setDeleteURI("/masonic/packet-set-delete-confirmation.jsp");
PacketSet lclPS = lclOF.getUserFacing();

String lclTitle = lclOF.isNew() ? "New Packet Set" : "Edit " + lclPS.getName();

if (lclOF.alreadyExists()) {
	lclOF.disable("Code");
}
%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="<%= lclTitle %>" />
	<jsp:param name="pageDescription" value="<%= lclTitle %>" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"packet-set-edit\") %>" />
	<jsp:param name="h1" value="<%= lclTitle %>" />
</jsp:include>

<%= lclOF.open() %><%
if (lclOF.hasErrors()) {
	%><div class="row">
		<p class="form-error-intro">Error:</p>
		<div class="form-errors"><%= lclOF.errors() %></div>
	</div><%
}

%><div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Name", "Name").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.text("Name", 30) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("ShortName", "Short name").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.text("ShortName", 30) %>
	</div>
</div>

<div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Code", "Code").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.text("Code", 30) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Deadline", "Deadline").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
			<%= lclOF.date("Deadline").placeholder("yyyy-mm-dd") %>
	</div>
</div>

<div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Note", "Note").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.textarea("Note", 60, 2) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Completed", "Completed?").css("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= HTMLUtility.switchWidget(lclOF, "Completed") %>
	</div>
</div>

<div class="row">
	<hr />
</div>

<div class="row">
	<div class="small-12 columns">
		<h2>Packets</h2>
		<table class="responsive">
			<thead>
				<tr>
					<th>Name</th>
					<th>Short Name</th>
					<th>Sequence</th>
					<th>Edit</th>
					<th>Delete?</th>
				</tr>
			</thead>
			<tbody><%
				for (OpalForm<Packet> lclPOF : lclOF.children("Packet", PacketFactory.getInstance(), 1, Packet.SequenceComparator.getInstance())) {
					%><tr>
						<%= lclPOF.open() %>
						<td><%= lclPOF.text("Name", 30) %></td>
						<td><%= lclPOF.text("ShortName", 10) %></td>
						<td><%= lclPOF.text("Sequence", 2) %></td>
						<td><%
							if (lclPOF.alreadyExists()) {
								%><a href="packet-edit.jsp?packet_id=<%= lclPOF.getUserFacing().getId() %>">Edit</a><%
							} else {
								%>&nbsp;<%
							}
						%></td>
						<td><%= lclPOF.delete() %></td>
						<%= lclPOF.close() %>
					</tr><%
				}
			%></tbody>
		</table>
	</div>
</div>

<div class="row">
	<div class="small-12 columns">
		<%= lclOF.submit() %> <%= lclOF.delete() %> <%= lclOF.cancel() %>
	</div>
</div>

<%= lclOF.close() %>

<jsp:include page="/template/footer.jsp" />