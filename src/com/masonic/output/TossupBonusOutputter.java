package com.masonic.output;

import java.util.Arrays;

import org.apache.commons.lang3.Validate;

import com.masonic.application.Packet;
import com.masonic.application.PacketSet;
import com.masonic.application.Placement;
import com.masonic.application.Question;
import com.masonic.application.QuestionType;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.Section;
import com.masonic.application.TeamQuestion;
import com.masonic.application.Tossup;

public class TossupBonusOutputter extends PacketOutputter {
	public TossupBonusOutputter(final Packet argPacket) {
		super(argPacket);
	}
	
	@Override
	public void outputInternal() {
		getWriter().println("\\documentclass[12pt]{tossupbonus}");
		getWriter().println();
		getWriter().println("\\begin{document}");
		getWriter().println();
		
		Section[] lclSections = getPacket().createSectionArray();
		Arrays.sort(lclSections, Section.StandardComparator.getInstance());
		
		for (int lclI = 0; lclI < lclSections.length; ++lclI) {
			Section lclSection = lclSections[lclI];
			
			QuestionType lclType = lclSection.getQuestionType();
			
			// Hacky.  But so is this whole damn app.
			getWriter().println("\\sectionHeader{" + getPacketSet().getName() + "}{" + getPacket().getName() + "}{" + (lclType == QuestionTypeFactory.TOSSUP() ? "Tossups" : "Bonuses") + "}");
			getWriter().println();
			
			Placement[] lclPLs = lclSection.createPlacementArray();
			Arrays.sort(lclPLs, Placement.StandardComparator.getInstance());
			
			for (Placement lclPL : lclPLs) {
				Question lclQ = Validate.notNull(lclPL.getQuestion(), "No placement for " + lclPL + " in " + getPacket().getName());
				
				String lclQuestionLatex;
				if (lclQ.getType() == QuestionTypeFactory.TOSSUP()) {
					Tossup lclTU = (Tossup) lclQ;
					lclQuestionLatex = "\\tossup{" + (lclSection.isExtras() ? "Extra " : "") + lclPL.getSequence()  +
						".}{\n" +
							questionTextToLatex(lclTU.getText()) +
						"\n}{\n" +
							answerLineToLatex(lclTU.getAnswer()) +
						"\n}";
				} else if (lclQ.getType() == QuestionTypeFactory.TEAM_QUESTION()) {
					TeamQuestion lclTQ = (TeamQuestion) lclQ;
					lclQuestionLatex =
						"\\bonus{" + (lclSection.isExtras() ? "Extra " : "") + lclPL.getSequence() + ".}{\n" +
							questionTextToLatex(lclTQ.getIntroduction()) +
						"\n}{\n" +
							questionTextToLatex(lclTQ.getPart1Text()) +
						"\n}{\n" +
							answerLineToLatex(lclTQ.getPart1Answer()) +
						"\n}{\n" +
							questionTextToLatex(lclTQ.getPart2Text()) +
						"\n}{\n" +
							answerLineToLatex(lclTQ.getPart2Answer()) +
						"\n}{\n" +
							questionTextToLatex(lclTQ.getPart3Text()) +
						"\n}{\n" +
							answerLineToLatex(lclTQ.getPart3Answer()) +
						"\n}";
				} else {
					throw new IllegalStateException("Unknown question type (" + lclSection.getQuestionType().getCode() + ") for section #" + lclSection.getId());
				}
				
				getWriter().println(lclQuestionLatex);
				getWriter().println();
			}
			
			if (lclI < lclSections.length - 1) {
				getWriter().println("\\newpage");
				getWriter().println();
			}
		}
		
		getWriter().println();
		
		getWriter().println("\\end{document}");
	}
}
