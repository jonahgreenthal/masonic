package com.masonic.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;

import com.siliconage.util.Fast3Set;

import com.masonic.application.Account;
import com.masonic.application.Packet;
import com.masonic.application.PacketFactory;
import com.masonic.application.PacketSet;
import com.masonic.servlets.DownloadServlet;
import com.masonic.Utility;

public class OutputPacket extends DownloadServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String MIME_TYPE_PDF = "application/pdf";
	public static final String MIME_TYPE_ZIP = "application/zip";
	
	@Override
	protected Download makeDownload(final HttpServletRequest argRequest, final Account argUser) {
		final Collection<Packet> lclPackets = Validate.notEmpty(
			PacketFactory.getInstance().multipleFromHttpRequest(argRequest),
			"No packets specified to output"
		);
		
		String lclFilename;
		String lclMimeType;
		
		if (lclPackets.size() == 1) {
			lclFilename = PacketOutputter.makeFilename(lclPackets.iterator().next());
			lclMimeType = MIME_TYPE_PDF;
		} else {
			lclMimeType = MIME_TYPE_ZIP;
			
			Set<PacketSet> lclPSes = lclPackets.stream()
				.map(Packet::getPacketSet)
				.distinct()
				.collect(Collectors.toCollection(Fast3Set::new));
			Validate.notEmpty(lclPSes);
			if (lclPSes.size() == 1) {
				lclFilename = Utility.cleanFilename(lclPSes.iterator().next().getShortName()) + ".zip";
			} else {
				lclFilename = "masonic-bowl-packets.zip";
			}
		}
		
		List<LaTeXOutputter> lclOutputters = lclPackets.stream()
			.sorted(Packet.StandardComparator.getInstance())
			.map(argP -> new PacketOutputter(argP))
			.collect(Collectors.toList());
		
		final List<File> lclFiles = new ArrayList<>(lclOutputters.size());
		
		for (LaTeXOutputter lclO : lclOutputters) {
			lclO.output();
			
			final LaTeXCompiler lclC = new LaTeXCompiler(lclO);
			final File lclPDF = lclC.compile();
			
			lclFiles.add(lclPDF);
		}
		
		if (lclFiles.size() == 1) {
			final File lclF = lclFiles.get(0);
			return new Download(lclF, lclMimeType, lclFilename);
		} else {
			final File lclZipFile = new File(lclFilename);
			try (FileOutputStream lclFOS = new FileOutputStream(lclZipFile)) {
				try (ZipOutputStream lclZOS = new ZipOutputStream(lclFOS)) {
					for (final File lclF : lclFiles) {
						final ZipEntry lclZE = new ZipEntry(lclF.getName());
						lclZOS.putNextEntry(lclZE);
						
						try (BufferedInputStream lclBIS = new BufferedInputStream(new FileInputStream(lclF))) {
							int lclRead;
							while ((lclRead = lclBIS.read()) != -1) {
								lclZOS.write(lclRead);
							}
						}
						
						lclZOS.closeEntry();
					}
				}
				
				return new Download(lclZipFile, lclMimeType, lclZipFile.getName());
			} catch (IOException lclIOE) {
				throw new IllegalStateException(lclIOE);
			}
		}
	}
}
