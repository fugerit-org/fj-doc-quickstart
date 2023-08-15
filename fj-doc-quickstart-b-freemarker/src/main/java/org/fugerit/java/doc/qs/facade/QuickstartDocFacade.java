package org.fugerit.java.doc.qs.facade;

import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfig;
import org.fugerit.java.doc.freemarker.process.FreemarkerDocProcessConfigFacade;

public class QuickstartDocFacade {

	public final static String PATH_DOC_PROCESS_CONFIG = "cl://doc-facade/fm-quickstart-process-config.xml";
	
	private static FreemarkerDocProcessConfig INSTANCE = FreemarkerDocProcessConfigFacade.loadConfigSafe( PATH_DOC_PROCESS_CONFIG );

	public static FreemarkerDocProcessConfig getInstance() {
		return INSTANCE;
	}

}
