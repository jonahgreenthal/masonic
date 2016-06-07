package com.masonic.persistence;
import com.masonic.application.Packet;
import com.opal.PersistenceException;

public interface PacketOpalFactory extends com.opal.IdentityOpalFactory<Packet, PacketOpal>, com.opal.OpalFactoryCreator<Packet, PacketOpal> {

	public java.util.HashSet<PacketOpal> forPacketSetCodeCollection(java.lang.String argPacketSetCode) throws com.opal.PersistenceException;
	public PacketOpal forId(java.lang.Integer argId) throws PersistenceException;
	public PacketOpal forPacketSetCodeName(java.lang.String argPacketSetCode, java.lang.String argName) throws PersistenceException;
	public PacketOpal forPacketSetCodeSequence(java.lang.String argPacketSetCode, java.lang.Integer argSequence) throws PersistenceException;
	public PacketOpal forPacketSetCodeShortName(java.lang.String argPacketSetCode, java.lang.String argShortName) throws PersistenceException;
}
