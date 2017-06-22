package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opal.OpalCache;
import com.opal.OpalKey;
import com.opal.OpalUtility;
import com.opal.PersistenceException;

import com.masonic.application.Section;
import com.masonic.persistence.SectionImpl;
import com.masonic.persistence.SectionOpal;
import com.masonic.persistence.SectionOpalFactory;

public class PostgresSectionOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<Section, SectionOpal> implements SectionOpalFactory {
	private static final PostgresSectionOpalFactory ourInstance = new PostgresSectionOpalFactory();

	public static final PostgresSectionOpalFactory getInstance() { return ourInstance; }

	protected PostgresSectionOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"id", 
		"packet_id", 
		"question_type_code", 
		"sequence", 
		"name", 
		"short_name", 
		"extras", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"id",};

	@Override
	protected String[] getFieldNames() { return SectionOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return SectionOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return SectionOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return SectionOpal.getStaticFieldValidators(); }

	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected SectionOpal instantiate(Object[] argValues) {
		return new SectionOpal(this, argValues);
	}

	@Override
	public SectionOpal create() {
		SectionOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new SectionImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(SectionOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new SectionImpl(argO));
	}

	@Override
	public boolean hasGeneratedKeys() {
		return true;
	}

	@Override
	protected void processGeneratedKeys(java.sql.ResultSet argRS, SectionOpal argOpal) {
		try {
			argOpal.setId(argRS.getInt("id"));
		} catch (SQLException lclE) {
			throw new PersistenceException("Could not process generated keys.");
		}
	}

	protected void newObject(@SuppressWarnings("unused") SectionOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "section";
	}

	@Override
	protected void registerNewOpal(SectionOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(SectionOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(SectionOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<SectionOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.addOpal(new IdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
			lclOC.addOpal(new PacketIdSequenceOpalKey((java.lang.Integer) argValues[1], (java.lang.Integer) argValues[3]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(SectionOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<SectionOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new IdOpalKey((java.lang.Integer) lclOldValues[0]));
			lclOC.removeOpal(new PacketIdSequenceOpalKey((java.lang.Integer) lclOldValues[1], (java.lang.Integer) lclOldValues[3]));
		}
	}

	@Override
	public void updateKeys(SectionOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 7) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<SectionOpal> lclOC = getCache();
		synchronized (lclOC) {
			OpalKey<SectionOpal> lclOldKey = null;
			OpalKey<SectionOpal> lclNewKey = null;
			if (true) {
				if (!(lclNewValues[0].equals(lclOldValues[0]))) {
					lclNewKey = new IdOpalKey((java.lang.Integer) lclNewValues[0]);
					if (true) {
						lclOldKey = new IdOpalKey((java.lang.Integer) lclOldValues[0]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[1].equals(lclOldValues[1]) && lclNewValues[3].equals(lclOldValues[3]))) {
					lclNewKey = new PacketIdSequenceOpalKey((java.lang.Integer) lclNewValues[1], (java.lang.Integer) lclNewValues[3]);
					if (true) {
						lclOldKey = new PacketIdSequenceOpalKey((java.lang.Integer) lclOldValues[1], (java.lang.Integer) lclOldValues[3]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
		}
		return;
	}

	@Override
	protected String[] getPrimaryKeyWhereClauseColumns() {
		return ourPrimaryKeyWhereClauseColumns;
	}

	@Override
	protected OpalKey<SectionOpal> createOpalKeyForReloading(SectionOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new IdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public java.util.HashSet<SectionOpal> forPacketIdCollection(java.lang.Integer argPacketId) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argPacketId };
		final String[] lclFieldNames = new String[] { "packet_id" };
		java.util.HashSet<SectionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<SectionOpal> forQuestionTypeCodeCollection(java.lang.String argQuestionTypeCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argQuestionTypeCode };
		final String[] lclFieldNames = new String[] { "question_type_code" };
		java.util.HashSet<SectionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public SectionOpal forId(java.lang.Integer argId) throws PersistenceException {
		OpalKey<SectionOpal> lclOpalKey = new IdOpalKey(argId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public SectionOpal forPacketIdSequence(java.lang.Integer argPacketId, java.lang.Integer argSequence) throws PersistenceException {
		OpalKey<SectionOpal> lclOpalKey = new PacketIdSequenceOpalKey(argPacketId, argSequence);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<SectionOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new IdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("id"))
		);
	}

	/* package */ static class IdOpalKey extends com.opal.SingleValueDatabaseOpalKey<SectionOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"id", };

		public IdOpalKey(java.lang.Integer argId) {
			super(argId);
		}

		@Override
		public Object[] getParameters() {
			return new Object[] { getKeyValue(), };
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class PacketIdSequenceOpalKey extends com.opal.MultipleValueDatabaseOpalKey<SectionOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"packet_id", "sequence", };

		public PacketIdSequenceOpalKey(java.lang.Integer argPacketId, java.lang.Integer argSequence) {
			super(new Object[] {argPacketId, argSequence, });
		}

		@Override
		public Object[] getParameters() {
			return getFields();
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public SectionOpal forUniqueString(String argUniqueString) {
		if (argUniqueString == null || "".equals(argUniqueString)) {
			return null;
		}
		String[] lclArgs = argUniqueString.split("\\|");
		assert lclArgs.length == 1;
		return forOpalKey(
			new IdOpalKey(
				java.lang.Integer.valueOf(lclArgs[0])
			)
		);
	}

}
