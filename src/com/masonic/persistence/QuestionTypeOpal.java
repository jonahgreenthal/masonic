package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

public final class QuestionTypeOpal extends com.opal.UpdatableOpal<QuestionType> {

	private QuestionTypeOpal() {
		super();
		setUserFacing(null);
	}

	public QuestionTypeOpal(OpalFactory<QuestionType, QuestionTypeOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"Code",
		"Name",
		"ShortName",
		"Sequence",
		"TableName",
		"SectionHeader",
		"ScoringNote",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
		false,
		false,
		true,
		false,
	};

	/* package */ static final FieldValidator[] ourFieldValidators = new FieldValidator[] {
		null,
		null,
		null,
		null,
		null,
		null,
		null,
	};

	public static final QuestionTypeOpal NOT_YET_LOADED = new QuestionTypeOpal();

	public static String[] getStaticFieldNames() { return ourFieldNames; }

	public static Class<?>[] getStaticFieldTypes() { return ourFieldTypes; }

	@Override
	public Class<?>[] getFieldTypes() { return ourFieldTypes; }

	public static boolean[] getStaticFieldNullability() { return ourFieldNullability; }

	@Override
	public FieldValidator[] getFieldValidators() { return ourFieldValidators; }

	@Override
	public boolean[] getFieldNullability() { return ourFieldNullability; }

	public static FieldValidator[] getStaticFieldValidators() { return ourFieldValidators; }


	public synchronized java.lang.String getCode() {
		return (java.lang.String) getReadValueSet()[0];
	}

	public synchronized java.lang.String getName() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getShortName() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.lang.Integer getSequenceAsObject() {
		return (java.lang.Integer) getReadValueSet()[3];
	}

	public synchronized java.lang.String getTableName() {
		return (java.lang.String) getReadValueSet()[4];
	}

	public synchronized java.lang.String getSectionHeader() {
		return (java.lang.String) getReadValueSet()[5];
	}

	public synchronized java.lang.String getScoringNote() {
		return (java.lang.String) getReadValueSet()[6];
	}

	public synchronized QuestionTypeOpal setCode(final java.lang.String argCode) {
		tryMutate();
		if (argCode == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myCode on " + this + " to null.");
		}
		if (argCode.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myCode on " + this + " is 32.", argCode.length(), 32);
		}
		getNewValues()[0] = argCode;
		return this;
	}

	public synchronized QuestionTypeOpal setName(final java.lang.String argName) {
		tryMutate();
		if (argName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myName on " + this + " to null.");
		}
		if (argName.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myName on " + this + " is 256.", argName.length(), 256);
		}
		getNewValues()[1] = argName;
		return this;
	}

	public synchronized QuestionTypeOpal setShortName(final java.lang.String argShortName) {
		tryMutate();
		if (argShortName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myShortName on " + this + " to null.");
		}
		if (argShortName.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myShortName on " + this + " is 32.", argShortName.length(), 32);
		}
		getNewValues()[2] = argShortName;
		return this;
	}

	public synchronized QuestionTypeOpal setSequence(final java.lang.Integer argSequence) {
		tryMutate();
		if (argSequence == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set mySequence on " + this + " to null.");
		}
		getNewValues()[3] = argSequence;
		return this;
	}

	public QuestionTypeOpal setSequence(final int argSequence) {
		setSequence(java.lang.Integer.valueOf(argSequence));
		return this;
	}

	public synchronized QuestionTypeOpal setTableName(final java.lang.String argTableName) {
		tryMutate();
		if (argTableName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myTableName on " + this + " to null.");
		}
		if (argTableName.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myTableName on " + this + " is 256.", argTableName.length(), 256);
		}
		getNewValues()[4] = argTableName;
		return this;
	}

	public synchronized QuestionTypeOpal setSectionHeader(final java.lang.String argSectionHeader) {
		tryMutate();
		if ((argSectionHeader != null) && (argSectionHeader.length() > 256)) {
			throw new com.opal.ArgumentTooLongException("Maximum length of mySectionHeader on " + this + " is 256.", argSectionHeader.length(), 256);
		}
		getNewValues()[5] = argSectionHeader;
		return this;
	}

	public synchronized QuestionTypeOpal setScoringNote(final java.lang.String argScoringNote) {
		tryMutate();
		if (argScoringNote == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myScoringNote on " + this + " to null.");
		}
		if (argScoringNote.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myScoringNote on " + this + " is 256.", argScoringNote.length(), 256);
		}
		getNewValues()[6] = argScoringNote;
		return this;
	}

	private boolean myClearOldCollections = false;

	protected boolean needsToClearOldCollections() {
		return myClearOldCollections;
	}

	protected final void setClearOldCollections(boolean argValue) {
		myClearOldCollections = argValue;
	}

	@Override
	protected /* synchronized */ void copyOldValuesToNewInternal() {
		myNewQuestionOpalHashSet = null; /* Necessary if it has been rolled back */
		myQuestionOpalCachedOperations = null; /* Ditto */
		myNewSectionOpalHashSet = null; /* Necessary if it has been rolled back */
		mySectionOpalCachedOperations = null; /* Ditto */
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		/** This Opal has no references to other Opals that need to be copied. */
		if (needsToClearOldCollections()) {
			myOldQuestionOpalHashSet = null;
			} else {
			if (myNewQuestionOpalHashSet != null) {
				myOldQuestionOpalHashSet = myNewQuestionOpalHashSet;
				myNewQuestionOpalHashSet = null;
			} else {
				myQuestionOpalCachedOperations = null;
			}
		}
		if (needsToClearOldCollections()) {
			myOldSectionOpalHashSet = null;
			} else {
			if (myNewSectionOpalHashSet != null) {
				myOldSectionOpalHashSet = myNewSectionOpalHashSet;
				myNewSectionOpalHashSet = null;
			} else {
				mySectionOpalCachedOperations = null;
			}
		}
		setClearOldCollections(false);
		return;
	}

	@Override
	protected void unlinkInternal() {
		java.util.Iterator<?> lclI;
		if (myNewQuestionOpalHashSet != null || myQuestionOpalCachedOperations != null) {
			lclI = createQuestionOpalIterator();
			while (lclI.hasNext()) {
				((QuestionOpal) lclI.next()).setQuestionTypeOpalInternal(null);
			}
		}
		if (myNewSectionOpalHashSet != null || mySectionOpalCachedOperations != null) {
			lclI = createSectionOpalIterator();
			while (lclI.hasNext()) {
				((SectionOpal) lclI.next()).setQuestionTypeOpalInternal(null);
			}
		}
		return;
	}

	@Override
	protected void copyFieldsToInternal(UpdatableOpal<QuestionType> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (Code) is part of a unique key. */
		/* Field 1 (Name) is part of a unique key. */
		/* Field 2 (ShortName) is part of a unique key. */
		lclTargetNewValues[3] = lclValues[3]; /* Sequence (immutable) */
		lclTargetNewValues[4] = lclValues[4]; /* TableName (immutable) */
		lclTargetNewValues[5] = lclValues[5]; /* SectionHeader (immutable) */
		lclTargetNewValues[6] = lclValues[6]; /* ScoringNote (immutable) */

		return;
	}

	@Override
	public synchronized void translateReferencesToFields() {
		return;
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredPriorCommits() {
		return java.util.Collections.emptySet();
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredSubsequentCommits() {
		return java.util.Collections.emptySet();
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
	public synchronized void output(final PrintWriter argPW) {
		argPW.println("Code = " + getCode());
		argPW.println("Name = " + getName());
		argPW.println("ShortName = " + getShortName());
		argPW.println("Sequence = " + getSequenceAsObject());
		argPW.println("TableName = " + getTableName());
		argPW.println("SectionHeader = " + getSectionHeader());
		argPW.println("ScoringNote = " + getScoringNote());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("Code = " + getCode());
		argPS.println("Name = " + getName());
		argPS.println("ShortName = " + getShortName());
		argPS.println("Sequence = " + getSequenceAsObject());
		argPS.println("TableName = " + getTableName());
		argPS.println("SectionHeader = " + getSectionHeader());
		argPS.println("ScoringNote = " + getScoringNote());
	}

	private java.util.HashSet<QuestionOpal> myOldQuestionOpalHashSet = null;
	private java.util.HashSet<QuestionOpal> myNewQuestionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<QuestionOpal>> myQuestionOpalCachedOperations = null;

	/* package */ java.util.HashSet<QuestionOpal> getQuestionOpalHashSet() {
		if (tryAccess()) {
			if (myNewQuestionOpalHashSet == null) {
				if (myOldQuestionOpalHashSet == null) {
					if (isNew()) {
						myOldQuestionOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forQuestionTypeCodeCollection(getCode());
					}
				}
				myNewQuestionOpalHashSet = new java.util.HashSet<>(myOldQuestionOpalHashSet);
				if (myQuestionOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(myQuestionOpalCachedOperations, myNewQuestionOpalHashSet);
					myQuestionOpalCachedOperations = null;
				}
			}
			return myNewQuestionOpalHashSet;
		} else {
			if (myOldQuestionOpalHashSet == null) {
				myOldQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forQuestionTypeCodeCollection(getCode());
			}
			return myOldQuestionOpalHashSet;
		}
	}

	public synchronized void addQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setQuestionTypeOpal(this);
		return;
	}

	protected synchronized void addQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewQuestionOpalHashSet == null) {
			if (myOldQuestionOpalHashSet == null) {
				if (myQuestionOpalCachedOperations == null) { myQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argQuestionOpal));
			} else {
				myNewQuestionOpalHashSet = new java.util.HashSet<>(myOldQuestionOpalHashSet);
				myNewQuestionOpalHashSet.add(argQuestionOpal);
			}
		} else {
			myNewQuestionOpalHashSet.add(argQuestionOpal);
		}
		return;
	}

	public synchronized void removeQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setQuestionTypeOpal(null);
	}

	protected synchronized void removeQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewQuestionOpalHashSet == null) {
			if (myOldQuestionOpalHashSet == null) {
				if (myQuestionOpalCachedOperations == null) { myQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argQuestionOpal));
			} else {
				myNewQuestionOpalHashSet = new java.util.HashSet<>(myOldQuestionOpalHashSet);
				myNewQuestionOpalHashSet.remove(argQuestionOpal);
			}
		} else {
			myNewQuestionOpalHashSet.remove(argQuestionOpal);
		}
		return;
	}

	public synchronized int getQuestionOpalCount() { return getQuestionOpalHashSet().size(); }

	public synchronized java.util.Iterator<QuestionOpal> createQuestionOpalIterator() {
		return getQuestionOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<QuestionOpal> streamQuestionOpal() {
		return getQuestionOpalHashSet().stream();
	}

	public synchronized void clearQuestionOpalInternal() { getQuestionOpalHashSet().clear(); }

	private java.util.HashSet<SectionOpal> myOldSectionOpalHashSet = null;
	private java.util.HashSet<SectionOpal> myNewSectionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<SectionOpal>> mySectionOpalCachedOperations = null;

	/* package */ java.util.HashSet<SectionOpal> getSectionOpalHashSet() {
		if (tryAccess()) {
			if (myNewSectionOpalHashSet == null) {
				if (myOldSectionOpalHashSet == null) {
					if (isNew()) {
						myOldSectionOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldSectionOpalHashSet = OpalFactoryFactory.getInstance().getSectionOpalFactory().forQuestionTypeCodeCollection(getCode());
					}
				}
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				if (mySectionOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(mySectionOpalCachedOperations, myNewSectionOpalHashSet);
					mySectionOpalCachedOperations = null;
				}
			}
			return myNewSectionOpalHashSet;
		} else {
			if (myOldSectionOpalHashSet == null) {
				myOldSectionOpalHashSet = OpalFactoryFactory.getInstance().getSectionOpalFactory().forQuestionTypeCodeCollection(getCode());
			}
			return myOldSectionOpalHashSet;
		}
	}

	public synchronized void addSectionOpal(SectionOpal argSectionOpal) {
		tryMutate();
		argSectionOpal.setQuestionTypeOpal(this);
		return;
	}

	protected synchronized void addSectionOpalInternal(SectionOpal argSectionOpal) {
		tryMutate();
		if (myNewSectionOpalHashSet == null) {
			if (myOldSectionOpalHashSet == null) {
				if (mySectionOpalCachedOperations == null) { mySectionOpalCachedOperations = new java.util.ArrayList<>(); }
				mySectionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argSectionOpal));
			} else {
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				myNewSectionOpalHashSet.add(argSectionOpal);
			}
		} else {
			myNewSectionOpalHashSet.add(argSectionOpal);
		}
		return;
	}

	public synchronized void removeSectionOpal(SectionOpal argSectionOpal) {
		tryMutate();
		argSectionOpal.setQuestionTypeOpal(null);
	}

	protected synchronized void removeSectionOpalInternal(SectionOpal argSectionOpal) {
		tryMutate();
		if (myNewSectionOpalHashSet == null) {
			if (myOldSectionOpalHashSet == null) {
				if (mySectionOpalCachedOperations == null) { mySectionOpalCachedOperations = new java.util.ArrayList<>(); }
				mySectionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argSectionOpal));
			} else {
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				myNewSectionOpalHashSet.remove(argSectionOpal);
			}
		} else {
			myNewSectionOpalHashSet.remove(argSectionOpal);
		}
		return;
	}

	public synchronized int getSectionOpalCount() { return getSectionOpalHashSet().size(); }

	public synchronized java.util.Iterator<SectionOpal> createSectionOpalIterator() {
		return getSectionOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<SectionOpal> streamSectionOpal() {
		return getSectionOpalHashSet().stream();
	}

	public synchronized void clearSectionOpalInternal() { getSectionOpalHashSet().clear(); }

	@Override
	public String toString() {
		StringBuilder lclSB =  new StringBuilder(64);
		lclSB.append("QuestionTypeOpal[");
		lclSB.append("myCode=");
		lclSB.append(toStringField(0));
		lclSB.append(']');
		return lclSB.toString();
	}

	@Override
	protected void updateCollectionsAfterReload() {
		assert needsToClearOldCollections() == false;
		setClearOldCollections(true);
	}

}
