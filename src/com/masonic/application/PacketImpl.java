package com.masonic.application;

import com.masonic.persistence.PacketOpal;
import com.masonic.persistence.PacketSetOpal;

public class PacketImpl extends com.opal.AbstractIdentityImpl<Packet, PacketOpal> implements Packet {
	private final PacketOpal myPacketOpal;

	public PacketImpl(PacketOpal argPacketOpal) {
		super();
		myPacketOpal = org.apache.commons.lang3.Validate.notNull(argPacketOpal);
	}

	protected PacketOpal getPacketOpal() {
		return myPacketOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends Packet> getOpal() {
		return getPacketOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends Packet> getBottomOpal() {
		return getPacketOpal();
	}

	@Override
	public int compareTo(Packet argSecond) {
		return this.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
	}

	@Override
	public java.lang.Integer getIdAsObject() {
		return getPacketOpal().getIdAsObject();
	}

	@Override
	public PacketImpl setId(java.lang.Integer argId) {
		getPacketOpal().setId(argId);
		return this;
	}

	@Override
	public PacketImpl setId(int argId) {
		getPacketOpal().setId(argId);
		return this;
	}

	@Override
	public java.lang.String getPacketSetCode() {
		return getPacketOpal().getPacketSetCode();
	}

	@Override
	public PacketImpl setPacketSetCode(java.lang.String argPacketSetCode) {
		getPacketOpal().setPacketSetCode(argPacketSetCode);
		return this;
	}

	@Override
	public java.lang.String getName() {
		return getPacketOpal().getName();
	}

	@Override
	public PacketImpl setName(java.lang.String argName) {
		getPacketOpal().setName(argName);
		return this;
	}

	@Override
	public java.lang.String getShortName() {
		return getPacketOpal().getShortName();
	}

	@Override
	public PacketImpl setShortName(java.lang.String argShortName) {
		getPacketOpal().setShortName(argShortName);
		return this;
	}

	@Override
	public java.lang.Integer getSequenceAsObject() {
		return getPacketOpal().getSequenceAsObject();
	}

	@Override
	public PacketImpl setSequence(java.lang.Integer argSequence) {
		getPacketOpal().setSequence(argSequence);
		return this;
	}

	@Override
	public PacketImpl setSequence(int argSequence) {
		getPacketOpal().setSequence(argSequence);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the PacketSet object created from packet through reference packet_to_packet_set */

	@Override
	public PacketSet getPacketSet() {
		PacketSetOpal lclPacketSetOpal = getPacketOpal().getPacketSetOpal();
		return lclPacketSetOpal == null ? null : lclPacketSetOpal.getUserFacing();
	}

	@Override
	public Packet setPacketSet(PacketSet argPacketSet) {
		getPacketOpal().setPacketSetOpal(argPacketSet == null ? null : ((PacketSetImpl) argPacketSet).getPacketSetOpal());
		return this;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.Packet addSection(Section argSection) {
		getPacketOpal().addSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public com.masonic.application.Packet removeSection(Section argSection) {
		getPacketOpal().removeSectionOpal(((SectionImpl) argSection).getSectionOpal());
		return this;
	}

	@Override
	public int getSectionCount() {
		return getPacketOpal().getSectionOpalCount();
	}

	@Override
	public java.util.stream.Stream<Section> streamSection() {
		return getPacketOpal().streamSectionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Section> createSectionIterator() {
		return new com.opal.OpalIterator<> (getPacketOpal().createSectionOpalIterator());
	}

	@Override
	public com.masonic.application.Packet clearSection() {
		throw new UnsupportedOperationException();
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
	public Packet copy() {
		return getPacketOpal().copy().getUserFacing();
	}

}
