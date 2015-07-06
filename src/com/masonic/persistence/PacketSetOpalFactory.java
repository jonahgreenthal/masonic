package com.masonic.persistence;
import com.masonic.application.PacketSet;
import com.opal.PersistenceException;

public interface PacketSetOpalFactory extends com.opal.OpalFactory<PacketSet, PacketSetOpal>, com.opal.OpalFactoryCreator<PacketSet, PacketSetOpal> {
	public PacketSetOpal forCode(java.lang.String argCode) throws PersistenceException;
	public PacketSetOpal forName(java.lang.String argName) throws PersistenceException;
	public PacketSetOpal forShortName(java.lang.String argShortName) throws PersistenceException;
}
