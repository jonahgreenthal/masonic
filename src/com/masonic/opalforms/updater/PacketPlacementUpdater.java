package com.masonic.opalforms.updater;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.opal.cma.OpalFormUpdater;
import com.opal.cma.Validator;

import com.masonic.application.Packet;
import com.masonic.application.Placement;
import com.masonic.application.Question;
import com.masonic.application.QuestionFactory;
import com.masonic.application.Section;

public class PacketPlacementUpdater extends OpalFormUpdater<Packet> {
	public PacketPlacementUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName) {
		super(argRequest, argPrefix, argParameterName);
	}
	
	public PacketPlacementUpdater(final HttpServletRequest argRequest, final String argPrefix, final String argParameterName, final Validator<Packet> argValidator) {
		super(argRequest, argPrefix, argParameterName, argValidator);
	}
	
	public PacketPlacementUpdater(final HttpServletRequest argRequest, final String argPrefix, final Validator<Packet> argValidator) {
		super(argRequest, argPrefix, argValidator);
	}
	
	@Override
	protected void processSpecial() {
		final Packet lclP = Validate.notNull(getUserFacing());
		
		for (Section lclS : lclP.createSectionArray()) {
			for (Placement lclPL : lclS.createPlacementArray()) {
				if (lclPL.isNew()) {
					lclPL.setQuestion(null);
				} else {
					String lclQuestionIdString = StringUtils.trimToNull(getPrefixedParameter("Placement_" + lclPL.getId() + "_Question"));
					if (lclQuestionIdString == null) {
						lclPL.setQuestion(null);
					} else {
						try {
							int lclQuestionId = Integer.parseInt(lclQuestionIdString);
							Question lclQ = QuestionFactory.getInstance().forId(lclQuestionId);
							if (lclQ == null) {
								addError(lclQuestionId + " is not a valid ID of any question for " + lclPL.getString());
							} else {
								lclPL.setQuestion(lclQ);
							}
						} catch (NumberFormatException lclNFE) {
							addError("Couldn't interpret '" + lclQuestionIdString + "' as a question ID (or, in fact, any integer at all) for " + lclPL.getString());
						}
					}
				}
			}
		}
	}
}
