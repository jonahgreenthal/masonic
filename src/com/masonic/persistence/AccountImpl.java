package com.masonic.persistence;


public class AccountImpl extends com.opal.AbstractIdentityImpl<com.masonic.application.Account, com.masonic.persistence.AccountOpal> implements com.masonic.application.Account {

	private final com.masonic.persistence.AccountOpal myAccountOpal;

	public AccountImpl(AccountOpal argAccountOpal) {
		super();
		myAccountOpal = org.apache.commons.lang3.Validate.notNull(argAccountOpal);
	}

	protected com.masonic.persistence.AccountOpal getAccountOpal() {
		return myAccountOpal;
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Account> getOpal() {
		return getAccountOpal();
	}

	@Override
	protected com.opal.IdentityOpal<? extends com.masonic.application.Account> getBottomOpal() {
		return getAccountOpal();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public java.lang.Integer getIdAsObject() {
		return getAccountOpal().getIdAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@Override
	public com.masonic.persistence.AccountImpl setId(java.lang.Integer argId) {
		getAccountOpal().setId(argId);
		return this;
	}

	@Override
	public com.masonic.persistence.AccountImpl setId(int argId) {
		getAccountOpal().setId(argId);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getName() {
		return getAccountOpal().getName();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.AccountImpl setName(java.lang.String argName) {
		getAccountOpal().setName(argName);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public java.lang.String getEmailAddress() {
		return getAccountOpal().getEmailAddress();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	@Override
	public com.masonic.persistence.AccountImpl setEmailAddress(java.lang.String argEmailAddress) {
		getAccountOpal().setEmailAddress(argEmailAddress);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 64L)
	@Override
	public java.lang.String getUsername() {
		return getAccountOpal().getUsername();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 64L)
	@Override
	public com.masonic.persistence.AccountImpl setUsername(java.lang.String argUsername) {
		getAccountOpal().setUsername(argUsername);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 60L)
	@com.opal.annotation.Default(value = "$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	@Override
	public java.lang.String getPasswordHash() {
		return getAccountOpal().getPasswordHash();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 60L)
	@com.opal.annotation.Default(value = "$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	@Override
	public com.masonic.persistence.AccountImpl setPasswordHash(java.lang.String argPasswordHash) {
		getAccountOpal().setPasswordHash(argPasswordHash);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public java.lang.Boolean isAdministratorAsObject() {
		return getAccountOpal().isAdministratorAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	@Override
	public com.masonic.persistence.AccountImpl setAdministrator(java.lang.Boolean argAdministrator) {
		getAccountOpal().setAdministrator(argAdministrator);
		return this;
	}

	@Override
	public com.masonic.persistence.AccountImpl setAdministrator(boolean argAdministrator) {
		getAccountOpal().setAdministrator(argAdministrator);
		return this;
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "true")
	@Override
	public java.lang.Boolean isActiveAsObject() {
		return getAccountOpal().isActiveAsObject();
	}

	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "true")
	@Override
	public com.masonic.persistence.AccountImpl setActive(java.lang.Boolean argActive) {
		getAccountOpal().setActive(argActive);
		return this;
	}

	@Override
	public com.masonic.persistence.AccountImpl setActive(boolean argActive) {
		getAccountOpal().setActive(argActive);
		return this;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public com.masonic.application.Account addWriterQuestion(com.masonic.application.Question argQuestion) {
		getAccountOpal().addWriterQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public com.masonic.application.Account removeWriterQuestion(com.masonic.application.Question argQuestion) {
		getAccountOpal().removeWriterQuestionOpal(((QuestionImpl) argQuestion).getQuestionOpal());
		return this;
	}

	@Override
	public int getWriterQuestionCount() {
		return getAccountOpal().getWriterQuestionOpalCount();
	}

	@Override
	public java.util.stream.Stream<com.masonic.application.Question> streamWriterQuestion() {
		return getAccountOpal().streamWriterQuestionOpal().map(com.opal.Opal::getUserFacing);
	}

	@Override
	public java.util.Iterator<com.masonic.application.Question> createWriterQuestionIterator() {
		return new com.opal.OpalIterator<> (getAccountOpal().createWriterQuestionOpalIterator());
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
	public com.masonic.application.Account copy() {
		return getAccountOpal().copy().getUserFacing();
	}

}
