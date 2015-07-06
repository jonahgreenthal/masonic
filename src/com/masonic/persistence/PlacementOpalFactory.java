package com.masonic.persistence;
import com.masonic.application.Placement;
import com.opal.PersistenceException;

public interface PlacementOpalFactory extends com.opal.OpalFactory<Placement, PlacementOpal>, com.opal.OpalFactoryCreator<Placement, PlacementOpal> {
	public java.util.HashSet<PlacementOpal> forSectionIdCollection(java.lang.Integer argSectionId) throws com.opal.PersistenceException;
	public java.util.HashSet<PlacementOpal> forCategoryCodeCollection(java.lang.String argCategoryCode) throws com.opal.PersistenceException;
	public PlacementOpal forId(java.lang.Integer argId) throws PersistenceException;
	public PlacementOpal forQuestionId(java.lang.Integer argQuestionId) throws PersistenceException;
	public PlacementOpal forSectionIdSequence(java.lang.Integer argSectionId, java.lang.Integer argSequence) throws PersistenceException;
}
