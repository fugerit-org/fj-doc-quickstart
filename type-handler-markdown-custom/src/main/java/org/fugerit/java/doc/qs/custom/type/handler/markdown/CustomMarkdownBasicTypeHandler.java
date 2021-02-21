package org.fugerit.java.doc.qs.custom.type.handler.markdown;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.model.DocBase;

/**
 * DocTypeHandler for markdown basic syntax : 
 * 
 * https://www.markdownguide.org/basic-syntax/
 * 
 * @see MarkdownExtDocFacade
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class CustomMarkdownBasicTypeHandler extends AbstractCustomMarkdownTypeHandler {
	
	public static final DocTypeHandler HANDLER = new CustomMarkdownBasicTypeHandler();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -73945133608L;

	@Override
	public void handle(DocInput docInput, DocOutput docOutput) throws Exception {
		PrintWriter writer = new PrintWriter( new OutputStreamWriter( docOutput.getOs() ) );
		DocBase docBase = docInput.getDoc();
		/*
		 * The key for building a DocTypeHandler is to correctly renders 
		 * the DocBase model in the desired output (DocPara, DocTable, DocList etc).
		 * Here we created a facade to do so : 
		 */
		MarkdownBasicDocFacade facade = new MarkdownBasicDocFacade( writer );
		facade.handleDoc( docBase );
	}

}