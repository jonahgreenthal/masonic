package com.masonic.persistence;
import com.masonic.application.QuestionType;
import com.opal.PersistenceException;

public interface QuestionTypeOpalFactory extends com.opal.OpalFactory<QuestionType, QuestionTypeOpal>, com.opal.OpalFactoryCreator<QuestionType, QuestionTypeOpal> {
	public QuestionTypeOpal forCode(java.lang.String argCode) throws PersistenceException;
	public QuestionTypeOpal forName(java.lang.String argName) throws PersistenceException;
	public QuestionTypeOpal forShortName(java.lang.String argShortName) throws PersistenceException;
}
