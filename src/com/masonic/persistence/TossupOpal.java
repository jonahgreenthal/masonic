package com.masonic.persistence;

import com.masonic.application.Tossup;

public final class TossupOpal extends com.opal.UpdatableOpal<Tossup> {


	private TossupOpal() {
		super();
		setUserFacing(null);
	}

	public TossupOpal(com.opal.IdentityOpalFactory<Tossup, TossupOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void initializeReferences() {
		myOldQuestionOpal = QuestionOpal.NOT_YET_LOADED;
		return;
	}

	@Override
	protected void createSuperclassOpals() {
		setQuestionOpal(com.masonic.application.QuestionFactory.getInstance().getQuestionOpalFactory().createAsSuperOpal(getUserFacing()));
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"QuestionId",
		"Text",
		"Answer",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.String.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
	};

	/* package */ static final com.opal.FieldValidator[] ourFieldValidators = new com.opal.FieldValidator[] {
		null,
		null,
		null,
	};

	public static final TossupOpal NOT_YET_LOADED = new TossupOpal();

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


	public synchronized java.lang.Integer getQuestionIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[0];
	}

	public synchronized java.lang.String getText() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getAnswer() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized TossupOpal setQuestionId(final java.lang.Integer argQuestionId) {
		tryMutate();
		if (argQuestionId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myQuestionId on " + this + " to null.");
		}
		getNewValues()[0] = argQuestionId;
		return this;
	}

	public TossupOpal setQuestionId(final int argQuestionId) {
		setQuestionId(java.lang.Integer.valueOf(argQuestionId));
		return this;
	}

	public synchronized TossupOpal setText(final java.lang.String argText) {
		tryMutate();
		if (argText == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myText on " + this + " to null.");
		}
		getNewValues()[1] = argText;
		return this;
	}

	public synchronized TossupOpal setAnswer(final java.lang.String argAnswer) {
		tryMutate();
		if (argAnswer == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myAnswer on " + this + " to null.");
		}
		getNewValues()[2] = argAnswer;
		return this;
	}

	@Override
	protected /* synchronized */ void copyOldValuesToNewInternal() {
		myNewQuestionOpal = myOldQuestionOpal;
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		myOldQuestionOpal = myNewQuestionOpal;

		return;
	}

	@Override
	protected void unlinkInternal() {
		return;
	}

	@Override
	protected void copyFieldsToInternal(com.opal.UpdatableOpal<Tossup> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (QuestionId) is part of a unique key. */
		lclTargetNewValues[1] = lclValues[1]; /* Text (immutable) */
		lclTargetNewValues[2] = lclValues[2]; /* Answer (immutable) */

		return;
	}

	@Override
	public synchronized void translateReferencesToFields() {
		if (myNewQuestionOpal != QuestionOpal.NOT_YET_LOADED) {
			setQuestionId(myNewQuestionOpal == null ? null : myNewQuestionOpal.getIdAsObject());
		}
		return;
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredPriorCommits() {
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		com.opal.UpdatableOpal<?> lclUO;
		lclUO = myNewQuestionOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
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
		if ((lclUO = myOldQuestionOpal) == QuestionOpal.NOT_YET_LOADED) {
			lclUO = myOldQuestionOpal = retrieveQuestionOpal(getOldValues());
		}
		if (lclUO != null && lclUO.isDeleted()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
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
		argOutput.println("QuestionId = " + getQuestionIdAsObject());
		argOutput.println("Text = " + getText());
		argOutput.println("Answer = " + getAnswer());
	}

	@Override
	public synchronized void output(final java.io.PrintWriter argOutput) {
		argOutput.println("QuestionId = " + getQuestionIdAsObject());
		argOutput.println("Text = " + getText());
		argOutput.println("Answer = " + getAnswer());
	}

	private QuestionOpal myOldQuestionOpal;
	private QuestionOpal myNewQuestionOpal;

	protected QuestionOpal retrieveQuestionOpal(Object[] argValueSet) {
		assert argValueSet != null;
		if ((argValueSet[0] == null)) {
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

	public synchronized TossupOpal setQuestionOpal(QuestionOpal argQuestionOpal) {
		tryMutate();
		myNewQuestionOpal = argQuestionOpal;
		return this;
	}

	protected synchronized void setQuestionOpalInternal(QuestionOpal argQuestionOpal) {
		tryMutate();
		myNewQuestionOpal = argQuestionOpal;
	}

	@Override
	public java.lang.String toString() {
		java.lang.StringBuilder lclSB = new java.lang.StringBuilder(64);
		lclSB.append("TossupOpal[");
		lclSB.append("myQuestionId=");
		lclSB.append(toStringField(0));
		lclSB.append(']');
		return lclSB.toString();
	}

	@Override
	protected void updateReferencesAfterReload() {
		if (myNewQuestionOpal != QuestionOpal.NOT_YET_LOADED) {
			setQuestionOpal(retrieveQuestionOpal(getNewValues()));
		}
	}

}
