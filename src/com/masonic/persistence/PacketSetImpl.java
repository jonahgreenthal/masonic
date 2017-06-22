package com.masonic.persistence;


public class PacketSetImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.PacketSet, com.masonic.persistence.PacketSetOpal> implements com.masonic.application.PacketSet {

	private final com.masonic.persistence.PacketSetOpal myPacketSetOpal;

	public PacketSetImpl(PacketSetOpal argPacketSetOpal) {
		super();
		myPacketSetOpal = org.apache.commons.lang3.Validate.notNull(argPacketSetOpal);
	}

	protected com.masonic.persistence.PacketSetOpal getPacketSetOpal() {
		return myPacketSetOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.PacketSet> getOpal() {
		return getPacketSetOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.PacketSet> getBottomOpal() {
		return getPacketSetOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getCode() {
		return getPacketSetOpal().getCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.PacketSetImpl setCode(java.lang.String argCode) {
		getPacketSetOpal().setCode(argCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getPacketSetOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.PacketSetImpl setName(java.lang.String argName) {
		getPacketSetOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getPacketSetOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.PacketSetImpl setShortName(java.lang.String argShortName) {
		getPacketSetOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@Override
	public java.time.LocalDate getDeadline() {
		return getPacketSetOpal().getDeadline();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@Override
	public com.masonic.persistence.PacketSetImpl setDeadline(java.time.LocalDate argDeadline) {
		getPacketSetOpal().setDeadline(argDeadline);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getNote() {
		return getPacketSetOpal().getNote();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.PacketSetImpl setNote(java.lang.String argNote) {
		getPacketSetOpal().setNote(argNote);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public java.lang.Boolean isCompletedAsObject() {
		return getPacketSetOpal().isCompletedAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public com.masonic.persistence.PacketSetImpl setCompleted(java.lang.Boolean argCompleted) {
		getPacketSetOpal().setCompleted(argCompleted);
		return this;
	}

	@Override
	public com.masonic.persistence.PacketSetImpl setCompleted(boolean argCompleted) {
		getPacketSetOpal().setCompleted(argCompleted);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public java.lang.Boolean isReusesQuestionsAsObject() {
		return getPacketSetOpal().isReusesQuestionsAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public com.masonic.persistence.PacketSetImpl setReusesQuestions(java.lang.Boolean argReusesQuestions) {
		getPacketSetOpal().setReusesQuestions(argReusesQuestions);
		return this;
	}

	@Override
	public com.masonic.persistence.PacketSetImpl setReusesQuestions(boolean argReusesQuestions) {
		getPacketSetOpal().setReusesQuestions(argReusesQuestions);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.PacketSet addIntendedQuestion(com.masonic.application.Question argQuestion) {
		getPacketSetOpal().addIntendedQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.PacketSet removeIntendedQuestion(com.masonic.application.Question argQuestion) {
		getPacketSetOpal().removeIntendedQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getIntendedQuestionCount() {
		return getPacketSetOpal().getIntendedQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Question> streamIntendedQuestion() {
		return getPacketSetOpal().streamIntendedQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Question> createIntendedQuestionIterator() {
		return new com.opal.OpalIterator<> (getPacketSetOpal().createIntendedQuestionOpalIterator());
	}

	@Override
	public com.masonic.application.PacketSet addPacket(com.masonic.application.Packet argPacket) {
		getPacketSetOpal().addPacketOpal(((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	@Override
	public com.masonic.application.PacketSet removePacket(com.masonic.application.Packet argPacket) {
		getPacketSetOpal().removePacketOpal(((PacketImpl) argPacket).getPacketOpal());
		return this;
	}

	@Override
	public int getPacketCount() {
		return getPacketSetOpal().getPacketOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Packet> streamPacket() {
		return getPacketSetOpal().streamPacketOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Packet> createPacketIterator() {
		return new com.opal.OpalIterator<> (getPacketSetOpal().createPacketOpalIterator());
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
	public com.masonic.application.PacketSet copy() {
		return getPacketSetOpal().copy().getUserFacing();
	}

}
