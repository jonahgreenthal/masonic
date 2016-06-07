package com.masonic.persistence;


/**
 * represents a {@code Account} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code account}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Account}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.AccountFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Account} and the {@link com.masonic.application.AccountFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface AccountUserFacing extends com.opal.IdentityUserFacing {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} field in {@code account}.</p>
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
	 * <p>The {@code Id} field is a direct mapping of the {@code id} database column in the table {@code account}.</p>
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
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Account setId(java.lang.Integer argId);

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Account setId(int argId);

	/**
	 * object accessor for the {@code Name}
	 *
	 * <p>The {@code Name} field is a direct mapping of the {@code name} field in {@code account}.</p>
	 *
	 * @return an object value of {@code Name} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
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
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.Account setName(java.lang.String argName);

	/**
	 * object accessor for the {@code EmailAddress}
	 *
	 * <p>The {@code EmailAddress} field is a direct mapping of the {@code email_address} field in {@code account}.</p>
	 *
	 * @return an object value of {@code EmailAddress} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public java.lang.String getEmailAddress();

	/**
	 * sets the {@code EmailAddress} to the value of {@code argEmailAddress}
	 *
	 * @param argEmailAddress the new value of {@code EmailAddress}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code email_address} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argEmailAddress is null
	 * @throws com.opal.ArgumentTooLongException if {@code argEmailAddress} is longer than 256 characters
	 * <p>The database column {@code email_address} is limited to 256 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.Account setEmailAddress(java.lang.String argEmailAddress);

	/**
	 * object accessor for the {@code Username}
	 *
	 * <p>The {@code Username} field is a direct mapping of the {@code username} field in {@code account}.</p>
	 *
	 * @return an object value of {@code Username} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 64L)
	public java.lang.String getUsername();

	/**
	 * sets the {@code Username} to the value of {@code argUsername}
	 *
	 * @param argUsername the new value of {@code Username}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code username} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argUsername is null
	 * @throws com.opal.ArgumentTooLongException if {@code argUsername} is longer than 64 characters
	 * <p>The database column {@code username} is limited to 64 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 64L)
	public com.masonic.application.Account setUsername(java.lang.String argUsername);

	/**
	 * object accessor for the {@code PasswordHash}
	 *
	 * <p>The {@code PasswordHash} field is a direct mapping of the {@code password_hash} field in {@code account}.</p>
	 *
	 * @return an object value of {@code PasswordHash} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 60L)
	@com.opal.annotation.Default(value = "$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	public java.lang.String getPasswordHash();

	/**
	 * sets the {@code PasswordHash} to the value of {@code argPasswordHash}
	 *
	 * @param argPasswordHash the new value of {@code PasswordHash}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code password_hash} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPasswordHash is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPasswordHash} is longer than 60 characters
	 * <p>The database column {@code password_hash} is limited to 60 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 60L)
	@com.opal.annotation.Default(value = "$2a$16$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	public com.masonic.application.Account setPasswordHash(java.lang.String argPasswordHash);

	/**
	 * object accessor for the {@code Administrator}
	 *
	 * <p>The {@code Administrator} field is a direct mapping of the {@code administrator} field in {@code account}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the isAdministrator() method.</p>
	 *
	 * @return an object value of {@code Administrator} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	public java.lang.Boolean isAdministratorAsObject();

	/**
	 * primitive accessor for the {@code Administrator}
	 *
	 * <p>The {@code Administrator} field is a direct mapping of the {@code administrator} database column in the table {@code account}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the isAdministratorAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Administrator} (of the current {@link com.opal.TransactionContext})
	 */
	default public boolean isAdministrator() {
		java.lang.Boolean lclO = isAdministratorAsObject();
		return lclO.booleanValue();
	}

	/**
	 * sets the {@code Administrator} to the value of {@code argAdministrator}
	 *
	 * @param argAdministrator the new value of {@code Administrator}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code administrator} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argAdministrator is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	public com.masonic.application.Account setAdministrator(java.lang.Boolean argAdministrator);

	/**
	 * sets the {@code Administrator} to the value of {@code argAdministrator}
	 *
	 * @param argAdministrator the new value of {@code Administrator}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Account setAdministrator(boolean argAdministrator);

	/**
	 * object accessor for the {@code Active}
	 *
	 * <p>The {@code Active} field is a direct mapping of the {@code active} field in {@code account}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the isActive() method.</p>
	 *
	 * @return an object value of {@code Active} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "true")
	public java.lang.Boolean isActiveAsObject();

	/**
	 * primitive accessor for the {@code Active}
	 *
	 * <p>The {@code Active} field is a direct mapping of the {@code active} database column in the table {@code account}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the isActiveAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Active} (of the current {@link com.opal.TransactionContext})
	 */
	default public boolean isActive() {
		java.lang.Boolean lclO = isActiveAsObject();
		return lclO.booleanValue();
	}

	/**
	 * sets the {@code Active} to the value of {@code argActive}
	 *
	 * @param argActive the new value of {@code Active}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code active} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argActive is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "true")
	public com.masonic.application.Account setActive(java.lang.Boolean argActive);

	/**
	 * sets the {@code Active} to the value of {@code argActive}
	 *
	 * @param argActive the new value of {@code Active}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Account setActive(boolean argActive);

	public int getWriterQuestionCount();
	public java.util.Iterator<com.masonic.application.Question> createWriterQuestionIterator();

	public java.util.stream.Stream<com.masonic.application.Question> streamWriterQuestion();

	public com.masonic.application.Account addWriterQuestion(com.masonic.application.Question argQuestion);
	public com.masonic.application.Account removeWriterQuestion(com.masonic.application.Question argQuestion);
	default public <T extends java.util.Collection<? super com.masonic.application.Question>> T acquireWriterQuestion(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Question> lclI = createWriterQuestionIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Question[] createWriterQuestionArray() {
		int lclLength = getWriterQuestionCount();
		com.masonic.application.Question[] lclA = new com.masonic.application.Question[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Question> lclI = createWriterQuestionIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public com.masonic.application.Account copy();

	/** This is a Comparator that can be used to compare Account objects based on their {@code Id} values. */

	public static class IdComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Account> {
		private static final IdComparator ourInstance = new IdComparator();
		public static final IdComparator getInstance() { return ourInstance; }

		private IdComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Account argFirst, com.masonic.application.Account argSecond) {
			return argFirst.getIdAsObject().compareTo(argSecond.getIdAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Account objects based on their {@code Name} values. */

	public static class NameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Account> {
		private static final NameComparator ourInstance = new NameComparator();
		public static final NameComparator getInstance() { return ourInstance; }

		private NameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Account argFirst, com.masonic.application.Account argSecond) {
			return argFirst.getName().compareToIgnoreCase(argSecond.getName());
		}
	}

}
