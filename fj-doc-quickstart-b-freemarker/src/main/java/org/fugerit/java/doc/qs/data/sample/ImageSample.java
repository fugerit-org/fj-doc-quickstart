package org.fugerit.java.doc.qs.data.sample;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.fugerit.java.core.io.StreamIO;

public class ImageSample {

	public static final String URL_IMG_DYNAMIC_PIPELINE = "https://venusdocs.fugerit.org/docs/img/102_dynamic_pipeline.gif";
	
	public static String getBase64ImgDynamicPipeline() throws Exception {
		return getBase64FromUrl( URL_IMG_DYNAMIC_PIPELINE );
	}
	
	public static String getBase64FromUrl( String url ) throws Exception {
		String base64 = null;
		if ( url != null ) {
			URL u = new URL( url );
			URLConnection uc = u.openConnection();
			try ( InputStream is = uc.getInputStream() ) {
				byte[] data = StreamIO.readBytes( is );
				base64 = Base64.getEncoder().encodeToString( data );
			}
		}
		return base64;
	}
	
}
