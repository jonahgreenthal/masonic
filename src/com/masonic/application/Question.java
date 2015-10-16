package com.masonic.application;

import com.siliconage.web.form.FunctionalNameCodeExtractor;
import com.siliconage.web.form.NullSafeNameCodeExtractor;

import com.masonic.persistence.QuestionUserFacing;

/**
 * This interface may be changed at will.
 *
 * <p>This interface and the {@link QuestionFactory} class are the only two automatically generated files for this type that are intended to be referenced in user code. Other automatically generated files package) are intended to be invisible to the user's code and may change (or disappear entirely) when newer versions of the Opal generating code is used.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */

public interface Question extends QuestionUserFacing {
	default boolean isUsed() {
		return getPlacement() != null;
	}
	
	public static final NullSafeNameCodeExtractor<Question> NCE = new FunctionalNameCodeExtractor<>(
		argQ -> argQ.getIdAsObject().toString(),
		Question::getLabel
	);
}
