package test.org.fugerit.java.doc.qs;

import java.io.File;
import java.io.FileOutputStream;

import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.process.DocProcessContext;
import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfig;
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
public class QuickstartB006SimpleMarkdown extends TestBase {

	/**
	 * Name of the chain configured in out DocProcessConfig
	 */
	public static final String CHAIN_ID = "simple-markdown";

	private void generateDoc( String type, String fileName ) {
		File destFile = this.getOutputFile( fileName );
		FreemarkerDocProcessConfig docFacade = QuickstartDocFacade.getInstance();
		DocProcessContext context = DocProcessContext.newContext( "characterList" , CharacterSample.getDataSample() );
		try ( FileOutputStream dest = new FileOutputStream( destFile ) ) {
			SAXParseResult result = docFacade.process( CHAIN_ID, type, context, dest, true );
			logger.info( "dest -> {} (valid:{})", destFile.getCanonicalPath(), result.isPartialSuccess() );
		} catch (Exception e) {
			this.handleFailError( e );
		}
	}
	
	@Test
	public void testMd() {
		String type = DocConfig.TYPE_MD; // "md"
		this.generateDoc( type , CHAIN_ID+"."+type );
	}
	
}
