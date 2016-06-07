package com.masonic.persistence;


/**
 * represents a {@code Question} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code question}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Question}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.QuestionFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Question} and the {@link com.masonic.application.QuestionFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface QuestionUserFacing extends com.opal.IdentityUserFacing {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} field in {@code question}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getId() method.</p>
	 *
	 * @return an object value of {@code Id} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public java.lang.Integer getIdAsObject();

	/**
	 * primitive accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} database column in the table {@code question}.</p>
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
	 * <p>The database column {@code id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argId is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public void setId(java.lang.Integer argId);

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}
	 */
	public void setId(int argId);

	/**
	 * object accessor for the {@code CategoryCode}
	 *
	 * <p>The {@code CategoryCode} field is a direct mapping of the {@code category_code} field in {@code question}.</p>
	 *
	 * @return an object value of {@code CategoryCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public java.lang.String getCategoryCode();

	/**
	 * sets the {@code CategoryCode} to the value of {@code argCategoryCode}
	 *
	 * @param argCategoryCode the new value of {@code CategoryCode}.  May not be <code>null</code>.
	 * <p>The database column {@code category_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argCategoryCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argCategoryCode} is longer than 32 characters
	 * <p>The database column {@code category_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public void setCategoryCode(java.lang.String argCategoryCode);

	/**
	 * object accessor for the {@code InternalNote}
	 *
	 * <p>The {@code InternalNote} field is a direct mapping of the {@code internal_note} field in {@code question}.</p>
	 *
	 * @return an object value of {@code InternalNote} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getInternalNote();

	/**
	 * object accessor for the {@code InternalNote} with substitution for a null value
	 *
	 * <p>The {@code InternalNote} field is a direct mapping of the {@code internal_note} database column in the table {@code question}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code InternalNote} is {@code null}.
	 * @return an object value of {@code InternalNote} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getInternalNote(java.lang.String argStringToSubstituteIfNull) {
		java.lang.String lclO = getInternalNote();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code InternalNote} to the value of {@code argInternalNote}
	 *
	 * @param argInternalNote the new value of {@code InternalNote}.  May be <code>null</code>.
	 * @throws com.opal.ArgumentTooLongException if {@code argInternalNote} is longer than 2147483647 characters
	 * <p>The database column {@code internal_note} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public void setInternalNote(java.lang.String argInternalNote);

	/**
	 * object accessor for the {@code ExternalNote}
	 *
	 * <p>The {@code ExternalNote} field is a direct mapping of the {@code external_note} field in {@code question}.</p>
	 *
	 * @return an object value of {@code ExternalNote} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getExternalNote();

	/**
	 * object accessor for the {@code ExternalNote} with substitution for a null value
	 *
	 * <p>The {@code ExternalNote} field is a direct mapping of the {@code external_note} database column in the table {@code question}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code ExternalNote} is {@code null}.
	 * @return an object value of {@code ExternalNote} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getExternalNote(java.lang.String argStringToSubstituteIfNull) {
		java.lang.String lclO = getExternalNote();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code ExternalNote} to the value of {@code argExternalNote}
	 *
	 * @param argExternalNote the new value of {@code ExternalNote}.  May be <code>null</code>.
	 * @throws com.opal.ArgumentTooLongException if {@code argExternalNote} is longer than 2147483647 characters
	 * <p>The database column {@code external_note} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public void setExternalNote(java.lang.String argExternalNote);

	/**
	 * object accessor for the {@code QuestionTypeCode}
	 *
	 * <p>The {@code QuestionTypeCode} field is a direct mapping of the {@code question_type_code} field in {@code question}.</p>
	 *
	 * @return an object value of {@code QuestionTypeCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public java.lang.String getQuestionTypeCode();

	/**
	 * sets the {@code QuestionTypeCode} to the value of {@code argQuestionTypeCode}
	 *
	 * @param argQuestionTypeCode the new value of {@code QuestionTypeCode}.  May not be <code>null</code>.
	 * <p>The database column {@code question_type_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argQuestionTypeCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argQuestionTypeCode} is longer than 32 characters
	 * <p>The database column {@code question_type_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public void setQuestionTypeCode(java.lang.String argQuestionTypeCode);

	/**
	 * object accessor for the {@code Label}
	 *
	 * <p>The {@code Label} field is a direct mapping of the {@code label} field in {@code question}.</p>
	 *
	 * @return an object value of {@code Label} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public java.lang.String getLabel();

	/**
	 * sets the {@code Label} to the value of {@code argLabel}
	 *
	 * @param argLabel the new value of {@code Label}.  May not be <code>null</code>.
	 * <p>The database column {@code label} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argLabel is null
	 * @throws com.opal.ArgumentTooLongException if {@code argLabel} is longer than 256 characters
	 * <p>The database column {@code label} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public void setLabel(java.lang.String argLabel);

	/**
	 * object accessor for the {@code WriterAccountId}
	 *
	 * <p>The {@code WriterAccountId} field is a direct mapping of the {@code writer_account_id} field in {@code question}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getWriterAccountId() method.</p>
	 *
	 * @return an object value of {@code WriterAccountId} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public java.lang.Integer getWriterAccountIdAsObject();

	/**
	 * primitive accessor for the {@code WriterAccountId}
	 *
	 * <p>The {@code WriterAccountId} field is a direct mapping of the {@code writer_account_id} database column in the table {@code question}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getWriterAccountIdAsObject() method.</p>
	 *
	 * @return the primitive value of {@code WriterAccountId} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getWriterAccountId() {
		java.lang.Integer lclO = getWriterAccountIdAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code WriterAccountId} to the value of {@code argWriterAccountId}
	 *
	 * @param argWriterAccountId the new value of {@code WriterAccountId}.  May not be <code>null</code>.
	 * <p>The database column {@code writer_account_id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argWriterAccountId is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public void setWriterAccountId(java.lang.Integer argWriterAccountId);

	/**
	 * sets the {@code WriterAccountId} to the value of {@code argWriterAccountId}
	 *
	 * @param argWriterAccountId the new value of {@code WriterAccountId}
	 */
	public void setWriterAccountId(int argWriterAccountId);

	/**
	 * object accessor for the {@code Updated}
	 *
	 * <p>The {@code Updated} field is a direct mapping of the {@code updated} field in {@code question}.</p>
	 *
	 * @return an object value of {@code Updated} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.CurrentDateTimeDefault
	public java.time.LocalDateTime getUpdated();

	/**
	 * sets the {@code Updated} to the value of {@code argUpdated}
	 *
	 * @param argUpdated the new value of {@code Updated}.  May not be <code>null</code>.
	 * <p>The database column {@code updated} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argUpdated is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.CurrentDateTimeDefault
	public void setUpdated(java.time.LocalDateTime argUpdated);

	/**
	 * object accessor for the {@code IntendedPacketSetCode}
	 *
	 * <p>The {@code IntendedPacketSetCode} field is a direct mapping of the {@code intended_packet_set_code} field in {@code question}.</p>
	 *
	 * @return an object value of {@code IntendedPacketSetCode} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 32L)
	public java.lang.String getIntendedPacketSetCode();

	/**
	 * object accessor for the {@code IntendedPacketSetCode} with substitution for a null value
	 *
	 * <p>The {@code IntendedPacketSetCode} field is a direct mapping of the {@code intended_packet_set_code} database column in the table {@code question}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code IntendedPacketSetCode} is {@code null}.
	 * @return an object value of {@code IntendedPacketSetCode} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getIntendedPacketSetCode(java.lang.String argStringToSubstituteIfNull) {
		java.lang.String lclO = getIntendedPacketSetCode();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code IntendedPacketSetCode} to the value of {@code argIntendedPacketSetCode}
	 *
	 * @param argIntendedPacketSetCode the new value of {@code IntendedPacketSetCode}.  May be <code>null</code>.
	 * @throws com.opal.ArgumentTooLongException if {@code argIntendedPacketSetCode} is longer than 32 characters
	 * <p>The database column {@code intended_packet_set_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 32L)
	public void setIntendedPacketSetCode(java.lang.String argIntendedPacketSetCode);

	/**
	 * object accessor for the {@code QuestionStatusCode}
	 *
	 * <p>The {@code QuestionStatusCode} field is a direct mapping of the {@code question_status_code} field in {@code question}.</p>
	 *
	 * @return an object value of {@code QuestionStatusCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@com.opal.annotation.Default(value = "DRAFTED")
	public java.lang.String getQuestionStatusCode();

	/**
	 * sets the {@code QuestionStatusCode} to the value of {@code argQuestionStatusCode}
	 *
	 * @param argQuestionStatusCode the new value of {@code QuestionStatusCode}.  May not be <code>null</code>.
	 * <p>The database column {@code question_status_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argQuestionStatusCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argQuestionStatusCode} is longer than 32 characters
	 * <p>The database column {@code question_status_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	@com.opal.annotation.Default(value = "DRAFTED")
	public void setQuestionStatusCode(java.lang.String argQuestionStatusCode);

	/**
	 * @return the {@code com.masonic.application.QuestionStatus}
	 * The returned {@code com.masonic.application.QuestionStatus} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code question_status} that is referenced by {@code question_question_status_code_fkey}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.QuestionStatus getStatus();
	public void setStatus(com.masonic.application.QuestionStatus argStatus);

	/**
	 * @return the {@code com.masonic.application.PacketSet}
	 * The returned {@code com.masonic.application.PacketSet} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code packet_set} that is referenced by {@code question_intended_packet_set_code_fkey}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = true)
	public com.masonic.application.PacketSet getIntendedPacketSet();
	public void setIntendedPacketSet(com.masonic.application.PacketSet argIntendedPacketSet);

	/**
	 * @return the {@code com.masonic.application.Account}
	 * The returned {@code com.masonic.application.Account} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code account} that is referenced by {@code question_writer_account_id_fkey}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Account getWriter();
	public void setWriter(com.masonic.application.Account argWriter);

	/**
	 * @return the {@code com.masonic.application.Category}
	 * The returned {@code com.masonic.application.Category} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code category} that is referenced by {@code question_to_category}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Category getCategory();
	public void setCategory(com.masonic.application.Category argCategory);

	/**
	 * @return the {@code com.masonic.application.QuestionType}
	 * The returned {@code com.masonic.application.QuestionType} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code question_type} that is referenced by {@code question_to_question_type}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.QuestionType getQuestionType();
	public void setQuestionType(com.masonic.application.QuestionType argQuestionType);

	@com.opal.annotation.Nullability(nullable = true)
	public com.masonic.application.Placement getPlacement();
	public void setPlacement(com.masonic.application.Placement argPlacement);

	public com.masonic.application.Question copy();

	/** This is a Comparator that can be used to compare Question objects based on their {@code Id} values. */

	public static class IdComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Question> {
		private static final IdComparator ourInstance = new IdComparator();
		public static final IdComparator getInstance() { return ourInstance; }

		private IdComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Question argFirst, com.masonic.application.Question argSecond) {
			return argFirst.getIdAsObject().compareTo(argSecond.getIdAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Question objects based on their {@code Updated} values. */

	public static class UpdatedComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Question> {
		private static final UpdatedComparator ourInstance = new UpdatedComparator();
		public static final UpdatedComparator getInstance() { return ourInstance; }

		private UpdatedComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Question argFirst, com.masonic.application.Question argSecond) {
			return argFirst.getUpdated().compareTo(argSecond.getUpdated());
		}
	}

}
