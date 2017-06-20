package com.masonic.menu;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.masonic.application.Account;

public class Menu extends MenuItem {
	private final List<MenuItem> myItems;
	private TopLevelMenu myTopLevelInstance = null; // will be lazily initialized
	
	public Menu(final String argName, final String argTitle, final List<MenuItem> argItems, final DisplayDeterminer argDD) {
		super(argName, argTitle, argDD);
		
		myItems = Validate.notEmpty(argItems);
	}
	
	public Menu(final String argName, final String argTitle, final List<MenuItem> argItems) {
		this(argName, argTitle, argItems, DisplayDeterminer.Always);
	}
	
	// For renaming a Menu, basically
	public Menu(final String argName, final String argTitle, final Menu argBase) {
		this(argName, argTitle, argBase.getItems(), argBase.getDisplayDeterminer());
	}
	
	// For renaming a Menu, basically
	public Menu(final String argName, final String argTitle, final Menu argBase, final DisplayDeterminer argDD) {
		this(argName, argTitle, argBase.getItems(), argDD);
	}
	
	public List<MenuItem> getItems() {
		return Collections.unmodifiableList(myItems);
	}
	
	public TopLevelMenu asTopLevel() {
		if (myTopLevelInstance == null) {
			myTopLevelInstance = new TopLevelMenu(this);
		}
		
		return myTopLevelInstance;
	}
	
	// A Menu is highlighted if it specifically is active, or any of its items is active
	@Override
	public boolean isHighlighted(final String argCurrentPageName) {
		if (argCurrentPageName == null) {
			return false;
		}
		
		if (getName().equalsIgnoreCase(argCurrentPageName)) {
			return true;
		} else {
			for (final MenuItem lclItem : getItems()) {
				if (lclItem.isHighlighted(argCurrentPageName)) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	@Override
	public String output(final MenuType argMT, final Account argUser, final String argCurrentPageName) {
		Validate.notNull(argMT);
		// argUser and argCurrentPageName may be null
		
		if (display(argUser)) {
			final StringBuilder lclSB = new StringBuilder();
			switch (argMT) {
				case BOOTSTRAP:
					if (this instanceof TopLevelMenu) {
						lclSB.append("<nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\">\n")
						     .append("	<div class=\"container-fluid\">\n")
						     .append("		<div class=\"navbar-header\">\n")
						     .append("			<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-collapse\" style=\"width: 30pt;\">\n")
						     .append("				<span class=\"sr-only\">Toggle navigation</span>\n")
						     .append("				<span class=\"icon-bar\"></span>\n")
						     .append("				<span class=\"icon-bar\"></span>\n")
						     .append("				<span class=\"icon-bar\"></span>\n")
						     .append("			</button>\n")
						     .append("		</div>\n")
						     .append("		<div class=\"collapse navbar-collapse\" id=\"navbar-collapse\">\n")
						     .append("			<p class=\"navbar-text\"><b>" + getTitle() + "</b></p>\n")
						     .append("			<ul class=\"nav navbar-nav\">\n");
					} else {
						if (isHighlighted(argCurrentPageName)) {
							lclSB.append("				<li class=\"dropdown active\">");
						} else {
							lclSB.append("				<li class=\"dropdown\">");
						}
						
						lclSB.append("					<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">" + getTitle() + " <span class=\"caret\"></span></a>\n")
						     .append("<ul class=\"dropdown-menu\" role=\"menu\">\n");
					}
					
					
					for (final MenuItem lclItem : getItems()) {
						lclSB.append(lclItem.output(argMT, argUser, argCurrentPageName))
						     .append('\n');
					}
					
					if (this instanceof TopLevelMenu) {
						lclSB.append("			</ul>\n");
					} else {
						lclSB.append("				</li>\n")
						     .append("			</ul>\n");
					}
					
					if (this instanceof TopLevelMenu && argUser != null) {
						lclSB.append("			<ul class=\"nav navbar-nav navbar-right\">\n")
						     .append("				<li title=\"Logged in as " + argUser.getName() + "\"><a href=\"/logout.jsp\">Log Out</a></li>\n")
						     .append("			</ul>\n");
					}
					
					if (this instanceof TopLevelMenu) {
						lclSB.append("		</div>\n")
						     .append("	</div>\n")
						     .append("</nav>\n\n");
					}
					
					return lclSB.toString();
				
				case FOUNDATION:
					if (this instanceof TopLevelMenu) {
						lclSB.append("<div data-sticky-container>\n")
						     .append("	<div class=\"top-bar\" data-topbar data-sticky data-options=\"marginTop:0;\" style=\"width:100%\">\n")
							 .append("		<div class=\"top-bar-title\">\n")
							 .append("			<span data-responsive-toggle=\"responsive-menu\" data-hide-for=\"medium\">\n")
							 .append("				<button class=\"menu-icon dark\" type=\"button\" data-toggle></button>\n")
							 .append("			</span>\n")
							 .append("			<strong>").append(getTitle()).append("</strong>\n")
							 .append("		</div>\n")
							 .append("		<div id=\"responsive-menu\">\n")
							 .append("			<div class=\"top-bar-left\">\n")
							 .append("				<ul class=\"dropdown menu\" data-dropdown-menu>\n");
					} else {
						lclSB.append("					<ul class=\"menu vertical\">\n")
							 .append("						<li>\n")
							 .append("							<a href=\"#\">").append(getTitle()).append("</a>\n")
							 .append("								<ul class=\"menu vertical\">\n");
					}
					
					for (final MenuItem lclItem : getItems()) {
						lclSB.append("								").append(lclItem.output(argMT, argUser, argCurrentPageName)).append('\n');
					}
					
					if (this instanceof TopLevelMenu) {
						lclSB.append("				</ul>\n") // dropdown menu
							 .append("			</div>\n"); // top-bar-left
						
						if (argUser != null) {
							lclSB.append("			<div class=\"top-bar-right\">\n")
								 .append("				<ul class=\"menu\">\n")
								 .append("					<li><a class=\"log-out\" title=\"Log out (currently logged in as ").append(argUser.getName()).append(")\" href=\"/logout.jsp\"><i class=\"fa fa-sign-out\"></i></a></li>\n")
								 .append("				</ul>\n")
								 .append("			</div>\n");
						}
						
						lclSB.append("		</div>\n") // responsive-menu
							 .append("	</div>\n") // top-bar
							 .append("</div>"); // data-sticky-container
					} else {
						lclSB.append("				</ul>\n"); // dropdown menu
					}
					
					return lclSB.toString();
					
				default:
					throw new MenuType.UnknownMenuTypeException(argMT);
			}
		} else {
			return "";
		}
	}
}
