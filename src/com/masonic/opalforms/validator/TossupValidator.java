package com.masonic.opalforms.validator;

import com.opal.cma.Validator;

import com.masonic.application.Question;
import com.masonic.application.Tossup;

public class TossupValidator extends Validator<Tossup> {
	public TossupValidator() {
		super();
	}
	
	public void validateText(String argText) {
		Question.validateMarkup(argText, "Text", this);
	}
	
	public void validateAnswer(String argText) {
		Question.validateMarkup(argText, "Text", this);
	}
}
