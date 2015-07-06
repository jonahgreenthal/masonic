package com.masonic.persistence;
import com.masonic.application.Account;
import com.opal.PersistenceException;

public interface AccountOpalFactory extends com.opal.OpalFactory<Account, AccountOpal>, com.opal.OpalFactoryCreator<Account, AccountOpal> {
	public AccountOpal forId(java.lang.Integer argId) throws PersistenceException;
	public AccountOpal forName(java.lang.String argName) throws PersistenceException;
	public AccountOpal forUsername(java.lang.String argUsername) throws PersistenceException;
}
