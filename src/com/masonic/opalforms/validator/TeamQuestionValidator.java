package com.masonic.opalforms.validator;

import com.opal.cma.Validator;

import com.masonic.application.Question;
import com.masonic.application.TeamQuestion;

public class TeamQuestionValidator extends Validator<TeamQuestion> {
	public TeamQuestionValidator() {
		super();
	}
	
	public void validateIntroduction(String argText) {
		Question.validateMarkup(argText, "Introduction", this);
	}
	
	public void validatePart1Text(String argText) {
		Question.validateMarkup(argText, "Part1Text", this);
	}
	
	public void validatePart1Answer(String argText) {
		Question.validateMarkup(argText, "Part1Answer", this);
	}
	
	public void validatePart2Text(String argText) {
		Question.validateMarkup(argText, "Part2Text", this);
	}
	
	public void validatePart2Answer(String argText) {
		Question.validateMarkup(argText, "Part2Answer", this);
	}
	
	public void validatePart3Text(String argText) {
		Question.validateMarkup(argText, "Part3Text", this);
	}
	
	public void validatePart3Answer(String argText) {
		Question.validateMarkup(argText, "Part3Answer", this);
	}
}
