package com.masonic.persistence;

import java.io.PrintWriter;
import java.io.PrintStream;

import com.opal.*;

import com.masonic.application.*;

@StoreGeneratedPrimaryKey
public final class PacketOpal extends com.opal.UpdatableOpal<Packet> {

	private PacketOpal() {
		super();
		setUserFacing(null);
	}

	public PacketOpal(OpalFactory<Packet, PacketOpal> argOpalFactory, Object[] argValues) {
		super(argOpalFactory, argValues);
	}

	@Override
	protected void initializeReferences() {
		myOldPacketSetOpal = PacketSetOpal.NOT_YET_LOADED;
		return;
	}

	/* package */ static final String[] ourFieldNames = new String[] {
		"Id",
		"PacketSetCode",
		"Name",
		"ShortName",
		"Sequence",
	};

	/* package */ static final Class<?>[] ourFieldTypes = new Class<?>[] {
		java.lang.Integer.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.String.class,
		java.lang.Integer.class,
	};

	/* package */ static final boolean[] ourFieldNullability = new boolean[] {
		false,
		false,
		false,
		false,
		false,
	};

	/* package */ static final FieldValidator[] ourFieldValidators = new FieldValidator[] {
		null,
		null,
		null,
		null,
		null,
	};

	public static final PacketOpal NOT_YET_LOADED = new PacketOpal();

	public static String[] getStaticFieldNames() { return ourFieldNames; }

	public static Class<?>[] getStaticFieldTypes() { return ourFieldTypes; }

	@Override
	public Class<?>[] getFieldTypes() { return ourFieldTypes; }

	public static boolean[] getStaticFieldNullability() { return ourFieldNullability; }

	@Override
	public FieldValidator[] getFieldValidators() { return ourFieldValidators; }

	@Override
	public boolean[] getFieldNullability() { return ourFieldNullability; }

	public static FieldValidator[] getStaticFieldValidators() { return ourFieldValidators; }


	public synchronized java.lang.Integer getIdAsObject() {
		return (java.lang.Integer) getReadValueSet()[0];
	}

	public synchronized java.lang.String getPacketSetCode() {
		return (java.lang.String) getReadValueSet()[1];
	}

	public synchronized java.lang.String getName() {
		return (java.lang.String) getReadValueSet()[2];
	}

	public synchronized java.lang.String getShortName() {
		return (java.lang.String) getReadValueSet()[3];
	}

	public synchronized java.lang.Integer getSequenceAsObject() {
		return (java.lang.Integer) getReadValueSet()[4];
	}

	public synchronized PacketOpal setId(final java.lang.Integer argId) {
		tryMutate();
		if (argId == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myId on " + this + " to null.");
		}
		getNewValues()[0] = argId;
		return this;
	}

	public PacketOpal setId(final int argId) {
		setId(java.lang.Integer.valueOf(argId));
		return this;
	}

	public synchronized PacketOpal setPacketSetCode(final java.lang.String argPacketSetCode) {
		tryMutate();
		if (argPacketSetCode == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myPacketSetCode on " + this + " to null.");
		}
		if (argPacketSetCode.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myPacketSetCode on " + this + " is 32.", argPacketSetCode.length(), 32);
		}
		getNewValues()[1] = argPacketSetCode;
		return this;
	}

	public synchronized PacketOpal setName(final java.lang.String argName) {
		tryMutate();
		if (argName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myName on " + this + " to null.");
		}
		if (argName.length() > 256) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myName on " + this + " is 256.", argName.length(), 256);
		}
		getNewValues()[2] = argName;
		return this;
	}

	public synchronized PacketOpal setShortName(final java.lang.String argShortName) {
		tryMutate();
		if (argShortName == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set myShortName on " + this + " to null.");
		}
		if (argShortName.length() > 32) {
			throw new com.opal.ArgumentTooLongException("Maximum length of myShortName on " + this + " is 32.", argShortName.length(), 32);
		}
		getNewValues()[3] = argShortName;
		return this;
	}

	public synchronized PacketOpal setSequence(final java.lang.Integer argSequence) {
		tryMutate();
		if (argSequence == null) {
			throw new com.opal.IllegalNullArgumentException("Cannot set mySequence on " + this + " to null.");
		}
		getNewValues()[4] = argSequence;
		return this;
	}

	public PacketOpal setSequence(final int argSequence) {
		setSequence(java.lang.Integer.valueOf(argSequence));
		return this;
	}

	private boolean myClearOldCollections = false;

	protected boolean needsToClearOldCollections() {
		return myClearOldCollections;
	}

	protected final void setClearOldCollections(boolean argValue) {
		myClearOldCollections = argValue;
	}

	@Override
	protected /* synchronized */ void copyOldValuesToNewInternal() {
		myNewPacketSetOpal = myOldPacketSetOpal;
		myNewSectionOpalHashSet = null; /* Necessary if it has been rolled back */
		mySectionOpalCachedOperations = null; /* Ditto */
		/* We don't copy Collections of other Opals; they will be cloned as needed. */
		return;
	}

	@Override
	protected /* synchronized */ void copyNewValuesToOldInternal() {
		myOldPacketSetOpal = myNewPacketSetOpal;

		if (needsToClearOldCollections()) {
			myOldSectionOpalHashSet = null;
			} else {
			if (myNewSectionOpalHashSet != null) {
				myOldSectionOpalHashSet = myNewSectionOpalHashSet;
				myNewSectionOpalHashSet = null;
			} else {
				mySectionOpalCachedOperations = null;
			}
		}
		setClearOldCollections(false);
		return;
	}

	@Override
	protected void unlinkInternal() {
		java.util.Iterator<?> lclI;
		if (myNewSectionOpalHashSet != null || mySectionOpalCachedOperations != null) {
			lclI = createSectionOpalIterator();
			while (lclI.hasNext()) {
				((SectionOpal) lclI.next()).setPacketOpalInternal(null);
			}
		}
		if (getPacketSetOpal() != null) {
			getPacketSetOpal().removePacketOpalInternal(this);
		}
		return;
	}

	@Override
	protected void copyFieldsToInternal(UpdatableOpal<Packet> argTarget) {
		/* Field 0 (Id) is database generated. */
		/* Field 1 (PacketSetCode) is part of a unique key. */
		/* Field 2 (Name) is part of a unique key. */
		/* Field 3 (ShortName) is part of a unique key. */
		/* Field 4 (Sequence) is part of a unique key. */

		return;
	}

	@Override
	public synchronized void translateReferencesToFields() {
		if (myNewPacketSetOpal != PacketSetOpal.NOT_YET_LOADED) {
			setPacketSetCode(myNewPacketSetOpal == null ? null : myNewPacketSetOpal.getCode());
		}
		return;
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredPriorCommits() {
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		UpdatableOpal<?> lclUO;
		lclUO = myNewPacketSetOpal;
		if ((lclUO != null) && lclUO.isNew()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
			lclTAs.add(lclUO);
		}
		return (lclTAs != null) && (lclTAs.size() > 0) ? lclTAs : java.util.Collections.emptySet();
	}

	@Override
	public java.util.Set<com.opal.TransactionAware> getRequiredSubsequentCommits() {
		java.util.Set<com.opal.TransactionAware> lclTAs = null;
		UpdatableOpal<?> lclUO;
		lclUO = myOldPacketSetOpal;
		if ((lclUO != null) && lclUO.isDeleted()) {
			lclTAs = new com.siliconage.util.Fast3Set<>();
			lclTAs.add(lclUO);
		}
		return (lclTAs != null) && (lclTAs.size() > 0) ? lclTAs : java.util.Collections.emptySet();
	}

	@Override
	public Object[] getPrimaryKeyWhereClauseValues() {
		return new Object[] {getOldValues()[0], };
	}

	private static int getFieldCountInternal() { return ourFieldNames.length; }

	@Override
	protected int getFieldCount() { return getFieldCountInternal(); }

	@Override
	protected String[] getFieldNames() { return ourFieldNames; }

	@Override
	public synchronized void output(final PrintWriter argPW) {
		argPW.println("Id = " + getIdAsObject());
		argPW.println("PacketSetCode = " + getPacketSetCode());
		argPW.println("Name = " + getName());
		argPW.println("ShortName = " + getShortName());
		argPW.println("Sequence = " + getSequenceAsObject());
	}

	@Override
	public synchronized void output(final PrintStream argPS) {
		argPS.println("Id = " + getIdAsObject());
		argPS.println("PacketSetCode = " + getPacketSetCode());
		argPS.println("Name = " + getName());
		argPS.println("ShortName = " + getShortName());
		argPS.println("Sequence = " + getSequenceAsObject());
	}

	private PacketSetOpal myOldPacketSetOpal;
	private PacketSetOpal myNewPacketSetOpal;

	protected PacketSetOpal retrievePacketSetOpal(Object[] argValueSet) {
		assert argValueSet != null;
		if ((argValueSet[1] == null)) {
			return null;
		}
		return OpalFactoryFactory.getInstance().getPacketSetOpalFactory().forCode(getPacketSetCode());
	}

	public synchronized PacketSetOpal getPacketSetOpal() {
		PacketSetOpal lclPacketSetOpal;
		boolean lclAccess = tryAccess();
		lclPacketSetOpal = lclAccess ? myNewPacketSetOpal : myOldPacketSetOpal;
		if (lclPacketSetOpal == PacketSetOpal.NOT_YET_LOADED) {
			lclPacketSetOpal = retrievePacketSetOpal(getReadValueSet());
			if (lclAccess) {
				myNewPacketSetOpal = lclPacketSetOpal;
			} else {
				myOldPacketSetOpal = lclPacketSetOpal;
			}
		}
		return lclPacketSetOpal;
	}

	public synchronized PacketOpal setPacketSetOpal(PacketSetOpal argPacketSetOpal) {
		tryMutate();
		PacketSetOpal lclPacketSetOpal = getPacketSetOpal();
		if (lclPacketSetOpal == argPacketSetOpal) { return this; }
		if (lclPacketSetOpal != null) {
			lclPacketSetOpal.removePacketOpalInternal(this);
		}
		myNewPacketSetOpal = argPacketSetOpal;
		if (argPacketSetOpal != null) {
			argPacketSetOpal.addPacketOpalInternal(this);
		}
		return this;
	}

	protected synchronized void setPacketSetOpalInternal(PacketSetOpal argPacketSetOpal) {
		tryMutate();
		myNewPacketSetOpal = argPacketSetOpal;
	}

	private java.util.HashSet<SectionOpal> myOldSectionOpalHashSet = null;
	private java.util.HashSet<SectionOpal> myNewSectionOpalHashSet = null;
	private java.util.ArrayList<com.opal.CachedOperation<SectionOpal>> mySectionOpalCachedOperations = null;

	/* package */ java.util.HashSet<SectionOpal> getSectionOpalHashSet() {
		if (tryAccess()) {
			if (myNewSectionOpalHashSet == null) {
				if (myOldSectionOpalHashSet == null) {
					if (isNew()) {
						myOldSectionOpalHashSet = new java.util.HashSet<>();
					} else {
						myOldSectionOpalHashSet = OpalFactoryFactory.getInstance().getSectionOpalFactory().forPacketIdCollection(getIdAsObject());
					}
				}
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				if (mySectionOpalCachedOperations != null) {
					OpalUtility.handleCachedOperations(mySectionOpalCachedOperations, myNewSectionOpalHashSet);
					mySectionOpalCachedOperations = null;
				}
			}
			return myNewSectionOpalHashSet;
		} else {
			if (myOldSectionOpalHashSet == null) {
				myOldSectionOpalHashSet = OpalFactoryFactory.getInstance().getSectionOpalFactory().forPacketIdCollection(getIdAsObject());
			}
			return myOldSectionOpalHashSet;
		}
	}

	public synchronized void addSectionOpal(SectionOpal argSectionOpal) {
		tryMutate();
		argSectionOpal.setPacketOpal(this);
		return;
	}

	protected synchronized void addSectionOpalInternal(SectionOpal argSectionOpal) {
		tryMutate();
		if (myNewSectionOpalHashSet == null) {
			if (myOldSectionOpalHashSet == null) {
				if (mySectionOpalCachedOperations == null) { mySectionOpalCachedOperations = new java.util.ArrayList<>(); }
				mySectionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.ADD, argSectionOpal));
			} else {
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				myNewSectionOpalHashSet.add(argSectionOpal);
			}
		} else {
			myNewSectionOpalHashSet.add(argSectionOpal);
		}
		return;
	}

	public synchronized void removeSectionOpal(SectionOpal argSectionOpal) {
		tryMutate();
		argSectionOpal.setPacketOpal(null);
	}

	protected synchronized void removeSectionOpalInternal(SectionOpal argSectionOpal) {
		tryMutate();
		if (myNewSectionOpalHashSet == null) {
			if (myOldSectionOpalHashSet == null) {
				if (mySectionOpalCachedOperations == null) { mySectionOpalCachedOperations = new java.util.ArrayList<>(); }
				mySectionOpalCachedOperations.add(new CachedOperation<>(CachedOperation.REMOVE, argSectionOpal));
			} else {
				myNewSectionOpalHashSet = new java.util.HashSet<>(myOldSectionOpalHashSet);
				myNewSectionOpalHashSet.remove(argSectionOpal);
			}
		} else {
			myNewSectionOpalHashSet.remove(argSectionOpal);
		}
		return;
	}

	public synchronized int getSectionOpalCount() { return getSectionOpalHashSet().size(); }

	public synchronized java.util.Iterator<SectionOpal> createSectionOpalIterator() {
		return getSectionOpalHashSet().iterator();
	}

	public synchronized java.util.stream.Stream<SectionOpal> streamSectionOpal() {
		return getSectionOpalHashSet().stream();
	}

	public synchronized void clearSectionOpalInternal() { getSectionOpalHashSet().clear(); }

	@Override
	public String toString() {
		StringBuilder lclSB =  new StringBuilder(64);
		lclSB.append("PacketOpal[");
		lclSB.append("myId=");
		lclSB.append(toStringField(0));
		lclSB.append(']');
		return lclSB.toString();
	}

	@Override
	protected void updateReferencesAfterReload() {
		if (myNewPacketSetOpal != PacketSetOpal.NOT_YET_LOADED) {
			setPacketSetOpal(retrievePacketSetOpal(getNewValues()));
		}
	}

	@Override
	protected void updateCollectionsAfterReload() {
		assert needsToClearOldCollections() == false;
		setClearOldCollections(true);
	}

}
