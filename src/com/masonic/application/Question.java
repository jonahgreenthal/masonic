package com.masonic.application;

import java.util.Comparator;

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
	public static final Comparator<Question> PLACEMENT_COMPARATOR = Comparator.<Question>comparingInt(argQ -> argQ.isUsed() ? 0 : 1).thenComparingInt(Question::getId);
	
	default boolean isUsed() {
		return getPlacement() != null;
	}
	
	public static final NullSafeNameCodeExtractor<Question> NCE = new FunctionalNameCodeExtractor<>(
		Question::getLabel,
		argQ -> argQ.getIdAsObject().toString()
	);
}
