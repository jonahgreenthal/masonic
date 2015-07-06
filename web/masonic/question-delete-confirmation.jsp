<%@ page import="com.masonic.menu.Menus" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="Question Deleted" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"question-deleted\") %>" />
	<jsp:param name="h1" value="Question Deleted" />
</jsp:include>

<div class="row">
	<div class="small-12 columns">
		<p>That question has been deleted.</p>
	</div>
</div>

<jsp:include page="/template/footer.jsp" />