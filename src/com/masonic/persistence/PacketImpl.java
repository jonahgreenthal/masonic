package com.masonic.persistence;


public class PacketImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.Packet, com.masonic.persistence.PacketOpal> implements com.masonic.application.Packet {

	private final com.masonic.persistence.PacketOpal myPacketOpal;

	public PacketImpl(PacketOpal argPacketOpal) {
		super();
		myPacketOpal = org.apache.commons.lang3.Validate.notNull(argPacketOpal);
	}

	protected com.masonic.persistence.PacketOpal getPacketOpal() {
		return myPacketOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Packet> getOpal() {
		return getPacketOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Packet> getBottomOpal() {
		return getPacketOpal();
	}

	@Override
	public int compareTo(com.masonic.application.Packet argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getIdAsObject() {
		return getPacketOpal().getIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.PacketImpl setId(java.lang.Integer argId) {
		getPacketOpal().setId(argId);
		return this;
	}

	@Override
	public com.masonic.persistence.PacketImpl setId(int argId) {
		getPacketOpal().setId(argId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getPacketSetCode() {
		return getPacketOpal().getPacketSetCode();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.PacketImpl setPacketSetCode(java.lang.String argPacketSetCode) {
		getPacketOpal().setPacketSetCode(argPacketSetCode);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getPacketOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.PacketImpl setName(java.lang.String argName) {
		getPacketOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public java.lang.String getShortName() {
		return getPacketOpal().getShortName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@Override
	public com.masonic.persistence.PacketImpl setShortName(java.lang.String argShortName) {
		getPacketOpal().setShortName(argShortName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getPacketOpal().getSequenceAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.PacketImpl setSequence(java.lang.Integer argSequence) {
		getPacketOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public com.masonic.persistence.PacketImpl setSequence(int argSequence) {
		getPacketOpal().setSequence(argSequence);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the PacketSet object created from packet through reference packet_to_packet_set */

	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.application.PacketSet getPacketSet() {
		PacketSetOpal lclPacketSetOpal = getPacketOpal().getPacketSetOpal();
		return lclPacketSetOpal == null ? null : lclPacketSetOpal.getUserFacing();
	}

	@Override
	public com.masonic.application.Packet setPacketSet(com.masonic.application.PacketSet argPacketSet) {
		getPacketOpal().setPacketSetOpal(argPacketSet == null ? null : ((PacketSetImpl) argPacketSet).getPacketSetOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.Packet addSection(com.masonic.application.Section argSection) {
		getPacketOpal().addSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public com.masonic.application.Packet removeSection(com.masonic.application.Section argSection) {
		getPacketOpal().removeSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public int getSectionCount() {
		return getPacketOpal().getSectionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Section> streamSection() {
		return getPacketOpal().streamSectionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Section> createSectionIterator() {
		return new com.opal.OpalIterator<> (getPacketOpal().createSectionOpalIterator());
	}

	@Override
	public void unlink() {
		getPacketOpal().unlink();
	}

	@Override
	public void reload() {
		getPacketOpal().reload();
	}

	@Override
	public com.masonic.application.Packet copy() {
		return getPacketOpal().copy().getUserFacing();
	}

}
