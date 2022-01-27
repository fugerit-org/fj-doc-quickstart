package test.org.fugerit.java.doc.qs;

import java.io.File;
import java.io.FileOutputStream;

import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.facade.ProcessDocFacade;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.fugerit.java.doc.qs.data.sample.CharacterSample;
import org.fugerit.java.doc.qs.facade.QuickstartDocFacade;
import org.junit.Test;

/**
 * file: QuickstartB004ComplexProcessStep.java
 * version : 001 (2021-02-24)
 * 
 * It is possible to use a more compact chain configuration
 * 
 * Goal : 	this example is very similar to QuickstartB003 but with a more compact chain configuration.
 * 			
 * 
 * Maven dependancies : 
 * org.fugerit.java/fj-core
 * org.fugerit.java/fj-doc-base
 * org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
 * org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)
 * 
 * @see TestBase for common specs of the quickstart examples
 * @see org.fugerit.java.doc.base.facade.ProcessDocFacade
 * @see https://freemarker.apache.org/docs/ref_builtins.html for build in free marker functions
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class QuickstartB005DocMetaData extends TestBase {

	/**
	 * Name of the chain configured in out DocProcessConfig
	 */
	public static final String CHAIN_ID = "doc-meta-data";

	private void generateDoc( String type, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		ProcessDocFacade docFacade = QuickstartDocFacade.getInstance();
		DocProcessContext context = DocProcessContext.newContext( "characterList" , CharacterSample.getDataSample() );
		try ( FileOutputStream dest = new FileOutputStream( destFile ) ) {
			SAXParseResult result = docFacade.process( CHAIN_ID, type, context, dest, true );
			logger.info( "dest -> {} (valid:{})", destFile.getCanonicalPath(), result.isPartialSuccess() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testPdf() {
		String type = DocConfig.TYPE_PDF; // "pdf"
		this.generateDoc( type , CHAIN_ID+"."+type );
	}
	
	@Test
	public void testHtml() {
		String type = DocConfig.TYPE_HTML; // "html"
		this.generateDoc( type , CHAIN_ID+"."+type );
	}
	
	@Test
	public void testXml() {
		/*
		 * When using a free marker template, it could be useful to generate the static XML source after the template has been applied.
		 */
		String type = DocConfig.TYPE_XML; // "xml"
		this.generateDoc( type , CHAIN_ID+"."+type );
	}	
	
	@Test
	public void testFo() {
		/*
		 * When using a PDF FOP DocTypeHandler, could be useful to produces the XSL-FO source after the free marker template has been applied.
		 */
		String type = DocConfig.TYPE_FO; // "fo
		this.generateDoc( type , CHAIN_ID+"."+type );
	}
	
}
