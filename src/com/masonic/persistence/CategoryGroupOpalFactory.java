package com.masonic.persistence;
import com.masonic.application.CategoryGroup;
import com.opal.PersistenceException;

public interface CategoryGroupOpalFactory extends com.opal.OpalFactory<CategoryGroup, CategoryGroupOpal>, com.opal.OpalFactoryCreator<CategoryGroup, CategoryGroupOpal> {
	public CategoryGroupOpal forCode(java.lang.String argCode) throws PersistenceException;
	public CategoryGroupOpal forName(java.lang.String argName) throws PersistenceException;
	public CategoryGroupOpal forShortName(java.lang.String argShortName) throws PersistenceException;
}
