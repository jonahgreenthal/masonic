package com.masonic.persistence;
import com.masonic.application.TeamQuestion;
import com.opal.PersistenceException;

public interface TeamQuestionOpalFactory extends com.opal.OpalFactory<TeamQuestion, TeamQuestionOpal>, com.opal.OpalFactoryCreator<TeamQuestion, TeamQuestionOpal> {
	public TeamQuestionOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException;
}
