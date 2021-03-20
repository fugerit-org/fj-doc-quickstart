package org.fugerit.java.fjdocquickstartdemoquarkus;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.facade.ProcessDocFacade;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.fugerit.java.doc.qs.data.sample.CharacterSample;
import org.fugerit.java.doc.qs.facade.QuickstartDocFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/pdftest")
public class FjDocQuickstartDemoQuarkusApp {

	private static final String CHAIN_ID = "character-table";

	private final static Logger logger = LoggerFactory.getLogger( FjDocQuickstartDemoQuarkusApp.class );
	
	private void generateDoc( OutputStream dest ) throws Exception {
		ProcessDocFacade docFacade = QuickstartDocFacade.getInstance();
		DocProcessContext context = DocProcessContext.newContext( "characterList" , CharacterSample.getDataSample() );
		SAXParseResult result = docFacade.process( CHAIN_ID, DocConfig.TYPE_PDF, context, dest, true );
		logger.info( "valid:{}", result.isPartialSuccess() );
	}

	@GET
	@Produces("application/pdf")
    public Response pdftest() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    this.generateDoc( baos );
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