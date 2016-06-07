package com.masonic.application;

import com.masonic.persistence.SectionOpalFactory;
import com.masonic.persistence.SectionOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class SectionFactory extends com.opal.AbstractIdentityFactory<Section, SectionOpal> implements com.opal.FactoryCreator<Section> {

	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final SectionFactory ourInstance = new SectionFactory(OpalFactoryFactory.getInstance().getSectionOpalFactory());

	public static SectionFactory getInstance() { return ourInstance; }

	public SectionOpalFactory getSectionOpalFactory() { return (SectionOpalFactory) getOpalFactory(); }

	protected SectionFactory(com.opal.IdentityOpalFactory<Section, SectionOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<Section> getUserFacingInterface() {
		return Section.class;
	}

	@Override
	public Section create() {
		return getSectionOpalFactory().create().getUserFacing();
	}

	public Section forId(java.lang.Integer argId) {
		SectionOpal lclSectionOpal = getSectionOpalFactory().forId(argId);
		return (lclSectionOpal == null) ? null : lclSectionOpal.getUserFacing();
	}

	public Section forPacketIdSequence(java.lang.Integer argPacketId, java.lang.Integer argSequence) {
		SectionOpal lclSectionOpal = getSectionOpalFactory().forPacketIdSequence(argPacketId, argSequence);
		return (lclSectionOpal == null) ? null : lclSectionOpal.getUserFacing();
	}

	@Override
	public Section[] createArray(int argSize) {
		return new Section[argSize];
	}

	public Section fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "section_id");
	}

	public Section fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argId) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclIdString = argRequest.getParameter(argId);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclIdString)) {
			return null;
		}
		java.lang.Integer lclId = java.lang.Integer.valueOf(lclIdString);
		return forId(lclId);
	}

	public <T extends java.util.Collection<? super Section>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
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
			java.lang.Integer lclId = java.lang.Integer.valueOf(lclValue);
			Section lclResult = forId(lclId);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid Id for any Section");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super Section>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "section_id");
	}

	public java.util.Collection<Section> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<Section> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "section_id");
	}

	public Section[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<Section> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public Section[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "section_id");
	}

	@Override
	public Section forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		SectionOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
