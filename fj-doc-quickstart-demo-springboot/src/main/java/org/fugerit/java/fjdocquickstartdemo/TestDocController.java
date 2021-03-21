package org.fugerit.java.fjdocquickstartdemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;
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

	private final static Logger logger = LoggerFactory.getLogger( TestDocController.class );

	@RequestMapping(value = "/pdftest", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdftest() {
		try {
	        var headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=pdftest.pdf");
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        FreemarkerDocSample.generateCharacterListPdf( baos );
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
