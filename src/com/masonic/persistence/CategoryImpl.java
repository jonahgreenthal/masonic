package com.masonic.persistence;


public class CategoryImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.Category, com.masonic.persistence.CategoryOpal> implements com.masonic.application.Category {

	private final com.masonic.persistence.CategoryOpal myCategoryOpal;

	public CategoryImpl(CategoryOpal argCategoryOpal) {
		super();
		myCategoryOpal = org.apache.commons.lang3.Validate.notNull(argCategoryOpal);
	}

	protected com.masonic.persistence.CategoryOpal getCategoryOpal() {
		return myCategoryOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Category> getOpal() {
		return getCategoryOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Category> getBottomOpal() {
		return getCategoryOpal();
	}

	@Override
	public int compareTo(com.masonic.application.Category argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCode() {
		return getCategoryOpal().getCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.CategoryImpl setCode(java.lang.String argCode) {
		getCategoryOpal().setCode(argCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getCategoryOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.CategoryImpl setName(java.lang.String argName) {
		getCategoryOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getCategoryOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.CategoryImpl setShortName(java.lang.String argShortName) {
		getCategoryOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getCategoryOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.CategoryImpl setSequence(java.lang.Integer argSequence) {
		getCategoryOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.CategoryImpl setSequence(int argSequence) {
		getCategoryOpal().setSequence(argSequence);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCategoryGroupCode() {
		return getCategoryOpal().getCategoryGroupCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.CategoryImpl setCategoryGroupCode(java.lang.String argCategoryGroupCode) {
		getCategoryOpal().setCategoryGroupCode(argCategoryGroupCode);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the CategoryGroup object created from category through reference category_to_category_group */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.CategoryGroup getCategoryGroup() {
		CategoryGroupOpal lclCategoryGroupOpal = getCategoryOpal().getCategoryGroupOpal();
		return lclCategoryGroupOpal == null ? null : lclCategoryGroupOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Category setCategoryGroup(com.masonic.application.CategoryGroup argCategoryGroup) {
		getCategoryOpal().setCategoryGroupOpal(argCategoryGroup == null ? null : ((CategoryGroupImpl) argCategoryGroup).getCategoryGroupOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.Category addQuestion(com.masonic.application.Question argQuestion) {
		getCategoryOpal().addQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.Category removeQuestion(com.masonic.application.Question argQuestion) {
		getCategoryOpal().removeQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getQuestionCount() {
		return getCategoryOpal().getQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Question> streamQuestion() {
		return getCategoryOpal().streamQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Question> createQuestionIterator() {
		return new com.opal.OpalIterator<> (getCategoryOpal().createQuestionOpalIterator());
	}

	@Override
	public com.masonic.application.Category addPlacement(com.masonic.application.Placement argPlacement) {
		getCategoryOpal().addPlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
		return this;
	}

	@Override
	public com.masonic.application.Category removePlacement(com.masonic.application.Placement argPlacement) {
		getCategoryOpal().removePlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
		return this;
	}

	@Override
	public int getPlacementCount() {
		return getCategoryOpal().getPlacementOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Placement> streamPlacement() {
		return getCategoryOpal().streamPlacementOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Placement> createPlacementIterator() {
		return new com.opal.OpalIterator<> (getCategoryOpal().createPlacementOpalIterator());
	}

	@Override
	public void unlink() {
		getCategoryOpal().unlink();
	}

	@Override
	public void reload() {
		getCategoryOpal().reload();
	}

	@Override
	public com.masonic.application.Category copy() {
		return getCategoryOpal().copy().getUserFacing();
	}

}
