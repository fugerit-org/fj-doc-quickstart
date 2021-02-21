package test.org.fugerit.java.doc.qs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Reader;

import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.facade.SimpleDocFacade;
import org.fugerit.java.doc.mod.fop.PdfFopTypeHandler;
import org.fugerit.java.doc.qs.custom.type.handler.fop.CustomPdfFopTypeHandler;
import org.junit.Test;

/**
 * file: QuickstartC001CustomFopTypeHandler.java
 * version : 001 (2021-02-21)
 * 
 * It's possible to create and add custom doc type handler for existing types.
 * 
 * Goal : 	this example shows how to extend an existing doc type handler and compare the output documents.
 * 
 * Maven dependancies : 
 * org.fugerit.java/fj-core
 * org.fugerit.java/fj-doc-base
 * org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
 * org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)
 * org.fugerit.java/type-handler-fop-custom	(our new custom fop pdf type handler created as a maven jar module)
 * 
 * @see TestBase for common specs of the quickstart examples
 * @see org.fugerit.java.doc.base.facade.SimpleDocFacade
 * @see /fj-doc-quickstart/docs/quickstart/002HelloWorld.md
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class QuickstartC001CustomFopTypeHandler extends TestBase {

	/*
	 *	Path of the input xml doc.
	 *  prefix 'cl://' loads from classloader
	 *  prefix 'file://' loads from file 
	 */
	public static final String PATH_STATIC_DATA_SAMPLE_01 = "cl://sample-doc-xml/QuickstartC001/static-data-sample-01.xml";
	
	private void generateDoc( DocTypeHandler typeHandler, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		// note that the source XML document is always the same
		try ( Reader reader = this.loadFromClassLoader( PATH_STATIC_DATA_SAMPLE_01 );
				FileOutputStream dest = new FileOutputStream( destFile ) ) {
			SimpleDocFacade.produce( typeHandler , reader, dest );
			logger.info( "dest -> {}", destFile.getCanonicalPath() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testPdfFop() {
		this.generateDoc( PdfFopTypeHandler.HANDLER , "dstatic-data-sample-01-fop-core.pdf" );
	}
	
	@Test
	public void testCustomPdfFop() {
		/*
		 *  org.fugerit.java.doc.qs.custom.type.handler.fop.CustomPdfFopTypeHandler
		 */
		this.generateDoc( CustomPdfFopTypeHandler.HANDLER , "static-data-sample-01-fop-custom.pdf" );
	}

}
