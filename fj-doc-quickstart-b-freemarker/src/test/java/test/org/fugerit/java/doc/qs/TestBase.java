package test.org.fugerit.java.doc.qs;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.fugerit.java.core.io.helper.StreamHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * file: TestBase.java
 * version : 001 (2021-02-18)
 * 
 * Basic class for other test case in this quickstart project
 * 
 * The way of loading source and writing output is just an example an should be customized in your software.
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class TestBase {

	protected static final Logger logger = LoggerFactory.getLogger( TestBase.class );
	
	public final static String BASE_DIR = "target";
	
	/**
	 * Calculate the output File from a file name.
	 * 
	 * the base dire from the file is : 
	 * target/${QuickstartXXX}.getClass.getSimpleName()/fileName
	 * 
	 * @param fileName	the name of the file
	 * @return	the file
	 */
	protected File getOutputFile( String fileName ) {
		File baseDir = new File( BASE_DIR );
		File outputDir = new File( baseDir, this.getClass().getSimpleName() );
		outputDir.mkdirs();
		File destFile = new File( outputDir, fileName );
		return destFile;
	}
	
	/**
	 * 	Load an input as a Reader from a path
	 * 
	 *	Path of the input xml doc.
	 *  prefix 'cl://' loads from classloader
	 *  prefix 'file://' loads from file 
	 * 
	 * @param path	source path
	 * @return		the Reader
	 * @throws Exception	in case of problems
	 */
	protected Reader loadFromClassLoader( String path ) throws Exception {
		return new InputStreamReader( StreamHelper.resolveStream( path ) );
	}
	
	/**
	 * Default exception handling
	 * 
	 * @param e	the exception
	 */
	protected void handleFailError( Exception e ) {
		String message = "Error : "+e;
		logger.error( message, e );
		fail( message );
	}
	
}
