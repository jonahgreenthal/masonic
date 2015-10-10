package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opal.OpalCache;
import com.opal.OpalKey;
import com.opal.OpalUtility;
import com.opal.PersistenceException;

import com.masonic.application.Packet;
import com.masonic.application.PacketImpl;
import com.masonic.persistence.PacketOpal;
import com.masonic.persistence.PacketOpalFactory;

public class PostgresPacketOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<Packet, PacketOpal> implements PacketOpalFactory {
	private static final PostgresPacketOpalFactory ourInstance = new PostgresPacketOpalFactory();

	public static final PostgresPacketOpalFactory getInstance() { return ourInstance; }

	protected PostgresPacketOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"id", 
		"packet_set_code", 
		"name", 
		"short_name", 
		"sequence", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"id",};

	@Override
	protected String[] getFieldNames() { return PacketOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return PacketOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return PacketOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return PacketOpal.getStaticFieldValidators(); }


	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected PacketOpal instantiate(Object[] argValues) {
		return new PacketOpal(this, argValues);
	}

	@Override
	public PacketOpal create() {
		PacketOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new PacketImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(PacketOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new PacketImpl(argO));
	}

	@Override
	public boolean hasGeneratedKeys() {
		return true;
	}

	@Override
	protected void processGeneratedKeys(java.sql.ResultSet argRS, PacketOpal argOpal) {
		try {
			argOpal.setId(argRS.getInt("id"));
		} catch (SQLException lclE) {
			throw new PersistenceException("Could not process generated keys.");
		}
	}

	protected void newObject(@SuppressWarnings("unused") PacketOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "packet";
	}

	@Override
	protected void registerNewOpal(PacketOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(PacketOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(PacketOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PacketOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.addOpal(new IdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
			lclOC.addOpal(new PacketSetCodeNameOpalKey((java.lang.String) argValues[1], (java.lang.String) argValues[2]), argOpal, true);
			lclOC.addOpal(new PacketSetCodeSequenceOpalKey((java.lang.String) argValues[1], (java.lang.Integer) argValues[4]), argOpal, true);
			lclOC.addOpal(new PacketSetCodeShortNameOpalKey((java.lang.String) argValues[1], (java.lang.String) argValues[3]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(PacketOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PacketOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new IdOpalKey((java.lang.Integer) lclOldValues[0]));
			lclOC.removeOpal(new PacketSetCodeNameOpalKey((java.lang.String) lclOldValues[1], (java.lang.String) lclOldValues[2]));
			lclOC.removeOpal(new PacketSetCodeSequenceOpalKey((java.lang.String) lclOldValues[1], (java.lang.Integer) lclOldValues[4]));
			lclOC.removeOpal(new PacketSetCodeShortNameOpalKey((java.lang.String) lclOldValues[1], (java.lang.String) lclOldValues[3]));
		}
	}

	@Override
	public void updateKeys(PacketOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 5) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PacketOpal> lclOC = getCache();
		synchronized (lclOC) {
			OpalKey<PacketOpal> lclOldKey = null;
			OpalKey<PacketOpal> lclNewKey = null;
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
				if (!(lclNewValues[1].equals(lclOldValues[1]) && lclNewValues[2].equals(lclOldValues[2]))) {
					lclNewKey = new PacketSetCodeNameOpalKey((java.lang.String) lclNewValues[1], (java.lang.String) lclNewValues[2]);
					if (true) {
						lclOldKey = new PacketSetCodeNameOpalKey((java.lang.String) lclOldValues[1], (java.lang.String) lclOldValues[2]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[1].equals(lclOldValues[1]) && lclNewValues[4].equals(lclOldValues[4]))) {
					lclNewKey = new PacketSetCodeSequenceOpalKey((java.lang.String) lclNewValues[1], (java.lang.Integer) lclNewValues[4]);
					if (true) {
						lclOldKey = new PacketSetCodeSequenceOpalKey((java.lang.String) lclOldValues[1], (java.lang.Integer) lclOldValues[4]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[1].equals(lclOldValues[1]) && lclNewValues[3].equals(lclOldValues[3]))) {
					lclNewKey = new PacketSetCodeShortNameOpalKey((java.lang.String) lclNewValues[1], (java.lang.String) lclNewValues[3]);
					if (true) {
						lclOldKey = new PacketSetCodeShortNameOpalKey((java.lang.String) lclOldValues[1], (java.lang.String) lclOldValues[3]);
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
	protected OpalKey<PacketOpal> createOpalKeyForReloading(PacketOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new IdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public java.util.HashSet<PacketOpal> forPacketSetCodeCollection(java.lang.String argPacketSetCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argPacketSetCode };
		final String[] lclFieldNames = new String[] { "packet_set_code" };
		java.util.HashSet<PacketOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public PacketOpal forId(java.lang.Integer argId) throws PersistenceException {
		OpalKey<PacketOpal> lclOpalKey = new IdOpalKey(argId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PacketOpal forPacketSetCodeName(java.lang.String argPacketSetCode, java.lang.String argName) throws PersistenceException {
		OpalKey<PacketOpal> lclOpalKey = new PacketSetCodeNameOpalKey(argPacketSetCode, argName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PacketOpal forPacketSetCodeSequence(java.lang.String argPacketSetCode, java.lang.Integer argSequence) throws PersistenceException {
		OpalKey<PacketOpal> lclOpalKey = new PacketSetCodeSequenceOpalKey(argPacketSetCode, argSequence);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PacketOpal forPacketSetCodeShortName(java.lang.String argPacketSetCode, java.lang.String argShortName) throws PersistenceException {
		OpalKey<PacketOpal> lclOpalKey = new PacketSetCodeShortNameOpalKey(argPacketSetCode, argShortName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<PacketOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new IdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("id"))
		);
	}

	/* package */ static class IdOpalKey extends com.opal.DatabaseOpalKey<PacketOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"id", };

		public IdOpalKey(java.lang.Integer argId) {
			super(new Object[] {argId, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class PacketSetCodeNameOpalKey extends com.opal.DatabaseOpalKey<PacketOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"packet_set_code", "name", };

		public PacketSetCodeNameOpalKey(java.lang.String argPacketSetCode, java.lang.String argName) {
			super(new Object[] {argPacketSetCode, argName, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class PacketSetCodeSequenceOpalKey extends com.opal.DatabaseOpalKey<PacketOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"packet_set_code", "sequence", };

		public PacketSetCodeSequenceOpalKey(java.lang.String argPacketSetCode, java.lang.Integer argSequence) {
			super(new Object[] {argPacketSetCode, argSequence, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class PacketSetCodeShortNameOpalKey extends com.opal.DatabaseOpalKey<PacketOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"packet_set_code", "short_name", };

		public PacketSetCodeShortNameOpalKey(java.lang.String argPacketSetCode, java.lang.String argShortName) {
			super(new Object[] {argPacketSetCode, argShortName, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public PacketOpal forUniqueString(String argUniqueString) {
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
