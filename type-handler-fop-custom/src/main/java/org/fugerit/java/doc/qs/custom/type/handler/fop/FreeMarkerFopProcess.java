package org.fugerit.java.doc.qs.custom.type.handler.fop;

import java.io.Serializable;

import org.fugerit.java.doc.base.process.DocProcessConfig;

public class FreeMarkerFopProcess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1277168639030295400L;

	public static final String CONFIG_PATH = "cl://custom_fm_fop/fop-process-config.xml";
	
	private static DocProcessConfig INSTANCE = DocProcessConfig.loadConfigSafe( CONFIG_PATH );

	public static DocProcessConfig getInstance() {
		return INSTANCE;
	}
	
}
