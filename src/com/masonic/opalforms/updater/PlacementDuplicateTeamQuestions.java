package com.masonic.opalforms.updater;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;

import com.opal.cma.OpalFormUpdater;
import com.opal.cma.Validator;

import com.masonic.application.Placement;
import com.masonic.application.PlacementFactory;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.TeamQuestion;

public class PlacementDuplicateTeamQuestions extends OpalFormUpdater<Placement> {
	public PlacementDuplicateTeamQuestions(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName) {
		super(argRequest, argPrefix, argParameterName);
	}
	
	public PlacementDuplicateTeamQuestions(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName, final Validator<Placement> argValidator) {
		super(argRequest, argPrefix, argParameterName, argValidator);
	}
	
	public PlacementDuplicateTeamQuestions(final HttpServletRequest argRequest, final String argPrefix, final Validator<Placement> argValidator) {
		super(argRequest, argPrefix, argValidator);
	}
	
	@Override
	protected void afterUpdate() {
		final Placement lclPL = Validate.notNull(getUserFacing());
		
		if (lclPL.isNew() && lclPL.getSection().getQuestionType() == QuestionTypeFactory.TEAM_QUESTION()) {
			if ((!lclPL.getSection().isExtras() && lclPL.getSequence() % 2 == 1) || (lclPL.getSection().isExtras() && lclPL.getSequence() % 2 == 0)) {
				Placement lclPL2 = PlacementFactory.getInstance().create()
					.setSection(lclPL.getSection())
					.setCategory(lclPL.getCategory())
					.setSequence(lclPL.getSequence() + 1);
			}
		}
	}
}
