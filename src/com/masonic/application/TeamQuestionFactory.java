package com.masonic.application;

import com.opal.*;
import com.masonic.persistence.TeamQuestionOpalFactory;
import com.masonic.persistence.TeamQuestionOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class TeamQuestionFactory extends com.opal.AbstractFactory<TeamQuestion, TeamQuestionOpal> implements com.opal.FactoryCreator<TeamQuestion>, com.opal.IdentityFactory<TeamQuestion> {
	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final TeamQuestionFactory ourInstance = new TeamQuestionFactory(OpalFactoryFactory.getInstance().getTeamQuestionOpalFactory());

	public static TeamQuestionFactory getInstance() { return ourInstance; }

	public TeamQuestionOpalFactory getTeamQuestionOpalFactory() { return (TeamQuestionOpalFactory) getOpalFactory(); }

	protected TeamQuestionFactory(OpalFactory<TeamQuestion, TeamQuestionOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<TeamQuestion> getUserFacingInterface() {
		return TeamQuestion.class;
	}

	@Override
	public TeamQuestion create() {
		return getTeamQuestionOpalFactory().create().getUserFacing();
	}

	public TeamQuestion forQuestionId(java.lang.Integer argQuestionId) {
		TeamQuestionOpal lclTeamQuestionOpal = getTeamQuestionOpalFactory().forQuestionId(argQuestionId);
		return (lclTeamQuestionOpal == null) ? null : lclTeamQuestionOpal.getUserFacing();
	}

	@Override
	public TeamQuestion[] createArray(int argSize) {
		return new TeamQuestion[argSize];
	}

	public TeamQuestion fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "team_question_question_id");
	}

	public TeamQuestion fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argQuestionId) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclQuestionIdString = argRequest.getParameter(argQuestionId);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclQuestionIdString)) {
			return null;
		}
		java.lang.Integer lclQuestionId = java.lang.Integer.valueOf(lclQuestionIdString);
		return forQuestionId(lclQuestionId);
	}

	public <T extends java.util.Collection<? super TeamQuestion>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		org.apache.commons.lang3.Validate.notNull(argCollection);
		org.apache.commons.lang3.Validate.notNull(argRequest);
		org.apache.commons.lang3.Validate.notEmpty(argParameterName);
		String[] lclValues = argRequest.getParameterValues(argParameterName);
		if (lclValues == null || lclValues.length == 0) {
			return argCollection;
		}
		for (String lclValueUntrimmed : lclValues) {
			String lclValue = org.apache.commons.lang3.StringUtils.trimToNull(lclValueUntrimmed);
			if (lclValue == null) {
				continue;
			}
			java.lang.Integer lclQuestionId = java.lang.Integer.valueOf(lclValue);
			TeamQuestion lclResult = forQuestionId(lclQuestionId);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid QuestionId for any TeamQuestion");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super TeamQuestion>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "team_question_question_id");
	}

	public java.util.Collection<TeamQuestion> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<TeamQuestion> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "team_question_question_id");
	}

	public TeamQuestion[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<TeamQuestion> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public TeamQuestion[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "team_question_question_id");
	}

	@Override
	public TeamQuestion forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		TeamQuestionOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
