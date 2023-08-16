package org.fugerit.java.fjdocquickstartdemoquarkus;

import java.io.ByteArrayOutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/pdftest")
public class TestPdfService {

	@GET
	@Produces("application/pdf")
    public Response pdftest() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FreemarkerDocSample.generateCharacterListPdf( baos );
			byte[] data = baos.toByteArray();
			log.info( "test pdf OK : {}", data.length );
			Response.ResponseBuilder responseBuilder = Response.ok(data);
		    responseBuilder.type("application/pdf");
		    responseBuilder.header("Content-Disposition", "inline; filename=pdftest.pdf");
		    return responseBuilder.build();			
		} catch (Exception e) {
			log.error( "Error : "+e, e );
	        return Response.status( 505 ).build();
		}
    }
}