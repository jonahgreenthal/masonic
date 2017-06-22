package com.masonic.output;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

import com.masonic.application.Packet;
import com.masonic.application.Placement;
import com.masonic.application.Question;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.Section;
import com.masonic.application.TeamQuestion;
import com.masonic.application.Tossup;

public class MasonicOutputter extends PacketOutputter {
	public MasonicOutputter(final Packet argPacket) {
		super(argPacket);
	}
	
	@Override
	public void outputInternal() {
		getWriter().println("\\documentclass[12pt]{masonicbowl}");
		getWriter().println();
		getWriter().println("\\begin{document}");
		getWriter().println();
		
		List<Section> lclSections = getPacket().acquireSection(new ArrayList<>(getPacket().getSectionCount()));
		lclSections.sort(Section.StandardComparator.getInstance());
		Iterator<Section> lclSI = lclSections.iterator();
		while (lclSI.hasNext()) {
			Section lclSection = lclSI.next();
			
			List<Placement> lclPLs = lclSection.acquirePlacement(new ArrayList<>(lclSection.getPlacementCount()));
			lclPLs.sort(Placement.StandardComparator.getInstance());
			
			List<Pair<Placement, Placement>> lclPairs = new ArrayList<>(lclPLs.size() / 2 + 1);
			
			for (int lclI = 0; lclI < lclPLs.size(); lclI += 2) {
				Placement lclPL1 = lclPLs.get(lclI);
				Placement lclPL2 = lclI < lclPLs.size() - 1 ? lclPLs.get(lclI + 1) : null;
				
				Question lclQ1 = lclPL1.getQuestion(); // may be null
				if (lclQ1 != null) {
					Validate.isTrue(lclQ1.getQuestionType() == lclSection.getQuestionType(), "Question #" + lclQ1.getId() + " doesn't match its section's question type: question is " + lclQ1.getQuestionType().getCode() + "; section is " + lclQ1.getQuestionType().getCode());
					Validate.isTrue(lclQ1.getCategory() == lclPL1.getCategory(), "Question #" + lclQ1.getId() + " doesn't match its placement's category: placement is " + lclPL1.getCategory().getNameWithGroupName() + "; question is " + lclQ1.getCategory().getNameWithGroupName());
				}
				
				Question lclQ2 = lclPL2 == null ? null : lclPL2.getQuestion(); // may be null
				if (lclQ2 != null) {
					Validate.isTrue(lclQ2.getQuestionType() == lclSection.getQuestionType(), "Question #" + lclQ2.getId() + " doesn't match its section's question type: question is " + lclQ2.getQuestionType().getCode() + "; section is " + lclQ2.getQuestionType().getCode());
					Validate.isTrue(lclQ2.getCategory() == lclPL2.getCategory(), "Question #" + lclQ2.getId() + " doesn't match its placement's category (placement is " + lclPL2.getCategory().getNameWithGroupName() + "; question is " + lclQ2.getCategory().getNameWithGroupName());
				}
				
				lclPairs.add(Pair.of(lclPL1, lclPL2));
			}
			
			Iterator<Pair<Placement, Placement>> lclPI = lclPairs.iterator();
			while (lclPI.hasNext()) {
				Pair<Placement, Placement> lclPair = lclPI.next();
				
				Placement lclPL1 = lclPair.getLeft();
				Placement lclPL2 = lclPair.getRight(); // may be null
				
				Question lclQ1 = lclPL1.getQuestion(); // may be null
				Question lclQ2 = lclPL2 == null ? null : lclPL2.getQuestion(); // may be null
				
				String lclQ1Latex;
				String lclQ2Latex;
				
				if (lclSection.getQuestionType() == QuestionTypeFactory.TOSSUP()) {
					Tossup lclTU1 = (Tossup) lclQ1;
					if (lclTU1 == null) {
						lclQ1Latex = "";
					} else {
						lclQ1Latex =
							"\\tossup{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL1.getSequence() + ": " +
							escape(lclTU1.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTU1.getCategory().getName()) +
							"}{" + escape(lclTU1.getQuestionType().getScoringNote()) + "}{\n" +
								questionTextToLatex(lclTU1.getText()) +
							"\n}{\n" +
								answerLineToLatex(lclTU1.getAnswer()) +
							"\n}";
					}
					
					Tossup lclTU2 = (Tossup) lclQ2;
					if (lclTU2 == null) {
						lclQ2Latex = "";
					} else {
						lclQ2Latex =
							"\\tossup{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL2.getSequence() + ": " +
							escape(lclTU2.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTU2.getCategory().getName()) +
							"}{" + escape(lclTU2.getQuestionType().getScoringNote()) + "}{\n" +
								questionTextToLatex(lclTU2.getText()) +
							"\n}{\n" +
								answerLineToLatex(lclTU2.getAnswer()) +
							"\n}";
					}
				} else if (lclSection.getQuestionType() == QuestionTypeFactory.TEAM_QUESTION()) {
					TeamQuestion lclTQ1 = (TeamQuestion) lclQ1;
					if (lclTQ1 == null) {
						lclQ1Latex = "";
					} else {
						lclQ1Latex =
							"\\teamquestion{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL1.getSequence() + ": " +
							escape(lclTQ1.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTQ1.getCategory().getName()) +
							"}{" + escape(lclTQ1.getQuestionType().getScoringNote()) + "}{\n" +
								questionTextToLatex(lclTQ1.getIntroduction()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ1.getPart1Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ1.getPart1Answer()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ1.getPart2Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ1.getPart2Answer()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ1.getPart3Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ1.getPart3Answer()) +
							"\n}";
					}
					
					TeamQuestion lclTQ2 = (TeamQuestion) lclQ2;
					if (lclTQ2 == null) {
						lclQ2Latex = "";
					} else {
						lclQ2Latex =
							"\\teamquestion{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL2.getSequence() + ": " +
							escape(lclTQ2.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTQ2.getCategory().getName()) +
							"}{" + escape(lclTQ2.getQuestionType().getScoringNote()) + "}{\n" +
								questionTextToLatex(lclTQ2.getIntroduction()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ2.getPart1Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ2.getPart1Answer()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ2.getPart2Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ2.getPart2Answer()) +
							"\n}{\n" +
								questionTextToLatex(lclTQ2.getPart3Text()) +
							"\n}{\n" +
								answerLineToLatex(lclTQ2.getPart3Answer()) +
							"\n}";
					}
				} else {
					throw new IllegalStateException("Unknown question type (" + lclSection.getQuestionType().getCode() + ") for section #" + lclSection.getId());
				}
				
				getWriter().println("\\questionpage{" + escape(getPacketSet().getName()) + "}{" + escape(getPacket().getName()) + "}{" + escape(lclSection.getName()) + "}{" + lclSection.getQuestionType().getSectionHeader() + "}{\n" + lclQ1Latex + "\n}{\n" + lclQ2Latex + "\n}");
				getWriter().println();
			
				if (lclPI.hasNext()) {
					getWriter().println("\\newpage");
					getWriter().println();
				}
			}
			
			if (lclSI.hasNext()) {
				getWriter().println("\\newpage");
				getWriter().println();
			}
		}
		
		getWriter().println();
		
		getWriter().println("\\end{document}");
	}
}
