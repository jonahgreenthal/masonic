package com.masonic.output;

import java.io.File;

import org.apache.commons.lang3.Validate;

import com.masonic.application.Packet;
import com.masonic.application.PacketSet;
import com.masonic.MasonicConfiguration;
import com.masonic.Utility;

public abstract class PacketOutputter extends LaTeXOutputter {
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
						
						if (lclUnderlining && !lclInMath /* just left math */) {
							lclSB.append("}"); // end of \boldsymbol
						}
						
						lclSB.append(lclC);
						
						if (lclUnderlining && lclInMath /* just started math */) {
							lclSB.append("\\boldsymbol{");
						}
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
					if (lclInMath) {
						lclSB.append('_');
					} else {
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
