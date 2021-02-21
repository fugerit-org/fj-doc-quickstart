package org.fugerit.java.doc.qs.custom.type.handler.fop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.fugerit.java.core.cfg.ConfigException;
import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.w3c.dom.Element;

public class CustomPdfFopTypeHandler extends FreeMarkerFopTypeHandler {

	public static final DocTypeHandler HANDLER = new CustomPdfFopTypeHandler();
	
	public static final boolean DEFAULT_ACCESSIBILITY = true;
	
	public static final boolean DEFAULT_KEEP_EMPTY_TAGS = false;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7394516771708L;

	private boolean accessibility;
	
	private boolean keepEmptyTags;
	
	private FopConfig fopConfig;
	
	public CustomPdfFopTypeHandler( FopConfig fopConfig, boolean accessibility, boolean keepEmptyTags ) {
		super( DocConfig.TYPE_PDF );
		this.fopConfig = fopConfig;
		this.accessibility = accessibility;
		this.keepEmptyTags = keepEmptyTags;
	}
	
	public CustomPdfFopTypeHandler( boolean accessibility, boolean keepEmptyTags ) {
		this( FopConfigDefault.DEFAULT, accessibility, keepEmptyTags );
	}
	
	public CustomPdfFopTypeHandler() {
		this( DEFAULT_ACCESSIBILITY, DEFAULT_KEEP_EMPTY_TAGS );
	}

	@Override
	public void handle(DocInput docInput, DocOutput docOutput) throws Exception {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		DocOutput bufferOutput = DocOutput.newOutput( buffer );
		super.handle(docInput, bufferOutput);
		// the XML file which provides the input
		StreamSource xmlSource = new StreamSource( new InputStreamReader( new ByteArrayInputStream( buffer.toByteArray() ) ) );
		// create an instance of fop factory
		FopFactory fopFactory = this.fopConfig.newFactory();
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		foUserAgent.setAccessibility( this.isAccessibility() );
		foUserAgent.setKeepEmptyTags( this.isKeepEmptyTags() );
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, docOutput.getOs());
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		Result res = new SAXResult(fop.getDefaultHandler());
		transformer.transform(xmlSource, res);
	}

	public boolean isAccessibility() {
		return accessibility;
	}

	public boolean isKeepEmptyTags() {
		return keepEmptyTags;
	}

	public FopConfig getFopConfig() {
		return fopConfig;
	}

	public void setFopConfig(FopConfig fopConfig) {
		this.fopConfig = fopConfig;
	}

	@Override
	public void configure(Element tag) throws ConfigException {
		// this custom type handler has no custom configuration
	}
	
}