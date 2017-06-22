package com.masonic.persistence;


public class TossupImpl extends QuestionImpl implements com.masonic.application.Tossup {

	private final com.masonic.persistence.TossupOpal myTossupOpal;

	public TossupImpl(TossupOpal argTossupOpal) {
		super();
		myTossupOpal = org.apache.commons.lang3.Validate.notNull(argTossupOpal);
	}

	protected com.masonic.persistence.TossupOpal getTossupOpal() {
		return myTossupOpal;
	}

	@Override
	protected QuestionOpal getQuestionOpal() {
		return getTossupOpal().getQuestionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Tossup> getOpal() {
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
	protected com.opal.IdentityOpal<? extends com.masonic.application.Tossup> getBottomOpal() {
		return getTossupOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getTossupOpal().getQuestionIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.TossupImpl setQuestionId(java.lang.Integer argQuestionId) {
		getTossupOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public com.masonic.persistence.TossupImpl setQuestionId(int argQuestionId) {
		getTossupOpal().setQuestionId(argQuestionId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getText() {
		return getTossupOpal().getText();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TossupImpl setText(java.lang.String argText) {
		getTossupOpal().setText(argText);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getAnswer() {
		return getTossupOpal().getAnswer();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TossupImpl setAnswer(java.lang.String argAnswer) {
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
	public com.masonic.application.Tossup copy() {
		throw new com.siliconage.util.UnimplementedOperationException();
	}

}
