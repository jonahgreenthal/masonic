package com.masonic;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class Utility {
	private static final String FILENAME_SEPARATOR = "-";
	
	private Utility() {
		throw new UnsupportedOperationException();
	}
	
	public static final String getAdminContact() {
		return "Jonah Greenthal (<a href=\"mailto:jonah@jonahgreenthal.com\">jonah@jonahgreenthal.com</a>)";
	}
	
	public static final String cleanFilename(final String argS) {
		final StringBuilder lclSB = new StringBuilder(argS.length());
		
		boolean lclJustAppendedNonAlphanumeric = false;
		for (final char lclC : argS.toCharArray()) {
			if (Character.isLetterOrDigit(lclC)) {
				lclSB.append(Character.toLowerCase(lclC));
				lclJustAppendedNonAlphanumeric = false;
			} else {
				if (!lclJustAppendedNonAlphanumeric) {
					lclSB.append(FILENAME_SEPARATOR);
					lclJustAppendedNonAlphanumeric = true;
				}
			}
		}
		
		return lclSB.toString();
	}
	
	public static final String nParameters(int argN) {
		Validate.isTrue(argN > 0);
		return StringUtils.join(Collections.nCopies(argN, "?"), ',');
	}
	
	public static final String convertAnswerToLabel(String argAnswer) {
		Validate.notNull(argAnswer);
		
		String lclLabel = StringUtils.remove(argAnswer, '_');
		if (lclLabel.contains(" [")) {
			lclLabel = lclLabel.substring(0, lclLabel.indexOf(" ["));
		}
		
		return lclLabel;
	}
}
