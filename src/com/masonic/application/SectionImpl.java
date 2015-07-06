package com.masonic.application;

import com.masonic.persistence.SectionOpal;
import com.masonic.persistence.QuestionTypeOpal;
import com.masonic.persistence.PacketOpal;

public class SectionImpl extends com.opal.AbstractIdentityImpl<Section, SectionOpal> implements Section {
	private final SectionOpal mySectionOpal;

	public SectionImpl(SectionOpal argSectionOpal) {
		super();
		mySectionOpal = org.apache.commons.lang3.Validate.notNull(argSectionOpal);
	}

	protected SectionOpal getSectionOpal() {
		return mySectionOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends Section> getOpal() {
		return getSectionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends Section> getBottomOpal() {
		return getSectionOpal();
	}

	@Override
	public java.lang.Integer getIdAsObject() {
		return getSectionOpal().getIdAsObject();
	}

	@Override
	public SectionImpl setId(java.lang.Integer argId) {
		getSectionOpal().setId(argId);
		return this;
	}

	@Override
	public SectionImpl setId(int argId) {
		getSectionOpal().setId(argId);
		return this;
	}

	@Override
	public java.lang.Integer getPacketIdAsObject() {
		return getSectionOpal().getPacketIdAsObject();
	}

	@Override
	public SectionImpl setPacketId(java.lang.Integer argPacketId) {
		getSectionOpal().setPacketId(argPacketId);
		return this;
	}

	@Override
	public SectionImpl setPacketId(int argPacketId) {
		getSectionOpal().setPacketId(argPacketId);
		return this;
	}

	@Override
	public java.lang.String getQuestionTypeCode() {
		return getSectionOpal().getQuestionTypeCode();
	}

	@Override
	public SectionImpl setQuestionTypeCode(java.lang.String argQuestionTypeCode) {
		getSectionOpal().setQuestionTypeCode(argQuestionTypeCode);
		return this;
	}

	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getSectionOpal().getSequenceAsObject();
	}

	@Override
	public SectionImpl setSequence(java.lang.Integer argSequence) {
		getSectionOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public SectionImpl setSequence(int argSequence) {
		getSectionOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public java.lang.String getName() {
		return getSectionOpal().getName();
	}

	@Override
	public SectionImpl setName(java.lang.String argName) {
		getSectionOpal().setName(argName);
		return this;
	}

	@Override
	public java.lang.String getShortName() {
		return getSectionOpal().getShortName();
	}

	@Override
	public SectionImpl setShortName(java.lang.String argShortName) {
		getSectionOpal().setShortName(argShortName);
		return this;
	}

	@Override
	public java.lang.Boolean isExtrasAsObject() {
		return getSectionOpal().isExtrasAsObject();
	}

	@Override
	public SectionImpl setExtras(java.lang.Boolean argExtras) {
		getSectionOpal().setExtras(argExtras);
		return this;
	}

	@Override
	public SectionImpl setExtras(boolean argExtras) {
		getSectionOpal().setExtras(argExtras);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the QuestionType object created from section through reference section_to_question_type */

	@Override
	public QuestionType getQuestionType() {
		QuestionTypeOpal lclQuestionTypeOpal = getSectionOpal().getQuestionTypeOpal();
		return lclQuestionTypeOpal == null ? null : lclQuestionTypeOpal.getUserFacing();
	}

	@Override
	public Section setQuestionType(QuestionType argQuestionType) {
		getSectionOpal().setQuestionTypeOpal(argQuestionType == null ? null : ((QuestionTypeImpl) argQuestionType).getQuestionTypeOpal());
		return this;
	}

	/** @return the Packet object created from section through reference section_to_packet */

	@Override
	public Packet getPacket() {
		PacketOpal lclPacketOpal = getSectionOpal().getPacketOpal();
		return lclPacketOpal == null ? null : lclPacketOpal.getUserFacing();
	}

	@Override
	public Section setPacket(Packet argPacket) {
		getSectionOpal().setPacketOpal(argPacket == null ? null : ((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void addPlacement(Placement argPlacement) {
		getSectionOpal().addPlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
	}

	@Override
	public void removePlacement(Placement argPlacement) {
		getSectionOpal().removePlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
	}

	@Override
	public int getPlacementCount() {
		return getSectionOpal().getPlacementOpalCount();
	}

	@Override
	public java.util.stream.Stream<Placement> streamPlacement() {
		return getSectionOpal().streamPlacementOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Placement> createPlacementIterator() {
		return new com.opal.OpalIterator<> (getSectionOpal().createPlacementOpalIterator());
	}

	@Override
	public void clearPlacement() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void unlink() {
		getSectionOpal().unlink();
	}

	@Override
	public void reload() {
		getSectionOpal().reload();
	}

	@Override
	public Section copy() {
		return getSectionOpal().copy().getUserFacing();
	}

}
