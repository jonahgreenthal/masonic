<%@ page import="java.util.List" %>
<%@ page import="com.opal.cma.OpalForm" %>
<%@ page import="com.opal.cma.OpalMainForm" %>
<%@ page import="com.masonic.application.Account" %>
<%@ page import="com.masonic.application.Category" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.Question" %>
<%@ page import="com.masonic.application.QuestionFactory" %>
<%@ page import="com.masonic.application.QuestionStatus" %>
<%@ page import="com.masonic.application.TeamQuestion" %>
<%@ page import="com.masonic.application.TeamQuestionFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.opalforms.updater.QuestionToTeamQuestionUpdater" %>
<%@ page import="com.masonic.opalforms.validator.TeamQuestionValidator" %>
<%@ page import="com.masonic.HTMLUtility" %>

<%
OpalMainForm<TeamQuestion> lclOF = OpalForm.create(
	session,
	request,
	"/OpalFormController",
	TeamQuestionFactory.getInstance(),
	"question_id"
);
lclOF.setUpdaterClass(QuestionToTeamQuestionUpdater.class);
lclOF.setValidatorClass(TeamQuestionValidator.class);
lclOF.setDeleteURI("/masonic/question-delete-confirmation.jsp");
TeamQuestion lclTQ = lclOF.getUserFacing();

Account lclUser = Account.demand(request);
if (!lclUser.isAdministrator()) {
	lclOF.disable("Writer");
}

String lclTitle = lclOF.isNew() ? "New Team Question" : "Edit " + lclTQ.getLabel();
%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="<%= lclTitle %>" />
	<jsp:param name="pageDescription" value="<%= lclTitle %>" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"team-question-edit\") %>" />
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
		<%= lclOF.label("Introduction", "Introduction").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Introduction", 60, 2) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part1Text", "Part 1 Text").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part1Text", 60, 2) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part1Answer", "Part 1 Answer").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part1Answer", 60, 1) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part2Text", "Part 2 Text").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part2Text", 60, 2) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part2Answer", "Part 2 Answer").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part2Answer", 60, 1) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part3Text", "Part 3 Text").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part3Text", 60, 2) %>
	</div>
	
	<div class="small-2 columns">
		<%= lclOF.label("Part3Answer", "Part 3 Answer").addCssClass("right inline") %>
	</div>
	<div class="small-10 columns">
		<%= lclOF.textarea("Part3Answer", 60, 1) %>
	</div>
</div>

<div class="row">
	<hr />
</div>

<!--<div class="row">
	<div class="small-2 columns text-right">
		<%= lclOF.label("ExternalNote", "<span class=\"stealth-tool-tip\" title=\"This is a host note that will be output with the question, for instance, an explanation of how to work a computation problem. (NOT YET IMPLEMENTED IN OUTPUT.)\">Note</span>") %>
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