package com.masonic.persistence.postgres;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.opal.*;
import com.masonic.application.TeamQuestion;
import com.masonic.application.TeamQuestionImpl;
import com.masonic.persistence.TeamQuestionOpal;
import com.masonic.persistence.TeamQuestionOpalFactory;

public class PostgresTeamQuestionOpalFactory extends com.opal.AbstractDatabaseIdentityOpalFactory<TeamQuestion, TeamQuestionOpal> implements TeamQuestionOpalFactory {
	private static final PostgresTeamQuestionOpalFactory ourInstance = new PostgresTeamQuestionOpalFactory();

	public static final PostgresTeamQuestionOpalFactory getInstance() { return ourInstance; }

	protected PostgresTeamQuestionOpalFactory() {
		super();
	}

	private static final String[] ourColumnNames = new String[] {
		"question_id", 
		"introduction", 
		"part_1_text", 
		"part_1_answer", 
		"part_2_text", 
		"part_2_answer", 
		"part_3_text", 
		"part_3_answer", 
	};

	protected static String[] getStaticColumnNames() { return ourColumnNames; }

	@Override
	protected String[] getColumnNames() { return ourColumnNames; }

	private static final String[] ourPrimaryKeyWhereClauseColumns = new String[] {"question_id",};

	@Override
	protected String[] getFieldNames() { return TeamQuestionOpal.getStaticFieldNames(); }

	@Override
	protected Class<?>[] getFieldTypes() { return TeamQuestionOpal.getStaticFieldTypes(); }

	@Override
	protected boolean[] getFieldNullability() { return TeamQuestionOpal.getStaticFieldNullability(); }

	@Override
	protected com.opal.FieldValidator[] getFieldValidators() { return TeamQuestionOpal.getStaticFieldValidators(); }


	@Override
	protected javax.sql.DataSource getDataSource() {
		return PostgresOpalFactoryFactory.getSpecificInstance().getDataSource();
	}

	@Override
	protected TeamQuestionOpal instantiate(Object[] argValues) {
		return new TeamQuestionOpal(this, argValues);
	}

	@Override
	public TeamQuestionOpal create() {
		TeamQuestionOpal lclOpal;
		synchronized (lclOpal = instantiate((Object[]) null)) {
			assert lclOpal.getUserFacing() == null;
			lclOpal.setUserFacing(new TeamQuestionImpl(lclOpal));
			lclOpal.newObject();
			newObject(lclOpal);
		}
		return lclOpal;
	}

	@Override
	protected void determineUserFacing(TeamQuestionOpal argO, boolean argConcrete) {
		assert argO != null;
		assert argConcrete == false;
		assert argO.getUserFacing() == null;
		argO.setUserFacing(new TeamQuestionImpl(argO));
	}

	protected void newObject(@SuppressWarnings("unused") TeamQuestionOpal argOpal) {
		return;
	}

	@Override
	protected String getFullyQualifiedTableName() {
		return "team_question";
	}

	@Override
	protected void registerNewOpal(TeamQuestionOpal argOpal) {
		registerOpal(argOpal, argOpal.getNewValues());
	}

	@Override
	protected void registerOldOpal(TeamQuestionOpal argOpal) {
		registerOpal(argOpal, argOpal.getOldValues());
	}

	protected void registerOpal(TeamQuestionOpal argOpal, Object[] argValues) {
		if (argValues == null) { throw new IllegalStateException(); }
		if (argValues.length != 8) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.addOpal(new QuestionIdOpalKey((java.lang.Integer) argValues[0]), argOpal, true);
		}
	}

	@Override
	protected void unregisterOpal(TeamQuestionOpal argOpal) {
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 8) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			lclOC.removeOpal(new QuestionIdOpalKey((java.lang.Integer) lclOldValues[0]));
		}
	}

	@Override
	public void updateKeys(TeamQuestionOpal argOpal) {
		org.apache.commons.lang3.Validate.notNull(argOpal);
		Object[] lclOldValues = argOpal.getOldValues();
		if (lclOldValues == null) { throw new IllegalStateException(); }
		if (lclOldValues.length != 8) { throw new IllegalStateException(); }
		Object[] lclNewValues = argOpal.getNewValues();
		if (lclNewValues == null) { throw new IllegalStateException(); }
		if (lclNewValues.length != 8) { throw new IllegalStateException(); }
		OpalCache lclOC = getOpalCache();
		synchronized (lclOC) {
			OpalKey<TeamQuestionOpal> lclOldKey = null;
			OpalKey<TeamQuestionOpal> lclNewKey = null;
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
	protected OpalKey<TeamQuestionOpal> createOpalKeyForReloading(TeamQuestionOpal argOpal) {
		Object[] lclValues = argOpal.getNewValues();
		return new QuestionIdOpalKey((java.lang.Integer) lclValues[0]);
	}

	@Override
	public TeamQuestionOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException {
		OpalKey<TeamQuestionOpal> lclOpalKey = new QuestionIdOpalKey(argQuestionId);
		return forOpalKey(lclOpalKey);
	}

	@Override
	protected OpalKey<TeamQuestionOpal> createOpalKeyForRow(ResultSet argRS) throws SQLException {
		return new QuestionIdOpalKey(
			OpalUtility.convertTo(java.lang.Integer.class, argRS.getObject("question_id"))
		);
	}

	/* package */ static class QuestionIdOpalKey extends com.opal.DatabaseOpalKey<TeamQuestionOpal> {
		private static final String[] ourKeyColumnNames = new String[] {"question_id", };

		public QuestionIdOpalKey(java.lang.Integer argQuestionId) {
			super(new Object[] {argQuestionId, });
		}

		@Override
		protected Object[] getParameters() { return getFields(); }

		@Override
		protected String[] getColumnNames() { return ourKeyColumnNames; }

	}

	@Override
	public TeamQuestionOpal forUniqueString(String argUniqueString) {
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
