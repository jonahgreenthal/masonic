package com.masonic.application;

import com.masonic.persistence.PlacementUserFacing;

/**
 * This interface may be changed at will.
 *
 * <p>This interface and the {@link PlacementFactory} class are the only two automatically generated files for this type that are intended to be referenced in user code. Other automatically generated files package) are intended to be invisible to the user's code and may change (or disappear entirely) when newer versions of the Opal generating code is used.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */

public interface Placement extends PlacementUserFacing {
	default PacketSet getPacketSet() {
		return getSection().getPacket().getPacketSet();
	}
	
	default Packet getPacket() {
		return getSection().getPacket();
	}
	
	default String getString() {
		return getPacket().getName() + " section " + getSection().getSequence() + " #" + getSequence();
	}
	
	default String getShortString() {
		return getPacket().getName() + " &sect;" + getSection().getSequence() + " #" + getSequence();
	}
	
	default String getStringWithPacketSet() {
		return getPacketSet().getName() + ' ' + getString();
	}
	
	default String getStringWithPacketSetShortName() {
		return getPacketSet().getShortName() + ' ' + getShortString();
	}
	
	default boolean isEmpty() {
		return getQuestion() == null;
	}
	
	default boolean isFilled() {
		return getQuestion() != null;
	}
}
