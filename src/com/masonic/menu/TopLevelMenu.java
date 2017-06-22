package com.masonic.menu;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;

import com.masonic.application.Account;

public class TopLevelMenu extends Menu {
	/* package */ TopLevelMenu(final String argName, final String argTitle, final List<MenuItem> argItems, final DisplayDeterminer argDD) {
		super(argName, argTitle, argItems, argDD);
	}
	
	/* package */ TopLevelMenu(final String argName, final String argTitle, final List<MenuItem> argItems) {
		super(argName, argTitle, argItems);
	}
	
	/* package */ TopLevelMenu(final Menu argM) {
		super(argM.getName(), argM.getTitle(), argM.getItems(), argM.getDisplayDeterminer());
	}
	
	public final String output(final HttpServletRequest argRequest, final String argCurrentPageName) {
		return output(Account.determineCurrent(argRequest), argCurrentPageName);
	}
	
	@Override
	protected String outputInitial(final Account argUser, final String argCurrentPageName) {
		return
			"<div data-sticky-container>\n" +
			"	<div class=\"top-bar\" data-topbar data-sticky data-options=\"marginTop:0;\" style=\"width:100%\">\n" +
			"		<div class=\"top-bar-title\">\n" +
			"			<span data-responsive-toggle=\"responsive-menu\" data-hide-for=\"medium\">\n" +
			"				<button class=\"menu-icon dark\" type=\"button\" data-toggle></button>\n" +
			"			</span>\n" +
			"		</div>\n" +
			"		<div id=\"responsive-menu\">\n" +
			"			<div class=\"top-bar-left\">\n" +
			"				<ul class=\"dropdown menu\" data-dropdown-menu>\n" +
			"					<li class=\"menu-text\"><strong>" + getTitle() + "</strong></li>\n";
	}
	
	
	// outputInternal uses Menu's implementation thereof
	
	@Override
	protected String outputFinal(final Account argUser, final String argCurrentPageName) {
		return
			"				</ul>\n" + // dropdown menu
			"			</div>\n" + // top-bar-left
			outputAccountSection(argUser) +
			"		</div>\n" + // responsive-menu
			"	</div>\n" + // top-bar
			"</div>"; // data-sticky-container
	}
	
	protected String outputAccountSection(final Account argUser) {
		if (argUser == null) {
			return "";
		} else {
			return
				"			<div class=\"top-bar-right\">\n" +
				"				<ul class=\"menu\">\n" +
				"					<li><a class=\"log-out stealth-tooltip\" title=\"Log out (currently logged in as " + argUser.getName() + ")\" href=\"/logout.jsp\"><i class=\"fa fa-sign-out\"></i></a></li>\n" +
				"				</ul>\n" +
				"			</div>\n";
		}
	}
}
