package com.masonic.application;

import com.masonic.persistence.PlacementOpal;
import com.masonic.persistence.SectionOpal;
import com.masonic.persistence.QuestionOpal;
import com.masonic.persistence.CategoryOpal;

public class PlacementImpl extends com.opal.AbstractIdentityImpl<Placement, PlacementOpal> implements Placement {
	private final PlacementOpal myPlacementOpal;

	public PlacementImpl(PlacementOpal argPlacementOpal) {
		super();
		myPlacementOpal = org.apache.commons.lang3.Validate.notNull(argPlacementOpal);
	}

	protected PlacementOpal getPlacementOpal() {
		return myPlacementOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends Placement> getOpal() {
		return getPlacementOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends Placement> getBottomOpal() {
		return getPlacementOpal();
	}

	@Override
	public java.lang.Integer getIdAsObject() {
		return getPlacementOpal().getIdAsObject();
	}

	@Override
	public PlacementImpl setId(java.lang.Integer argId) {
		getPlacementOpal().setId(argId);
		return this;
	}

	@Override
	public PlacementImpl setId(int argId) {
		getPlacementOpal().setId(argId);
		return this;
	}

	@Override
	public java.lang.Integer getSectionIdAsObject() {
		return getPlacementOpal().getSectionIdAsObject();
	}

	@Override
	public PlacementImpl setSectionId(java.lang.Integer argSectionId) {
		getPlacementOpal().setSectionId(argSectionId);
		return this;
	}

	@Override
	public PlacementImpl setSectionId(int argSectionId) {
		getPlacementOpal().setSectionId(argSectionId);
		return this;
	}

	@Override
	public java.lang.String getCategoryCode() {
		return getPlacementOpal().getCategoryCode();
	}

	@Override
	public PlacementImpl setCategoryCode(java.lang.String argCategoryCode) {
		getPlacementOpal().setCategoryCode(argCategoryCode);
		return this;
	}

	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getPlacementOpal().getSequenceAsObject();
	}

	@Override
	public PlacementImpl setSequence(java.lang.Integer argSequence) {
		getPlacementOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public PlacementImpl setSequence(int argSequence) {
		getPlacementOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getPlacementOpal().getQuestionIdAsObject();
	}

	@Override
	public PlacementImpl setQuestionId(java.lang.Integer argQuestionId) {
		getPlacementOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public PlacementImpl setQuestionId(int argQuestionId) {
		getPlacementOpal().setQuestionId(argQuestionId);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the Section object created from placement through reference placement_to_section */

	@Override
	public Section getSection() {
		SectionOpal lclSectionOpal = getPlacementOpal().getSectionOpal();
		return lclSectionOpal == null ? null : lclSectionOpal.getUserFacing();
	}

	@Override
	public Placement setSection(Section argSection) {
		getPlacementOpal().setSectionOpal(argSection == null ? null : ((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	/** @return the Question object created from placement through reference placement_to_question */

	@Override
	public Question getQuestion() {
		QuestionOpal lclQuestionOpal = getPlacementOpal().getQuestionOpal();
		return lclQuestionOpal == null ? null : lclQuestionOpal.getUserFacing();
	}

	@Override
	public Placement setQuestion(Question argQuestion) {
		getPlacementOpal().setQuestionOpal(argQuestion == null ? null : ((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	/** @return the Category object created from placement through reference placement_to_category */

	@Override
	public Category getCategory() {
		CategoryOpal lclCategoryOpal = getPlacementOpal().getCategoryOpal();
		return lclCategoryOpal == null ? null : lclCategoryOpal.getUserFacing();
	}

	@Override
	public Placement setCategory(Category argCategory) {
		getPlacementOpal().setCategoryOpal(argCategory == null ? null : ((CategoryImpl) argCategory).getCategoryOpal());
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
	public Placement copy() {
		return getPlacementOpal().copy().getUserFacing();
	}

}
