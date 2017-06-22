package com.masonic.persistence;


public class PlacementImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.Placement, com.masonic.persistence.PlacementOpal> implements com.masonic.application.Placement {

	private final com.masonic.persistence.PlacementOpal myPlacementOpal;

	public PlacementImpl(PlacementOpal argPlacementOpal) {
		super();
		myPlacementOpal = org.apache.commons.lang3.Validate.notNull(argPlacementOpal);
	}

	protected com.masonic.persistence.PlacementOpal getPlacementOpal() {
		return myPlacementOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Placement> getOpal() {
		return getPlacementOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Placement> getBottomOpal() {
		return getPlacementOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getIdAsObject() {
		return getPlacementOpal().getIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.PlacementImpl setId(java.lang.Integer argId) {
		getPlacementOpal().setId(argId);
		return this;
	}

	@Override
	public com.masonic.persistence.PlacementImpl setId(int argId) {
		getPlacementOpal().setId(argId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSectionIdAsObject() {
		return getPlacementOpal().getSectionIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.PlacementImpl setSectionId(java.lang.Integer argSectionId) {
		getPlacementOpal().setSectionId(argSectionId);
		return this;
	}

	@Override
	public com.masonic.persistence.PlacementImpl setSectionId(int argSectionId) {
		getPlacementOpal().setSectionId(argSectionId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCategoryCode() {
		return getPlacementOpal().getCategoryCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.PlacementImpl setCategoryCode(java.lang.String argCategoryCode) {
		getPlacementOpal().setCategoryCode(argCategoryCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getPlacementOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.PlacementImpl setSequence(java.lang.Integer argSequence) {
		getPlacementOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.PlacementImpl setSequence(int argSequence) {
		getPlacementOpal().setSequence(argSequence);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getPlacementOpal().getQuestionIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@Override
	public com.masonic.persistence.PlacementImpl setQuestionId(java.lang.Integer argQuestionId) {
		getPlacementOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public com.masonic.persistence.PlacementImpl setQuestionId(int argQuestionId) {
		getPlacementOpal().setQuestionId(argQuestionId);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the Category object created from placement through reference placement_to_category */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.Category getCategory() {
		CategoryOpal lclCategoryOpal = getPlacementOpal().getCategoryOpal();
		return lclCategoryOpal == null ? null : lclCategoryOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Placement setCategory(com.masonic.application.Category argCategory) {
		getPlacementOpal().setCategoryOpal(argCategory == null ? null : ((CategoryImpl) argCategory).getCategoryOpal());
		return this;
	}

	/** @return the Question object created from placement through reference placement_to_question */

	@com.opal.annotation.Nullability(nullable = true)
	@Override
	public com.masonic.application.Question getQuestion() {
		QuestionOpal lclQuestionOpal = getPlacementOpal().getQuestionOpal();
		return lclQuestionOpal == null ? null : lclQuestionOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Placement setQuestion(com.masonic.application.Question argQuestion) {
		getPlacementOpal().setQuestionOpal(argQuestion == null ? null : ((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	/** @return the Section object created from placement through reference placement_to_section */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.Section getSection() {
		SectionOpal lclSectionOpal = getPlacementOpal().getSectionOpal();
		return lclSectionOpal == null ? null : lclSectionOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Placement setSection(com.masonic.application.Section argSection) {
		getPlacementOpal().setSectionOpal(argSection == null ? null : ((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void unlink() {
		getPlacementOpal().unlink();
	}

	@Override
	public void reload() {
		getPlacementOpal().reload();
	}

	@Override
	public com.masonic.application.Placement copy() {
		return getPlacementOpal().copy().getUserFacing();
	}

}
