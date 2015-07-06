package com.masonic.application;

import com.masonic.persistence.AccountOpal;

public class AccountImpl extends com.opal.AbstractIdentityImpl<Account, AccountOpal> implements Account {
	private final AccountOpal myAccountOpal;

	public AccountImpl(AccountOpal argAccountOpal) {
		super();
		myAccountOpal = org.apache.commons.lang3.Validate.notNull(argAccountOpal);
	}

	protected AccountOpal getAccountOpal() {
		return myAccountOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends Account> getOpal() {
		return getAccountOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends Account> getBottomOpal() {
		return getAccountOpal();
	}

	@Override
	public java.lang.Integer getIdAsObject() {
		return getAccountOpal().getIdAsObject();
	}

	@Override
	public AccountImpl setId(java.lang.Integer argId) {
		getAccountOpal().setId(argId);
		return this;
	}

	@Override
	public AccountImpl setId(int argId) {
		getAccountOpal().setId(argId);
		return this;
	}

	@Override
	public java.lang.String getName() {
		return getAccountOpal().getName();
	}

	@Override
	public AccountImpl setName(java.lang.String argName) {
		getAccountOpal().setName(argName);
		return this;
	}

	@Override
	public java.lang.String getEmailAddress() {
		return getAccountOpal().getEmailAddress();
	}

	@Override
	public AccountImpl setEmailAddress(java.lang.String argEmailAddress) {
		getAccountOpal().setEmailAddress(argEmailAddress);
		return this;
	}

	@Override
	public java.lang.String getUsername() {
		return getAccountOpal().getUsername();
	}

	@Override
	public AccountImpl setUsername(java.lang.String argUsername) {
		getAccountOpal().setUsername(argUsername);
		return this;
	}

	@Override
	public java.lang.String getPasswordHash() {
		return getAccountOpal().getPasswordHash();
	}

	@Override
	public AccountImpl setPasswordHash(java.lang.String argPasswordHash) {
		getAccountOpal().setPasswordHash(argPasswordHash);
		return this;
	}

	@Override
	public java.lang.Boolean isAdministratorAsObject() {
		return getAccountOpal().isAdministratorAsObject();
	}

	@Override
	public AccountImpl setAdministrator(java.lang.Boolean argAdministrator) {
		getAccountOpal().setAdministrator(argAdministrator);
		return this;
	}

	@Override
	public AccountImpl setAdministrator(boolean argAdministrator) {
		getAccountOpal().setAdministrator(argAdministrator);
		return this;
	}

	@Override
	public java.lang.Boolean isActiveAsObject() {
		return getAccountOpal().isActiveAsObject();
	}

	@Override
	public AccountImpl setActive(java.lang.Boolean argActive) {
		getAccountOpal().setActive(argActive);
		return this;
	}

	@Override
	public AccountImpl setActive(boolean argActive) {
		getAccountOpal().setActive(argActive);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void addWriterQuestion(Question argQuestion) {
		getAccountOpal().addWriterQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
	}

	@Override
	public void removeWriterQuestion(Question argQuestion) {
		getAccountOpal().removeWriterQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
	}

	@Override
	public int getWriterQuestionCount() {
		return getAccountOpal().getWriterQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<Question> streamWriterQuestion() {
		return getAccountOpal().streamWriterQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<Question> createWriterQuestionIterator() {
		return new com.opal.OpalIterator<> (getAccountOpal().createWriterQuestionOpalIterator());
	}

	@Override
	public void clearWriterQuestion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void unlink() {
		getAccountOpal().unlink();
	}

	@Override
	public void reload() {
		getAccountOpal().reload();
	}

	@Override
	public Account copy() {
		return getAccountOpal().copy().getUserFacing();
	}

}
