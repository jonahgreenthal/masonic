package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opal.OpalCache;
import com.opal.OpalKey;
import com.opal.OpalUtility;
import com.opal.PersistenceException;

import com.masonic.application.QuestionType;
import com.masonic.persistence.QuestionTypeImpl;
import com.masonic.persistence.QuestionTypeOpal;
import com.masonic.persistence.QuestionTypeOpalFactory;

public class PostgresQuestionTypeOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<QuestionType, QuestionTypeOpal> implements QuestionTypeOpalFactory {
	private static final PostgresQuestionTypeOpalFactory ourInstance = new PostgresQuestionTypeOpalFactory();

	public static final PostgresQuestionTypeOpalFactory getInstance() { return ourInstance; }

	protected PostgresQuestionTypeOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"code", 
		"name", 
		"short_name", 
		"sequence", 
		"table_name", 
		"section_header", 
		"scoring_note", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"code",};

	@Override
	protected String[] getFieldNames() { return QuestionTypeOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return QuestionTypeOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return QuestionTypeOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return QuestionTypeOpal.getStaticFieldValidators(); }

	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected QuestionTypeOpal instantiate(Object[] argValues) {
		return new QuestionTypeOpal(this, argValues);
	}

	@Override
	public QuestionTypeOpal create() {
		QuestionTypeOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new QuestionTypeImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(QuestionTypeOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new QuestionTypeImpl(argO));
	}

	protected void newObject(@SuppressWarnings("unused") QuestionTypeOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "question_type";
	}

	@Override
	protected void registerNewOpal(QuestionTypeOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(QuestionTypeOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(QuestionTypeOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<QuestionTypeOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.addOpal(new CodeOpalKey((java.lang.String) argValues[0]), argOpal, true);
			lclOC.addOpal(new NameOpalKey((java.lang.String) argValues[1]), argOpal, true);
			lclOC.addOpal(new ShortNameOpalKey((java.lang.String) argValues[2]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(QuestionTypeOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<QuestionTypeOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new CodeOpalKey((java.lang.String) lclOldValues[0]));
			lclOC.removeOpal(new NameOpalKey((java.lang.String) lclOldValues[1]));
			lclOC.removeOpal(new ShortNameOpalKey((java.lang.String) lclOldValues[2]));
		}
	}

	@Override
	public void updateKeys(QuestionTypeOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 7) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 7) { throw new IllegalStateException(); }
		OpalCache<QuestionTypeOpal> lclOC = getCache();
		synchronized (lclOC) {
			OpalKey<QuestionTypeOpal> lclOldKey = null;
			OpalKey<QuestionTypeOpal> lclNewKey = null;
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
	protected OpalKey<QuestionTypeOpal> createOpalKeyForReloading(QuestionTypeOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new CodeOpalKey((java.lang.String) lclValues[0]);
	}

	@Override
	public QuestionTypeOpal forCode(java.lang.String argCode) throws PersistenceException {
		OpalKey<QuestionTypeOpal> lclOpalKey = new CodeOpalKey(argCode);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public QuestionTypeOpal forName(java.lang.String argName) throws PersistenceException {
		OpalKey<QuestionTypeOpal> lclOpalKey = new NameOpalKey(argName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public QuestionTypeOpal forShortName(java.lang.String argShortName) throws PersistenceException {
		OpalKey<QuestionTypeOpal> lclOpalKey = new ShortNameOpalKey(argShortName);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<QuestionTypeOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new CodeOpalKey(
			OpalUtility.convertTo(java.lang.String.class, argRS.getObject("code"))
		);
	}

	/* package */ static class CodeOpalKey extends com.opal.SingleValueDatabaseOpalKey<QuestionTypeOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"code", };

		public CodeOpalKey(java.lang.String argCode) {
			super(argCode);
		}

		@Override
		public Object[] getParameters() {
			return new Object[] { getKeyValue(), };
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class NameOpalKey extends com.opal.SingleValueDatabaseOpalKey<QuestionTypeOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"name", };

		public NameOpalKey(java.lang.String argName) {
			super(argName);
		}

		@Override
		public Object[] getParameters() {
			return new Object[] { getKeyValue(), };
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class ShortNameOpalKey extends com.opal.SingleValueDatabaseOpalKey<QuestionTypeOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"short_name", };

		public ShortNameOpalKey(java.lang.String argShortName) {
			super(argShortName);
		}

		@Override
		public Object[] getParameters() {
			return new Object[] { getKeyValue(), };
		}

		@Override
		public String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public QuestionTypeOpal forUniqueString(String argUniqueString) {
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
