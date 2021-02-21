package org.fugerit.java.doc.qs.custom.type.handler.markdown;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.model.DocBase;

/**
 * DocTypeHandler for markdown extended syntax : 
 * 
 * https://www.markdownguide.org/extended-syntax/
 * 
 * @see MarkdownExtDocFacade
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 *
 */
public class CustomMarkdownExtTypeHandler extends AbstractCustomMarkdownTypeHandler {

	public static final DocTypeHandler HANDLER = new CustomMarkdownExtTypeHandler();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7394541608L;

	@Override
	public void handle(DocInput docInput, DocOutput docOutput) throws Exception {
		PrintWriter writer = new PrintWriter( new OutputStreamWriter( docOutput.getOs() ) );
		DocBase docBase = docInput.getDoc();
		/*
		 * The key for building a DocTypeHandler is to correctly renders 
		 * the DocBase model in the desired output (DocPara, DocTable, DocList etc).
		 * Here we created a facade to do so : 
		 */
		MarkdownExtDocFacade facade = new MarkdownExtDocFacade( writer );
		facade.handleDoc( docBase );
	}

}