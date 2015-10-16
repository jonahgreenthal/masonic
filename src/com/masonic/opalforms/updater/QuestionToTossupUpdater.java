package com.masonic.opalforms.updater;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.opal.cma.OpalFormUpdater;
import com.opal.cma.Validator;

import com.masonic.application.Account;
import com.masonic.application.QuestionStatusFactory;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.Tossup;

public class QuestionToTossupUpdater extends OpalFormUpdater<Tossup> {
	public QuestionToTossupUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName) {
		super(argRequest, argPrefix, argParameterName);
	}
	
	public QuestionToTossupUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName, final Validator<Tossup> argValidator) {
		super(argRequest, argPrefix, argParameterName, argValidator);
	}
	
	public QuestionToTossupUpdater(final HttpServletRequest argRequest, final String argPrefix, final Validator<Tossup> argValidator) {
		super(argRequest, argPrefix, argValidator);
	}
	
	@Override
	protected void processSpecial() {
		final Tossup lclTU = Validate.notNull(getUserFacing());
		
		if (lclTU.isNew() && lclTU.getWriter() == null) {
			lclTU.setWriter(Account.demand(getRequest()));
			lclTU.setQuestionType(QuestionTypeFactory.TOSSUP());
		}
		
		if (lclTU.getLabel() == null) {
			lclTU.setLabel(convertAnswerToLabel(lclTU.getAnswer()));
		}
		
		if (lclTU.getCategory() == null) {
			addError("Category", "You must specify a category.");
		}
		
		if (lclTU.isNew() && lclTU.getStatus() == null) {
			if (lclTU.getText() == null) {
				lclTU.setStatus(QuestionStatusFactory.ANSWER_CHOSEN());
			} else {
				lclTU.setStatus(QuestionStatusFactory.DRAFTED()); // This is the database column's default, so this line isn't necessary. But I like being clear.
			}
		}
		
		if (lclTU.getText() == null && lclTU.getStatus() == QuestionStatusFactory.ANSWER_CHOSEN()) {
			lclTU.setText("Answer claim only");
		} else {
			if (lclTU.getText() == null) {
				addError("Text", "You must input question text.");
			}
		}
		
		if (lclTU.getAnswer() == null) {
			addError("Answer", "You must input the answer line.");
		}
	}
	
	@Override
	protected void afterUpdate() {
		getUserFacing().setUpdated(LocalDateTime.now());
	}
	
	public String convertAnswerToLabel(String argAnswer) {
		Validate.notNull(argAnswer);
		
		String lclLabel = StringUtils.remove(argAnswer, '_');
		if (lclLabel.contains(" [")) {
			lclLabel = lclLabel.substring(0, lclLabel.indexOf(" ["));
		}
		
		return lclLabel;
	}
}
