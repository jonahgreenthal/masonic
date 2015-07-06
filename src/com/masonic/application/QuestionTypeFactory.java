package com.masonic.application;

import com.opal.*;
import com.masonic.persistence.QuestionTypeOpalFactory;
import com.masonic.persistence.QuestionTypeOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class QuestionTypeFactory extends com.opal.AbstractFactory<QuestionType, QuestionTypeOpal> implements com.opal.FactoryCreator<QuestionType>, com.opal.IdentityFactory<QuestionType> {
	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final QuestionTypeFactory ourInstance = new QuestionTypeFactory(OpalFactoryFactory.getInstance().getQuestionTypeOpalFactory());

	public static QuestionTypeFactory getInstance() { return ourInstance; }

	public QuestionTypeOpalFactory getQuestionTypeOpalFactory() { return (QuestionTypeOpalFactory) getOpalFactory(); }

	protected QuestionTypeFactory(OpalFactory<QuestionType, QuestionTypeOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<QuestionType> getUserFacingInterface() {
		return QuestionType.class;
	}


	/* These Singleton objects are initialized on system start up to refer to unchanging objects
		from the database.
	*/

	public static final QuestionType TEAM_QUESTION() { return getInstance().forCode("TEAM_QUESTION"); }
	public static final QuestionType TOSSUP() { return getInstance().forCode("TOSSUP"); }

	@Override
	public QuestionType create() {
		return getQuestionTypeOpalFactory().create().getUserFacing();
	}

	public QuestionType forCode(java.lang.String argCode) {
		QuestionTypeOpal lclQuestionTypeOpal = getQuestionTypeOpalFactory().forCode(argCode);
		return (lclQuestionTypeOpal == null) ? null : lclQuestionTypeOpal.getUserFacing();
	}

	public QuestionType forName(java.lang.String argName) {
		QuestionTypeOpal lclQuestionTypeOpal = getQuestionTypeOpalFactory().forName(argName);
		return (lclQuestionTypeOpal == null) ? null : lclQuestionTypeOpal.getUserFacing();
	}

	public QuestionType forShortName(java.lang.String argShortName) {
		QuestionTypeOpal lclQuestionTypeOpal = getQuestionTypeOpalFactory().forShortName(argShortName);
		return (lclQuestionTypeOpal == null) ? null : lclQuestionTypeOpal.getUserFacing();
	}

	@Override
	public QuestionType[] createArray(int argSize) {
		return new QuestionType[argSize];
	}

	public QuestionType fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "question_type_code");
	}

	public QuestionType fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argCode) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclCodeString = argRequest.getParameter(argCode);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclCodeString)) {
			return null;
		}
		java.lang.String lclCode = lclCodeString;
		return forCode(lclCode);
	}

	public <T extends java.util.Collection<? super QuestionType>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
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
			java.lang.String lclCode = lclValue;
			QuestionType lclResult = forCode(lclCode);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid Code for any QuestionType");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super QuestionType>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "question_type_code");
	}

	public java.util.Collection<QuestionType> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<QuestionType> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "question_type_code");
	}

	public QuestionType[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<QuestionType> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public QuestionType[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "question_type_code");
	}

	@Override
	public QuestionType forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		QuestionTypeOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
