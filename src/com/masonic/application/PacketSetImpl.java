package com.masonic.application;

import com.masonic.persistence.PacketSetOpal;

public class PacketSetImpl extends com.opal.AbstractIdentityImpl<PacketSet, PacketSetOpal> implements PacketSet {
	private final PacketSetOpal myPacketSetOpal;

	public PacketSetImpl(PacketSetOpal argPacketSetOpal) {
		super();
		myPacketSetOpal = org.apache.commons.lang3.Validate.notNull(argPacketSetOpal);
	}

	protected PacketSetOpal getPacketSetOpal() {
		return myPacketSetOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends PacketSet> getOpal() {
		return getPacketSetOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends PacketSet> getBottomOpal() {
		return getPacketSetOpal();
	}

	@Override
	public java.lang.String getCode() {
		return getPacketSetOpal().getCode();
	}

	@Override
	public PacketSetImpl setCode(java.lang.String argCode) {
		getPacketSetOpal().setCode(argCode);
		return this;
	}

	@Override
	public java.lang.String getName() {
		return getPacketSetOpal().getName();
	}

	@Override
	public PacketSetImpl setName(java.lang.String argName) {
		getPacketSetOpal().setName(argName);
		return this;
	}

	@Override
	public java.lang.String getShortName() {
		return getPacketSetOpal().getShortName();
	}

	@Override
	public PacketSetImpl setShortName(java.lang.String argShortName) {
		getPacketSetOpal().setShortName(argShortName);
		return this;
	}

	@Override
	public java.time.LocalDate getDeadline() {
		return getPacketSetOpal().getDeadline();
	}

	@Override
	public PacketSetImpl setDeadline(java.time.LocalDate argDeadline) {
		getPacketSetOpal().setDeadline(argDeadline);
		return this;
	}

	@Override
	public java.lang.String getNote() {
		return getPacketSetOpal().getNote();
	}

	@Override
	public PacketSetImpl setNote(java.lang.String argNote) {
		getPacketSetOpal().setNote(argNote);
		return this;
	}

	@Override
	public java.lang.Boolean isCompletedAsObject() {
		return getPacketSetOpal().isCompletedAsObject();
	}

	@Override
	public PacketSetImpl setCompleted(java.lang.Boolean argCompleted) {
		getPacketSetOpal().setCompleted(argCompleted);
		return this;
	}

	@Override
	public PacketSetImpl setCompleted(boolean argCompleted) {
		getPacketSetOpal().setCompleted(argCompleted);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.PacketSet addIntendedQuestion(Question argQuestion) {
		getPacketSetOpal().addIntendedQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.PacketSet removeIntendedQuestion(Question argQuestion) {
		getPacketSetOpal().removeIntendedQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getIntendedQuestionCount() {
		return getPacketSetOpal().getIntendedQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<Question> streamIntendedQuestion() {
		return getPacketSetOpal().streamIntendedQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Question> createIntendedQuestionIterator() {
		return new com.opal.OpalIterator<> (getPacketSetOpal().createIntendedQuestionOpalIterator());
	}

	@Override
	public com.masonic.application.PacketSet clearIntendedQuestion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public com.masonic.application.PacketSet addPacket(Packet argPacket) {
		getPacketSetOpal().addPacketOpal(((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	@Override
	public com.masonic.application.PacketSet removePacket(Packet argPacket) {
		getPacketSetOpal().removePacketOpal(((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	@Override
	public int getPacketCount() {
		return getPacketSetOpal().getPacketOpalCount();
	}

	@Override
	public java.util.stream.Stream<Packet> streamPacket() {
		return getPacketSetOpal().streamPacketOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Packet> createPacketIterator() {
		return new com.opal.OpalIterator<> (getPacketSetOpal().createPacketOpalIterator());
	}

	@Override
	public com.masonic.application.PacketSet clearPacket() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void unlink() {
		getPacketSetOpal().unlink();
	}

	@Override
	public void reload() {
		getPacketSetOpal().reload();
	}

	@Override
	public PacketSet copy() {
		return getPacketSetOpal().copy().getUserFacing();
	}

}
