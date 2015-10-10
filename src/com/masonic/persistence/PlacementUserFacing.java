package com.masonic.persistence;


/**
 * represents a {@code Placement} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code placement}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Placement}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.PlacementFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Placement} and the {@link com.masonic.application.PlacementFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface PlacementUserFacing extends com.opal.IdentityUserFacing {
	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} field in {@code placement}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getId() method.</p>
	 *
	 * @return an object value of {@code Id} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getIdAsObject();

	/**
	 * primitive accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} database column in the table {@code placement}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getIdAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Id} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getId() {
		java.lang.Integer lclO = getIdAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argId is null
	 */
	@com.opal.annotation.NotNull
	public com.masonic.application.Placement setId(java.lang.Integer argId);

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Placement setId(int argId);

	/**
	 * object accessor for the {@code SectionId}
	 *
	 * <p>The {@code SectionId} field is a direct mapping of the {@code section_id} field in {@code placement}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getSectionId() method.</p>
	 *
	 * @return an object value of {@code SectionId} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getSectionIdAsObject();

	/**
	 * primitive accessor for the {@code SectionId}
	 *
	 * <p>The {@code SectionId} field is a direct mapping of the {@code section_id} database column in the table {@code placement}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getSectionIdAsObject() method.</p>
	 *
	 * @return the primitive value of {@code SectionId} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getSectionId() {
		java.lang.Integer lclO = getSectionIdAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code SectionId} to the value of {@code argSectionId}
	 *
	 * @param argSectionId the new value of {@code SectionId}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code section_id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argSectionId is null
	 */
	@com.opal.annotation.NotNull
	public com.masonic.application.Placement setSectionId(java.lang.Integer argSectionId);

	/**
	 * sets the {@code SectionId} to the value of {@code argSectionId}
	 *
	 * @param argSectionId the new value of {@code SectionId}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Placement setSectionId(int argSectionId);

	/**
	 * object accessor for the {@code CategoryCode}
	 *
	 * <p>The {@code CategoryCode} field is a direct mapping of the {@code category_code} field in {@code placement}.</p>
	 *
	 * @return an object value of {@code CategoryCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getCategoryCode();

	/**
	 * sets the {@code CategoryCode} to the value of {@code argCategoryCode}
	 *
	 * @param argCategoryCode the new value of {@code CategoryCode}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code category_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argCategoryCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argCategoryCode} is longer than 32 characters
	 * <p>The database column {@code category_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.Placement setCategoryCode(java.lang.String argCategoryCode);

	/**
	 * object accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} field in {@code placement}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getSequence() method.</p>
	 *
	 * @return an object value of {@code Sequence} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getSequenceAsObject();

	/**
	 * primitive accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} database column in the table {@code placement}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getSequenceAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Sequence} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getSequence() {
		java.lang.Integer lclO = getSequenceAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code Sequence} to the value of {@code argSequence}
	 *
	 * @param argSequence the new value of {@code Sequence}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code sequence} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argSequence is null
	 */
	@com.opal.annotation.NotNull
	public com.masonic.application.Placement setSequence(java.lang.Integer argSequence);

	/**
	 * sets the {@code Sequence} to the value of {@code argSequence}
	 *
	 * @param argSequence the new value of {@code Sequence}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Placement setSequence(int argSequence);

	/**
	 * object accessor for the {@code QuestionId}
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} field in {@code placement}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getQuestionId() method.</p>
	 *
	 * @return an object value of {@code QuestionId} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	public java.lang.Integer getQuestionIdAsObject();

	/**
	 * object accessor for the {@code QuestionId} with substitution for a null value
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} database column in the table {@code placement}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code QuestionId} is {@code null}.
	 * @return an object value of {@code QuestionId} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getQuestionIdAsObject(java.lang.String argStringToSubstituteIfNull) {
		java.lang.Integer lclO = getQuestionIdAsObject();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * primitive accessor for the {@code QuestionId}
	 *
	 * <p>The {@code QuestionId} field is a direct mapping of the {@code question_id} database column in the table {@code placement}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getQuestionIdAsObject() method.</p>
	 *
	 * <p>The underlying database table allows a {@code NULL} value for this column; calling this method when the value is null will result in an Exception.  To test for a null value, use the Object accessor mentioned above.</p>
	 *
	 * @return the primitive value of {@code QuestionId} (of the current {@link com.opal.TransactionContext})
	 * @throws com.opal.NullValueException when the internal value is null
	 */
	default public int getQuestionId() throws com.opal.NullValueException {
		java.lang.Integer lclO = getQuestionIdAsObject();
		if (lclO == null) {
			throw new com.opal.NullValueException("The internal value is null and cannot be returned as a primitive.");
		}
		return lclO.intValue();
	}

	default public int getQuestionId(int argStringToSubstituteIfNull) {
		java.lang.Integer lclO = getQuestionIdAsObject();
		return lclO != null ? lclO.intValue() : argStringToSubstituteIfNull;
	}

	default public java.lang.String getQuestionId(java.lang.String argStringToSubstituteIfNull) {
		java.lang.Integer lclO = getQuestionIdAsObject();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}

	/**
	 * sets the {@code QuestionId} to the value of {@code argQuestionId}
	 *
	 * @param argQuestionId the new value of {@code QuestionId}.  May be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 */
	public com.masonic.application.Placement setQuestionId(java.lang.Integer argQuestionId);

	/**
	 * sets the {@code QuestionId} to the value of {@code argQuestionId}
	 *
	 * @param argQuestionId the new value of {@code QuestionId}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Placement setQuestionId(int argQuestionId);

	/**
	 * @return the {@code com.masonic.application.Section}
	 * The returned {@code com.masonic.application.Section} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code section} that is referenced by {@code placement_to_section}.
	 *
	 */
	public com.masonic.application.Section getSection();
	public com.masonic.application.Placement setSection(com.masonic.application.Section argSection);

	/**
	 * @return the {@code com.masonic.application.Question}
	 * The returned {@code com.masonic.application.Question} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code question} that is referenced by {@code placement_to_question}.
	 *
	 */
	public com.masonic.application.Question getQuestion();
	public com.masonic.application.Placement setQuestion(com.masonic.application.Question argQuestion);

	/**
	 * @return the {@code com.masonic.application.Category}
	 * The returned {@code com.masonic.application.Category} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code category} that is referenced by {@code placement_to_category}.
	 *
	 */
	public com.masonic.application.Category getCategory();
	public com.masonic.application.Placement setCategory(com.masonic.application.Category argCategory);

	public com.masonic.application.Placement copy();

	/** This is a Comparator that can be used to compare Placement objects based on their {@code Id} values. */

	public static class IdComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Placement> {
		private static final IdComparator ourInstance = new IdComparator();
		public static final IdComparator getInstance() { return ourInstance; }

		private IdComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Placement argFirst, com.masonic.application.Placement argSecond) {
			return argFirst.getIdAsObject().compareTo(argSecond.getIdAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Placement objects based on their {@code Sequence} values. */

	public static class SequenceComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Placement> {
		private static final SequenceComparator ourInstance = new SequenceComparator();
		public static final SequenceComparator getInstance() { return ourInstance; }

		private SequenceComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Placement argFirst, com.masonic.application.Placement argSecond) {
			return argFirst.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
		}
	}

	public static class StandardComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Placement> {
		private static final StandardComparator ourInstance = new StandardComparator();
		public static final StandardComparator getInstance() { return ourInstance; }

		private StandardComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Placement argFirst, com.masonic.application.Placement argSecond) {
			int lclResult = com.masonic.application.Section.SequenceComparator.getInstance().compare(argFirst.getSection(),  argSecond.getSection());
			if (lclResult != 0) {
				return lclResult;
			}
			return argFirst.getSequence() - argSecond.getSequence();
		}
	}

}
