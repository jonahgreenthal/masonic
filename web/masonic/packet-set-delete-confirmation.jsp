<%@ page import="com.masonic.menu.Menus" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Packet Set Deleted" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"packet-set-deleted\") %>" />
	<jsp:param name="h1" value="Packet Set Deleted" />
</jsp:include>

<div class="row">
	<div class="small-12 columns">
		<p>That packet set has been deleted.</p>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />