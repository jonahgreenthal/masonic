package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

public final class TossupOpal extends com.opal.UpdatableOpal<Tossup> {

	private TossupOpal() {
		super();
		setUserFacing(null);
	}

	public TossupOpal(OpalFactory<Tossup, TossupOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void initializeReferences() {
		myOldQuestionOpal = QuestionOpal.NOT_YET_LOADED;
		return;
	}

	@Override
	protected void createSuperclassOpals() {
		setQuestionOpal(QuestionFactory.getInstance().getQuestionOpalFactory().createAsSuperOpal(getUserFacing()));
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

	/* package */ static final FieldValidator[] ourFieldValidators = new FieldValidator[] {
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
	public FieldValidator[] getFieldValidators() { return ourFieldValidators; }

	@Override
	public boolean[] getFieldNullability() { return ourFieldNullability; }

	public static FieldValidator[] getStaticFieldValidators() { return ourFieldValidators; }


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
	protected void copyFieldsToInternal(UpdatableOpal<Tossup> argTarget) {
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
		UpdatableOpal<?> lclUO;
		lclUO = myNewQuestionOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
			lclTAs.add(lclUO);
		}
		return (lclTAs != null) && (lclTAs.size() > 0) ? lclTAs : java.util.Collections.emptySet();
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredSubsequentCommits() {
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		UpdatableOpal<?> lclUO;
		lclUO = myOldQuestionOpal;
		if ((lclUO != null) && lclUO.isDeleted()) {
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
	public synchronized void output(final PrintWriter argPW) {
		argPW.println("QuestionId = " + getQuestionIdAsObject());
		argPW.println("Text = " + getText());
		argPW.println("Answer = " + getAnswer());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("QuestionId = " + getQuestionIdAsObject());
		argPS.println("Text = " + getText());
		argPS.println("Answer = " + getAnswer());
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
	public String toString() {
		StringBuilder lclSB =  new StringBuilder(64);
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
