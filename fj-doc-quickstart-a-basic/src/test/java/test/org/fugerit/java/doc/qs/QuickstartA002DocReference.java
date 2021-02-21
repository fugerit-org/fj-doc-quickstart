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
 * file: QuickstartA002DocReference.java
 * version : 001 (2021-02-19)
 * 
 * Doc Referece example (containing headings, paragraphs, phrases, table and list)
 * 
 * Goal : 	this example shows some of the elements accepted for source xml doc.
 * 			rendering is identycal to HelloWorld example.
 * 
 * Maven dependancies : 
 * org.fugerit.java/fj-core
 * org.fugerit.java/fj-doc-base
 * org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
 * org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)
 * 
 * @see TestBase for common specs of the quickstart examples
 * @see org.fugerit.java.doc.base.facade.SimpleDocFacade
 * @see /fj-doc-quickstart/docs/quickstart/A002HelloWorld.md
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class QuickstartA002DocReference extends TestBase {

	/*
	 *	Path of the input xml doc.
	 *  prefix 'cl://' loads from classloader
	 *  prefix 'file://' loads from file 
	 */
	public static final String PATH_DOC_REFERENCE = "cl://sample-doc-xml/QuickstartA002/doc-reference.xml";

	private void generateDoc( DocTypeHandler typeHandler, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		// note that the source XML document is always the same
		try ( Reader reader = this.loadFromClassLoader( PATH_DOC_REFERENCE );
				FileOutputStream dest = new FileOutputStream( destFile ) ) {
			SimpleDocFacade.produce( typeHandler , reader, dest );
			logger.info( "dest -> {}", destFile.getCanonicalPath() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testPdfFop() {
		this.generateDoc( PdfFopTypeHandler.HANDLER , "doc-reference-fop.pdf" );
	}
	
	@Test
	public void testHtmlFreemarker() {
		this.generateDoc( FreeMarkerHtmlTypeHandler.HANDLER , "doc-reference-freemarker.html" );
	}

}
