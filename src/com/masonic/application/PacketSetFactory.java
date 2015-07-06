package com.masonic.application;

import com.opal.*;
import com.masonic.persistence.PacketSetOpalFactory;
import com.masonic.persistence.PacketSetOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class PacketSetFactory extends com.opal.AbstractFactory<PacketSet, PacketSetOpal> implements com.opal.FactoryCreator<PacketSet>, com.opal.IdentityFactory<PacketSet> {
	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final PacketSetFactory ourInstance = new PacketSetFactory(OpalFactoryFactory.getInstance().getPacketSetOpalFactory());

	public static PacketSetFactory getInstance() { return ourInstance; }

	public PacketSetOpalFactory getPacketSetOpalFactory() { return (PacketSetOpalFactory) getOpalFactory(); }

	protected PacketSetFactory(OpalFactory<PacketSet, PacketSetOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<PacketSet> getUserFacingInterface() {
		return PacketSet.class;
	}


	/* These Singleton objects are initialized on system start up to refer to unchanging objects
		from the database.
	*/

	public static final PacketSet _2015_SECTIONALS() { return getInstance().forCode("2015_SECTIONALS"); }
	public static final PacketSet _2016_SECTIONALS() { return getInstance().forCode("2016_SECTIONALS"); }
	public static final PacketSet _2016_STATE() { return getInstance().forCode("2016_STATE"); }

	@Override
	public PacketSet create() {
		return getPacketSetOpalFactory().create().getUserFacing();
	}

	public PacketSet forCode(java.lang.String argCode) {
		PacketSetOpal lclPacketSetOpal = getPacketSetOpalFactory().forCode(argCode);
		return (lclPacketSetOpal == null) ? null : lclPacketSetOpal.getUserFacing();
	}

	public PacketSet forName(java.lang.String argName) {
		PacketSetOpal lclPacketSetOpal = getPacketSetOpalFactory().forName(argName);
		return (lclPacketSetOpal == null) ? null : lclPacketSetOpal.getUserFacing();
	}

	public PacketSet forShortName(java.lang.String argShortName) {
		PacketSetOpal lclPacketSetOpal = getPacketSetOpalFactory().forShortName(argShortName);
		return (lclPacketSetOpal == null) ? null : lclPacketSetOpal.getUserFacing();
	}

	@Override
	public PacketSet[] createArray(int argSize) {
		return new PacketSet[argSize];
	}

	public PacketSet fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "packet_set_code");
	}

	public PacketSet fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argCode) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclCodeString = argRequest.getParameter(argCode);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclCodeString)) {
			return null;
		}
		java.lang.String lclCode = lclCodeString;
		return forCode(lclCode);
	}

	public <T extends java.util.Collection<? super PacketSet>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		org.apache.commons.lang3.Validate.notNull(argCollection);
		org.apache.commons.lang3.Validate.notNull(argRequest);
		org.apache.commons.lang3.Validate.notEmpty(argParameterName);
		String[] lclValues = argRequest.getParameterValues(argParameterName);
		if (lclValues == null || lclValues.length == 0) {
			return argCollection;
		}
		for (String lclValueUntrimmed : lclValues) {
			String lclValue = org.apache.commons.lang3.StringUtils.trimToNull(lclValueUntrimmed);
			if (lclValue == null) {
				continue;
			}
			java.lang.String lclCode = lclValue;
			PacketSet lclResult = forCode(lclCode);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid Code for any PacketSet");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super PacketSet>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "packet_set_code");
	}

	public java.util.Collection<PacketSet> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<PacketSet> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "packet_set_code");
	}

	public PacketSet[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<PacketSet> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public PacketSet[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "packet_set_code");
	}

	@Override
	public PacketSet forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		PacketSetOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
