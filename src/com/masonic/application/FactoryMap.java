package com.masonic.application;

import com.opal.AbstractFactoryMap;

public class FactoryMap extends AbstractFactoryMap {

	private static final long serialVersionUID = 1L;

	private static final FactoryMap ourInstance = new FactoryMap();

	public static final FactoryMap getInstance() {
		return ourInstance;
	}

	private FactoryMap() {
		super();
	}

	@Override
	protected void initialize() {
		put(com.masonic.application.TeamQuestion.class, com.masonic.application.TeamQuestionFactory.getInstance());
		put(com.masonic.application.Tossup.class, com.masonic.application.TossupFactory.getInstance());
		put(com.masonic.application.Question.class, com.masonic.application.QuestionFactory.getInstance());
		put(com.masonic.application.QuestionType.class, com.masonic.application.QuestionTypeFactory.getInstance());
		put(com.masonic.application.Section.class, com.masonic.application.SectionFactory.getInstance());
		put(com.masonic.application.QuestionStatus.class, com.masonic.application.QuestionStatusFactory.getInstance());
		put(com.masonic.application.Placement.class, com.masonic.application.PlacementFactory.getInstance());
		put(com.masonic.application.PacketSet.class, com.masonic.application.PacketSetFactory.getInstance());
		put(com.masonic.application.Packet.class, com.masonic.application.PacketFactory.getInstance());
		put(com.masonic.application.Category.class, com.masonic.application.CategoryFactory.getInstance());
		put(com.masonic.application.Account.class, com.masonic.application.AccountFactory.getInstance());
		put(com.masonic.application.CategoryGroup.class, com.masonic.application.CategoryGroupFactory.getInstance());
		return;
	}

}
