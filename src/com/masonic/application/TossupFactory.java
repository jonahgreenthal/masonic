package com.masonic.application;

import com.opal.*;
import com.masonic.persistence.TossupOpalFactory;
import com.masonic.persistence.TossupOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class TossupFactory extends com.opal.AbstractFactory<Tossup, TossupOpal> implements com.opal.FactoryCreator<Tossup>, com.opal.IdentityFactory<Tossup> {
	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final TossupFactory ourInstance = new TossupFactory(OpalFactoryFactory.getInstance().getTossupOpalFactory());

	public static TossupFactory getInstance() { return ourInstance; }

	public TossupOpalFactory getTossupOpalFactory() { return (TossupOpalFactory) getOpalFactory(); }

	protected TossupFactory(OpalFactory<Tossup, TossupOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<Tossup> getUserFacingInterface() {
		return Tossup.class;
	}

	@Override
	public Tossup create() {
		return getTossupOpalFactory().create().getUserFacing();
	}

	public Tossup forQuestionId(java.lang.Integer argQuestionId) {
		TossupOpal lclTossupOpal = getTossupOpalFactory().forQuestionId(argQuestionId);
		return (lclTossupOpal == null) ? null : lclTossupOpal.getUserFacing();
	}

	@Override
	public Tossup[] createArray(int argSize) {
		return new Tossup[argSize];
	}

	public Tossup fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "tossup_question_id");
	}

	public Tossup fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argQuestionId) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclQuestionIdString = argRequest.getParameter(argQuestionId);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclQuestionIdString)) {
			return null;
		}
		java.lang.Integer lclQuestionId = java.lang.Integer.valueOf(lclQuestionIdString);
		return forQuestionId(lclQuestionId);
	}

	public <T extends java.util.Collection<? super Tossup>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
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
			Tossup lclResult = forQuestionId(lclQuestionId);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid QuestionId for any Tossup");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super Tossup>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "tossup_question_id");
	}

	public java.util.Collection<Tossup> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<Tossup> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "tossup_question_id");
	}

	public Tossup[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<Tossup> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public Tossup[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "tossup_question_id");
	}

	@Override
	public Tossup forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		TossupOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
