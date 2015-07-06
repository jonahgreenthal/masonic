<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.apache.commons.lang3.Validate" %>
<%@ page import="com.masonic.application.Packet" %>
<%@ page import="com.masonic.application.PacketSet" %>
<%@ page import="com.masonic.application.PacketSetFactory" %>
<%@ page import="com.masonic.menu.Menus" %>
<%@ page import="com.masonic.HTMLUtility" %>

<%
PacketSet lclPS = Validate.notNull(PacketSetFactory.getInstance().fromHttpRequest(request));
String lclTitle = "Output " + lclPS.getName();
%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="pageTitle" value="<%= lclTitle %>" />
	<jsp:param name="pageDescription" value="<%= lclTitle %>" />
	<jsp:param name="topMenu" value="<%= Menus.INTERNAL.asTopLevel().output(request, \"packet-set-output\") %>" />
	<jsp:param name="h1" value="<%= lclTitle %>" />
</jsp:include>

<form method="post" action="OutputPacket">
	<input type="hidden" name="packet_set_code" value="<%= lclPS.getCode() %>"><!-- not used currently, but seems like a good idea -->
	
	<div class="row">
		<div class="small-12 columns">
			<p>Choose the packets you wish to output:</p>
			<ul class="no-bullet"><%
				List<Packet> lclPackets = lclPS.acquirePacket(new ArrayList<>(lclPS.getPacketCount()));
				lclPackets.sort(Packet.StandardComparator.getInstance());
				for (Packet lclP : lclPackets) {
					%><li>
						<label>
							<input type="checkbox" name="packet_id" value="<%= lclP.getId() %>" checked="checked" />
							<%= lclP.getName() %>
						</label>
					</li><%
				}
			
			%></ul>
		</div>
	</div>
	
	<div class="row">
		<div class="small-12 columns">
			<input type="submit" value="Download packets" />
		</div>
	</div>
</form>

<jsp:include page="/template/footer.jsp" />