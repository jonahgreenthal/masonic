package com.masonic.persistence;


/**
 * represents a {@code TeamQuestion} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code team_question}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.TeamQuestion}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.TeamQuestionFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.TeamQuestion} and the {@link com.masonic.application.TeamQuestionFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface TeamQuestionUserFacing extends com.masonic.application.Question {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code QuestionId}
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} field in {@code team_question}.</p>
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
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} database column in the table {@code team_question}.</p>
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
	public com.masonic.application.TeamQuestion setQuestionId(java.lang.Integer argQuestionId);

	/**
	 * sets the {@code QuestionId} to the value of {@code argQuestionId}
	 *
	 * @param argQuestionId the new value of {@code QuestionId}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.TeamQuestion setQuestionId(int argQuestionId);

	/**
	 * object accessor for the {@code Introduction}
	 *
	 * <p>The {@code Introduction} field is a direct mapping of the {@code introduction} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Introduction} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getIntroduction();

	/**
	 * sets the {@code Introduction} to the value of {@code argIntroduction}
	 *
	 * @param argIntroduction the new value of {@code Introduction}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code introduction} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argIntroduction is null
	 * @throws com.opal.ArgumentTooLongException if {@code argIntroduction} is longer than 2147483647 characters
	 * <p>The database column {@code introduction} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setIntroduction(java.lang.String argIntroduction);

	/**
	 * object accessor for the {@code Part1Text}
	 *
	 * <p>The {@code Part1Text} field is a direct mapping of the {@code part_1_text} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part1Text} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart1Text();

	/**
	 * sets the {@code Part1Text} to the value of {@code argPart1Text}
	 *
	 * @param argPart1Text the new value of {@code Part1Text}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_1_text} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart1Text is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart1Text} is longer than 2147483647 characters
	 * <p>The database column {@code part_1_text} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart1Text(java.lang.String argPart1Text);

	/**
	 * object accessor for the {@code Part1Answer}
	 *
	 * <p>The {@code Part1Answer} field is a direct mapping of the {@code part_1_answer} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part1Answer} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart1Answer();

	/**
	 * sets the {@code Part1Answer} to the value of {@code argPart1Answer}
	 *
	 * @param argPart1Answer the new value of {@code Part1Answer}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_1_answer} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart1Answer is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart1Answer} is longer than 2147483647 characters
	 * <p>The database column {@code part_1_answer} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart1Answer(java.lang.String argPart1Answer);

	/**
	 * object accessor for the {@code Part2Text}
	 *
	 * <p>The {@code Part2Text} field is a direct mapping of the {@code part_2_text} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part2Text} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart2Text();

	/**
	 * sets the {@code Part2Text} to the value of {@code argPart2Text}
	 *
	 * @param argPart2Text the new value of {@code Part2Text}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_2_text} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart2Text is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart2Text} is longer than 2147483647 characters
	 * <p>The database column {@code part_2_text} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart2Text(java.lang.String argPart2Text);

	/**
	 * object accessor for the {@code Part2Answer}
	 *
	 * <p>The {@code Part2Answer} field is a direct mapping of the {@code part_2_answer} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part2Answer} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart2Answer();

	/**
	 * sets the {@code Part2Answer} to the value of {@code argPart2Answer}
	 *
	 * @param argPart2Answer the new value of {@code Part2Answer}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_2_answer} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart2Answer is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart2Answer} is longer than 2147483647 characters
	 * <p>The database column {@code part_2_answer} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart2Answer(java.lang.String argPart2Answer);

	/**
	 * object accessor for the {@code Part3Text}
	 *
	 * <p>The {@code Part3Text} field is a direct mapping of the {@code part_3_text} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part3Text} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart3Text();

	/**
	 * sets the {@code Part3Text} to the value of {@code argPart3Text}
	 *
	 * @param argPart3Text the new value of {@code Part3Text}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_3_text} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart3Text is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart3Text} is longer than 2147483647 characters
	 * <p>The database column {@code part_3_text} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart3Text(java.lang.String argPart3Text);

	/**
	 * object accessor for the {@code Part3Answer}
	 *
	 * <p>The {@code Part3Answer} field is a direct mapping of the {@code part_3_answer} field in {@code team_question}.</p>
	 *
	 * @return an object value of {@code Part3Answer} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getPart3Answer();

	/**
	 * sets the {@code Part3Answer} to the value of {@code argPart3Answer}
	 *
	 * @param argPart3Answer the new value of {@code Part3Answer}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code part_3_answer} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPart3Answer is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPart3Answer} is longer than 2147483647 characters
	 * <p>The database column {@code part_3_answer} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.TeamQuestion setPart3Answer(java.lang.String argPart3Answer);

}
