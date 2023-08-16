package org.fugerit.java.fjdocquickstartdemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestDocController {
	
	@GetMapping( value = "/pdftest", produces = MediaType.APPLICATION_PDF_VALUE )
    public ResponseEntity<InputStreamResource> pdftest() {
		try {
	        var headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=pdftest.pdf");
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        FreemarkerDocSample.generateCharacterListPdf( baos );
	        byte[] data = baos.toByteArray();
	        ByteArrayInputStream bis = new ByteArrayInputStream( data );
	        log.info( "test pdf OK : {}", data.length );
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));			
		} catch (Exception e) {
			log.error( "Error : "+e, e );
	        return ResponseEntity
	                .status( HttpServletResponse.SC_INTERNAL_SERVER_ERROR ).build();
		}
    }

}
