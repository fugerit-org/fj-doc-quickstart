package test.org.fugerit.java.doc.qs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Reader;

import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.facade.SimpleDocFacade;
import org.fugerit.java.doc.freemarker.html.FreeMarkerHtmlTypeHandler;
import org.fugerit.java.doc.mod.fop.PdfFopTypeHandler;
import org.junit.Test;

/**
 * file: QuickstartA001HelloWorld.java
 * version : 001 (2021-02-18)
 * 
 * Hellow World example for fugerit doc library (Venus)
 * 
 * Goal : 	fj-doc is basically as set of A.P.I. for producing documents in various formats from a xml doc meta model.
 * 			this example will use the simpliest way of doing that, with no configuration at all.
 * 			org.fugerit.java.doc.base.facade.SimpleDocFacade will be used.
 * 			This facade let's you select three parameters : 
 * 			1) output format (as an implementation of org.fugerit.java.doc.base.config.DocTypeHandler)
 * 			2) input xml (in this example as resource in class loader)
 * 			3) destination file (in this example starting at 'target')
 * 
 * Maven dependancies : 
 * org.fugerit.java/fj-core
 * org.fugerit.java/fj-doc-base
 * org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
 * org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)
 * 
 * @see TestBase for common specs of the quickstart examples
 * @see org.fugerit.java.doc.base.facade.SimpleDocFacade
 * @see /fj-doc-quickstart/docs/quickstart/A001HelloWorld.md
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class QuickstartA001HelloWorld extends TestBase {

	/*
	 *	Path of the input xml doc.
	 *  prefix 'cl://' loads from classloader
	 *  prefix 'file://' loads from file 
	 */
	public static final String PATH_HELLO_WORLD = "cl://sample-doc-xml/QuickstartA001/hello-world.xml";

	private void generateHelloWorld( DocTypeHandler typeHandler, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		// note that the source XML document is always the same
		try ( Reader reader = this.loadFromClassLoader( PATH_HELLO_WORLD );
				FileOutputStream dest = new FileOutputStream( destFile ) ) {
			SimpleDocFacade.produce( typeHandler , reader, dest );
			logger.info( "dest -> {}", destFile.getCanonicalPath() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testPdfFop() {
		this.generateHelloWorld( PdfFopTypeHandler.HANDLER , "hellow-world-fop.pdf" );
	}
	
	@Test
	public void testHtmlFreemarker() {
		this.generateHelloWorld( FreeMarkerHtmlTypeHandler.HANDLER , "hellow-world-freemarker.html" );
	}

}
