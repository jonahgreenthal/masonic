package com.masonic.persistence;

import com.masonic.application.Placement;

@com.opal.StoreGeneratedPrimaryKey
public final class PlacementOpal extends com.opal.UpdatableOpal<Placement> {


	private PlacementOpal() {
		super();
		setUserFacing(null);
	}

	public PlacementOpal(com.opal.IdentityOpalFactory<Placement, PlacementOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void initializeReferences() {
		myOldSectionOpal = SectionOpal.NOT_YET_LOADED;
		myOldQuestionOpal = QuestionOpal.NOT_YET_LOADED;
		myOldCategoryOpal = CategoryOpal.NOT_YET_LOADED;
		return;
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"Id",
		"SectionId",
		"CategoryCode",
		"Sequence",
		"QuestionId",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.Integer.class,
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.Integer.class,
		java.lang.Integer.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
		false,
		true,
	};

	/* package */ static final com.opal.FieldValidator[] ourFieldValidators = new com.opal.FieldValidator[] {
		null,
		null,
		null,
		null,
		null,
	};

	public static final PlacementOpal NOT_YET_LOADED = new PlacementOpal();

	public static String[] getStaticFieldNames() { return ourFieldNames; }

	public static Class<?>[] getStaticFieldTypes() { return ourFieldTypes; }

	@Override
	public Class<?>[] getFieldTypes() { return ourFieldTypes; }

	public static boolean[] getStaticFieldNullability() { return ourFieldNullability; }

	@Override
	public com.opal.FieldValidator[] getFieldValidators() { return ourFieldValidators; }

	@Override
	public boolean[] getFieldNullability() { return ourFieldNullability; }

	public static com.opal.FieldValidator[] getStaticFieldValidators() { return ourFieldValidators; }


	public synchronized java.lang.Integer getIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[0];
	}

	public synchronized java.lang.Integer getSectionIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[1];
	}

	public synchronized java.lang.String getCategoryCode() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.lang.Integer getSequenceAsObject() {
		return (java.lang.Integer) getReadValueSet()[3];
	}

	public synchronized java.lang.Integer getQuestionIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[4];
	}

	public synchronized PlacementOpal setId(final java.lang.Integer argId) {
		tryMutate();
		if (argId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myId on " + this + " to null.");
		}
		getNewValues()[0] = argId;
		return this;
	}

	public PlacementOpal setId(final int argId) {
		setId(java.lang.Integer.valueOf(argId));
		return this;
	}

	public synchronized PlacementOpal setSectionId(final java.lang.Integer argSectionId) {
		tryMutate();
		if (argSectionId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set mySectionId on " + this + " to null.");
		}
		getNewValues()[1] = argSectionId;
		return this;
	}

	public PlacementOpal setSectionId(final int argSectionId) {
		setSectionId(java.lang.Integer.valueOf(argSectionId));
		return this;
	}

	public synchronized PlacementOpal setCategoryCode(final java.lang.String argCategoryCode) {
		tryMutate();
		if (argCategoryCode == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myCategoryCode on " + this + " to null.");
		}
		if (argCategoryCode.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Cannot set myCategoryCode on " + this + " to \"" + argCategoryCode + "\" because that field's maximum length is 32.", argCategoryCode.length(), 32);
		}
		getNewValues()[2] = argCategoryCode;
		return this;
	}

	public synchronized PlacementOpal setSequence(final java.lang.Integer argSequence) {
		tryMutate();
		if (argSequence == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set mySequence on " + this + " to null.");
		}
		getNewValues()[3] = argSequence;
		return this;
	}

	public PlacementOpal setSequence(final int argSequence) {
		setSequence(java.lang.Integer.valueOf(argSequence));
		return this;
	}

	public synchronized PlacementOpal setQuestionId(final java.lang.Integer argQuestionId) {
		tryMutate();
		getNewValues()[4] = argQuestionId;
		return this;
	}

	public PlacementOpal setQuestionId(final int argQuestionId) {
		setQuestionId(java.lang.Integer.valueOf(argQuestionId));
		return this;
	}

	@Override
	protected /* synchronized */ void copyOldValuesToNewInternal() {
		myNewSectionOpal = myOldSectionOpal;
		myNewQuestionOpal = myOldQuestionOpal;
		myNewCategoryOpal = myOldCategoryOpal;
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		myOldSectionOpal = myNewSectionOpal;
		myOldQuestionOpal = myNewQuestionOpal;
		myOldCategoryOpal = myNewCategoryOpal;

		return;
	}

	@Override
	protected void unlinkInternal() {
		if (getSectionOpal() != null) {
			getSectionOpal().removePlacementOpalInternal(this);
		}
		if (getCategoryOpal() != null) {
			getCategoryOpal().removePlacementOpalInternal(this);
		}
		if (getQuestionOpal() != null) {
			getQuestionOpal().setPlacementOpalInternal(null);
		}
		return;
	}

	@Override
	protected void copyFieldsToInternal(com.opal.UpdatableOpal<Placement> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (Id) is database generated. */
		/* Field 1 (SectionId) is part of a unique key. */
		lclTargetNewValues[2] = lclValues[2]; /* CategoryCode (immutable) */
		/* Field 3 (Sequence) is part of a unique key. */
		/* Field 4 (QuestionId) is part of a unique key. */

		return;
	}

	@Override
	public synchronized void translateReferencesToFields() {
		if (myNewSectionOpal != SectionOpal.NOT_YET_LOADED) {
			setSectionId(myNewSectionOpal == null ? null : myNewSectionOpal.getIdAsObject());
		}
		if (myNewQuestionOpal != QuestionOpal.NOT_YET_LOADED) {
			setQuestionId(myNewQuestionOpal == null ? null : myNewQuestionOpal.getIdAsObject());
		}
		if (myNewCategoryOpal != CategoryOpal.NOT_YET_LOADED) {
			setCategoryCode(myNewCategoryOpal == null ? null : myNewCategoryOpal.getCode());
		}
		return;
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredPriorCommits() {
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		com.opal.UpdatableOpal<?> lclUO;
		lclUO = myNewCategoryOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
			lclTAs.add(lclUO);
		}
		lclUO = myNewQuestionOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			if (lclTAs == null) {
				lclTAs = new com.siliconage.util.Fast3Set<>();
			}
			lclTAs.add(lclUO);
		}
		lclUO = myNewSectionOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			if (lclTAs == null) {
				lclTAs = new com.siliconage.util.Fast3Set<>();
			}
			lclTAs.add(lclUO);
		}
		return (lclTAs != null) && (lclTAs.size() > 0) ? lclTAs : java.util.Collections.emptySet();
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredSubsequentCommits() {
		if (isNew()) {
			return java.util.Collections.emptySet();
		}
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		com.opal.UpdatableOpal<?> lclUO;
		if ((lclUO = myOldCategoryOpal) == CategoryOpal.NOT_YET_LOADED) {
			lclUO = myOldCategoryOpal = retrieveCategoryOpal(getOldValues());
		}
		if (lclUO != null && lclUO.isDeleted()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
			lclTAs.add(lclUO);
		}
		if ((lclUO = myOldQuestionOpal) == QuestionOpal.NOT_YET_LOADED) {
			lclUO = myOldQuestionOpal = retrieveQuestionOpal(getOldValues());
		}
		if (lclUO != null && lclUO.isDeleted()) {
			if (lclTAs == null) {
				lclTAs = new com.siliconage.util.Fast3Set<>();
			}
			lclTAs.add(lclUO);
		}
		if ((lclUO = myOldSectionOpal) == SectionOpal.NOT_YET_LOADED) {
			lclUO = myOldSectionOpal = retrieveSectionOpal(getOldValues());
		}
		if (lclUO != null && lclUO.isDeleted()) {
			if (lclTAs == null) {
				lclTAs = new com.siliconage.util.Fast3Set<>();
			}
			lclTAs.add(lclUO);
		}
		return (lclTAs != null) && (lclTAs.size() > 0) ? lclTAs : java.util.Collections.emptySet();
	}

	@Override
	public Object[] getPrimaryKeyWhereClauseValues() {
		return new Object[] {getOldValues()[0], };
	}

	private static int getFieldCountInternal() { return ourFieldNames.length; }

	@Override
	protected int getFieldCount() { return getFieldCountInternal(); }

	@Override
	protected String[] getFieldNames() { return ourFieldNames; }

	@Override
	public synchronized void output(final java.io.PrintStream argOutput) {
		argOutput.println("Id = " + getIdAsObject());
		argOutput.println("SectionId = " + getSectionIdAsObject());
		argOutput.println("CategoryCode = " + getCategoryCode());
		argOutput.println("Sequence = " + getSequenceAsObject());
		argOutput.println("QuestionId = " + getQuestionIdAsObject());
	}

	@Override
	public synchronized void output(final java.io.PrintWriter argOutput) {
		argOutput.println("Id = " + getIdAsObject());
		argOutput.println("SectionId = " + getSectionIdAsObject());
		argOutput.println("CategoryCode = " + getCategoryCode());
		argOutput.println("Sequence = " + getSequenceAsObject());
		argOutput.println("QuestionId = " + getQuestionIdAsObject());
	}

	private SectionOpal myOldSectionOpal;
	private SectionOpal myNewSectionOpal;

	protected SectionOpal retrieveSectionOpal(Object[] argValueSet) {
		assert argValueSet != null;
		if ((argValueSet[1] == null)) {
			return null;
		}
		return OpalFactoryFactory.getInstance().getSectionOpalFactory().forId(getSectionIdAsObject());
	}

	public synchronized SectionOpal getSectionOpal() {
		SectionOpal lclSectionOpal;
		boolean lclAccess = tryAccess();
		lclSectionOpal = lclAccess ? myNewSectionOpal : myOldSectionOpal;
		if (lclSectionOpal == SectionOpal.NOT_YET_LOADED) {
			lclSectionOpal = retrieveSectionOpal(getReadValueSet());
			if (lclAccess) {
				myNewSectionOpal = lclSectionOpal;
			} else {
				myOldSectionOpal = lclSectionOpal;
			}
		}
		return lclSectionOpal;
	}

	public synchronized PlacementOpal setSectionOpal(SectionOpal argSectionOpal) {
		tryMutate();
		SectionOpal lclSectionOpal = getSectionOpal();
		if (lclSectionOpal == argSectionOpal) { return this; }
		if (lclSectionOpal != null) {
			lclSectionOpal.removePlacementOpalInternal(this);
		}
		myNewSectionOpal = argSectionOpal;
		if (argSectionOpal != null) {
			argSectionOpal.addPlacementOpalInternal(this);
		}
		return this;
	}

	protected synchronized void setSectionOpalInternal(SectionOpal argSectionOpal) {
		tryMutate();
		myNewSectionOpal = argSectionOpal;
	}

	private QuestionOpal myOldQuestionOpal;
	private QuestionOpal myNewQuestionOpal;

	protected QuestionOpal retrieveQuestionOpal(Object[] argValueSet) {
		assert argValueSet != null;
		if ((argValueSet[4] == null)) {
			return null;
		}
		return OpalFactoryFactory.getInstance().getQuestionOpalFactory().forId(getQuestionIdAsObject());
	}

	public synchronized QuestionOpal getQuestionOpal() {
		QuestionOpal lclQuestionOpal;
		boolean lclAccess = tryAccess();
		lclQuestionOpal = lclAccess ? myNewQuestionOpal : myOldQuestionOpal;
		if (lclQuestionOpal == QuestionOpal.NOT_YET_LOADED) {
			lclQuestionOpal = retrieveQuestionOpal(getReadValueSet());
			if (lclAccess) {
				myNewQuestionOpal = lclQuestionOpal;
			} else {
				myOldQuestionOpal = lclQuestionOpal;
			}
		}
		return lclQuestionOpal;
	}

	public synchronized PlacementOpal setQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewQuestionOpal != null && myNewQuestionOpal != QuestionOpal.NOT_YET_LOADED) {
			myNewQuestionOpal.setPlacementOpalInternal(null);
		}
		myNewQuestionOpal = argQuestionOpal;
		if (argQuestionOpal != null) {
			argQuestionOpal.setPlacementOpalInternal(this);
		}
		return this;
	}

	protected synchronized void setQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		myNewQuestionOpal = argQuestionOpal;
	}

	private CategoryOpal myOldCategoryOpal;
	private CategoryOpal myNewCategoryOpal;

	protected CategoryOpal retrieveCategoryOpal(Object[] argValueSet) {
		assert argValueSet != null;
		if ((argValueSet[2] == null)) {
			return null;
		}
		return OpalFactoryFactory.getInstance().getCategoryOpalFactory().forCode(getCategoryCode());
	}

	public synchronized CategoryOpal getCategoryOpal() {
		CategoryOpal lclCategoryOpal;
		boolean lclAccess = tryAccess();
		lclCategoryOpal = lclAccess ? myNewCategoryOpal : myOldCategoryOpal;
		if (lclCategoryOpal == CategoryOpal.NOT_YET_LOADED) {
			lclCategoryOpal = retrieveCategoryOpal(getReadValueSet());
			if (lclAccess) {
				myNewCategoryOpal = lclCategoryOpal;
			} else {
				myOldCategoryOpal = lclCategoryOpal;
			}
		}
		return lclCategoryOpal;
	}

	public synchronized PlacementOpal setCategoryOpal(CategoryOpal argCategoryOpal) {
		tryMutate();
		CategoryOpal lclCategoryOpal = getCategoryOpal();
		if (lclCategoryOpal == argCategoryOpal) { return this; }
		if (lclCategoryOpal != null) {
			lclCategoryOpal.removePlacementOpalInternal(this);
		}
		myNewCategoryOpal = argCategoryOpal;
		if (argCategoryOpal != null) {
			argCategoryOpal.addPlacementOpalInternal(this);
		}
		return this;
	}

	protected synchronized void setCategoryOpalInternal(CategoryOpal argCategoryOpal) {
		tryMutate();
		myNewCategoryOpal = argCategoryOpal;
	}

	@Override
	public java.lang.String toString() {
		java.lang.StringBuilder lclSB = new java.lang.StringBuilder(64);
		lclSB.append("PlacementOpal[");
		lclSB.append("myId=");
		lclSB.append(toStringField(0));
		lclSB.append(']');
		return lclSB.toString();
	}

	@Override
	protected void updateReferencesAfterReload() {
		if (myNewSectionOpal != SectionOpal.NOT_YET_LOADED) {
			setSectionOpal(retrieveSectionOpal(getNewValues()));
		}
		if (myNewQuestionOpal != QuestionOpal.NOT_YET_LOADED) {
			setQuestionOpal(retrieveQuestionOpal(getNewValues()));
		}
		if (myNewCategoryOpal != CategoryOpal.NOT_YET_LOADED) {
			setCategoryOpal(retrieveCategoryOpal(getNewValues()));
		}
	}

}
