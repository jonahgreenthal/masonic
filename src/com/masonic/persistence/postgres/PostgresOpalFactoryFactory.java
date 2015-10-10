package com.masonic.persistence.postgres;

import javax.sql.DataSource;
import javax.naming.NamingException;
import javax.naming.InitialContext;

import com.opal.PersistenceException;

import com.masonic.persistence.AccountOpalFactory;
import com.masonic.persistence.CategoryGroupOpalFactory;
import com.masonic.persistence.CategoryOpalFactory;
import com.masonic.persistence.OpalFactoryFactory;
import com.masonic.persistence.PacketOpalFactory;
import com.masonic.persistence.PacketSetOpalFactory;
import com.masonic.persistence.PlacementOpalFactory;
import com.masonic.persistence.QuestionOpalFactory;
import com.masonic.persistence.QuestionStatusOpalFactory;
import com.masonic.persistence.QuestionTypeOpalFactory;
import com.masonic.persistence.SectionOpalFactory;
import com.masonic.persistence.TeamQuestionOpalFactory;
import com.masonic.persistence.TossupOpalFactory;

public class PostgresOpalFactoryFactory extends OpalFactoryFactory {
	private static final PostgresOpalFactoryFactory ourInstance = new PostgresOpalFactoryFactory();

	public static final PostgresOpalFactoryFactory getSpecificInstance() { return ourInstance; }

	private static final String DATA_SOURCE_NAME="java:comp/env/MasonicDataSource";

	private DataSource myDataSource;

	@Override
	public TeamQuestionOpalFactory getTeamQuestionOpalFactory() {
		return PostgresTeamQuestionOpalFactory.getInstance();
	}

	@Override
	public TossupOpalFactory getTossupOpalFactory() {
		return PostgresTossupOpalFactory.getInstance();
	}

	@Override
	public QuestionOpalFactory getQuestionOpalFactory() {
		return PostgresQuestionOpalFactory.getInstance();
	}

	@Override
	public QuestionTypeOpalFactory getQuestionTypeOpalFactory() {
		return PostgresQuestionTypeOpalFactory.getInstance();
	}

	@Override
	public SectionOpalFactory getSectionOpalFactory() {
		return PostgresSectionOpalFactory.getInstance();
	}

	@Override
	public QuestionStatusOpalFactory getQuestionStatusOpalFactory() {
		return PostgresQuestionStatusOpalFactory.getInstance();
	}

	@Override
	public PlacementOpalFactory getPlacementOpalFactory() {
		return PostgresPlacementOpalFactory.getInstance();
	}

	@Override
	public PacketSetOpalFactory getPacketSetOpalFactory() {
		return PostgresPacketSetOpalFactory.getInstance();
	}

	@Override
	public PacketOpalFactory getPacketOpalFactory() {
		return PostgresPacketOpalFactory.getInstance();
	}

	@Override
	public CategoryOpalFactory getCategoryOpalFactory() {
		return PostgresCategoryOpalFactory.getInstance();
	}

	@Override
	public AccountOpalFactory getAccountOpalFactory() {
		return PostgresAccountOpalFactory.getInstance();
	}

	@Override
	public CategoryGroupOpalFactory getCategoryGroupOpalFactory() {
		return PostgresCategoryGroupOpalFactory.getInstance();
	}

	public String getDataSourceName() {
		return DATA_SOURCE_NAME;
	}

	public synchronized DataSource getDataSource() throws PersistenceException {
		if (myDataSource == null) {
			try {
				InitialContext lclC = new InitialContext();
				myDataSource = (DataSource) lclC.lookup(getDataSourceName());
				if (myDataSource == null) {
					throw new IllegalStateException("Could not get DataSource from the InitialContext");
				}
			} catch (NamingException lclE) {
				throw new PersistenceException("Could not get DataSource", lclE);
			}
		}
		return myDataSource;
	}
}
