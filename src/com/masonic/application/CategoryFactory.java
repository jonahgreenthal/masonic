package com.masonic.application;

import com.opal.*;
import com.masonic.persistence.CategoryOpalFactory;
import com.masonic.persistence.CategoryOpal;
import com.masonic.persistence.OpalFactoryFactory;

public class CategoryFactory extends com.opal.AbstractFactory<Category, CategoryOpal> implements com.opal.FactoryCreator<Category>, com.opal.IdentityFactory<Category> {
	/** This static variable holds the Singleton instance of the Factory for application
		objects of this type.  It is private, but can be accessed via the getInstance() method.
	*/

	private static final CategoryFactory ourInstance = new CategoryFactory(OpalFactoryFactory.getInstance().getCategoryOpalFactory());

	public static CategoryFactory getInstance() { return ourInstance; }

	public CategoryOpalFactory getCategoryOpalFactory() { return (CategoryOpalFactory) getOpalFactory(); }

	protected CategoryFactory(OpalFactory<Category, CategoryOpal> argOpalFactory) {
		super(argOpalFactory);
	}

	@Override
	public Class<Category> getUserFacingInterface() {
		return Category.class;
	}


	/* These Singleton objects are initialized on system start up to refer to unchanging objects
		from the database.
	*/

	public static final Category AGRICULTURE() { return getInstance().forCode("AGRICULTURE"); }
	public static final Category ALGEBRA() { return getInstance().forCode("ALGEBRA"); }
	public static final Category ANALYTIC_GEOMETRY() { return getInstance().forCode("ANALYTIC_GEOMETRY"); }
	public static final Category ART_HISTORY() { return getInstance().forCode("ART_HISTORY"); }
	public static final Category ART_THEORY() { return getInstance().forCode("ART_THEORY"); }
	public static final Category ASTRONOMY() { return getInstance().forCode("ASTRONOMY"); }
	public static final Category BIOLOGY() { return getInstance().forCode("BIOLOGY"); }
	public static final Category BRITISH_LITERATURE() { return getInstance().forCode("BRITISH_LITERATURE"); }
	public static final Category CHEMISTRY() { return getInstance().forCode("CHEMISTRY"); }
	public static final Category CLASSICAL_MUSIC_OPERA() { return getInstance().forCode("CLASSICAL_MUSIC_OPERA"); }
	public static final Category CONSUMER_EDUCATION() { return getInstance().forCode("CONSUMER_EDUCATION"); }
	public static final Category CURRENT_EVENTS() { return getInstance().forCode("CURRENT_EVENTS"); }
	public static final Category EARTH_SCIENCE() { return getInstance().forCode("EARTH_SCIENCE"); }
	public static final Category ECONOMICS() { return getInstance().forCode("ECONOMICS"); }
	public static final Category ENVIRONMENTAL_SCIENCE() { return getInstance().forCode("ENVIRONMENTAL_SCIENCE"); }
	public static final Category GEOGRAPHY() { return getInstance().forCode("GEOGRAPHY"); }
	public static final Category GEOMETRY() { return getInstance().forCode("GEOMETRY"); }
	public static final Category GRAMMAR_USAGE() { return getInstance().forCode("GRAMMAR_USAGE"); }
	public static final Category HEALTH() { return getInstance().forCode("HEALTH"); }
	public static final Category INDUSTRIAL_ARTS() { return getInstance().forCode("INDUSTRIAL_ARTS"); }
	public static final Category JAZZ() { return getInstance().forCode("JAZZ"); }
	public static final Category JOURNALISM() { return getInstance().forCode("JOURNALISM"); }
	public static final Category MATH_CONCEPTS() { return getInstance().forCode("MATH_CONCEPTS"); }
	public static final Category MODERN_COMPOSERS() { return getInstance().forCode("MODERN_COMPOSERS"); }
	public static final Category MUSICAL_THEATRE() { return getInstance().forCode("MUSICAL_THEATRE"); }
	public static final Category MUSIC_THEORY() { return getInstance().forCode("MUSIC_THEORY"); }
	public static final Category MYTHOLOGY() { return getInstance().forCode("MYTHOLOGY"); }
	public static final Category PHYSICS() { return getInstance().forCode("PHYSICS"); }
	public static final Category POPULAR_CULTURE() { return getInstance().forCode("POPULAR_CULTURE"); }
	public static final Category PRECALCULUS() { return getInstance().forCode("PRECALCULUS"); }
	public static final Category PROBABILITY() { return getInstance().forCode("PROBABILITY"); }
	public static final Category PSYCHOLOGY() { return getInstance().forCode("PSYCHOLOGY"); }
	public static final Category RELIGION() { return getInstance().forCode("RELIGION"); }
	public static final Category SPEECH() { return getInstance().forCode("SPEECH"); }
	public static final Category SPELLING() { return getInstance().forCode("SPELLING"); }
	public static final Category SPORTS() { return getInstance().forCode("SPORTS"); }
	public static final Category STATISTICS() { return getInstance().forCode("STATISTICS"); }
	public static final Category TECHNOLOGY() { return getInstance().forCode("TECHNOLOGY"); }
	public static final Category TRIGONOMETRY() { return getInstance().forCode("TRIGONOMETRY"); }
	public static final Category US_GOVERNMENT() { return getInstance().forCode("US_GOVERNMENT"); }
	public static final Category US_HISTORY() { return getInstance().forCode("US_HISTORY"); }
	public static final Category US_LITERATURE() { return getInstance().forCode("US_LITERATURE"); }
	public static final Category VOCABULARY() { return getInstance().forCode("VOCABULARY"); }
	public static final Category WORLD_HISTORY() { return getInstance().forCode("WORLD_HISTORY"); }
	public static final Category WORLD_LITERATURE() { return getInstance().forCode("WORLD_LITERATURE"); }

	@Override
	public Category create() {
		return getCategoryOpalFactory().create().getUserFacing();
	}

	public Category forCode(java.lang.String argCode) {
		CategoryOpal lclCategoryOpal = getCategoryOpalFactory().forCode(argCode);
		return (lclCategoryOpal == null) ? null : lclCategoryOpal.getUserFacing();
	}

	public Category forName(java.lang.String argName) {
		CategoryOpal lclCategoryOpal = getCategoryOpalFactory().forName(argName);
		return (lclCategoryOpal == null) ? null : lclCategoryOpal.getUserFacing();
	}

	public Category forShortName(java.lang.String argShortName) {
		CategoryOpal lclCategoryOpal = getCategoryOpalFactory().forShortName(argShortName);
		return (lclCategoryOpal == null) ? null : lclCategoryOpal.getUserFacing();
	}

	@Override
	public Category[] createArray(int argSize) {
		return new Category[argSize];
	}

	public Category fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		return fromHttpRequest(argRequest, "category_code");
	}

	public Category fromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argCode) {
		org.apache.commons.lang3.Validate.notNull(argRequest);
		String lclCodeString = argRequest.getParameter(argCode);
		if (org.apache.commons.lang3.StringUtils.isBlank(lclCodeString)) {
			return null;
		}
		java.lang.String lclCode = lclCodeString;
		return forCode(lclCode);
	}

	public <T extends java.util.Collection<? super Category>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
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
			Category lclResult = forCode(lclCode);
			org.apache.commons.lang3.Validate.notNull(lclResult, "'" + lclValue + "' is not a valid Code for any Category");
			argCollection.add(lclResult);
		}
		return argCollection;
	}

	public <T extends java.util.Collection<? super Category>> T acquireFromHttpRequest(T argCollection, javax.servlet.http.HttpServletRequest argRequest) {
		return acquireFromHttpRequest(argCollection, argRequest, "category_code");
	}

	public java.util.Collection<Category> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		return acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
	}

	public java.util.Collection<Category> multipleFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return multipleFromHttpRequest(argRequest, "category_code");
	}

	public Category[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest, String argParameterName) {
		java.util.LinkedList<Category> lclUs = acquireFromHttpRequest(new java.util.LinkedList<>(), argRequest, argParameterName); // checks parameters for nullity
		return lclUs.toArray(createArray(lclUs.size()));
	}

	public Category[] arrayFromHttpRequest(javax.servlet.http.HttpServletRequest argRequest) {
		return arrayFromHttpRequest(argRequest, "category_code");
	}

	@Override
	public Category forUniqueString(String argUniqueString) {
		if (argUniqueString == null) {
			return null;
		}
		CategoryOpal lclOpal = getOpalFactory().forUniqueString(argUniqueString);
		return lclOpal != null ? lclOpal.getUserFacing() : null;
	}
}
