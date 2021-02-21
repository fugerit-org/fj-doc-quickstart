package test.org.fugerit.java.doc.qs;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogging {

	private static final Logger logger = LoggerFactory.getLogger( TestLogging.class );
	
	@Test
	public void testLogging() {
		logger.info( "logging is working" );
	}

}
