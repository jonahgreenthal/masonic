package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

public final class PacketSetOpal extends com.opal.UpdatableOpal<PacketSet> {
	public static final java.lang.Boolean ourDefaultCompleted = java.lang.Boolean.FALSE;

	private PacketSetOpal() {
		super();
		setUserFacing(null);
	}

	public PacketSetOpal(OpalFactory<PacketSet, PacketSetOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void applyDefaults() {
		getNewValues()[5] = ourDefaultCompleted;
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

	/* package */ static final FieldValidator[] ourFieldValidators = new FieldValidator[] {
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
			throw new com.opal.ArgumentTooLongException("Maximum length of myCode on " + this + " is 32.", argCode.length(), 32);
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
			throw new com.opal.ArgumentTooLongException("Maximum length of myName on " + this + " is 256.", argName.length(), 256);
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
			throw new com.opal.ArgumentTooLongException("Maximum length of myShortName on " + this + " is 32.", argShortName.length(), 32);
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
			} else {
			if (myNewIntendedQuestionOpalHashSet != null) {
				myOldIntendedQuestionOpalHashSet = myNewIntendedQuestionOpalHashSet;
				myNewIntendedQuestionOpalHashSet = null;
			} else {
				myIntendedQuestionOpalCachedOperations = null;
			}
		}
		if (needsToClearOldCollections()) {
			myOldPacketOpalHashSet = null;
			} else {
			if (myNewPacketOpalHashSet != null) {
				myOldPacketOpalHashSet = myNewPacketOpalHashSet;
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
	protected void copyFieldsToInternal(UpdatableOpal<PacketSet> argTarget) {
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
	public synchronized void output(final PrintWriter argPW) {
		argPW.println("Code = " + getCode());
		argPW.println("Name = " + getName());
		argPW.println("ShortName = " + getShortName());
		argPW.println("Deadline = " + getDeadline());
		argPW.println("Note = " + getNote());
		argPW.println("Completed = " + isCompletedAsObject());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("Code = " + getCode());
		argPS.println("Name = " + getName());
		argPS.println("ShortName = " + getShortName());
		argPS.println("Deadline = " + getDeadline());
		argPS.println("Note = " + getNote());
		argPS.println("Completed = " + isCompletedAsObject());
	}

	private java.util.HashSet<QuestionOpal> myOldIntendedQuestionOpalHashSet = null;
	private java.util.HashSet<QuestionOpal> myNewIntendedQuestionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<QuestionOpal>> myIntendedQuestionOpalCachedOperations = null;

	/* package */ java.util.HashSet<QuestionOpal> getIntendedQuestionOpalHashSet() {
		if (tryAccess()) {
			if (myNewIntendedQuestionOpalHashSet == null) {
				if (myOldIntendedQuestionOpalHashSet == null) {
					if (isNew()) {
						myOldIntendedQuestionOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldIntendedQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forIntendedPacketSetCodeCollection(getCode());
					}
				}
				myNewIntendedQuestionOpalHashSet = new java.util.HashSet<>(myOldIntendedQuestionOpalHashSet);
				if (myIntendedQuestionOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(myIntendedQuestionOpalCachedOperations, myNewIntendedQuestionOpalHashSet);
					myIntendedQuestionOpalCachedOperations = null;
				}
			}
			return myNewIntendedQuestionOpalHashSet;
		} else {
			if (myOldIntendedQuestionOpalHashSet == null) {
				myOldIntendedQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forIntendedPacketSetCodeCollection(getCode());
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
				myIntendedQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argQuestionOpal));
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
				myIntendedQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argQuestionOpal));
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

	public synchronized void clearIntendedQuestionOpalInternal() { getIntendedQuestionOpalHashSet().clear(); }

	private java.util.HashSet<PacketOpal> myOldPacketOpalHashSet = null;
	private java.util.HashSet<PacketOpal> myNewPacketOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<PacketOpal>> myPacketOpalCachedOperations = null;

	/* package */ java.util.HashSet<PacketOpal> getPacketOpalHashSet() {
		if (tryAccess()) {
			if (myNewPacketOpalHashSet == null) {
				if (myOldPacketOpalHashSet == null) {
					if (isNew()) {
						myOldPacketOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldPacketOpalHashSet = OpalFactoryFactory.getInstance().getPacketOpalFactory().forPacketSetCodeCollection(getCode());
					}
				}
				myNewPacketOpalHashSet = new java.util.HashSet<>(myOldPacketOpalHashSet);
				if (myPacketOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(myPacketOpalCachedOperations, myNewPacketOpalHashSet);
					myPacketOpalCachedOperations = null;
				}
			}
			return myNewPacketOpalHashSet;
		} else {
			if (myOldPacketOpalHashSet == null) {
				myOldPacketOpalHashSet = OpalFactoryFactory.getInstance().getPacketOpalFactory().forPacketSetCodeCollection(getCode());
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
				myPacketOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argPacketOpal));
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
				myPacketOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argPacketOpal));
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

	public synchronized void clearPacketOpalInternal() { getPacketOpalHashSet().clear(); }

	@Override
	public String toString() {
		StringBuilder lclSB =  new StringBuilder(64);
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
