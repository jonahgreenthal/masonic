package com.masonic.persistence;


public class QuestionStatusImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.QuestionStatus, com.masonic.persistence.QuestionStatusOpal> implements com.masonic.application.QuestionStatus {

	private final com.masonic.persistence.QuestionStatusOpal myQuestionStatusOpal;

	public QuestionStatusImpl(QuestionStatusOpal argQuestionStatusOpal) {
		super();
		myQuestionStatusOpal = org.apache.commons.lang3.Validate.notNull(argQuestionStatusOpal);
	}

	protected com.masonic.persistence.QuestionStatusOpal getQuestionStatusOpal() {
		return myQuestionStatusOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.QuestionStatus> getOpal() {
		return getQuestionStatusOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.QuestionStatus> getBottomOpal() {
		return getQuestionStatusOpal();
	}

	@Override
	public int compareTo(com.masonic.application.QuestionStatus argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCode() {
		return getQuestionStatusOpal().getCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.QuestionStatusImpl setCode(java.lang.String argCode) {
		getQuestionStatusOpal().setCode(argCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getQuestionStatusOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.QuestionStatusImpl setName(java.lang.String argName) {
		getQuestionStatusOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getQuestionStatusOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.QuestionStatusImpl setShortName(java.lang.String argShortName) {
		getQuestionStatusOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getQuestionStatusOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.QuestionStatusImpl setSequence(java.lang.Integer argSequence) {
		getQuestionStatusOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.QuestionStatusImpl setSequence(int argSequence) {
		getQuestionStatusOpal().setSequence(argSequence);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.QuestionStatus addQuestion(com.masonic.application.Question argQuestion) {
		getQuestionStatusOpal().addQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.QuestionStatus removeQuestion(com.masonic.application.Question argQuestion) {
		getQuestionStatusOpal().removeQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getQuestionCount() {
		return getQuestionStatusOpal().getQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Question> streamQuestion() {
		return getQuestionStatusOpal().streamQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Question> createQuestionIterator() {
		return new com.opal.OpalIterator<> (getQuestionStatusOpal().createQuestionOpalIterator());
	}

	@Override
	public void unlink() {
		getQuestionStatusOpal().unlink();
	}

	@Override
	public void reload() {
		getQuestionStatusOpal().reload();
	}

	@Override
	public com.masonic.application.QuestionStatus copy() {
		return getQuestionStatusOpal().copy().getUserFacing();
	}

}
