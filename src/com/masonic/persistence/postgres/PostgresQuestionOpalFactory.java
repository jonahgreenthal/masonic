package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.opal.*;
import com.masonic.persistence.OpalFactoryFactory;
import com.masonic.application.Question;
import com.masonic.persistence.QuestionOpal;
import com.masonic.persistence.QuestionOpalFactory;

public class PostgresQuestionOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<Question, QuestionOpal> implements QuestionOpalFactory {
	private static final PostgresQuestionOpalFactory ourInstance = new PostgresQuestionOpalFactory();

	public static final PostgresQuestionOpalFactory getInstance() { return ourInstance; }

	protected PostgresQuestionOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"id", 
		"category_code", 
		"internal_note", 
		"external_note", 
		"question_type_code", 
		"label", 
		"writer_account_id", 
		"updated", 
		"intended_packet_set_code", 
		"question_status_code", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"id",};

	@Override
	protected String[] getFieldNames() { return QuestionOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return QuestionOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return QuestionOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return QuestionOpal.getStaticFieldValidators(); }


	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected QuestionOpal instantiate(Object[] argValues) {
		return new QuestionOpal(this, argValues);
	}

	@Override
	public QuestionOpal createAsSuperOpal(Question argUF) {
		assert argUF != null;
		QuestionOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(argUF);
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	public QuestionOpal create(com.masonic.application.QuestionType argT) {
		throw new IllegalStateException("This overload of create should only be used with SingleTablePolymorphism.");
	}

	@Override
	protected void determineUserFacing(QuestionOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		com.masonic.persistence.QuestionTypeOpal lcl0 = argO.getQuestionTypeOpal();
		if (lcl0 == null) {
			throw new IllegalStateException();
		}
		Question lclUF;
		String lclTableName = (String) lcl0.getField(4);
		if (lclTableName.equalsIgnoreCase("team_question")) {
			com.masonic.persistence.TeamQuestionOpalFactory lclOF = OpalFactoryFactory.getInstance().getTeamQuestionOpalFactory();
			assert lclOF != null;
			com.masonic.persistence.TeamQuestionOpal lclO = lclOF.forQuestionId(((java.lang.Integer) argO.getField(0)));
			if (lclO == null) {
				throw new PersistenceException("Polymorphism data for " + argO + " suggested that there should be a subclass row in team_question, but none was found.");
			}
			lclUF = lclO.getUserFacing();
		} else if (lclTableName.equalsIgnoreCase("tossup")) {
			com.masonic.persistence.TossupOpalFactory lclOF = OpalFactoryFactory.getInstance().getTossupOpalFactory();
			assert lclOF != null;
			com.masonic.persistence.TossupOpal lclO = lclOF.forQuestionId(((java.lang.Integer) argO.getField(0)));
			if (lclO == null) {
				throw new PersistenceException("Polymorphism data for " + argO + " suggested that there should be a subclass row in tossup, but none was found.");
			}
			lclUF = lclO.getUserFacing();
		} else {
			throw new PersistenceException("While instantiating Opal " + argO + " it was necessary to populate subclass information from table " + lclTableName + " but that table doesn't have an associated Opal (that is properly configured as a subclass).");
		}
		if (lclUF == null) {
			throw new PersistenceException("While instantiating Opal " + argO + " it was necessary to populate subclass information from table " + lclTableName + " but no row corresponding to the superclass primary key values was found.");
		}
		argO.setUserFacing(lclUF);
	}

	@Override
	public boolean hasGeneratedKeys() {
		return true;
	}

	@Override
	protected void processGeneratedKeys(java.sql.ResultSet argRS, QuestionOpal argOpal) {
		try {
			argOpal.setId(argRS.getInt("id"));
		} catch (SQLException lclE) {
			throw new PersistenceException("Could not process generated keys.");
		}
	}

	protected void newObject(@SuppressWarnings("unused") QuestionOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "question";
	}

	@Override
	protected void registerNewOpal(QuestionOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(QuestionOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(QuestionOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 10) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.addOpal(new IdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(QuestionOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 10) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new IdOpalKey((java.lang.Integer) lclOldValues[0]));
		}
	}

	@Override
	public void updateKeys(QuestionOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 10) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 10) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			OpalKey<QuestionOpal> lclOldKey = null;
			OpalKey<QuestionOpal> lclNewKey = null;
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
		}
		return;
	}

	@Override
	protected String[] getPrimaryKeyWhereClauseColumns() {
		return ourPrimaryKeyWhereClauseColumns;
	}

	@Override
	protected OpalKey<QuestionOpal> createOpalKeyForReloading(QuestionOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new IdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public java.util.HashSet<QuestionOpal> forQuestionStatusCodeCollection(java.lang.String argQuestionStatusCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argQuestionStatusCode };
		final String[] lclFieldNames = new String[] { "question_status_code" };
		java.util.HashSet<QuestionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<QuestionOpal> forIntendedPacketSetCodeCollection(java.lang.String argIntendedPacketSetCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argIntendedPacketSetCode };
		final String[] lclFieldNames = new String[] { "intended_packet_set_code" };
		java.util.HashSet<QuestionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<QuestionOpal> forWriterAccountIdCollection(java.lang.Integer argWriterAccountId) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argWriterAccountId };
		final String[] lclFieldNames = new String[] { "writer_account_id" };
		java.util.HashSet<QuestionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<QuestionOpal> forCategoryCodeCollection(java.lang.String argCategoryCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argCategoryCode };
		final String[] lclFieldNames = new String[] { "category_code" };
		java.util.HashSet<QuestionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public java.util.HashSet<QuestionOpal> forQuestionTypeCodeCollection(java.lang.String argQuestionTypeCode) /* throws PersistenceException */ {
		final Object[] lclParameters = new Object[] { argQuestionTypeCode };
		final String[] lclFieldNames = new String[] { "question_type_code" };
		java.util.HashSet<QuestionOpal> lclCollection = new java.util.HashSet<>();
		load(getFullyQualifiedTableName(), lclFieldNames, lclParameters, null, lclCollection);
		return lclCollection;
	}

	@Override
	public QuestionOpal forId(java.lang.Integer argId) throws PersistenceException {
		OpalKey<QuestionOpal> lclOpalKey = new IdOpalKey(argId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<QuestionOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new IdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("id"))
		);
	}

	/* package */ static class IdOpalKey extends com.opal.DatabaseOpalKey<QuestionOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"id", };

		public IdOpalKey(java.lang.Integer argId) {
			super(new Object[] {argId, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public QuestionOpal forUniqueString(String argUniqueString) {
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
