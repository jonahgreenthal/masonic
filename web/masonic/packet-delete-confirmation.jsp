<%@ page import="com.masonic.menu.Menus" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Packet Deleted" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"packet-deleted\") %>" />
	<jsp:param name="h1" value="Packet Deleted" />
</jsp:include>

<div class="row">
	<div class="small-12 columns">
		<p>That packet has been deleted.</p>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />