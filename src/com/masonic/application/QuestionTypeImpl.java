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

	@Override
	public java.lang.String getCode() {
		return getQuestionTypeOpal().getCode();
	}

	@Override
	public QuestionTypeImpl setCode(java.lang.String argCode) {
		getQuestionTypeOpal().setCode(argCode);
		return this;
	}

	@Override
	public java.lang.String getName() {
		return getQuestionTypeOpal().getName();
	}

	@Override
	public QuestionTypeImpl setName(java.lang.String argName) {
		getQuestionTypeOpal().setName(argName);
		return this;
	}

	@Override
	public java.lang.String getShortName() {
		return getQuestionTypeOpal().getShortName();
	}

	@Override
	public QuestionTypeImpl setShortName(java.lang.String argShortName) {
		getQuestionTypeOpal().setShortName(argShortName);
		return this;
	}

	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getQuestionTypeOpal().getSequenceAsObject();
	}

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

	@Override
	public java.lang.String getTableName() {
		return getQuestionTypeOpal().getTableName();
	}

	@Override
	public QuestionTypeImpl setTableName(java.lang.String argTableName) {
		getQuestionTypeOpal().setTableName(argTableName);
		return this;
	}

	@Override
	public java.lang.String getSectionHeader() {
		return getQuestionTypeOpal().getSectionHeader();
	}

	@Override
	public QuestionTypeImpl setSectionHeader(java.lang.String argSectionHeader) {
		getQuestionTypeOpal().setSectionHeader(argSectionHeader);
		return this;
	}

	@Override
	public java.lang.String getScoringNote() {
		return getQuestionTypeOpal().getScoringNote();
	}

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
	public void addQuestion(Question argQuestion) {
		getQuestionTypeOpal().addQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
	}

	@Override
	public void removeQuestion(Question argQuestion) {
		getQuestionTypeOpal().removeQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
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
	public void clearQuestion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addSection(Section argSection) {
		getQuestionTypeOpal().addSectionOpal(((SectionImpl) argSection).getSectionOpal());
	}

	@Override
	public void removeSection(Section argSection) {
		getQuestionTypeOpal().removeSectionOpal(((SectionImpl) argSection).getSectionOpal());
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
	public void clearSection() {
		throw new UnsupportedOperationException();
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
