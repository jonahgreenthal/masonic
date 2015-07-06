package com.masonic.application;

import com.masonic.persistence.QuestionOpal;
import com.masonic.persistence.QuestionStatusOpal;
import com.masonic.persistence.PacketSetOpal;
import com.masonic.persistence.AccountOpal;
import com.masonic.persistence.CategoryOpal;
import com.masonic.persistence.QuestionTypeOpal;
import com.masonic.persistence.PlacementOpal;

public abstract class QuestionImpl extends com.opal.AbstractIdentityImpl<Question, QuestionOpal> implements Question {
	protected QuestionImpl() {
		super();
	}

	protected abstract QuestionOpal getQuestionOpal();

	@Override
	protected com.opal.IdentityOpal<? extends Question> getOpal() {
		return getQuestionOpal();
	}

	@Override
	public java.lang.Integer getIdAsObject() {
		return getQuestionOpal().getIdAsObject();
	}

	@Override
	public void setId(java.lang.Integer argId) {
		getQuestionOpal().setId(argId);
		return;
	}

	@Override
	public void setId(int argId) {
		getQuestionOpal().setId(argId);
		return;
	}

	@Override
	public java.lang.String getCategoryCode() {
		return getQuestionOpal().getCategoryCode();
	}

	@Override
	public void setCategoryCode(java.lang.String argCategoryCode) {
		getQuestionOpal().setCategoryCode(argCategoryCode);
		return;
	}

	@Override
	public java.lang.String getInternalNote() {
		return getQuestionOpal().getInternalNote();
	}

	@Override
	public void setInternalNote(java.lang.String argInternalNote) {
		getQuestionOpal().setInternalNote(argInternalNote);
		return;
	}

	@Override
	public java.lang.String getExternalNote() {
		return getQuestionOpal().getExternalNote();
	}

	@Override
	public void setExternalNote(java.lang.String argExternalNote) {
		getQuestionOpal().setExternalNote(argExternalNote);
		return;
	}

	@Override
	public java.lang.String getQuestionTypeCode() {
		return getQuestionOpal().getQuestionTypeCode();
	}

	@Override
	public void setQuestionTypeCode(java.lang.String argQuestionTypeCode) {
		getQuestionOpal().setQuestionTypeCode(argQuestionTypeCode);
		return;
	}

	@Override
	public java.lang.String getLabel() {
		return getQuestionOpal().getLabel();
	}

	@Override
	public void setLabel(java.lang.String argLabel) {
		getQuestionOpal().setLabel(argLabel);
		return;
	}

	@Override
	public java.lang.Integer getWriterAccountIdAsObject() {
		return getQuestionOpal().getWriterAccountIdAsObject();
	}

	@Override
	public void setWriterAccountId(java.lang.Integer argWriterAccountId) {
		getQuestionOpal().setWriterAccountId(argWriterAccountId);
		return;
	}

	@Override
	public void setWriterAccountId(int argWriterAccountId) {
		getQuestionOpal().setWriterAccountId(argWriterAccountId);
		return;
	}

	@Override
	public java.time.LocalDateTime getUpdated() {
		return getQuestionOpal().getUpdated();
	}

	@Override
	public void setUpdated(java.time.LocalDateTime argUpdated) {
		getQuestionOpal().setUpdated(argUpdated);
		return;
	}

	@Override
	public java.lang.String getIntendedPacketSetCode() {
		return getQuestionOpal().getIntendedPacketSetCode();
	}

	@Override
	public void setIntendedPacketSetCode(java.lang.String argIntendedPacketSetCode) {
		getQuestionOpal().setIntendedPacketSetCode(argIntendedPacketSetCode);
		return;
	}

	@Override
	public java.lang.String getQuestionStatusCode() {
		return getQuestionOpal().getQuestionStatusCode();
	}

	@Override
	public void setQuestionStatusCode(java.lang.String argQuestionStatusCode) {
		getQuestionOpal().setQuestionStatusCode(argQuestionStatusCode);
		return;
	}

	/* The following methods allow direct access to the user objects to which
	this object has references in the database. */

	/** @return the QuestionStatus object created from question through reference question_question_status_code_fkey */

	@Override
	public QuestionStatus getStatus() {
		QuestionStatusOpal lclQuestionStatusOpal = getQuestionOpal().getStatusOpal();
		return lclQuestionStatusOpal == null ? null : lclQuestionStatusOpal.getUserFacing();
	}

	@Override
	public void setStatus(QuestionStatus argQuestionStatus) {
		getQuestionOpal().setStatusOpal(argQuestionStatus == null ? null : ((QuestionStatusImpl) argQuestionStatus).getQuestionStatusOpal());
		return;
	}

	/** @return the PacketSet object created from question through reference question_intended_packet_set_code_fkey */

	@Override
	public PacketSet getIntendedPacketSet() {
		PacketSetOpal lclPacketSetOpal = getQuestionOpal().getIntendedPacketSetOpal();
		return lclPacketSetOpal == null ? null : lclPacketSetOpal.getUserFacing();
	}

	@Override
	public void setIntendedPacketSet(PacketSet argPacketSet) {
		getQuestionOpal().setIntendedPacketSetOpal(argPacketSet == null ? null : ((PacketSetImpl) argPacketSet).getPacketSetOpal());
		return;
	}

	/** @return the Account object created from question through reference question_writer_account_id_fkey */

	@Override
	public Account getWriter() {
		AccountOpal lclAccountOpal = getQuestionOpal().getWriterOpal();
		return lclAccountOpal == null ? null : lclAccountOpal.getUserFacing();
	}

	@Override
	public void setWriter(Account argAccount) {
		getQuestionOpal().setWriterOpal(argAccount == null ? null : ((AccountImpl) argAccount).getAccountOpal());
		return;
	}

	/** @return the Category object created from question through reference question_to_category */

	@Override
	public Category getCategory() {
		CategoryOpal lclCategoryOpal = getQuestionOpal().getCategoryOpal();
		return lclCategoryOpal == null ? null : lclCategoryOpal.getUserFacing();
	}

	@Override
	public void setCategory(Category argCategory) {
		getQuestionOpal().setCategoryOpal(argCategory == null ? null : ((CategoryImpl) argCategory).getCategoryOpal());
		return;
	}

	/** @return the QuestionType object created from question through reference question_to_question_type */

	@Override
	public QuestionType getQuestionType() {
		QuestionTypeOpal lclQuestionTypeOpal = getQuestionOpal().getQuestionTypeOpal();
		return lclQuestionTypeOpal == null ? null : lclQuestionTypeOpal.getUserFacing();
	}

	@Override
	public void setQuestionType(QuestionType argQuestionType) {
		getQuestionOpal().setQuestionTypeOpal(argQuestionType == null ? null : ((QuestionTypeImpl) argQuestionType).getQuestionTypeOpal());
		return;
	}

	@Override
	public Placement getPlacement() {
		PlacementOpal lclO = getQuestionOpal().getPlacementOpal();
		return lclO == null ? null : lclO.getUserFacing();
	}

	@Override
	public void setPlacement(Placement argPlacement) {
		getQuestionOpal().setPlacementOpal(argPlacement == null ? null : ((PlacementImpl) argPlacement).getPlacementOpal());
		return;
	}

	/* The following methods allow access to the user objects that have references
	to this object. */

	@Override
	public void unlink() {
		getQuestionOpal().unlink();
	}

	@Override
	public void reload() {
		getQuestionOpal().reload();
	}

	@Override
	public Question copy() {
		return getQuestionOpal().copy().getUserFacing();
	}

}
