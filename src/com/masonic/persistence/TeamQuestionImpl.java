package com.masonic.persistence;


public class TeamQuestionImpl extends QuestionImpl implements com.masonic.application.TeamQuestion {

	private final com.masonic.persistence.TeamQuestionOpal myTeamQuestionOpal;

	public TeamQuestionImpl(TeamQuestionOpal argTeamQuestionOpal) {
		super();
		myTeamQuestionOpal = org.apache.commons.lang3.Validate.notNull(argTeamQuestionOpal);
	}

	protected com.masonic.persistence.TeamQuestionOpal getTeamQuestionOpal() {
		return myTeamQuestionOpal;
	}

	@Override
	protected QuestionOpal getQuestionOpal() {
		return getTeamQuestionOpal().getQuestionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.TeamQuestion> getOpal() {
		return getTeamQuestionOpal();
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
	protected com.opal.IdentityOpal<? extends com.masonic.application.TeamQuestion> getBottomOpal() {
		return getTeamQuestionOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getTeamQuestionOpal().getQuestionIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setQuestionId(java.lang.Integer argQuestionId) {
		getTeamQuestionOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public com.masonic.persistence.TeamQuestionImpl setQuestionId(int argQuestionId) {
		getTeamQuestionOpal().setQuestionId(argQuestionId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getIntroduction() {
		return getTeamQuestionOpal().getIntroduction();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setIntroduction(java.lang.String argIntroduction) {
		getTeamQuestionOpal().setIntroduction(argIntroduction);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart1Text() {
		return getTeamQuestionOpal().getPart1Text();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart1Text(java.lang.String argPart1Text) {
		getTeamQuestionOpal().setPart1Text(argPart1Text);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart1Answer() {
		return getTeamQuestionOpal().getPart1Answer();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart1Answer(java.lang.String argPart1Answer) {
		getTeamQuestionOpal().setPart1Answer(argPart1Answer);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart2Text() {
		return getTeamQuestionOpal().getPart2Text();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart2Text(java.lang.String argPart2Text) {
		getTeamQuestionOpal().setPart2Text(argPart2Text);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart2Answer() {
		return getTeamQuestionOpal().getPart2Answer();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart2Answer(java.lang.String argPart2Answer) {
		getTeamQuestionOpal().setPart2Answer(argPart2Answer);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart3Text() {
		return getTeamQuestionOpal().getPart3Text();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart3Text(java.lang.String argPart3Text) {
		getTeamQuestionOpal().setPart3Text(argPart3Text);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public java.lang.String getPart3Answer() {
		return getTeamQuestionOpal().getPart3Answer();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	@Override
	public com.masonic.persistence.TeamQuestionImpl setPart3Answer(java.lang.String argPart3Answer) {
		getTeamQuestionOpal().setPart3Answer(argPart3Answer);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void unlink() {
		getTeamQuestionOpal().unlink();
		super.unlink();
	}

	@Override
	public void reload() {
		super.reload();
		getTeamQuestionOpal().reload();
	}

	@Override
	public com.masonic.application.TeamQuestion copy() {
		throw new com.siliconage.util.UnimplementedOperationException();
	}

}
