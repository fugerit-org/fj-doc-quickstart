package org.fugerit.java.doc.quickstart.wlp;

import java.io.ByteArrayOutputStream;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
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