package com.masonic.application;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.masonic.persistence.AccountUserFacing;

/**
 * This interface may be changed at will.
 *
 * <p>This interface and the {@link AccountFactory} class are the only two automatically generated files for this type that are intended to be referenced in user code. Other automatically generated files package) are intended to be invisible to the user's code and may change (or disappear entirely) when newer versions of the Opal generating code is used.</p>
 *
 * @author		<a href="mailto:jonah@jonahgreenthal.com">Jonah Greenthal</a>
 */

public interface Account extends AccountUserFacing {
	public static Account determineCurrent(final HttpServletRequest argRequest) {
		Validate.notNull(argRequest);
		
		final Principal lclPrincipal = argRequest.getUserPrincipal();
		if (lclPrincipal == null) {
			return null;
		}
		
		final String lclUsername = StringUtils.trimToNull(lclPrincipal.getName());
		if (lclUsername == null) {
			return null;
		}
		
		final Account lclA = AccountFactory.getInstance().forUsername(lclUsername);
		
		if (lclA != null && lclA.isActive()) {
			return lclA;
		} else {
			return null;
		}
	}
	
	public static Account demand(final HttpServletRequest argRequest) {
		final Account lclA = determineCurrent(argRequest);
		
		if (lclA == null) {
			throw new IllegalStateException("No user is logged in");
		}
		
		return lclA;
	}
}
