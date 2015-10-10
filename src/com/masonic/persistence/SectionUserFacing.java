package com.masonic.persistence;


/**
 * represents a {@code Section} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code section}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Section}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.SectionFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Section} and the {@link com.masonic.application.SectionFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
public interface SectionUserFacing extends com.opal.IdentityUserFacing {
	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} field in {@code section}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getId() method.</p>
	 *
	 * @return an object value of {@code Id} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getIdAsObject();

	/**
	 * primitive accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} database column in the table {@code section}.</p>
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
	public com.masonic.application.Section setId(java.lang.Integer argId);

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Section setId(int argId);

	/**
	 * object accessor for the {@code PacketId}
	 *
	 * <p>The {@code PacketId} field is a direct mapping of the {@code packet_id} field in {@code section}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getPacketId() method.</p>
	 *
	 * @return an object value of {@code PacketId} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getPacketIdAsObject();

	/**
	 * primitive accessor for the {@code PacketId}
	 *
	 * <p>The {@code PacketId} field is a direct mapping of the {@code packet_id} database column in the table {@code section}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the getPacketIdAsObject() method.</p>
	 *
	 * @return the primitive value of {@code PacketId} (of the current {@link com.opal.TransactionContext})
	 */
	default public int getPacketId() {
		java.lang.Integer lclO = getPacketIdAsObject();
		return lclO.intValue();
	}

	/**
	 * sets the {@code PacketId} to the value of {@code argPacketId}
	 *
	 * @param argPacketId the new value of {@code PacketId}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code packet_id} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPacketId is null
	 */
	@com.opal.annotation.NotNull
	public com.masonic.application.Section setPacketId(java.lang.Integer argPacketId);

	/**
	 * sets the {@code PacketId} to the value of {@code argPacketId}
	 *
	 * @param argPacketId the new value of {@code PacketId}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Section setPacketId(int argPacketId);

	/**
	 * object accessor for the {@code QuestionTypeCode}
	 *
	 * <p>The {@code QuestionTypeCode} field is a direct mapping of the {@code question_type_code} field in {@code section}.</p>
	 *
	 * @return an object value of {@code QuestionTypeCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.String getQuestionTypeCode();

	/**
	 * sets the {@code QuestionTypeCode} to the value of {@code argQuestionTypeCode}
	 *
	 * @param argQuestionTypeCode the new value of {@code QuestionTypeCode}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code question_type_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argQuestionTypeCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argQuestionTypeCode} is longer than 32 characters
	 * <p>The database column {@code question_type_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.NotNull
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.Section setQuestionTypeCode(java.lang.String argQuestionTypeCode);

	/**
	 * object accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} field in {@code section}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getSequence() method.</p>
	 *
	 * @return an object value of {@code Sequence} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Integer getSequenceAsObject();

	/**
	 * primitive accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} database column in the table {@code section}.</p>
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
	public com.masonic.application.Section setSequence(java.lang.Integer argSequence);

	/**
	 * sets the {@code Sequence} to the value of {@code argSequence}
	 *
	 * @param argSequence the new value of {@code Sequence}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Section setSequence(int argSequence);

	/**
	 * object accessor for the {@code Name}
	 *
	 * <p>The {@code Name} field is a direct mapping of the {@code name} field in {@code section}.</p>
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
	public com.masonic.application.Section setName(java.lang.String argName);

	/**
	 * object accessor for the {@code ShortName}
	 *
	 * <p>The {@code ShortName} field is a direct mapping of the {@code short_name} field in {@code section}.</p>
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
	public com.masonic.application.Section setShortName(java.lang.String argShortName);

	/**
	 * object accessor for the {@code Extras}
	 *
	 * <p>The {@code Extras} field is a direct mapping of the {@code extras} field in {@code section}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the isExtras() method.</p>
	 *
	 * @return an object value of {@code Extras} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	public java.lang.Boolean isExtrasAsObject();

	/**
	 * primitive accessor for the {@code Extras}
	 *
	 * <p>The {@code Extras} field is a direct mapping of the {@code extras} database column in the table {@code section}.</p>
	 *
	 * <p>This method returns the value as a primitive (for example, as an {@code int} rather than an {@code Integer}; to retrieve the value as an object, use the isExtrasAsObject() method.</p>
	 *
	 * @return the primitive value of {@code Extras} (of the current {@link com.opal.TransactionContext})
	 */
	default public boolean isExtras() {
		java.lang.Boolean lclO = isExtrasAsObject();
		return lclO.booleanValue();
	}

	/**
	 * sets the {@code Extras} to the value of {@code argExtras}
	 *
	 * @param argExtras the new value of {@code Extras}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code extras} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argExtras is null
	 */
	@com.opal.annotation.NotNull
	public com.masonic.application.Section setExtras(java.lang.Boolean argExtras);

	/**
	 * sets the {@code Extras} to the value of {@code argExtras}
	 *
	 * @param argExtras the new value of {@code Extras}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Section setExtras(boolean argExtras);

	/**
	 * @return the {@code com.masonic.application.QuestionType}
	 * The returned {@code com.masonic.application.QuestionType} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code question_type} that is referenced by {@code section_to_question_type}.
	 *
	 */
	public com.masonic.application.QuestionType getQuestionType();
	public com.masonic.application.Section setQuestionType(com.masonic.application.QuestionType argQuestionType);

	/**
	 * @return the {@code com.masonic.application.Packet}
	 * The returned {@code com.masonic.application.Packet} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code packet} that is referenced by {@code section_to_packet}.
	 *
	 */
	public com.masonic.application.Packet getPacket();
	public com.masonic.application.Section setPacket(com.masonic.application.Packet argPacket);

	public int getPlacementCount();
	public java.util.Iterator<com.masonic.application.Placement> createPlacementIterator();

	public java.util.stream.Stream<com.masonic.application.Placement> streamPlacement();

	public com.masonic.application.Section addPlacement(com.masonic.application.Placement argPlacement);
	public com.masonic.application.Section removePlacement(com.masonic.application.Placement argPlacement);
	public com.masonic.application.Section clearPlacement();

	default public <T extends java.util.Collection<? super com.masonic.application.Placement>> T acquirePlacement(T argC) {
		org.apache.commons.lang3.Validate.notNull(argC, "Target Collection is null");
		java.util.Iterator<com.masonic.application.Placement> lclI = createPlacementIterator();
		while (lclI.hasNext()) {
			argC.add(lclI.next());
		}
		return argC;
	}

	default public com.masonic.application.Placement[] createPlacementArray() {
		int lclLength = getPlacementCount();
		com.masonic.application.Placement[] lclA = new com.masonic.application.Placement[lclLength];
		int lclIndex = 0;
		java.util.Iterator<com.masonic.application.Placement> lclI = createPlacementIterator();
		while (lclI.hasNext()) {
			lclA[lclIndex++] = lclI.next();
		}
		return lclA;
	}

	public com.masonic.application.Section copy();

	/** This is a Comparator that can be used to compare Section objects based on their {@code Id} values. */

	public static class IdComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Section> {
		private static final IdComparator ourInstance = new IdComparator();
		public static final IdComparator getInstance() { return ourInstance; }

		private IdComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Section argFirst, com.masonic.application.Section argSecond) {
			return argFirst.getIdAsObject().compareTo(argSecond.getIdAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Section objects based on their {@code Sequence} values. */

	public static class SequenceComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Section> {
		private static final SequenceComparator ourInstance = new SequenceComparator();
		public static final SequenceComparator getInstance() { return ourInstance; }

		private SequenceComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Section argFirst, com.masonic.application.Section argSecond) {
			return argFirst.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Section objects based on their {@code Name} values. */

	public static class NameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Section> {
		private static final NameComparator ourInstance = new NameComparator();
		public static final NameComparator getInstance() { return ourInstance; }

		private NameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Section argFirst, com.masonic.application.Section argSecond) {
			return argFirst.getName().compareToIgnoreCase(argSecond.getName());
		}
	}

	/** This is a Comparator that can be used to compare Section objects based on their {@code ShortName} values. */

	public static class ShortNameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Section> {
		private static final ShortNameComparator ourInstance = new ShortNameComparator();
		public static final ShortNameComparator getInstance() { return ourInstance; }

		private ShortNameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Section argFirst, com.masonic.application.Section argSecond) {
			return argFirst.getShortName().compareToIgnoreCase(argSecond.getShortName());
		}
	}

	public static class StandardComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Section> {
		private static final StandardComparator ourInstance = new StandardComparator();
		public static final StandardComparator getInstance() { return ourInstance; }

		private StandardComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Section argFirst, com.masonic.application.Section argSecond) {
			int lclResult = com.masonic.application.Packet.SequenceComparator.getInstance().compare(argFirst.getPacket(),  argSecond.getPacket());
			if (lclResult != 0) {
				return lclResult;
			}
			return argFirst.getSequence() - argSecond.getSequence();
		}
	}

}
