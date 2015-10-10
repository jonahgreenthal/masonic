package com.masonic.application;

import com.masonic.persistence.TossupOpal;
import com.masonic.persistence.QuestionOpal;

public class TossupImpl extends QuestionImpl implements Tossup {
	private final TossupOpal myTossupOpal;

	public TossupImpl(TossupOpal argTossupOpal) {
		super();
		myTossupOpal = org.apache.commons.lang3.Validate.notNull(argTossupOpal);
	}

	protected TossupOpal getTossupOpal() {
		return myTossupOpal;
	}

	@Override
	protected QuestionOpal getQuestionOpal() {
		return getTossupOpal().getQuestionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends Tossup> getOpal() {
		return getTossupOpal();
	}

	@Override
	protected void outputSuperclassOpalFields(java.io.PrintStream argOutput) {
		if (argOutput != null) {
			getQuestionOpal().output(argOutput);
		}
	}

	@Override
	protected void outputSuperclassOpalFields(java.io.PrintWriter argOutput) {
		if (argOutput != null) {
			getQuestionOpal().output(argOutput);
		}
	}

	@Override
	protected com.opal.IdentityOpal<? extends Tossup> getBottomOpal() {
		return getTossupOpal();
	}

	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getTossupOpal().getQuestionIdAsObject();
	}

	@Override
	public TossupImpl setQuestionId(java.lang.Integer argQuestionId) {
		getTossupOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public TossupImpl setQuestionId(int argQuestionId) {
		getTossupOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public java.lang.String getText() {
		return getTossupOpal().getText();
	}

	@Override
	public TossupImpl setText(java.lang.String argText) {
		getTossupOpal().setText(argText);
		return this;
	}

	@Override
	public java.lang.String getAnswer() {
		return getTossupOpal().getAnswer();
	}

	@Override
	public TossupImpl setAnswer(java.lang.String argAnswer) {
		getTossupOpal().setAnswer(argAnswer);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void unlink() {
		getTossupOpal().unlink();
		super.unlink();
	}

	@Override
	public void reload() {
		super.reload();
		getTossupOpal().reload();
	}

	@Override
	public Tossup copy() {
		throw new com.siliconage.util.UnimplementedOperationException();
	}

}
