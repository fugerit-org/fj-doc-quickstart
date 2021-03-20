package org.fugerit.java.fjdocquickstartdemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.facade.ProcessDocFacade;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.fugerit.java.doc.qs.data.sample.CharacterSample;
import org.fugerit.java.doc.qs.facade.QuickstartDocFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDocController {

	private static final String CHAIN_ID = "character-table";

	private final static Logger logger = LoggerFactory.getLogger( TestDocController.class );
	
	private void generateDoc( OutputStream dest ) throws Exception {
		ProcessDocFacade docFacade = QuickstartDocFacade.getInstance();
		DocProcessContext context = DocProcessContext.newContext( "characterList" , CharacterSample.getDataSample() );
		SAXParseResult result = docFacade.process( CHAIN_ID, DocConfig.TYPE_PDF, context, dest, true );
		logger.info( "valid:{}", result.isPartialSuccess() );
	}

	@RequestMapping(value = "/pdftest", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {
		try {
	        var headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=pdftest.pdf");
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        this.generateDoc( baos );
	        ByteArrayInputStream bis = new ByteArrayInputStream( baos.toByteArray() );
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));			
		} catch (Exception e) {
			logger.error( "Error : "+e, e );
	        return ResponseEntity
	                .status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
    }

}
