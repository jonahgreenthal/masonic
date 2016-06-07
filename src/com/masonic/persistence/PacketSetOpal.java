package com.masonic.persistence;

import com.masonic.application.PacketSet;

public final class PacketSetOpal extends com.opal.UpdatableOpal<PacketSet> {

	public static final java.lang.Boolean ourDefaultCompleted = java.lang.Boolean.FALSE;

	private PacketSetOpal() {
		super();
		setUserFacing(null);
	}

	public PacketSetOpal(com.opal.IdentityOpalFactory<PacketSet, PacketSetOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void applyDefaults() {
		/* Initialize fields with their default values. */
		getNewValues()[5] = ourDefaultCompleted;


		/* Initialize the back Collections to empty sets. */

		myNewIntendedQuestionOpalHashSet = new java.util.HashSet<>();
		myNewPacketOpalHashSet = new java.util.HashSet<>();

		return;
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"Code",
		"Name",
		"ShortName",
		"Deadline",
		"Note",
		"Completed",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.time.LocalDate.class,
		java.lang.String.class,
		java.lang.Boolean.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
		true,
		true,
		false,
	};

	/* package */ static final com.opal.FieldValidator[] ourFieldValidators = new com.opal.FieldValidator[] {
		null,
		null,
		null,
		null,
		null,
		null,
	};

	public static final PacketSetOpal NOT_YET_LOADED = new PacketSetOpal();

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


	public synchronized java.lang.String getCode() {
		return (java.lang.String) getReadValueSet()[0];
	}

	public synchronized java.lang.String getName() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getShortName() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.time.LocalDate getDeadline() {
		return (java.time.LocalDate) getReadValueSet()[3];
	}

	public synchronized java.lang.String getNote() {
		return (java.lang.String) getReadValueSet()[4];
	}

	public synchronized java.lang.Boolean isCompletedAsObject() {
		return (java.lang.Boolean) getReadValueSet()[5];
	}

	public synchronized PacketSetOpal setCode(final java.lang.String argCode) {
		tryMutate();
		if (argCode == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myCode on " + this + " to null.");
		}
		if (argCode.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Cannot set myCode on " + this + " to \"" + argCode + "\" because that field's maximum length is 32.", argCode.length(), 32);
		}
		getNewValues()[0] = argCode;
		return this;
	}

	public synchronized PacketSetOpal setName(final java.lang.String argName) {
		tryMutate();
		if (argName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myName on " + this + " to null.");
		}
		if (argName.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Cannot set myName on " + this + " to \"" + argName + "\" because that field's maximum length is 256.", argName.length(), 256);
		}
		getNewValues()[1] = argName;
		return this;
	}

	public synchronized PacketSetOpal setShortName(final java.lang.String argShortName) {
		tryMutate();
		if (argShortName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myShortName on " + this + " to null.");
		}
		if (argShortName.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Cannot set myShortName on " + this + " to \"" + argShortName + "\" because that field's maximum length is 32.", argShortName.length(), 32);
		}
		getNewValues()[2] = argShortName;
		return this;
	}

	public synchronized PacketSetOpal setDeadline(final java.time.LocalDate argDeadline) {
		tryMutate();
		getNewValues()[3] = argDeadline;
		return this;
	}

	public synchronized PacketSetOpal setNote(final java.lang.String argNote) {
		tryMutate();
		getNewValues()[4] = argNote;
		return this;
	}

	public synchronized PacketSetOpal setCompleted(final java.lang.Boolean argCompleted) {
		tryMutate();
		if (argCompleted == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myCompleted on " + this + " to null.");
		}
		getNewValues()[5] = argCompleted;
		return this;
	}

	public PacketSetOpal setCompleted(final boolean argCompleted) {
		setCompleted(argCompleted ? Boolean.TRUE : Boolean.FALSE);
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
		myNewIntendedQuestionOpalHashSet = null; /* Necessary if it has been rolled back */
		myIntendedQuestionOpalCachedOperations = null; /* Ditto */
		myNewPacketOpalHashSet = null; /* Necessary if it has been rolled back */
		myPacketOpalCachedOperations = null; /* Ditto */
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		/** This Opal has no references to other Opals that need to be copied. */
		if (needsToClearOldCollections()) {
			myOldIntendedQuestionOpalHashSet = null;
			myOldPacketOpalHashSet = null;
		} else {
			if (myNewIntendedQuestionOpalHashSet != null) {
				if (myNewIntendedQuestionOpalHashSet.size() > 0) {
					myOldIntendedQuestionOpalHashSet = myNewIntendedQuestionOpalHashSet;
				} else {
					myOldIntendedQuestionOpalHashSet = java.util.Collections.emptySet();
				}
				myNewIntendedQuestionOpalHashSet = null;
			} else {
				myIntendedQuestionOpalCachedOperations = null;
			}
			if (myNewPacketOpalHashSet != null) {
				if (myNewPacketOpalHashSet.size() > 0) {
					myOldPacketOpalHashSet = myNewPacketOpalHashSet;
				} else {
					myOldPacketOpalHashSet = java.util.Collections.emptySet();
				}
				myNewPacketOpalHashSet = null;
			} else {
				myPacketOpalCachedOperations = null;
			}
		}
		setClearOldCollections(false);
		return;
	}

	@Override
	protected void unlinkInternal() {
		java.util.Iterator<?> lclI;
		if (myNewIntendedQuestionOpalHashSet != null || myIntendedQuestionOpalCachedOperations != null) {
			lclI = createIntendedQuestionOpalIterator();
			while (lclI.hasNext()) {
				((QuestionOpal) lclI.next()).setIntendedPacketSetOpalInternal(null);
			}
		}
		if (myNewPacketOpalHashSet != null || myPacketOpalCachedOperations != null) {
			lclI = createPacketOpalIterator();
			while (lclI.hasNext()) {
				((PacketOpal) lclI.next()).setPacketSetOpalInternal(null);
			}
		}
		return;
	}

	@Override
	protected void copyFieldsToInternal(com.opal.UpdatableOpal<PacketSet> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (Code) is part of a unique key. */
		/* Field 1 (Name) is part of a unique key. */
		/* Field 2 (ShortName) is part of a unique key. */
		lclTargetNewValues[3] = lclValues[3]; /* Deadline (immutable) */
		lclTargetNewValues[4] = lclValues[4]; /* Note (immutable) */
		lclTargetNewValues[5] = lclValues[5]; /* Completed (immutable) */

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
	public synchronized void output(final java.io.PrintStream argOutput) {
		argOutput.println("Code = " + getCode());
		argOutput.println("Name = " + getName());
		argOutput.println("ShortName = " + getShortName());
		argOutput.println("Deadline = " + getDeadline());
		argOutput.println("Note = " + getNote());
		argOutput.println("Completed = " + isCompletedAsObject());
	}

	@Override
	public synchronized void output(final java.io.PrintWriter argOutput) {
		argOutput.println("Code = " + getCode());
		argOutput.println("Name = " + getName());
		argOutput.println("ShortName = " + getShortName());
		argOutput.println("Deadline = " + getDeadline());
		argOutput.println("Note = " + getNote());
		argOutput.println("Completed = " + isCompletedAsObject());
	}

	private java.util.Set<QuestionOpal> myOldIntendedQuestionOpalHashSet = null;
	private java.util.Set<QuestionOpal> myNewIntendedQuestionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<QuestionOpal>> myIntendedQuestionOpalCachedOperations = null;

	/* package */ java.util.Set<QuestionOpal> getIntendedQuestionOpalHashSet() {
		if (tryAccess()) {
			if (myNewIntendedQuestionOpalHashSet == null) {
				if (myOldIntendedQuestionOpalHashSet == null) {
					if (isNew()) {
						myOldIntendedQuestionOpalHashSet = java.util.Collections.emptySet();
					} else {
						java.util.Set<QuestionOpal> lclS;
						lclS = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forIntendedPacketSetCodeCollection(getCode());
						myOldIntendedQuestionOpalHashSet = lclS.size() > 0 ? lclS : java.util.Collections.emptySet();
					}
				}
				myNewIntendedQuestionOpalHashSet = new java.util.HashSet<>(myOldIntendedQuestionOpalHashSet);
				if (myIntendedQuestionOpalCachedOperations != null) {
					com.opal.OpalUtility.handleCachedOperations(myIntendedQuestionOpalCachedOperations, myNewIntendedQuestionOpalHashSet);
					myIntendedQuestionOpalCachedOperations = null;
				}
			}
			return myNewIntendedQuestionOpalHashSet;
		} else {
			if (myOldIntendedQuestionOpalHashSet == null) {
				java.util.Set<QuestionOpal> lclS;
				lclS = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forIntendedPacketSetCodeCollection(getCode());
				myOldIntendedQuestionOpalHashSet = lclS.size() > 0 ? lclS : java.util.Collections.emptySet();
			}
			return myOldIntendedQuestionOpalHashSet;
		}
	}

	public synchronized void addIntendedQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setIntendedPacketSetOpal(this);
		return;
	}

	protected synchronized void addIntendedQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewIntendedQuestionOpalHashSet == null) {
			if (myOldIntendedQuestionOpalHashSet == null) {
				if (myIntendedQuestionOpalCachedOperations == null) { myIntendedQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myIntendedQuestionOpalCachedOperations.add(new com.opal.CachedOperation<>(com.opal.CachedOperation.ADD, argQuestionOpal));
			} else {
				myNewIntendedQuestionOpalHashSet = new java.util.HashSet<>(myOldIntendedQuestionOpalHashSet);
				myNewIntendedQuestionOpalHashSet.add(argQuestionOpal);
			}
		} else {
			myNewIntendedQuestionOpalHashSet.add(argQuestionOpal);
		}
		return;
	}

	public synchronized void removeIntendedQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setIntendedPacketSetOpal(null);
	}

	protected synchronized void removeIntendedQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewIntendedQuestionOpalHashSet == null) {
			if (myOldIntendedQuestionOpalHashSet == null) {
				if (myIntendedQuestionOpalCachedOperations == null) { myIntendedQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myIntendedQuestionOpalCachedOperations.add(new com.opal.CachedOperation<>(com.opal.CachedOperation.REMOVE, argQuestionOpal));
			} else {
				myNewIntendedQuestionOpalHashSet = new java.util.HashSet<>(myOldIntendedQuestionOpalHashSet);
				myNewIntendedQuestionOpalHashSet.remove(argQuestionOpal);
			}
		} else {
			myNewIntendedQuestionOpalHashSet.remove(argQuestionOpal);
		}
		return;
	}

	public synchronized int getIntendedQuestionOpalCount() { return getIntendedQuestionOpalHashSet().size(); }

	public synchronized java.util.Iterator<QuestionOpal> createIntendedQuestionOpalIterator() {
		return getIntendedQuestionOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<QuestionOpal> streamIntendedQuestionOpal() {
		return getIntendedQuestionOpalHashSet().stream();
	}

	private java.util.Set<PacketOpal> myOldPacketOpalHashSet = null;
	private java.util.Set<PacketOpal> myNewPacketOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<PacketOpal>> myPacketOpalCachedOperations = null;

	/* package */ java.util.Set<PacketOpal> getPacketOpalHashSet() {
		if (tryAccess()) {
			if (myNewPacketOpalHashSet == null) {
				if (myOldPacketOpalHashSet == null) {
					if (isNew()) {
						myOldPacketOpalHashSet = java.util.Collections.emptySet();
					} else {
						java.util.Set<PacketOpal> lclS;
						lclS = OpalFactoryFactory.getInstance().getPacketOpalFactory().forPacketSetCodeCollection(getCode());
						myOldPacketOpalHashSet = lclS.size() > 0 ? lclS : java.util.Collections.emptySet();
					}
				}
				myNewPacketOpalHashSet = new java.util.HashSet<>(myOldPacketOpalHashSet);
				if (myPacketOpalCachedOperations != null) {
					com.opal.OpalUtility.handleCachedOperations(myPacketOpalCachedOperations, myNewPacketOpalHashSet);
					myPacketOpalCachedOperations = null;
				}
			}
			return myNewPacketOpalHashSet;
		} else {
			if (myOldPacketOpalHashSet == null) {
				java.util.Set<PacketOpal> lclS;
				lclS = OpalFactoryFactory.getInstance().getPacketOpalFactory().forPacketSetCodeCollection(getCode());
				myOldPacketOpalHashSet = lclS.size() > 0 ? lclS : java.util.Collections.emptySet();
			}
			return myOldPacketOpalHashSet;
		}
	}

	public synchronized void addPacketOpal(PacketOpal argPacketOpal) {
		tryMutate();
		argPacketOpal.setPacketSetOpal(this);
		return;
	}

	protected synchronized void addPacketOpalInternal(PacketOpal argPacketOpal) {
		tryMutate();
		if (myNewPacketOpalHashSet == null) {
			if (myOldPacketOpalHashSet == null) {
				if (myPacketOpalCachedOperations == null) { myPacketOpalCachedOperations = new java.util.ArrayList<>(); }
				myPacketOpalCachedOperations.add(new com.opal.CachedOperation<>(com.opal.CachedOperation.ADD, argPacketOpal));
			} else {
				myNewPacketOpalHashSet = new java.util.HashSet<>(myOldPacketOpalHashSet);
				myNewPacketOpalHashSet.add(argPacketOpal);
			}
		} else {
			myNewPacketOpalHashSet.add(argPacketOpal);
		}
		return;
	}

	public synchronized void removePacketOpal(PacketOpal argPacketOpal) {
		tryMutate();
		argPacketOpal.setPacketSetOpal(null);
	}

	protected synchronized void removePacketOpalInternal(PacketOpal argPacketOpal) {
		tryMutate();
		if (myNewPacketOpalHashSet == null) {
			if (myOldPacketOpalHashSet == null) {
				if (myPacketOpalCachedOperations == null) { myPacketOpalCachedOperations = new java.util.ArrayList<>(); }
				myPacketOpalCachedOperations.add(new com.opal.CachedOperation<>(com.opal.CachedOperation.REMOVE, argPacketOpal));
			} else {
				myNewPacketOpalHashSet = new java.util.HashSet<>(myOldPacketOpalHashSet);
				myNewPacketOpalHashSet.remove(argPacketOpal);
			}
		} else {
			myNewPacketOpalHashSet.remove(argPacketOpal);
		}
		return;
	}

	public synchronized int getPacketOpalCount() { return getPacketOpalHashSet().size(); }

	public synchronized java.util.Iterator<PacketOpal> createPacketOpalIterator() {
		return getPacketOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<PacketOpal> streamPacketOpal() {
		return getPacketOpalHashSet().stream();
	}

	@Override
	public java.lang.String toString() {
		java.lang.StringBuilder lclSB = new java.lang.StringBuilder(64);
		lclSB.append("PacketSetOpal[");
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
