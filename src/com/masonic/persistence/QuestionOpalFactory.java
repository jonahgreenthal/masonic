package com.masonic.persistence;
import com.masonic.application.Question;
import com.opal.PersistenceException;

public interface QuestionOpalFactory extends com.opal.OpalFactory<Question, QuestionOpal> {
	public java.util.HashSet<QuestionOpal> forQuestionStatusCodeCollection(java.lang.String argQuestionStatusCode) throws com.opal.PersistenceException;
	public java.util.HashSet<QuestionOpal> forIntendedPacketSetCodeCollection(java.lang.String argIntendedPacketSetCode) throws com.opal.PersistenceException;
	public java.util.HashSet<QuestionOpal> forWriterAccountIdCollection(java.lang.Integer argWriterAccountId) throws com.opal.PersistenceException;
	public java.util.HashSet<QuestionOpal> forCategoryCodeCollection(java.lang.String argCategoryCode) throws com.opal.PersistenceException;
	public java.util.HashSet<QuestionOpal> forQuestionTypeCodeCollection(java.lang.String argQuestionTypeCode) throws com.opal.PersistenceException;
	public QuestionOpal forId(java.lang.Integer argId) throws PersistenceException;
	public QuestionOpal createAsSuperOpal(Question argUF);

}
