package com.masonic.persistence;

import com.opal.AbstractOpalFactoryFactory;

public abstract class OpalFactoryFactory extends AbstractOpalFactoryFactory {
	public static OpalFactoryFactory getInstance() { return com.masonic.persistence.postgres.PostgresOpalFactoryFactory.getSpecificInstance(); }

	public abstract TeamQuestionOpalFactory getTeamQuestionOpalFactory();
	public abstract TossupOpalFactory getTossupOpalFactory();
	public abstract QuestionOpalFactory getQuestionOpalFactory();
	public abstract QuestionTypeOpalFactory getQuestionTypeOpalFactory();
	public abstract SectionOpalFactory getSectionOpalFactory();
	public abstract QuestionStatusOpalFactory getQuestionStatusOpalFactory();
	public abstract PlacementOpalFactory getPlacementOpalFactory();
	public abstract PacketSetOpalFactory getPacketSetOpalFactory();
	public abstract PacketOpalFactory getPacketOpalFactory();
	public abstract CategoryOpalFactory getCategoryOpalFactory();
	public abstract AccountOpalFactory getAccountOpalFactory();
	public abstract CategoryGroupOpalFactory getCategoryGroupOpalFactory();
}
