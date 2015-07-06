package com.masonic.opalforms.updater;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;

import com.opal.cma.OpalFormUpdater;
import com.opal.cma.Validator;

import com.masonic.application.QuestionStatusFactory;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.TeamQuestion;
import com.masonic.AccountUtility;

public class QuestionToTeamQuestionUpdater extends OpalFormUpdater<TeamQuestion> {
	public QuestionToTeamQuestionUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName) {
		super(argRequest, argPrefix, argParameterName);
	}
	
	public QuestionToTeamQuestionUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName, final Validator<TeamQuestion> argValidator) {
		super(argRequest, argPrefix, argParameterName, argValidator);
	}
	
	public QuestionToTeamQuestionUpdater(final HttpServletRequest argRequest, final String argPrefix, final Validator<TeamQuestion> argValidator) {
		super(argRequest, argPrefix, argValidator);
	}
	
	@Override
	protected void processSpecial() {
		final TeamQuestion lclTQ = Validate.notNull(getUserFacing());
		
		if (lclTQ.isNew()) {
			lclTQ.setWriter(AccountUtility.demandLoggedInAccount(getRequest()));
			lclTQ.setQuestionType(QuestionTypeFactory.TEAM_QUESTION());
		}
		
		if (lclTQ.getLabel() == null) {
			addError("Label", "You must specify a label for this question. The label is a short description of what the question is about -- essentially, what completes the sentence \"I wrote a question about...\".");
		}
		
		if (lclTQ.getCategory() == null) {
			addError("Category", "You must specify a category.");
		}
		
		if (lclTQ.isNew() && lclTQ.getStatus() == null) {
			if (lclTQ.getIntroduction() == null || lclTQ.getPart1Text() == null || lclTQ.getPart2Text() == null || lclTQ.getPart3Text() == null) {
				lclTQ.setStatus(QuestionStatusFactory.ANSWER_CHOSEN());
			} else {
				lclTQ.setStatus(QuestionStatusFactory.DRAFTED()); // This is the database column's default, so this line isn't necessary. But I like being clear.
			}
		}
		
		if (lclTQ.getIntroduction() == null && lclTQ.getStatus() == QuestionStatusFactory.ANSWER_CHOSEN()) {
			lclTQ.setIntroduction("Answer claim only");
		} else {
			if (lclTQ.getIntroduction() == null) {
				addError("Introduction", "You must input an introduction.");
			}
		}
		
		if (lclTQ.getPart1Text() == null && lclTQ.getStatus() == QuestionStatusFactory.ANSWER_CHOSEN()) {
			lclTQ.setPart1Text("Answer claim only");
		} else {
			if (lclTQ.getPart1Text() == null) {
				addError("Part1Text", "You must input text for part 1.");
			}
		}
		
		if (lclTQ.getPart2Text() == null && lclTQ.getStatus() == QuestionStatusFactory.ANSWER_CHOSEN()) {
			lclTQ.setPart2Text("Answer claim only");
		} else {
			if (lclTQ.getPart2Text() == null) {
				addError("Part2Text", "You must input text for part 2.");
			}
		}
		
		if (lclTQ.getPart3Text() == null && lclTQ.getStatus() == QuestionStatusFactory.ANSWER_CHOSEN()) {
			lclTQ.setPart3Text("Answer claim only");
		} else {
			if (lclTQ.getPart3Text() == null) {
				addError("Part3Text", "You must input text for part 3.");
			}
		}
		
		if (lclTQ.getPart1Answer() == null) {
			addError("Part1Answer", "You must input the answer line for part 1.");
		}
		
		if (lclTQ.getPart2Answer() == null) {
			addError("Part2Answer", "You must input the answer line for part 2.");
		}
		
		if (lclTQ.getPart3Answer() == null) {
			addError("Part3Answer", "You must input the answer line for part 3.");
		}
	}
	
	@Override
	protected void afterUpdate() {
		getUserFacing().setUpdated(LocalDateTime.now());
	}
}
