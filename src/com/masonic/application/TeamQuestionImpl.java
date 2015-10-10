package com.masonic.application;

import com.masonic.persistence.TeamQuestionOpal;
import com.masonic.persistence.QuestionOpal;

public class TeamQuestionImpl extends QuestionImpl implements TeamQuestion {
	private final TeamQuestionOpal myTeamQuestionOpal;

	public TeamQuestionImpl(TeamQuestionOpal argTeamQuestionOpal) {
		super();
		myTeamQuestionOpal = org.apache.commons.lang3.Validate.notNull(argTeamQuestionOpal);
	}

	protected TeamQuestionOpal getTeamQuestionOpal() {
		return myTeamQuestionOpal;
	}

	@Override
	protected QuestionOpal getQuestionOpal() {
		return getTeamQuestionOpal().getQuestionOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends TeamQuestion> getOpal() {
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
	protected com.opal.IdentityOpal<? extends TeamQuestion> getBottomOpal() {
		return getTeamQuestionOpal();
	}

	@Override
	public java.lang.Integer getQuestionIdAsObject() {
		return getTeamQuestionOpal().getQuestionIdAsObject();
	}

	@Override
	public TeamQuestionImpl setQuestionId(java.lang.Integer argQuestionId) {
		getTeamQuestionOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public TeamQuestionImpl setQuestionId(int argQuestionId) {
		getTeamQuestionOpal().setQuestionId(argQuestionId);
		return this;
	}

	@Override
	public java.lang.String getIntroduction() {
		return getTeamQuestionOpal().getIntroduction();
	}

	@Override
	public TeamQuestionImpl setIntroduction(java.lang.String argIntroduction) {
		getTeamQuestionOpal().setIntroduction(argIntroduction);
		return this;
	}

	@Override
	public java.lang.String getPart1Text() {
		return getTeamQuestionOpal().getPart1Text();
	}

	@Override
	public TeamQuestionImpl setPart1Text(java.lang.String argPart1Text) {
		getTeamQuestionOpal().setPart1Text(argPart1Text);
		return this;
	}

	@Override
	public java.lang.String getPart1Answer() {
		return getTeamQuestionOpal().getPart1Answer();
	}

	@Override
	public TeamQuestionImpl setPart1Answer(java.lang.String argPart1Answer) {
		getTeamQuestionOpal().setPart1Answer(argPart1Answer);
		return this;
	}

	@Override
	public java.lang.String getPart2Text() {
		return getTeamQuestionOpal().getPart2Text();
	}

	@Override
	public TeamQuestionImpl setPart2Text(java.lang.String argPart2Text) {
		getTeamQuestionOpal().setPart2Text(argPart2Text);
		return this;
	}

	@Override
	public java.lang.String getPart2Answer() {
		return getTeamQuestionOpal().getPart2Answer();
	}

	@Override
	public TeamQuestionImpl setPart2Answer(java.lang.String argPart2Answer) {
		getTeamQuestionOpal().setPart2Answer(argPart2Answer);
		return this;
	}

	@Override
	public java.lang.String getPart3Text() {
		return getTeamQuestionOpal().getPart3Text();
	}

	@Override
	public TeamQuestionImpl setPart3Text(java.lang.String argPart3Text) {
		getTeamQuestionOpal().setPart3Text(argPart3Text);
		return this;
	}

	@Override
	public java.lang.String getPart3Answer() {
		return getTeamQuestionOpal().getPart3Answer();
	}

	@Override
	public TeamQuestionImpl setPart3Answer(java.lang.String argPart3Answer) {
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
	public TeamQuestion copy() {
		throw new com.siliconage.util.UnimplementedOperationException();
	}

}
