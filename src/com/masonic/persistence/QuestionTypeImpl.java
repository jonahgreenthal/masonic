package com.masonic.persistence;


public class QuestionTypeImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.QuestionType, com.masonic.persistence.QuestionTypeOpal> implements com.masonic.application.QuestionType {

	private final com.masonic.persistence.QuestionTypeOpal myQuestionTypeOpal;

	public QuestionTypeImpl(QuestionTypeOpal argQuestionTypeOpal) {
		super();
		myQuestionTypeOpal = org.apache.commons.lang3.Validate.notNull(argQuestionTypeOpal);
	}

	protected com.masonic.persistence.QuestionTypeOpal getQuestionTypeOpal() {
		return myQuestionTypeOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.QuestionType> getOpal() {
		return getQuestionTypeOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.QuestionType> getBottomOpal() {
		return getQuestionTypeOpal();
	}

	@Override
	public int compareTo(com.masonic.application.QuestionType argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCode() {
		return getQuestionTypeOpal().getCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setCode(java.lang.String argCode) {
		getQuestionTypeOpal().setCode(argCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getQuestionTypeOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setName(java.lang.String argName) {
		getQuestionTypeOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getQuestionTypeOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setShortName(java.lang.String argShortName) {
		getQuestionTypeOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getQuestionTypeOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setSequence(java.lang.Integer argSequence) {
		getQuestionTypeOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.QuestionTypeImpl setSequence(int argSequence) {
		getQuestionTypeOpal().setSequence(argSequence);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getTableName() {
		return getQuestionTypeOpal().getTableName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setTableName(java.lang.String argTableName) {
		getQuestionTypeOpal().setTableName(argTableName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getSectionHeader() {
		return getQuestionTypeOpal().getSectionHeader();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setSectionHeader(java.lang.String argSectionHeader) {
		getQuestionTypeOpal().setSectionHeader(argSectionHeader);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getScoringNote() {
		return getQuestionTypeOpal().getScoringNote();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.QuestionTypeImpl setScoringNote(java.lang.String argScoringNote) {
		getQuestionTypeOpal().setScoringNote(argScoringNote);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.QuestionType addQuestion(com.masonic.application.Question argQuestion) {
		getQuestionTypeOpal().addQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.QuestionType removeQuestion(com.masonic.application.Question argQuestion) {
		getQuestionTypeOpal().removeQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getQuestionCount() {
		return getQuestionTypeOpal().getQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Question> streamQuestion() {
		return getQuestionTypeOpal().streamQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Question> createQuestionIterator() {
		return new com.opal.OpalIterator<> (getQuestionTypeOpal().createQuestionOpalIterator());
	}

	@Override
	public com.masonic.application.QuestionType addSection(com.masonic.application.Section argSection) {
		getQuestionTypeOpal().addSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public com.masonic.application.QuestionType removeSection(com.masonic.application.Section argSection) {
		getQuestionTypeOpal().removeSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public int getSectionCount() {
		return getQuestionTypeOpal().getSectionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Section> streamSection() {
		return getQuestionTypeOpal().streamSectionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Section> createSectionIterator() {
		return new com.opal.OpalIterator<> (getQuestionTypeOpal().createSectionOpalIterator());
	}

	@Override
	public void unlink() {
		getQuestionTypeOpal().unlink();
	}

	@Override
	public void reload() {
		getQuestionTypeOpal().reload();
	}

	@Override
	public com.masonic.application.QuestionType copy() {
		return getQuestionTypeOpal().copy().getUserFacing();
	}

}
