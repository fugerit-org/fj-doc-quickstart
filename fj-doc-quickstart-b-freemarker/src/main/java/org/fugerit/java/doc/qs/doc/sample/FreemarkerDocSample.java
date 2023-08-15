package org.fugerit.java.doc.qs.doc.sample;

import java.io.OutputStream;

import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfig;
import org.fugerit.java.doc.qs.data.sample.CharacterSample;
import org.fugerit.java.doc.qs.facade.QuickstartDocFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FreemarkerDocSample {

	private static final String CHAIN_ID = "character-table";

	private final static Logger logger = LoggerFactory.getLogger( FreemarkerDocSample.class );
	
	public static void generateCharacterListPdf( OutputStream dest ) throws Exception {
		FreemarkerDocProcessConfig docFacade = QuickstartDocFacade.getInstance();
		DocProcessContext context = DocProcessContext.newContext( "characterList" , CharacterSample.getDataSample() );
		SAXParseResult result = docFacade.process( CHAIN_ID, DocConfig.TYPE_PDF, context, dest, true );
		logger.info( "valid:{}", result.isPartialSuccess() );
	}
	
}
