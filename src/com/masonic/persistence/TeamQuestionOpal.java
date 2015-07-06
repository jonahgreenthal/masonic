package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

public final class TeamQuestionOpal extends com.opal.UpdatableOpal<TeamQuestion> {

	private TeamQuestionOpal() {
		super();
		setUserFacing(null);
	}

	public TeamQuestionOpal(OpalFactory<TeamQuestion, TeamQuestionOpal> argOpalFactory, Object[] argValues) {
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
		"Introduction",
		"Part1Text",
		"Part1Answer",
		"Part2Text",
		"Part2Answer",
		"Part3Text",
		"Part3Answer",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
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
		null,
	};

	public static final TeamQuestionOpal NOT_YET_LOADED = new TeamQuestionOpal();

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

	public synchronized java.lang.String getIntroduction() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getPart1Text() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.lang.String getPart1Answer() {
		return (java.lang.String) getReadValueSet()[3];
	}

	public synchronized java.lang.String getPart2Text() {
		return (java.lang.String) getReadValueSet()[4];
	}

	public synchronized java.lang.String getPart2Answer() {
		return (java.lang.String) getReadValueSet()[5];
	}

	public synchronized java.lang.String getPart3Text() {
		return (java.lang.String) getReadValueSet()[6];
	}

	public synchronized java.lang.String getPart3Answer() {
		return (java.lang.String) getReadValueSet()[7];
	}

	public synchronized TeamQuestionOpal setQuestionId(final java.lang.Integer argQuestionId) {
		tryMutate();
		if (argQuestionId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myQuestionId on " + this + " to null.");
		}
		getNewValues()[0] = argQuestionId;
		return this;
	}

	public TeamQuestionOpal setQuestionId(final int argQuestionId) {
		setQuestionId(java.lang.Integer.valueOf(argQuestionId));
		return this;
	}

	public synchronized TeamQuestionOpal setIntroduction(final java.lang.String argIntroduction) {
		tryMutate();
		if (argIntroduction == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myIntroduction on " + this + " to null.");
		}
		getNewValues()[1] = argIntroduction;
		return this;
	}

	public synchronized TeamQuestionOpal setPart1Text(final java.lang.String argPart1Text) {
		tryMutate();
		if (argPart1Text == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart1Text on " + this + " to null.");
		}
		getNewValues()[2] = argPart1Text;
		return this;
	}

	public synchronized TeamQuestionOpal setPart1Answer(final java.lang.String argPart1Answer) {
		tryMutate();
		if (argPart1Answer == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart1Answer on " + this + " to null.");
		}
		getNewValues()[3] = argPart1Answer;
		return this;
	}

	public synchronized TeamQuestionOpal setPart2Text(final java.lang.String argPart2Text) {
		tryMutate();
		if (argPart2Text == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart2Text on " + this + " to null.");
		}
		getNewValues()[4] = argPart2Text;
		return this;
	}

	public synchronized TeamQuestionOpal setPart2Answer(final java.lang.String argPart2Answer) {
		tryMutate();
		if (argPart2Answer == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart2Answer on " + this + " to null.");
		}
		getNewValues()[5] = argPart2Answer;
		return this;
	}

	public synchronized TeamQuestionOpal setPart3Text(final java.lang.String argPart3Text) {
		tryMutate();
		if (argPart3Text == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart3Text on " + this + " to null.");
		}
		getNewValues()[6] = argPart3Text;
		return this;
	}

	public synchronized TeamQuestionOpal setPart3Answer(final java.lang.String argPart3Answer) {
		tryMutate();
		if (argPart3Answer == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPart3Answer on " + this + " to null.");
		}
		getNewValues()[7] = argPart3Answer;
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
	protected void copyFieldsToInternal(UpdatableOpal<TeamQuestion> argTarget) {
		Object[] lclValues = getReadValueSet();
		Object[] lclTargetNewValues = argTarget.getNewValues();
		/* Field 0 (QuestionId) is part of a unique key. */
		lclTargetNewValues[1] = lclValues[1]; /* Introduction (immutable) */
		lclTargetNewValues[2] = lclValues[2]; /* Part1Text (immutable) */
		lclTargetNewValues[3] = lclValues[3]; /* Part1Answer (immutable) */
		lclTargetNewValues[4] = lclValues[4]; /* Part2Text (immutable) */
		lclTargetNewValues[5] = lclValues[5]; /* Part2Answer (immutable) */
		lclTargetNewValues[6] = lclValues[6]; /* Part3Text (immutable) */
		lclTargetNewValues[7] = lclValues[7]; /* Part3Answer (immutable) */

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
		argPW.println("Introduction = " + getIntroduction());
		argPW.println("Part1Text = " + getPart1Text());
		argPW.println("Part1Answer = " + getPart1Answer());
		argPW.println("Part2Text = " + getPart2Text());
		argPW.println("Part2Answer = " + getPart2Answer());
		argPW.println("Part3Text = " + getPart3Text());
		argPW.println("Part3Answer = " + getPart3Answer());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("QuestionId = " + getQuestionIdAsObject());
		argPS.println("Introduction = " + getIntroduction());
		argPS.println("Part1Text = " + getPart1Text());
		argPS.println("Part1Answer = " + getPart1Answer());
		argPS.println("Part2Text = " + getPart2Text());
		argPS.println("Part2Answer = " + getPart2Answer());
		argPS.println("Part3Text = " + getPart3Text());
		argPS.println("Part3Answer = " + getPart3Answer());
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

	public synchronized TeamQuestionOpal setQuestionOpal(QuestionOpal argQuestionOpal) {
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
		lclSB.append("TeamQuestionOpal[");
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
