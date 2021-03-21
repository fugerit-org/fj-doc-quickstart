package org.fugerit.java.doc.quickstart.wlp;

import java.io.ByteArrayOutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.fugerit.java.doc.qs.doc.sample.FreemarkerDocSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/pdftest")
public class TestPdfService {

	private final static Logger logger = LoggerFactory.getLogger( TestPdfService.class );
	
	@GET
	@Produces("application/pdf")
    public Response pdftest() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FreemarkerDocSample.generateCharacterListPdf( baos );
			Response.ResponseBuilder responseBuilder = Response.ok(baos.toByteArray());
		    responseBuilder.type("application/pdf");
		    responseBuilder.header("Content-Disposition", "inline; filename=pdftest.pdf");
		    return responseBuilder.build();			
		} catch (Exception e) {
			logger.error( "Error : "+e, e );
	        return Response.status( 505 ).build();
		}
    }
}