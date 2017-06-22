package com.masonic.persistence;


/**
 * represents a {@code Packet} from the persistent store
 *
 * <p>This interface was automatically generated to represent objects loaded from {@code packet}.  Do not modify this class directly; instead, alter the permanent storage on which it is based, the Opal configuration file for the project, and/or the {@link com.masonic.application.Packet}, and then regenerate the opals.  Any changes made to this file will be lost if the opals are regenerated.</p>
 *
 * <p>To create objects of this type from persistent data, use one of the various {@code forXXX} methods on the {@link com.masonic.application.PacketFactory} factory class.  To create new instances, use the {@code create()} method on the factory.</p>
 *
 * <p>Objects that implement this interface must provide Opal thread semantics; among other things this means that all modification of such objects must be done with an active {@link com.opal.TransactionContext}.</p>
 *
 * <p>This interface is not meant to be referenced in user code.  Only the {@link com.masonic.application.Packet} and the {@link com.masonic.application.PacketFactory} class should be referenced directly.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */
	@com.opal.annotation.Creatability(creatable = true)
	@com.opal.annotation.Updatability(updatable = true)
public interface PacketUserFacing extends com.opal.IdentityUserFacing, Comparable<com.masonic.application.Packet> {

	/* Accessors and mutators for internal data. */
	/**
	 * object accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} field in {@code packet}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getId() method.</p>
	 *
	 * @return an object value of {@code Id} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	public java.lang.Integer getIdAsObject();

	/**
	 * primitive accessor for the {@code Id}
	 *
	 * <p>The {@code Id} field is a direct mapping of the {@code id} database column in the table {@code packet}.</p>
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
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Packet setId(java.lang.Integer argId);

	/**
	 * sets the {@code Id} to the value of {@code argId}
	 *
	 * @param argId the new value of {@code Id}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Packet setId(int argId);

	/**
	 * object accessor for the {@code PacketSetCode}
	 *
	 * <p>The {@code PacketSetCode} field is a direct mapping of the {@code packet_set_code} field in {@code packet}.</p>
	 *
	 * @return an object value of {@code PacketSetCode} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public java.lang.String getPacketSetCode();

	/**
	 * sets the {@code PacketSetCode} to the value of {@code argPacketSetCode}
	 *
	 * @param argPacketSetCode the new value of {@code PacketSetCode}.  May not be <code>null</code>.
	 * @return itself, so that mutator calls can be chained fluently
	 * <p>The database column {@code packet_set_code} to which this field is mapped is {@code NOT NULL}.</p>
	 *
	 * @throws com.opal.IllegalNullArgumentException if argPacketSetCode is null
	 * @throws com.opal.ArgumentTooLongException if {@code argPacketSetCode} is longer than 32 characters
	 * <p>The database column {@code packet_set_code} is limited to 32 characters.</p>
	 *
	 */
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.Packet setPacketSetCode(java.lang.String argPacketSetCode);

	/**
	 * object accessor for the {@code Name}
	 *
	 * <p>The {@code Name} field is a direct mapping of the {@code name} field in {@code packet}.</p>
	 *
	 * @return an object value of {@code Name} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Updatability(updatable = true)
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
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 256L)
	public com.masonic.application.Packet setName(java.lang.String argName);

	/**
	 * object accessor for the {@code ShortName}
	 *
	 * <p>The {@code ShortName} field is a direct mapping of the {@code short_name} field in {@code packet}.</p>
	 *
	 * @return an object value of {@code ShortName} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Updatability(updatable = true)
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
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	@com.opal.annotation.Length(maximum = 32L)
	public com.masonic.application.Packet setShortName(java.lang.String argShortName);

	/**
	 * object accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} field in {@code packet}.</p>
	 *
	 * <p>This method returns the current value as an Object.  To retrieve the value as a primitive, use the getSequence() method.</p>
	 *
	 * @return an object value of {@code Sequence} (of the current {@link com.opal.TransactionContext})  Will not be <code>null</code>.
	 */
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	public java.lang.Integer getSequenceAsObject();

	/**
	 * primitive accessor for the {@code Sequence}
	 *
	 * <p>The {@code Sequence} field is a direct mapping of the {@code sequence} database column in the table {@code packet}.</p>
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
	@com.opal.annotation.Updatability(updatable = true)
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.Packet setSequence(java.lang.Integer argSequence);

	/**
	 * sets the {@code Sequence} to the value of {@code argSequence}
	 *
	 * @param argSequence the new value of {@code Sequence}
	 * @return itself, so that mutators may be chained fluently
	 */
	public com.masonic.application.Packet setSequence(int argSequence);

	/**
	 * @return the {@code com.masonic.application.PacketSet}
	 * The returned {@code com.masonic.application.PacketSet} is the {@link com.opal.UserFacing} object corresponding to the entry in {@code packet_set} that is referenced by {@code packet_to_packet_set}.
	 *
	 */
	@com.opal.annotation.Nullability(nullable = false)
	public com.masonic.application.PacketSet getPacketSet();
	public com.masonic.application.Packet setPacketSet(com.masonic.application.PacketSet argPacketSet);

	public int getSectionCount();
	public java.util.Iterator<com.masonic.application.Section> createSectionIterator();

	public java.util.stream.Stream<com.masonic.application.Section> streamSection();

	public com.masonic.application.Packet addSection(com.masonic.application.Section argSection);
	public com.masonic.application.Packet removeSection(com.masonic.application.Section argSection);
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

	public com.masonic.application.Packet copy();

	/** This is a Comparator that can be used to compare Packet objects based on their {@code Id} values. */

	public static class IdComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Packet> {
		private static final IdComparator ourInstance = new IdComparator();
		public static final IdComparator getInstance() { return ourInstance; }

		private IdComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Packet argFirst, com.masonic.application.Packet argSecond) {
			return argFirst.getIdAsObject().compareTo(argSecond.getIdAsObject());
		}
	}

	/** This is a Comparator that can be used to compare Packet objects based on their {@code Name} values. */

	public static class NameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Packet> {
		private static final NameComparator ourInstance = new NameComparator();
		public static final NameComparator getInstance() { return ourInstance; }

		private NameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Packet argFirst, com.masonic.application.Packet argSecond) {
			return argFirst.getName().compareToIgnoreCase(argSecond.getName());
		}
	}

	/** This is a Comparator that can be used to compare Packet objects based on their {@code ShortName} values. */

	public static class ShortNameComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Packet> {
		private static final ShortNameComparator ourInstance = new ShortNameComparator();
		public static final ShortNameComparator getInstance() { return ourInstance; }

		private ShortNameComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Packet argFirst, com.masonic.application.Packet argSecond) {
			return argFirst.getShortName().compareToIgnoreCase(argSecond.getShortName());
		}
	}

	/** This is a Comparator that can be used to compare Packet objects based on their {@code Sequence} values. */

	public static class SequenceComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Packet> {
		private static final SequenceComparator ourInstance = new SequenceComparator();
		public static final SequenceComparator getInstance() { return ourInstance; }

		private SequenceComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Packet argFirst, com.masonic.application.Packet argSecond) {
			return argFirst.getSequenceAsObject().compareTo(argSecond.getSequenceAsObject());
		}
	}

	public static class StandardComparator extends com.siliconage.util.NullSafeComparator<com.masonic.application.Packet> {
		private static final StandardComparator ourInstance = new StandardComparator();
		public static final StandardComparator getInstance() { return ourInstance; }

		private StandardComparator() { super(); }

		@Override
		public int compareInternal(com.masonic.application.Packet argFirst, com.masonic.application.Packet argSecond) {
			int lclResult = com.masonic.application.PacketSet.StandardComparator.getInstance().compare(argFirst.getPacketSet(),  argSecond.getPacketSet());
			if (lclResult != 0) {
				return lclResult;
			}
			return argFirst.getSequence() - argSecond.getSequence();
		}
	}

}
