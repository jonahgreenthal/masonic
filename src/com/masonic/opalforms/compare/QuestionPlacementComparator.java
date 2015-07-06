package com.masonic.opalforms.compare;

import com.siliconage.util.NullSafeComparator;

import com.masonic.application.Placement;
import com.masonic.application.Question;

public final class QuestionPlacementComparator extends NullSafeComparator<Question> {
	private static final QuestionPlacementComparator ourInstance = new QuestionPlacementComparator();
	
	public static QuestionPlacementComparator getInstance() {
		return ourInstance;
	}
	
	private QuestionPlacementComparator() {
		super();
	}
	
	@Override
	protected int compareInternal(final Question argA, final Question argB) {
		if (argA.isUsed() && argB.isUsed()) {
			return Placement.StandardComparator.getInstance().compare(argA.getPlacement(), argB.getPlacement());
		} else if (argA.isUsed()) {
			return 1;
		} else if (argB.isUsed()) {
			return -1;
		} else {
			return argA.getId() - argB.getId();
		}
	}
}
