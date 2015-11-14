package com.masonic.output;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

import com.masonic.application.Packet;
import com.masonic.application.PacketSet;
import com.masonic.application.Placement;
import com.masonic.application.Question;
import com.masonic.application.QuestionTypeFactory;
import com.masonic.application.Section;
import com.masonic.application.TeamQuestion;
import com.masonic.application.Tossup;
import com.masonic.MasonicConfiguration;
import com.masonic.Utility;

public class PacketOutputter extends LaTeXOutputter {
	private final Packet myPacket;
	
	public PacketOutputter(final Packet argPacket) {
		super(makeFile(argPacket));
		
		myPacket = argPacket; // null-checked by makeFile()
	}
	
	public Packet getPacket() {
		return myPacket;
	}
	
	public PacketSet getPacketSet() {
		return getPacket().getPacketSet();
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
				
				Validate.isTrue(lclPL1.isFilled());
				Validate.isTrue(lclPL2 == null || lclPL2.isFilled());
				
				Question lclQ1 = Validate.notNull(lclPL1.getQuestion());
				Question lclQ2 = lclPL2 == null ? null : Validate.notNull(lclPL2.getQuestion());
				
				Validate.isTrue(lclQ1.getQuestionType() == lclSection.getQuestionType(), "Question #" + lclQ1.getId() + " doesn't match its section's question type: question is " + lclQ1.getQuestionType().getCode() + "; section is " + lclQ1.getQuestionType().getCode());
				Validate.isTrue(lclQ1.getCategory() == lclPL1.getCategory(), "Question #" + lclQ1.getId() + " doesn't match its placement's category: placement is " + lclPL1.getCategory().getNameWithGroupName() + "; question is " + lclQ1.getCategory().getNameWithGroupName());
				
				
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
				
				Question lclQ1 = Validate.notNull(lclPL1.getQuestion());
				Question lclQ2 = lclPL2 == null ? null : Validate.notNull(lclPL2.getQuestion());
				
				String lclQ1Latex;
				String lclQ2Latex;
				
				if (lclSection.getQuestionType() == QuestionTypeFactory.TOSSUP()) {
					Tossup lclTU1 = (Tossup) lclQ1;
					lclQ1Latex =
						"\\tossup{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL1.getSequence() + ": " +
						escape(lclTU1.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTU1.getCategory().getName()) +
						"}{" + escape(lclTU1.getQuestionType().getScoringNote()) + "}{" +
							questionTextToLatex(lclTU1.getText()) +
						"}{" +
							answerLineToLatex(lclTU1.getAnswer()) +
						"}";
					
					Tossup lclTU2 = (Tossup) lclQ2;
					if (lclTU2 == null) {
						lclQ2Latex = "";
					} else {
						lclQ2Latex =
							"\\tossup{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL2.getSequence() + ": " +
							escape(lclTU2.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTU2.getCategory().getName()) +
							"}{" + escape(lclTU2.getQuestionType().getScoringNote()) + "}{" +
								questionTextToLatex(lclTU2.getText()) +
							"}{" +
								answerLineToLatex(lclTU2.getAnswer()) +
							"}";
					}
				} else if (lclSection.getQuestionType() == QuestionTypeFactory.TEAM_QUESTION()) {
					TeamQuestion lclTQ1 = (TeamQuestion) lclQ1;
					lclQ1Latex =
						"\\teamquestion{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL1.getSequence() + ": " +
						escape(lclTQ1.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTQ1.getCategory().getName()) +
						"}{" + escape(lclTQ1.getQuestionType().getScoringNote()) + "}{" +
							questionTextToLatex(lclTQ1.getIntroduction()) +
						"}{" +
							questionTextToLatex(lclTQ1.getPart1Text()) +
						"}{" +
							answerLineToLatex(lclTQ1.getPart1Answer()) +
						"}{" +
							questionTextToLatex(lclTQ1.getPart2Text()) +
						"}{" +
							answerLineToLatex(lclTQ1.getPart2Answer()) +
						"}{" +
							questionTextToLatex(lclTQ1.getPart3Text()) +
						"}{" +
							answerLineToLatex(lclTQ1.getPart3Answer()) +
						"}";
					
					TeamQuestion lclTQ2 = (TeamQuestion) lclQ2;
					if (lclTQ2 == null) {
						lclQ2Latex = "";
					} else {
						lclQ2Latex =
							"\\teamquestion{" + (lclSection.isExtras() ? "Extra Question" : "Question") + " \\#" + lclPL2.getSequence() + ": " +
							escape(lclTQ2.getCategory().getCategoryGroup().getName()) + " -- " + escape(lclTQ2.getCategory().getName()) +
							"}{" + escape(lclTQ2.getQuestionType().getScoringNote()) + "}{" +
								questionTextToLatex(lclTQ2.getIntroduction()) +
							"}{" +
								questionTextToLatex(lclTQ2.getPart1Text()) +
							"}{" +
								answerLineToLatex(lclTQ2.getPart1Answer()) +
							"}{" +
								questionTextToLatex(lclTQ2.getPart2Text()) +
							"}{" +
								answerLineToLatex(lclTQ2.getPart2Answer()) +
							"}{" +
								questionTextToLatex(lclTQ2.getPart3Text()) +
							"}{" +
								answerLineToLatex(lclTQ2.getPart3Answer()) +
							"}";
					}
				} else {
					throw new IllegalStateException("Unknown question type (" + lclSection.getQuestionType().getCode() + ") for section #" + lclSection.getId());
				}
				
				getWriter().println("\\questionpage{" + escape(getPacketSet().getName()) + "}{" + escape(getPacket().getName()) + "}{" + escape(lclSection.getName()) + "}{" + lclSection.getQuestionType().getSectionHeader() + "}{" + lclQ1Latex + "}{ " + lclQ2Latex + "}");
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
	
	/* package */ static String makeFilename(Packet argP) {
		Validate.notNull(argP);
		
		return Utility.cleanFilename(argP.getPacketSet().getShortName() + ' ' + argP.getName()) + ".tex";
	}
	
	protected static File makeFile(Packet argP) {
		Validate.notNull(argP);
		
		return new File(MasonicConfiguration.getInstance().getString("DATA_DIRECTORY") + File.separator + MasonicConfiguration.getInstance().getString("OUTPUTTED_PACKETS_SUBDIRECTORY") + File.separator + makeFilename(argP));
	}
	
	public static String questionTextToLatex(String argQuestionText) {
		Validate.notNull(argQuestionText);
		
		StringBuilder lclSB = new StringBuilder(argQuestionText.length() + 100); // half-assed guess
		
		boolean lclInItalics = false;
		boolean lclInDoubleQuotes = false;
		boolean lclUnderlining = false;
		boolean lclInMath = false;
		
		char lclPrev = ' ';
		for (char lclC : argQuestionText.toCharArray()) {
			switch (lclC) {
				case '$':
					if (lclPrev == '\\') {
						lclSB.append(lclC);
					} else {
						lclInMath = !lclInMath;
						lclSB.append(lclC);
					}
					break;
				case '~':
					if (lclPrev == '\\') {
						lclSB.append(lclC);
					} else {
						if (lclInItalics) {
							lclSB.append('}');
							lclInItalics = false;
						} else {
							lclSB.append("\\textit{");
							lclInItalics = true;
						}
					}
					break;
				
				case '"':
					if (lclPrev == '\\') {
						lclSB.append(lclC);
					} else {
						if (lclInDoubleQuotes) {
							lclSB.append("''");
							lclInDoubleQuotes = false;
						} else {
							lclSB.append("``");
							lclInDoubleQuotes = true;
						}
					}
					break;
				
				case '_':
					if (!lclInMath) {
						if (lclUnderlining) {
							lclSB.append('}');
							lclUnderlining = false;
						} else {
							lclSB.append("\\req{");
							lclUnderlining = true;
						}
					}
					break;
				
				default:
					lclSB.append(lclC);
			}
			
			lclPrev = lclC;
		}
		
		return lclSB.toString().trim();
	}
	
	public static String answerLineToLatex(String argAnswerLine) {
		Validate.notNull(argAnswerLine);
		
		return questionTextToLatex(argAnswerLine);
	}
}
