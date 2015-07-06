package com.masonic.persistence;
import com.masonic.application.Section;
import com.opal.PersistenceException;

public interface SectionOpalFactory extends com.opal.OpalFactory<Section, SectionOpal>, com.opal.OpalFactoryCreator<Section, SectionOpal> {
	public java.util.HashSet<SectionOpal> forQuestionTypeCodeCollection(java.lang.String argQuestionTypeCode) throws com.opal.PersistenceException;
	public java.util.HashSet<SectionOpal> forPacketIdCollection(java.lang.Integer argPacketId) throws com.opal.PersistenceException;
	public SectionOpal forId(java.lang.Integer argId) throws PersistenceException;
	public SectionOpal forPacketIdSequence(java.lang.Integer argPacketId, java.lang.Integer argSequence) throws PersistenceException;
}
