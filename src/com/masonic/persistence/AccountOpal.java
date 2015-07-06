package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

@StoreGeneratedPrimaryKey
public final class AccountOpal extends com.opal.UpdatableOpal<Account> {
	public static final java.lang.String ourDefaultPasswordHash = "$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static final java.lang.Boolean ourDefaultAdministrator = java.lang.Boolean.FALSE;
	public static final java.lang.Boolean ourDefaultActive = java.lang.Boolean.TRUE;

	private AccountOpal() {
		super();
		setUserFacing(null);
	}

	public AccountOpal(OpalFactory<Account, AccountOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void applyDefaults() {
		getNewValues()[4] = ourDefaultPasswordHash;
		getNewValues()[5] = ourDefaultAdministrator;
		getNewValues()[6] = ourDefaultActive;
		return;
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"Id",
		"Name",
		"EmailAddress",
		"Username",
		"PasswordHash",
		"Administrator",
		"Active",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.Boolean.class,
		java.lang.Boolean.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
		false,
		false,
		false,
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

	public static final AccountOpal NOT_YET_LOADED = new AccountOpal();

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


	public synchronized java.lang.Integer getIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[0];
	}

	public synchronized java.lang.String getName() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getEmailAddress() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.lang.String getUsername() {
		return (java.lang.String) getReadValueSet()[3];
	}

	public synchronized java.lang.String getPasswordHash() {
		return (java.lang.String) getReadValueSet()[4];
	}

	public synchronized java.lang.Boolean isAdministratorAsObject() {
		return (java.lang.Boolean) getReadValueSet()[5];
	}

	public synchronized java.lang.Boolean isActiveAsObject() {
		return (java.lang.Boolean) getReadValueSet()[6];
	}

	public synchronized AccountOpal setId(final java.lang.Integer argId) {
		tryMutate();
		if (argId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myId on " + this + " to null.");
		}
		getNewValues()[0] = argId;
		return this;
	}

	public AccountOpal setId(final int argId) {
		setId(java.lang.Integer.valueOf(argId));
		return this;
	}

	public synchronized AccountOpal setName(final java.lang.String argName) {
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

	public synchronized AccountOpal setEmailAddress(final java.lang.String argEmailAddress) {
		tryMutate();
		if (argEmailAddress == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myEmailAddress on " + this + " to null.");
		}
		if (argEmailAddress.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myEmailAddress on " + this + " is 256.", argEmailAddress.length(), 256);
		}
		getNewValues()[2] = argEmailAddress;
		return this;
	}

	public synchronized AccountOpal setUsername(final java.lang.String argUsername) {
		tryMutate();
		if (argUsername == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myUsername on " + this + " to null.");
		}
		if (argUsername.length() > 64) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myUsername on " + this + " is 64.", argUsername.length(), 64);
		}
		getNewValues()[3] = argUsername;
		return this;
	}

	public synchronized AccountOpal setPasswordHash(final java.lang.String argPasswordHash) {
		tryMutate();
		if (argPasswordHash == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPasswordHash on " + this + " to null.");
		}
		if (argPasswordHash.length() > 60) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myPasswordHash on " + this + " is 60.", argPasswordHash.length(), 60);
		}
		getNewValues()[4] = argPasswordHash;
		return this;
	}

	public synchronized AccountOpal setAdministrator(final java.lang.Boolean argAdministrator) {
		tryMutate();
		if (argAdministrator == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myAdministrator on " + this + " to null.");
		}
		getNewValues()[5] = argAdministrator;
		return this;
	}

	public AccountOpal setAdministrator(final boolean argAdministrator) {
		setAdministrator(argAdministrator ? Boolean.TRUE : Boolean.FALSE);
		return this;
	}

	public synchronized AccountOpal setActive(final java.lang.Boolean argActive) {
		tryMutate();
		if (argActive == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myActive on " + this + " to null.");
		}
		getNewValues()[6] = argActive;
		return this;
	}

	public AccountOpal setActive(final boolean argActive) {
		setActive(argActive ? Boolean.TRUE : Boolean.FALSE);
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
		myNewWriterQuestionOpalHashSet = null; /* Necessary if it has been rolled back */
		myWriterQuestionOpalCachedOperations = null; /* Ditto */
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		/** This Opal has no references to other Opals that need to be copied. */
		if (needsToClearOldCollections()) {
			myOldWriterQuestionOpalHashSet = null;
			} else {
			if (myNewWriterQuestionOpalHashSet != null) {
				myOldWriterQuestionOpalHashSet = myNewWriterQuestionOpalHashSet;
				myNewWriterQuestionOpalHashSet = null;
			} else {
				myWriterQuestionOpalCachedOperations = null;
			}
		}
		setClearOldCollections(false);
		return;
	}

	@Override
	protected void unlinkInternal() {
		java.util.Iterator<?> lclI;
		if (myNewWriterQuestionOpalHashSet != null || myWriterQuestionOpalCachedOperations != null) {
			lclI = createWriterQuestionOpalIterator();
			while (lclI.hasNext()) {
				((QuestionOpal) lclI.next()).setWriterOpalInternal(null);
			}
		}
		return;
	}

	@Override
	protected void copyFieldsToInternal(UpdatableOpal<Account> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (Id) is database generated. */
		/* Field 1 (Name) is part of a unique key. */
		lclTargetNewValues[2] = lclValues[2]; /* EmailAddress (immutable) */
		/* Field 3 (Username) is part of a unique key. */
		lclTargetNewValues[4] = lclValues[4]; /* PasswordHash (immutable) */
		lclTargetNewValues[5] = lclValues[5]; /* Administrator (immutable) */
		lclTargetNewValues[6] = lclValues[6]; /* Active (immutable) */

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
		argPW.println("Id = " + getIdAsObject());
		argPW.println("Name = " + getName());
		argPW.println("EmailAddress = " + getEmailAddress());
		argPW.println("Username = " + getUsername());
		argPW.println("PasswordHash = " + getPasswordHash());
		argPW.println("Administrator = " + isAdministratorAsObject());
		argPW.println("Active = " + isActiveAsObject());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("Id = " + getIdAsObject());
		argPS.println("Name = " + getName());
		argPS.println("EmailAddress = " + getEmailAddress());
		argPS.println("Username = " + getUsername());
		argPS.println("PasswordHash = " + getPasswordHash());
		argPS.println("Administrator = " + isAdministratorAsObject());
		argPS.println("Active = " + isActiveAsObject());
	}

	private java.util.HashSet<QuestionOpal> myOldWriterQuestionOpalHashSet = null;
	private java.util.HashSet<QuestionOpal> myNewWriterQuestionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<QuestionOpal>> myWriterQuestionOpalCachedOperations = null;

	/* package */ java.util.HashSet<QuestionOpal> getWriterQuestionOpalHashSet() {
		if (tryAccess()) {
			if (myNewWriterQuestionOpalHashSet == null) {
				if (myOldWriterQuestionOpalHashSet == null) {
					if (isNew()) {
						myOldWriterQuestionOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldWriterQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forWriterAccountIdCollection(getIdAsObject());
					}
				}
				myNewWriterQuestionOpalHashSet = new java.util.HashSet<>(myOldWriterQuestionOpalHashSet);
				if (myWriterQuestionOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(myWriterQuestionOpalCachedOperations, myNewWriterQuestionOpalHashSet);
					myWriterQuestionOpalCachedOperations = null;
				}
			}
			return myNewWriterQuestionOpalHashSet;
		} else {
			if (myOldWriterQuestionOpalHashSet == null) {
				myOldWriterQuestionOpalHashSet = OpalFactoryFactory.getInstance().getQuestionOpalFactory().forWriterAccountIdCollection(getIdAsObject());
			}
			return myOldWriterQuestionOpalHashSet;
		}
	}

	public synchronized void addWriterQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setWriterOpal(this);
		return;
	}

	protected synchronized void addWriterQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewWriterQuestionOpalHashSet == null) {
			if (myOldWriterQuestionOpalHashSet == null) {
				if (myWriterQuestionOpalCachedOperations == null) { myWriterQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myWriterQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argQuestionOpal));
			} else {
				myNewWriterQuestionOpalHashSet = new java.util.HashSet<>(myOldWriterQuestionOpalHashSet);
				myNewWriterQuestionOpalHashSet.add(argQuestionOpal);
			}
		} else {
			myNewWriterQuestionOpalHashSet.add(argQuestionOpal);
		}
		return;
	}

	public synchronized void removeWriterQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		argQuestionOpal.setWriterOpal(null);
	}

	protected synchronized void removeWriterQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		if (myNewWriterQuestionOpalHashSet == null) {
			if (myOldWriterQuestionOpalHashSet == null) {
				if (myWriterQuestionOpalCachedOperations == null) { myWriterQuestionOpalCachedOperations = new java.util.ArrayList<>(); }
				myWriterQuestionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argQuestionOpal));
			} else {
				myNewWriterQuestionOpalHashSet = new java.util.HashSet<>(myOldWriterQuestionOpalHashSet);
				myNewWriterQuestionOpalHashSet.remove(argQuestionOpal);
			}
		} else {
			myNewWriterQuestionOpalHashSet.remove(argQuestionOpal);
		}
		return;
	}

	public synchronized int getWriterQuestionOpalCount() { return getWriterQuestionOpalHashSet().size(); }

	public synchronized java.util.Iterator<QuestionOpal> createWriterQuestionOpalIterator() {
		return getWriterQuestionOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<QuestionOpal> streamWriterQuestionOpal() {
		return getWriterQuestionOpalHashSet().stream();
	}

	public synchronized void clearWriterQuestionOpalInternal() { getWriterQuestionOpalHashSet().clear(); }

	@Override
	public String toString() {
		StringBuilder lclSB =  new StringBuilder(64);
		lclSB.append("AccountOpal[");
		lclSB.append("myId=");
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
