package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opal.OpalCache;
import com.opal.OpalKey;
import com.opal.OpalUtility;
import com.opal.PersistenceException;

import com.masonic.application.Tossup;
import com.masonic.persistence.TossupImpl;
import com.masonic.persistence.TossupOpal;
import com.masonic.persistence.TossupOpalFactory;

public class PostgresTossupOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<Tossup, TossupOpal> implements TossupOpalFactory {
	private static final PostgresTossupOpalFactory ourInstance = new PostgresTossupOpalFactory();

	public static final PostgresTossupOpalFactory getInstance() { return ourInstance; }

	protected PostgresTossupOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"question_id", 
		"text", 
		"answer", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"question_id",};

	@Override
	protected String[] getFieldNames() { return TossupOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return TossupOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return TossupOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return TossupOpal.getStaticFieldValidators(); }

	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected TossupOpal instantiate(Object[] argValues) {
		return new TossupOpal(this, argValues);
	}

	@Override
	public TossupOpal create() {
		TossupOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new TossupImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(TossupOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new TossupImpl(argO));
	}

	protected void newObject(@SuppressWarnings("unused") TossupOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "tossup";
	}

	@Override
	protected void registerNewOpal(TossupOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(TossupOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(TossupOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 3) { throw new IllegalStateException(); }
		OpalCache<TossupOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.addOpal(new QuestionIdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(TossupOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 3) { throw new IllegalStateException(); }
		OpalCache<TossupOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new QuestionIdOpalKey((java.lang.Integer) lclOldValues[0]));
		}
	}

	@Override
	public void updateKeys(TossupOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 3) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 3) { throw new IllegalStateException(); }
		OpalCache<TossupOpal> lclOC = getCache();
		synchronized (lclOC) {
			OpalKey<TossupOpal> lclOldKey = null;
			OpalKey<TossupOpal> lclNewKey = null;
			if (true) {
				if (!(lclNewValues[0].equals(lclOldValues[0]))) {
					lclNewKey = new QuestionIdOpalKey((java.lang.Integer) lclNewValues[0]);
					if (true) {
						lclOldKey = new QuestionIdOpalKey((java.lang.Integer) lclOldValues[0]);
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
	protected OpalKey<TossupOpal> createOpalKeyForReloading(TossupOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new QuestionIdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public TossupOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException {
		OpalKey<TossupOpal> lclOpalKey = new QuestionIdOpalKey(argQuestionId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<TossupOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new QuestionIdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("question_id"))
		);
	}

	/* package */ static class QuestionIdOpalKey extends com.opal.SingleValueDatabaseOpalKey<TossupOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"question_id", };

		public QuestionIdOpalKey(java.lang.Integer argQuestionId) {
			super(argQuestionId);
		}

		@Override
		public Object[] getParameters() {
			return new Object[] { getKeyValue(), };
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public TossupOpal forUniqueString(String argUniqueString) {
		if (argUniqueString == null || "".equals(argUniqueString)) {
			return null;
		}
		String[] lclArgs = argUniqueString.split("\\|");
		assert lclArgs.length == 1;
		return forOpalKey(
			new QuestionIdOpalKey(
				java.lang.Integer.valueOf(lclArgs[0])
			)
		);
	}

}
