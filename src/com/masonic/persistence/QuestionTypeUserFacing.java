package com.masonic.persistence;


/**
 * represents a {@code QuestionType} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code question_type}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.QuestionType}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.QuestionTypeFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.QuestionType} and the {@link com.masonic.application.QuestionTypeFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface QuestionTypeUserFacing extends com.opal.IdentityUserFacing, Comparable<com.masonic.application.QuestionType> {
	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Code}
	 *
	 * <p>The {@code Code} field is a direct mapping of the {@code code} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code Code} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getCode();

	/**
	 * sets the {@code Code} to the value of {@code argCode}
	 *
	 * @param argCode the new value of {@code Code}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argCode} is longer than 32 characters
	 * <p>The database column {@code code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.QuestionType setCode(java.lang.String argCode);

	/**
	 * object accessor for the {@code Name}
	 *
	 * <p>The {@code Name} field is a direct mapping of the {@code name} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code Name} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getName();

	/**
	 * sets the {@code Name} to the value of {@code argName}
	 *
	 * @param argName the new value of {@code Name}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code name} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argName is null
	 * @throws com.opal.ArgumentTooLongException if {@code argName} is longer than 256 characters
	 * <p>The database column {@code name} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.QuestionType setName(java.lang.String argName);

	/**
	 * object accessor for the {@code ShortName}
	 *
	 * <p>The {@code ShortName} field is a direct mapping of the {@code short_name} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code ShortName} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getShortName();

	/**
	 * sets the {@code ShortName} to the value of {@code argShortName}
	 *
	 * @param argShortName the new value of {@code ShortName}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code short_name} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argShortName is null
	 * @throws com.opal.ArgumentTooLongException if {@code argShortName} is longer than 32 characters
	 * <p>The database column {@code short_name} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.QuestionType setShortName(java.lang.String argShortName);

	/**
	 * object accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} field in {@code question_type}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getSequence() method.</p>
	 *
	 * @return an object value of {@code Sequence} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getSequenceAsObject();

	/**
	 * primitive accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} database column in the table {@code question_type}.</p>
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
	public com.masonic.application.QuestionType setSequence(java.lang.Integer argSequence);

	/**
	 * sets the {@code Sequence} to the value of {@code argSequence}
	 *
	 * @param argSequence the new value of {@code Sequence}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.QuestionType setSequence(int argSequence);

	/**
	 * object accessor for the {@code TableName}
	 *
	 * <p>The {@code TableName} field is a direct mapping of the {@code table_name} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code TableName} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getTableName();

	/**
	 * sets the {@code TableName} to the value of {@code argTableName}
	 *
	 * @param argTableName the new value of {@code TableName}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code table_name} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argTableName is null
	 * @throws com.opal.ArgumentTooLongException if {@code argTableName} is longer than 256 characters
	 * <p>The database column {@code table_name} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.QuestionType setTableName(java.lang.String argTableName);

	/**
	 * object accessor for the {@code SectionHeader}
	 *
	 * <p>The {@code SectionHeader} field is a direct mapping of the {@code section_header} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code SectionHeader} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	public java.lang.String getSectionHeader();

	/**
	 * object accessor for the {@code SectionHeader} with substitution for a null value
	 *
	 * <p>The {@code SectionHeader} field is a direct mapping of the {@code section_header} database column in the table {@code question_type}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code SectionHeader} is {@code null}.
	 * @return an object value of {@code SectionHeader} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getSectionHeader(java.lang.String argStringToSubstituteIfNull) {
		java.lang.String lclO = getSectionHeader();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code SectionHeader} to the value of {@code argSectionHeader}
	 *
	 * @param argSectionHeader the new value of {@code SectionHeader}.  May be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * @throws com.opal.ArgumentTooLongException if {@code argSectionHeader} is longer than 256 characters
	 * <p>The database column {@code section_header} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.QuestionType setSectionHeader(java.lang.String argSectionHeader);

	/**
	 * object accessor for the {@code ScoringNote}
	 *
	 * <p>The {@code ScoringNote} field is a direct mapping of the {@code scoring_note} field in {@code question_type}.</p>
	 *
	 * @return an object value of {@code ScoringNote} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getScoringNote();

	/**
	 * sets the {@code ScoringNote} to the value of {@code argScoringNote}
	 *
	 * @param argScoringNote the new value of {@code ScoringNote}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code scoring_note} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argScoringNote is null
	 * @throws com.opal.ArgumentTooLongException if {@code argScoringNote} is longer than 256 characters
	 * <p>The database column {@code scoring_note} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.QuestionType setScoringNote(java.lang.String argScoringNote);

	public int getQuestionCount();
	public java.util.Iterator<com.masonic.application.Question> createQuestionIterator();

	public java.util.stream.Stream<com.masonic.application.Question> streamQuestion();

	public com.masonic.application.QuestionType addQuestion(com.masonic.application.Question argQuestion);
	public com.masonic.application.QuestionType removeQuestion(com.masonic.application.Question argQuestion);
	public com.masonic.application.QuestionType clearQuestion();

	default public <T extends java.util.Collection<? super com.masonic.application.Question>> T acquireQuestion(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Question> lclI = createQuestionIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Question[] createQuestionArray() {
		int lclLength = getQuestionCount();
		com.masonic.application.Question[] lclA = new com.masonic.application.Question[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Question> lclI = createQuestionIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public int getSectionCount();
	public java.util.Iterator<com.masonic.application.Section> createSectionIterator();

	public java.util.stream.Stream<com.masonic.application.Section> streamSection();

	public com.masonic.application.QuestionType addSection(com.masonic.application.Section argSection);
	public com.masonic.application.QuestionType removeSection(com.masonic.application.Section argSection);
	public com.masonic.application.QuestionType clearSection();

	default public <T extends java.util.Collection<? super com.masonic.application.Section>> T acquireSection(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Section> lclI = createSectionIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Section[] createSectionArray() {
		int lclLength = getSectionCount();
		com.masonic.application.Section[] lclA = new com.masonic.application.Section[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Section> lclI = createSectionIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public com.masonic.application.QuestionType copy();

	/** This is a Comparator that can be used to compare QuestionType objects based on their {@code Code} values. */

	public static class CodeComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.QuestionType> {
		private static final CodeComparator ourInstance = new CodeComparator();
		public static final CodeComparator getInstance() { return ourInstance; }

		private CodeComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.QuestionType argFirst, com.masonic.application.QuestionType argSecond) {
			return argFirst.getCode().compareToIgnoreCase(argSecond.getCode());
		}
	}

	/** This is a Comparator that can be used to compare QuestionType objects based on their {@code Name} values. */

	public static class NameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.QuestionType> {
		private static final NameComparator ourInstance = new NameComparator();
		public static final NameComparator getInstance() { return ourInstance; }

		private NameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.QuestionType argFirst, com.masonic.application.QuestionType argSecond) {
			return argFirst.getName().compareToIgnoreCase(argSecond.getName());
		}
	}

	/** This is a Comparator that can be used to compare QuestionType objects based on their {@code ShortName} values. */

	public static class ShortNameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.QuestionType> {
		private static final ShortNameComparator ourInstance = new ShortNameComparator();
		public static final ShortNameComparator getInstance() { return ourInstance; }

		private ShortNameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.QuestionType argFirst, com.masonic.application.QuestionType argSecond) {
			return argFirst.getShortName().compareToIgnoreCase(argSecond.getShortName());
		}
	}

	/** This is a Comparator that can be used to compare QuestionType objects based on their {@code Sequence} values. */

	public static class SequenceComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.QuestionType> {
		private static final SequenceComparator ourInstance = new SequenceComparator();
		public static final SequenceComparator getInstance() { return ourInstance; }

		private SequenceComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.QuestionType argFirst, com.masonic.application.QuestionType argSecond) {
			return argFirst.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
		}
	}

}
