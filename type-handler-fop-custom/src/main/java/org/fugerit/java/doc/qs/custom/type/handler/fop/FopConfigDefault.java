package org.fugerit.java.doc.qs.custom.type.handler.fop;

import java.io.File;
import java.io.Serializable;

import org.apache.fop.apps.FopFactory;

public class FopConfigDefault implements Serializable, FopConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 142423475475L;

	@Override
	public FopFactory newFactory() throws Exception {
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		return fopFactory;
	}

	public static final FopConfig DEFAULT = new FopConfigDefault();

}
