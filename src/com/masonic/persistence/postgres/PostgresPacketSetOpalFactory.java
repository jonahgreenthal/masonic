package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.opal.*;
import com.masonic.application.PacketSet;
import com.masonic.application.PacketSetImpl;
import com.masonic.persistence.PacketSetOpal;
import com.masonic.persistence.PacketSetOpalFactory;

public class PostgresPacketSetOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<PacketSet, PacketSetOpal> implements PacketSetOpalFactory {
	private static final PostgresPacketSetOpalFactory ourInstance = new PostgresPacketSetOpalFactory();

	public static final PostgresPacketSetOpalFactory getInstance() { return ourInstance; }

	protected PostgresPacketSetOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"code", 
		"name", 
		"short_name", 
		"deadline", 
		"note", 
		"completed", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"code",};

	@Override
	protected String[] getFieldNames() { return PacketSetOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return PacketSetOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return PacketSetOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return PacketSetOpal.getStaticFieldValidators(); }


	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected PacketSetOpal instantiate(Object[] argValues) {
		return new PacketSetOpal(this, argValues);
	}

	@Override
	public PacketSetOpal create() {
		PacketSetOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new PacketSetImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(PacketSetOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new PacketSetImpl(argO));
	}

	protected void newObject(@SuppressWarnings("unused") PacketSetOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "packet_set";
	}

	@Override
	protected void registerNewOpal(PacketSetOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(PacketSetOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(PacketSetOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 6) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.addOpal(new CodeOpalKey((java.lang.String) argValues[0]), argOpal, true);
			lclOC.addOpal(new NameOpalKey((java.lang.String) argValues[1]), argOpal, true);
			lclOC.addOpal(new ShortNameOpalKey((java.lang.String) argValues[2]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(PacketSetOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 6) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new CodeOpalKey((java.lang.String) lclOldValues[0]));
			lclOC.removeOpal(new NameOpalKey((java.lang.String) lclOldValues[1]));
			lclOC.removeOpal(new ShortNameOpalKey((java.lang.String) lclOldValues[2]));
		}
	}

	@Override
	public void updateKeys(PacketSetOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 6) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 6) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			OpalKey<PacketSetOpal> lclOldKey = null;
			OpalKey<PacketSetOpal> lclNewKey = null;
			if (true) {
				if (!(lclNewValues[0].equals(lclOldValues[0]))) {
					lclNewKey = new CodeOpalKey((java.lang.String) lclNewValues[0]);
					if (true) {
						lclOldKey = new CodeOpalKey((java.lang.String) lclOldValues[0]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[1].equals(lclOldValues[1]))) {
					lclNewKey = new NameOpalKey((java.lang.String) lclNewValues[1]);
					if (true) {
						lclOldKey = new NameOpalKey((java.lang.String) lclOldValues[1]);
					}
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[2].equals(lclOldValues[2]))) {
					lclNewKey = new ShortNameOpalKey((java.lang.String) lclNewValues[2]);
					if (true) {
						lclOldKey = new ShortNameOpalKey((java.lang.String) lclOldValues[2]);
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
	protected OpalKey<PacketSetOpal> createOpalKeyForReloading(PacketSetOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new CodeOpalKey((java.lang.String) lclValues[0]);
	}

	@Override
	public PacketSetOpal forCode(java.lang.String argCode) throws PersistenceException {
		OpalKey<PacketSetOpal> lclOpalKey = new CodeOpalKey(argCode);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PacketSetOpal forName(java.lang.String argName) throws PersistenceException {
		OpalKey<PacketSetOpal> lclOpalKey = new NameOpalKey(argName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PacketSetOpal forShortName(java.lang.String argShortName) throws PersistenceException {
		OpalKey<PacketSetOpal> lclOpalKey = new ShortNameOpalKey(argShortName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<PacketSetOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new CodeOpalKey(
			OpalUtility.convertTo(java.lang.String.class, argRS.getObject("code"))
		);
	}

	/* package */ static class CodeOpalKey extends com.opal.DatabaseOpalKey<PacketSetOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"code", };

		public CodeOpalKey(java.lang.String argCode) {
			super(new Object[] {argCode, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class NameOpalKey extends com.opal.DatabaseOpalKey<PacketSetOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"name", };

		public NameOpalKey(java.lang.String argName) {
			super(new Object[] {argName, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class ShortNameOpalKey extends com.opal.DatabaseOpalKey<PacketSetOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"short_name", };

		public ShortNameOpalKey(java.lang.String argShortName) {
			super(new Object[] {argShortName, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public PacketSetOpal forUniqueString(String argUniqueString) {
		if (argUniqueString == null || "".equals(argUniqueString)) {
			return null;
		}
		String[] lclArgs = argUniqueString.split("\\|");
		assert lclArgs.length == 1;
		return forOpalKey(
			new CodeOpalKey(
				lclArgs[0]
			)
		);
	}

}
