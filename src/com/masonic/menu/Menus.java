package com.masonic.menu;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.Validate;

public final class Menus {
	private static final Menus ourInstance = new Menus();
	
	public static final Menu PUBLIC = new Menu(
		"public",
		"Galton",
		Arrays.asList(
			new MenuPage("home", "Home", "/")
		)
	);
	
	public static final Menu INTERNAL = new Menu(
		"internal",
		"Masonic",
		Arrays.asList(
			new MenuPage("home", "Home", "/masonic/"),
			new MenuPage("progress", "Progress", "/masonic/progress.jsp"),
			new MenuPage("packet-sets", "Packet Sets", "/masonic/packet-sets.jsp"),
			new MenuPage("tossup-edit", "Write Tossup", "/masonic/tossup-edit.jsp"),
			new MenuPage("team-question-edit", "Write Team Question", "/masonic/team-question-edit.jsp"),
			new MenuPage("style-guide", "Style Guide", "/masonic/style-guide.jsp")
		)
	);
	
	private Menus() {
		super();
	}
	
	public static Menus getInstance() {
		return ourInstance;
	}
	
	public static final MenuType getDefaultMenuType() {
		return MenuType.FOUNDATION;
	}
}
