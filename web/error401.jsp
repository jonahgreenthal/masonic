<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.Utility" %>

<jsp:include page="/template/header.jsp">
    <jsp:param name="pageTitle" value="401 Unauthorized" />
    <jsp:param name="pageDescription" value="Error 401" />
	<jsp:param name="topMenu" value="<%= Menus.PUBLIC.asTopLevel().output(request, \"logout\") %>" />
	<jsp:param name="h1" value="Not Authorized" />
</jsp:include>

<div class="row">
	<div class="small-12 columns">
		<p>You are not authorized to see that page. If you believe that to be incorrect, contact <%= Utility.getAdminContact() %>.</p>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />