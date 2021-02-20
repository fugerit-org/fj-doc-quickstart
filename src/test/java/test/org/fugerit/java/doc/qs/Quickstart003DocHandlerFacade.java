package test.org.fugerit.java.doc.qs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Reader;

import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.facade.DocHandlerFacade;
import org.fugerit.java.doc.base.facade.DocHandlerFactory;
import org.fugerit.java.doc.qs.facade.QuickstartDocFacade;
import org.junit.Test;

/**
 * file: Quickstart003DocHandlerFacade.java
 * version : 001 (2021-02-20)
 * 
 * DocHandlerFacade is an entity holding mapping between output type and DocTypeHandler implementation.
 * This way it's possible to register a DocTypeHandler for the needed output types instead of always providing a specific DocTypeHandler.
 * 
 * Goal : 	this example shows how to create and use a DocHandlerFacade.
 * 
 * Maven dependancies : 
 * org.fugerit.java/fj-core
 * org.fugerit.java/fj-doc-base
 * org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
 * org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)
 * 
 * @see TestBase for common specs of the quickstart examples
 * @see org.fugerit.java.doc.base.facade.SimpleDocFacade
 * @see /fj-doc-quickstart/docs/quickstart/002HelloWorld.md
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class Quickstart003DocHandlerFacade extends TestBase {

	/*
	 *	Path of the input xml doc.
	 *  prefix 'cl://' loads from classloader
	 *  prefix 'file://' loads from file 
	 */
	public static final String PATH_STATIC_DATA_TABLE = "cl://sample-doc-xml/Quickstart003/static-data-table.xml";

	/*
	 *  In : QuickstartDocFacade.PATH_DOC_HANDLER_FACTORY_CONFIG
	 *  Is defined a factory for all the handlers we want to configure : 

	<factory id="quickstart-default">
		<data id="xml-doc" info="xml" type="org.fugerit.java.doc.base.config.DocTypeHandlerXML" />
		<data id="fo-fop" info="fo" type="org.fugerit.java.doc.mod.fop.FreeMarkerFopTypeHandler" />
		<data id="pdf-fop" info="pdf" type="org.fugerit.java.doc.mod.fop.PdfFopTypeHandler"/>
		<data id="fo-fop" info="fo" type="org.fugerit.java.doc.mod.fop.FreeMarkerFopTypeHandler" />
		<data id="html-fm" info="html" type="org.fugerit.java.doc.freemarker.html.FreeMarkerHtmlTypeHandler" />		
	</factory>
	
	 * So we can access a specific handler just by its "info" attribute
	 */
	
	private void generateDoc( String type, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		// note that the source XML document is always the same
		try ( Reader reader = this.loadFromClassLoader( PATH_STATIC_DATA_TABLE );
				FileOutputStream dest = new FileOutputStream( destFile ) ) {
			DocHandlerFactory factory = DocHandlerFactory.newInstance( QuickstartDocFacade.PATH_DOC_HANDLER_FACTORY_CONFIG );
			DocHandlerFacade facade = factory.get( QuickstartDocFacade.CATALOG_ID );
			facade.direct( reader , type, dest );
			logger.info( "dest -> {}", destFile.getCanonicalPath() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testPdf() {
		String type = DocConfig.TYPE_PDF; // "pdf"
		this.generateDoc( type , "static-data-table.pdf" );
	}
	
	@Test
	public void testHtml() {
		String type = DocConfig.TYPE_HTML; // "html"
		this.generateDoc( type , "static-data-table.html" );
	}

}
