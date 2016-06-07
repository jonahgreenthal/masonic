package com.masonic.application;

import com.masonic.persistence.QuestionTypeOpal;

public class QuestionTypeImpl extends com.opal.AbstractIdentityImpl<QuestionType, QuestionTypeOpal> implements QuestionType {

	private final QuestionTypeOpal myQuestionTypeOpal;

	public QuestionTypeImpl(QuestionTypeOpal argQuestionTypeOpal) {
		super();
		myQuestionTypeOpal = org.apache.commons.lang3.Validate.notNull(argQuestionTypeOpal);
	}

	protected QuestionTypeOpal getQuestionTypeOpal() {
		return myQuestionTypeOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends QuestionType> getOpal() {
		return getQuestionTypeOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends QuestionType> getBottomOpal() {
		return getQuestionTypeOpal();
	}

	@Override
	public int compareTo(QuestionType argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCode() {
		return getQuestionTypeOpal().getCode();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public QuestionTypeImpl setCode(java.lang.String argCode) {
		getQuestionTypeOpal().setCode(argCode);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getQuestionTypeOpal().getName();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public QuestionTypeImpl setName(java.lang.String argName) {
		getQuestionTypeOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getQuestionTypeOpal().getShortName();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public QuestionTypeImpl setShortName(java.lang.String argShortName) {
		getQuestionTypeOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getQuestionTypeOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public QuestionTypeImpl setSequence(java.lang.Integer argSequence) {
		getQuestionTypeOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public QuestionTypeImpl setSequence(int argSequence) {
		getQuestionTypeOpal().setSequence(argSequence);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getTableName() {
		return getQuestionTypeOpal().getTableName();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public QuestionTypeImpl setTableName(java.lang.String argTableName) {
		getQuestionTypeOpal().setTableName(argTableName);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getSectionHeader() {
		return getQuestionTypeOpal().getSectionHeader();
	}

	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public QuestionTypeImpl setSectionHeader(java.lang.String argSectionHeader) {
		getQuestionTypeOpal().setSectionHeader(argSectionHeader);
		return this;
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getScoringNote() {
		return getQuestionTypeOpal().getScoringNote();
	}

	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public QuestionTypeImpl setScoringNote(java.lang.String argScoringNote) {
		getQuestionTypeOpal().setScoringNote(argScoringNote);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.QuestionType addQuestion(Question argQuestion) {
		getQuestionTypeOpal().addQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.QuestionType removeQuestion(Question argQuestion) {
		getQuestionTypeOpal().removeQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getQuestionCount() {
		return getQuestionTypeOpal().getQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<Question> streamQuestion() {
		return getQuestionTypeOpal().streamQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Question> createQuestionIterator() {
		return new com.opal.OpalIterator<> (getQuestionTypeOpal().createQuestionOpalIterator());
	}

	@Override
	public com.masonic.application.QuestionType addSection(Section argSection) {
		getQuestionTypeOpal().addSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public com.masonic.application.QuestionType removeSection(Section argSection) {
		getQuestionTypeOpal().removeSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public int getSectionCount() {
		return getQuestionTypeOpal().getSectionOpalCount();
	}

	@Override
	public java.util.stream.Stream<Section> streamSection() {
		return getQuestionTypeOpal().streamSectionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Section> createSectionIterator() {
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
	public QuestionType copy() {
		return getQuestionTypeOpal().copy().getUserFacing();
	}

}
