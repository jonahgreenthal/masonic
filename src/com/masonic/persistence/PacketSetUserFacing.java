package com.masonic.persistence;


/**
 * represents a {@code PacketSet} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code packet_set}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.PacketSet}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.PacketSetFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.PacketSet} and the {@link com.masonic.application.PacketSetFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface PacketSetUserFacing extends com.opal.IdentityUserFacing {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Code}
	 *
	 * <p>The {@code Code} field is a direct mapping of the {@code code} field in {@code packet_set}.</p>
	 *
	 * @return an object value of {@code Code} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
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
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.PacketSet setCode(java.lang.String argCode);

	/**
	 * object accessor for the {@code Name}
	 *
	 * <p>The {@code Name} field is a direct mapping of the {@code name} field in {@code packet_set}.</p>
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
	public com.masonic.application.PacketSet setName(java.lang.String argName);

	/**
	 * object accessor for the {@code ShortName}
	 *
	 * <p>The {@code ShortName} field is a direct mapping of the {@code short_name} field in {@code packet_set}.</p>
	 *
	 * @return an object value of {@code ShortName} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
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
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.PacketSet setShortName(java.lang.String argShortName);

	/**
	 * object accessor for the {@code Deadline}
	 *
	 * <p>The {@code Deadline} field is a direct mapping of the {@code deadline} field in {@code packet_set}.</p>
	 *
	 * @return an object value of {@code Deadline} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = true)
	public java.time.LocalDate getDeadline();

	/**
	 * object accessor for the {@code Deadline} with substitution for a null value
	 *
	 * <p>The {@code Deadline} field is a direct mapping of the {@code deadline} database column in the table {@code packet_set}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code Deadline} is {@code null}.
	 * @return an object value of {@code Deadline} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getDeadline(java.lang.String argStringToSubstituteIfNull) {
		java.time.LocalDate lclO = getDeadline();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code Deadline} to the value of {@code argDeadline}
	 *
	 * @param argDeadline the new value of {@code Deadline}.  May be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 */
	@com.opal.annotation.Nullability(nullable = true)
	public com.masonic.application.PacketSet setDeadline(java.time.LocalDate argDeadline);

	/**
	 * object accessor for the {@code Note}
	 *
	 * <p>The {@code Note} field is a direct mapping of the {@code note} field in {@code packet_set}.</p>
	 *
	 * @return an object value of {@code Note} (of the current {@link com.opal.TransactionContext})  May be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public java.lang.String getNote();

	/**
	 * object accessor for the {@code Note} with substitution for a null value
	 *
	 * <p>The {@code Note} field is a direct mapping of the {@code note} database column in the table {@code packet_set}.</p>
	 *
	 * <p>This method returns the current value if it is not {@code null}, or {@code argStringToSubstituteIfNull} if the current value is {@code null}.</p>
	 *
	 * @param argStringToSubstituteIfNull the value to return if the {@code Note} is {@code null}.
	 * @return an object value of {@code Note} (of the current {@link com.opal.TransactionContext}) if it is not {@code null}, or {@code argStringToSubstituteIfNull} if it is {@code null}.
	 */
	default public java.lang.String getNote(java.lang.String argStringToSubstituteIfNull) {
		java.lang.String lclO = getNote();
		return lclO != null ? String.valueOf(lclO) : argStringToSubstituteIfNull;
	}


	/**
	 * sets the {@code Note} to the value of {@code argNote}
	 *
	 * @param argNote the new value of {@code Note}.  May be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * @throws com.opal.ArgumentTooLongException if {@code argNote} is longer than 2147483647 characters
	 * <p>The database column {@code note} is limited to 2147483647 characters.</p>
	 *
	 */
	@com.opal.annotation.Nullability(nullable = true)
	@com.opal.annotation.Length(maximum = 2147483647L)
	public com.masonic.application.PacketSet setNote(java.lang.String argNote);

	/**
	 * object accessor for the {@code Completed}
	 *
	 * <p>The {@code Completed} field is a direct mapping of the {@code completed} field in {@code packet_set}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the isCompleted() method.</p>
	 *
	 * @return an object value of {@code Completed} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	public java.lang.Boolean isCompletedAsObject();

	default public java.lang.Boolean isNotCompletedAsObject() {
		Boolean lclB = isCompletedAsObject();
		return lclB.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * primitive accessor for the {@code Completed}
	 *
	 * <p>The {@code Completed} field is a direct mapping of the {@code completed} database column in the table {@code packet_set}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the isCompletedAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Completed} (of the current {@link com.opal.TransactionContext})
	 */
	default public boolean isCompleted() {
		java.lang.Boolean lclO = isCompletedAsObject();
		return lclO.booleanValue();
	}

	default public java.lang.Boolean isNotCompleted() {
		return !isCompleted();
	}

	/**
	 * sets the {@code Completed} to the value of {@code argCompleted}
	 *
	 * @param argCompleted the new value of {@code Completed}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code completed} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argCompleted is null
	 */
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Default(value = "false")
	public com.masonic.application.PacketSet setCompleted(java.lang.Boolean argCompleted);

	/**
	 * sets the {@code Completed} to the value of {@code argCompleted}
	 *
	 * @param argCompleted the new value of {@code Completed}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.PacketSet setCompleted(boolean argCompleted);

	public int getIntendedQuestionCount();
	public java.util.Iterator<com.masonic.application.Question> createIntendedQuestionIterator();

	public java.util.stream.Stream<com.masonic.application.Question> streamIntendedQuestion();

	public com.masonic.application.PacketSet addIntendedQuestion(com.masonic.application.Question argQuestion);
	public com.masonic.application.PacketSet removeIntendedQuestion(com.masonic.application.Question argQuestion);
	default public <T extends java.util.Collection<? super com.masonic.application.Question>> T acquireIntendedQuestion(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Question> lclI = createIntendedQuestionIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Question[] createIntendedQuestionArray() {
		int lclLength = getIntendedQuestionCount();
		com.masonic.application.Question[] lclA = new com.masonic.application.Question[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Question> lclI = createIntendedQuestionIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public int getPacketCount();
	public java.util.Iterator<com.masonic.application.Packet> createPacketIterator();

	public java.util.stream.Stream<com.masonic.application.Packet> streamPacket();

	public com.masonic.application.PacketSet addPacket(com.masonic.application.Packet argPacket);
	public com.masonic.application.PacketSet removePacket(com.masonic.application.Packet argPacket);
	default public <T extends java.util.Collection<? super com.masonic.application.Packet>> T acquirePacket(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Packet> lclI = createPacketIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Packet[] createPacketArray() {
		int lclLength = getPacketCount();
		com.masonic.application.Packet[] lclA = new com.masonic.application.Packet[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Packet> lclI = createPacketIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public com.masonic.application.PacketSet copy();

	/** This is a Comparator that can be used to compare PacketSet objects based on their {@code Code} values. */

	public static class CodeComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.PacketSet> {
		private static final CodeComparator ourInstance = new CodeComparator();
		public static final CodeComparator getInstance() { return ourInstance; }

		private CodeComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.PacketSet argFirst, com.masonic.application.PacketSet argSecond) {
			return argFirst.getCode().compareToIgnoreCase(argSecond.getCode());
		}
	}

	/** This is a Comparator that can be used to compare PacketSet objects based on their {@code Name} values. */

	public static class NameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.PacketSet> {
		private static final NameComparator ourInstance = new NameComparator();
		public static final NameComparator getInstance() { return ourInstance; }

		private NameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.PacketSet argFirst, com.masonic.application.PacketSet argSecond) {
			return argFirst.getName().compareToIgnoreCase(argSecond.getName());
		}
	}

	/** This is a Comparator that can be used to compare PacketSet objects based on their {@code ShortName} values. */

	public static class ShortNameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.PacketSet> {
		private static final ShortNameComparator ourInstance = new ShortNameComparator();
		public static final ShortNameComparator getInstance() { return ourInstance; }

		private ShortNameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.PacketSet argFirst, com.masonic.application.PacketSet argSecond) {
			return argFirst.getShortName().compareToIgnoreCase(argSecond.getShortName());
		}
	}

	public static class StandardComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.PacketSet> {
		private static final StandardComparator ourInstance = new StandardComparator();
		public static final StandardComparator getInstance() { return ourInstance; }

		private StandardComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.PacketSet argFirst, com.masonic.application.PacketSet argSecond) {
			int lclResult = argFirst.isCompletedAsObject().compareTo(argSecond.isCompletedAsObject());
			if (lclResult != 0) {
				return lclResult;
			}
			return nullSafeCompare(argFirst.getDeadline(), argSecond.getDeadline());
		}
	}

}
