package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opal.OpalCache;
import com.opal.OpalKey;
import com.opal.OpalUtility;
import com.opal.PersistenceException;

import com.masonic.application.Placement;
import com.masonic.application.PlacementImpl;
import com.masonic.persistence.PlacementOpal;
import com.masonic.persistence.PlacementOpalFactory;

public class PostgresPlacementOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<Placement, PlacementOpal> implements PlacementOpalFactory {
	private static final PostgresPlacementOpalFactory ourInstance = new PostgresPlacementOpalFactory();

	public static final PostgresPlacementOpalFactory getInstance() { return ourInstance; }

	protected PostgresPlacementOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"id", 
		"section_id", 
		"category_code", 
		"sequence", 
		"question_id", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"id",};

	@Override
	protected String[] getFieldNames() { return PlacementOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return PlacementOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return PlacementOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return PlacementOpal.getStaticFieldValidators(); }


	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected PlacementOpal instantiate(Object[] argValues) {
		return new PlacementOpal(this, argValues);
	}

	@Override
	public PlacementOpal create() {
		PlacementOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new PlacementImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(PlacementOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new PlacementImpl(argO));
	}

	@Override
	public boolean hasGeneratedKeys() {
		return true;
	}

	@Override
	protected void processGeneratedKeys(java.sql.ResultSet argRS, PlacementOpal argOpal) {
		try {
			argOpal.setId(argRS.getInt("id"));
		} catch (SQLException lclE) {
			throw new PersistenceException("Could not process generated keys.");
		}
	}

	protected void newObject(@SuppressWarnings("unused") PlacementOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "placement";
	}

	@Override
	protected void registerNewOpal(PlacementOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(PlacementOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(PlacementOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PlacementOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.addOpal(new IdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
			if (true && argValues[4] != null) {
				lclOC.addOpal(new QuestionIdOpalKey((java.lang.Integer) argValues[4]), argOpal, true);
			}
			lclOC.addOpal(new SectionIdSequenceOpalKey((java.lang.Integer) argValues[1], (java.lang.Integer) argValues[3]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(PlacementOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PlacementOpal> lclOC = getCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new IdOpalKey((java.lang.Integer) lclOldValues[0]));
			if (true && lclOldValues[4] != null) {
				lclOC.removeOpal(new QuestionIdOpalKey((java.lang.Integer) lclOldValues[4]));
			}
			lclOC.removeOpal(new SectionIdSequenceOpalKey((java.lang.Integer) lclOldValues[1], (java.lang.Integer) lclOldValues[3]));
		}
	}

	@Override
	public void updateKeys(PlacementOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 5) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 5) { throw new IllegalStateException(); }
		OpalCache<PlacementOpal> lclOC = getCache();
		synchronized (lclOC) {
			OpalKey<PlacementOpal> lclOldKey = null;
			OpalKey<PlacementOpal> lclNewKey = null;
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
			if (true && lclNewValues[4] != null) {
				if (!(lclNewValues[4].equals(lclOldValues[4]))) {
					lclNewKey = new QuestionIdOpalKey((java.lang.Integer) lclNewValues[4]);
					if (true && lclOldValues[4] != null) {
						lclOldKey = new QuestionIdOpalKey((java.lang.Integer) lclOldValues[4]);
					}
				}
			} else {
				if (true && lclOldValues[4] != null) {
					lclOldKey = new QuestionIdOpalKey((java.lang.Integer) lclOldValues[4]);
				}
			}
			if (lclOldKey != null) { lclOC.removeOpal(lclOldKey); lclOldKey = null; }
			if (lclNewKey != null) { lclOC.addOpal(lclNewKey, argOpal, true); lclNewKey = null; } /* true = SoftReference */
			if (true) {
				if (!(lclNewValues[1].equals(lclOldValues[1]) && lclNewValues[3].equals(lclOldValues[3]))) {
					lclNewKey = new SectionIdSequenceOpalKey((java.lang.Integer) lclNewValues[1], (java.lang.Integer) lclNewValues[3]);
					if (true) {
						lclOldKey = new SectionIdSequenceOpalKey((java.lang.Integer) lclOldValues[1], (java.lang.Integer) lclOldValues[3]);
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
	protected OpalKey<PlacementOpal> createOpalKeyForReloading(PlacementOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new IdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public java.util.HashSet<PlacementOpal> forSectionIdCollection(java.lang.Integer argSectionId) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argSectionId };
		final String[] lclFieldNames = new String[] { "section_id" };
		java.util.HashSet<PlacementOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<PlacementOpal> forCategoryCodeCollection(java.lang.String argCategoryCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argCategoryCode };
		final String[] lclFieldNames = new String[] { "category_code" };
		java.util.HashSet<PlacementOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public PlacementOpal forId(java.lang.Integer argId) throws PersistenceException {
		OpalKey<PlacementOpal> lclOpalKey = new IdOpalKey(argId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PlacementOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException {
		OpalKey<PlacementOpal> lclOpalKey = new QuestionIdOpalKey(argQuestionId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	public PlacementOpal forSectionIdSequence(java.lang.Integer argSectionId, java.lang.Integer argSequence) throws PersistenceException {
		OpalKey<PlacementOpal> lclOpalKey = new SectionIdSequenceOpalKey(argSectionId, argSequence);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<PlacementOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new IdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("id"))
		);
	}

	/* package */ static class IdOpalKey extends com.opal.DatabaseOpalKey<PlacementOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"id", };

		public IdOpalKey(java.lang.Integer argId) {
			super(new Object[] {argId, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class QuestionIdOpalKey extends com.opal.DatabaseOpalKey<PlacementOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"question_id", };

		public QuestionIdOpalKey(java.lang.Integer argQuestionId) {
			super(new Object[] {argQuestionId, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	/* package */ static class SectionIdSequenceOpalKey extends com.opal.DatabaseOpalKey<PlacementOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"section_id", "sequence", };

		public SectionIdSequenceOpalKey(java.lang.Integer argSectionId, java.lang.Integer argSequence) {
			super(new Object[] {argSectionId, argSequence, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public PlacementOpal forUniqueString(String argUniqueString) {
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
