package com.masonic.persistence;
import com.masonic.application.Tossup;
import com.opal.PersistenceException;

public interface TossupOpalFactory extends com.opal.IdentityOpalFactory<Tossup, TossupOpal>, com.opal.OpalFactoryCreator<Tossup, TossupOpal> {

	public TossupOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException;
}
