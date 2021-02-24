package test.org.fugerit.java.doc.qs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuickstartB001ProcessDocFacade.class, 
	QuickstartB002CustomFreeMarkerMethod.class,
	QuickstartB003EmbedBase64Image.class})
public class TestSuite {

}
