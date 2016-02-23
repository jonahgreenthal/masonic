package com.masonic.application;

import java.util.Comparator;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.StringUtils;

import com.siliconage.web.form.FunctionalNameCodeExtractor;
import com.siliconage.web.form.NullSafeNameCodeExtractor;

import com.opal.cma.Validator;

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
	
	default boolean isUnused() {
		return getPlacement() == null;
	}
	
	// TODO There's a lot more validation this could do.
	public static void validateMarkup(String argText, String argFieldName, Validator<?> argValidator) {
		Validate.notNull(argText);
		Validate.notBlank(argFieldName);
		Validate.notNull(argValidator);
		
		if (StringUtils.countMatches(argText, '{') != StringUtils.countMatches(argText, '}')) {
			argValidator.addError(argFieldName, "Curly braces ({, }) are not matched!");
		}
		
		if (StringUtils.countMatches(argText, '[') != StringUtils.countMatches(argText, ']')) {
			argValidator.addError(argFieldName, "Square braces ([, ]) are not matched!");
		}
		
		if (argText.contains("_")) {
			int lclNonMathUnderscores = 0;
			boolean lclMath = false;
			for (int lclI = 0; lclI < argText.length(); ++lclI) {
				char lclC = argText.charAt(lclI);
				char lclPrev = lclI == 0 ? ' ' : argText.charAt(lclI - 1);
				
				if (lclC == '$' && lclPrev != '\\') {
					lclMath = !lclMath;
				} else if (lclC == '_') {
					if (!lclMath) {
						++lclNonMathUnderscores;
					}
				}
			}
			if (lclNonMathUnderscores % 2 != 0) {
				argValidator.addError(argFieldName, "Underscores (_) are not matched!");
			}
		}
		
		if (argText.contains("$")) {
			int lclUnescapedDollarSigns = 0;
			for (int lclI = 0; lclI < argText.length(); ++lclI) {
				char lclC = argText.charAt(lclI);
				
				if (lclC == '$') {
					char lclPrev = lclI == 0 ? ' ' : argText.charAt(lclI - 1);
					if (lclPrev != '\\') {
						++lclUnescapedDollarSigns;
					}
				}
			}
			if (lclUnescapedDollarSigns % 2 != 0) {
				argValidator.addError(argFieldName, "Dollar signs for math mode are not matched!");
			}
		}
		
		if (argText.contains("~")) {
			int lclUnescapedTildes = 0;
			for (int lclI = 0; lclI < argText.length(); ++lclI) {
				char lclC = argText.charAt(lclI);
				
				if (lclC == '~') {
					char lclPrev = lclI == 0 ? ' ' : argText.charAt(lclI - 1);
					if (lclPrev != '\\') {
						++lclUnescapedTildes;
					}
				}
			}
			if (lclUnescapedTildes % 2 != 0) {
				argValidator.addError(argFieldName, "Tildes (~) are not matched!");
			}
		}
	}
	
	public static final NullSafeNameCodeExtractor<Question> NCE = new FunctionalNameCodeExtractor<>(
		Question::getLabel,
		argQ -> argQ.getIdAsObject().toString()
	);
}
