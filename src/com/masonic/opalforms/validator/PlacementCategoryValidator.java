package com.masonic.opalforms.validator;

import org.apache.commons.lang3.Validate; 

import com.opal.cma.Validator;

import com.masonic.application.Category;
import com.masonic.application.Placement;
import com.masonic.application.Question;

public class PlacementCategoryValidator extends Validator<Placement> {
	public PlacementCategoryValidator() {
		super();
	}
	
	@Override
	public void validate(Placement argPL) {
		Validate.notNull(argPL);
		
		Question lclQ = argPL.getQuestion();
		if (lclQ == null) {
			return;
		} else {
			Category lclC = Validate.notNull(argPL.getCategory());
			
			if (lclQ.getCategory() != lclC) {
				addError("Question", "Category mismatch: " + argPL.getString() + " is supposed to have a question of category " + lclC.getName() + ", but the specified question (" + lclQ.getLabel() + ") is of the " + lclQ.getCategory().getName() + " category.");
			}
		}
	}
}
