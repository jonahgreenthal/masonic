<%@ page import="java.util.List" %>
<%@ page import="com.opal.cma.OpalForm" %>
<%@ page import="com.opal.cma.OpalMainForm" %>
<%@ page import="com.masonic.application.Account" %>
<%@ page import="com.masonic.application.Category" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.Question" %>
<%@ page import="com.masonic.application.QuestionFactory" %>
<%@ page import="com.masonic.application.QuestionStatus" %>
<%@ page import="com.masonic.application.Tossup" %>
<%@ page import="com.masonic.application.TossupFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.opalforms.updater.QuestionToTossupUpdater" %>
<%@ page import="com.masonic.opalforms.validator.TossupValidator" %>
<%@ page import="com.masonic.HTMLUtility" %>

<%
OpalMainForm<Tossup> lclOF = OpalForm.create(
	session,
	request,
	"/OpalFormController",
	TossupFactory.getInstance(),
	"question_id"
);
lclOF.setUpdaterClass(QuestionToTossupUpdater.class);
lclOF.setValidatorClass(TossupValidator.class);
lclOF.setDeleteURI("/masonic/question-delete-confirmation.jsp");
Tossup lclTU = lclOF.getUserFacing();

Account lclUser = Account.demand(request);
if (!lclUser.isAdministrator()) {
	lclOF.disable("Writer");
}

String lclTitle = lclOF.isNew() ? "New Tossup" : "Edit " + lclTU.getLabel();
%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="<%= lclTitle %>" />
	<jsp:param name="pageDescription" value="<%= lclTitle %>" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"tossup-edit\") %>" />
	<jsp:param name="h1" value="<%= lclTitle %>" />
</jsp:include>

<%= lclOF.open() %><%
if (lclOF.hasErrors()) {
	%><div class="row warning">
		<p class="form-error-intro">Error:</p>
		<div class="form-errors"><%= lclOF.errors() %></div>
	</div><%
}

%><div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Writer", "Writer").addCssClass("right inline") %>
	</div>
	<div class="small-10 medium-2 columns">
		<%= lclOF.dropdown("Writer", Account.NameComparator.getInstance()) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Label", "Label").addCssClass("right inline") %>
	</div>
	<div class="small-10 medium-2 columns">
		<%= lclOF.text("Label", 30) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Status", "Status").addCssClass("right inline") %>
	</div>
	<div class="small-10 medium-2 columns">
		<%= lclOF.dropdown("Status", QuestionStatus.SequenceComparator.getInstance()) %>
	</div>
</div>

<div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Category", "Category").addCssClass("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.dropdown("Category", Category.StandardComparator.getInstance()).namer(Category::getNameWithGroupName) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("IntendedPacketSet", "Intended Packet Set").addCssClass("right inline") %>
	</div>
	<div class="small-10 medium-4 columns">
		<%= lclOF.dropdown("IntendedPacketSet", PacketSet.StandardComparator.getInstance()).filter(PacketSet::isNotCompleted) %>
	</div>
</div>

<div class="row">
	<hr />
</div>

<div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("Text", "Question Text").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Text", 60, 6) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Answer", "Answer").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Answer", 60, 2) %>
	</div>
</div>

<div class="row">
	<hr />
</div>

<!--<div class="row">
	<div class="small-2 columns text-right">
		<%= lclOF.label("ExternalNote", "<span class=\"stealth-tool-tip\" title=\"This is a host note that will be output with the question, for instance, an explanation of how to work a computation problem.  (NOT YET IMPLEMENTED IN OUTPUT.)\">Note</span>") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("ExternalNote", 60, 3) %>
	</div>
</div>-->

<div class="row">
	<div class="small-2 columns">
		<%= lclOF.label("InternalNote", "Internal Note").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("InternalNote", 60, 4) %>
	</div>
	</div>
</div>

<div class="row">
	<div class="small-12 columns">
		<%= lclOF.submit() %> <%= lclOF.delete() %> <%= lclOF.cancel() %>
	</div>
</div>

<%= lclOF.close() %>

<jsp:include page="/template/footer.jsp" />