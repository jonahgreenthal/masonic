package com.masonic.persistence;


public class SectionImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.Section, com.masonic.persistence.SectionOpal> implements com.masonic.application.Section {

	private final com.masonic.persistence.SectionOpal mySectionOpal;

	public SectionImpl(SectionOpal argSectionOpal) {
		super();
		mySectionOpal = org.apache.commons.lang3.Validate.notNull(argSectionOpal);
	}

	protected com.masonic.persistence.SectionOpal getSectionOpal() {
		return mySectionOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Section> getOpal() {
		return getSectionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Section> getBottomOpal() {
		return getSectionOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getIdAsObject() {
		return getSectionOpal().getIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.SectionImpl setId(java.lang.Integer argId) {
		getSectionOpal().setId(argId);
		return this;
	}

	@Override
	public com.masonic.persistence.SectionImpl setId(int argId) {
		getSectionOpal().setId(argId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getPacketIdAsObject() {
		return getSectionOpal().getPacketIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.SectionImpl setPacketId(java.lang.Integer argPacketId) {
		getSectionOpal().setPacketId(argPacketId);
		return this;
	}

	@Override
	public com.masonic.persistence.SectionImpl setPacketId(int argPacketId) {
		getSectionOpal().setPacketId(argPacketId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getQuestionTypeCode() {
		return getSectionOpal().getQuestionTypeCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.SectionImpl setQuestionTypeCode(java.lang.String argQuestionTypeCode) {
		getSectionOpal().setQuestionTypeCode(argQuestionTypeCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getSectionOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.SectionImpl setSequence(java.lang.Integer argSequence) {
		getSectionOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.SectionImpl setSequence(int argSequence) {
		getSectionOpal().setSequence(argSequence);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getSectionOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.SectionImpl setName(java.lang.String argName) {
		getSectionOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getSectionOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.SectionImpl setShortName(java.lang.String argShortName) {
		getSectionOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public java.lang.Boolean isExtrasAsObject() {
		return getSectionOpal().isExtrasAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public com.masonic.persistence.SectionImpl setExtras(java.lang.Boolean argExtras) {
		getSectionOpal().setExtras(argExtras);
		return this;
	}

	@Override
	public com.masonic.persistence.SectionImpl setExtras(boolean argExtras) {
		getSectionOpal().setExtras(argExtras);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the Packet object created from section through reference section_to_packet */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.Packet getPacket() {
		PacketOpal lclPacketOpal = getSectionOpal().getPacketOpal();
		return lclPacketOpal == null ? null : lclPacketOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Section setPacket(com.masonic.application.Packet argPacket) {
		getSectionOpal().setPacketOpal(argPacket == null ? null : ((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	/** @return the QuestionType object created from section through reference section_to_question_type */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.QuestionType getQuestionType() {
		QuestionTypeOpal lclQuestionTypeOpal = getSectionOpal().getQuestionTypeOpal();
		return lclQuestionTypeOpal == null ? null : lclQuestionTypeOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Section setQuestionType(com.masonic.application.QuestionType argQuestionType) {
		getSectionOpal().setQuestionTypeOpal(argQuestionType == null ? null : ((QuestionTypeImpl) argQuestionType).getQuestionTypeOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.Section addPlacement(com.masonic.application.Placement argPlacement) {
		getSectionOpal().addPlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
		return this;
	}

	@Override
	public com.masonic.application.Section removePlacement(com.masonic.application.Placement argPlacement) {
		getSectionOpal().removePlacementOpal(((PlacementImpl) argPlacement).getPlacementOpal());
		return this;
	}

	@Override
	public int getPlacementCount() {
		return getSectionOpal().getPlacementOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Placement> streamPlacement() {
		return getSectionOpal().streamPlacementOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Placement> createPlacementIterator() {
		return new com.opal.OpalIterator<> (getSectionOpal().createPlacementOpalIterator());
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
	public com.masonic.application.Section copy() {
		return getSectionOpal().copy().getUserFacing();
	}

}
