package com.masonic.persistence;


/**
 * represents a {@code Tossup} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code tossup}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Tossup}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.TossupFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Tossup} and the {@link com.masonic.application.TossupFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface TossupUserFacing extends com.masonic.application.Question {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code QuestionId}
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} field in {@code tossup}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getQuestionId() method.</p>
	 *
	 * @return an object value of {@code QuestionId} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public java.lang.Integer getQuestionIdAsObject();

	/**
	 * primitive accessor for the {@code QuestionId}
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} database column in the table {@code tossup}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getQuestionIdAsObject() method.</p>
	 *
	 * @return the primitive value of {@code QuestionId} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getQuestionId() {
		java.lang.Integer lclO = getQuestionIdAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code QuestionId} to the value of {@code argQuestionId}
	 *
	 * @param argQuestionId the new value of {@code QuestionId}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code question_id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argQuestionId is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Tossup setQuestionId(java.lang.Integer argQuestionId);

	/**
	 * sets the {@code QuestionId} to the value of {@code argQuestionId}
	 *
	 * @param argQuestionId the new value of {@code QuestionId}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Tossup setQuestionId(int argQuestionId);

	/**
	 * object accessor for the {@code Text}
	 *
	 * <p>The {@code Text} field is a direct mapping of the {@code text} field in {@code tossup}.</p>
	 *
	 * @return an object value of {@code Text} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getText();

	/**
	 * sets the {@code Text} to the value of {@code argText}
	 *
	 * @param argText the new value of {@code Text}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code text} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argText is null
	 * @throws com.opal.ArgumentTooLongException if {@code argText} is longer than 2147483647 characters
	 * <p>The database column {@code text} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.Tossup setText(java.lang.String argText);

	/**
	 * object accessor for the {@code Answer}
	 *
	 * <p>The {@code Answer} field is a direct mapping of the {@code answer} field in {@code tossup}.</p>
	 *
	 * @return an object value of {@code Answer} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getAnswer();

	/**
	 * sets the {@code Answer} to the value of {@code argAnswer}
	 *
	 * @param argAnswer the new value of {@code Answer}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code answer} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argAnswer is null
	 * @throws com.opal.ArgumentTooLongException if {@code argAnswer} is longer than 2147483647 characters
	 * <p>The database column {@code answer} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.Tossup setAnswer(java.lang.String argAnswer);

}
