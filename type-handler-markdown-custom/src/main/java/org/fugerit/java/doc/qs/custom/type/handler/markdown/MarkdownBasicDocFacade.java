package org.fugerit.java.doc.qs.custom.type.handler.markdown;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.fugerit.java.doc.base.helper.DocTypeFacadeDefault;
import org.fugerit.java.doc.base.helper.DocTypeFacadeHelper;
import org.fugerit.java.doc.base.model.DocBase;
import org.fugerit.java.doc.base.model.DocCell;
import org.fugerit.java.doc.base.model.DocContainer;
import org.fugerit.java.doc.base.model.DocElement;
import org.fugerit.java.doc.base.model.DocLi;
import org.fugerit.java.doc.base.model.DocList;
import org.fugerit.java.doc.base.model.DocPara;
import org.fugerit.java.doc.base.model.DocPhrase;
import org.fugerit.java.doc.base.model.DocRow;
import org.fugerit.java.doc.base.model.DocStyle;
import org.fugerit.java.doc.base.model.DocTable;
import org.fugerit.java.doc.base.model.util.DocTableUtil;

/**
 * DocTypeFacade for basic markdown syntax
 * 
 * https://www.markdownguide.org/basic-syntax/
 * 
 * NOTES: 
 * 	tables are rendered in html, as they are not included in basic syntax
 * 	currently some DocBase model elements are skipped (for exampled DocImage)
 * 
 * @see DocTypeFacadeDefault provides facilities for mapping all DocBase model
 * 
 * @author Matteo a.k.a. Fugerit <m@fugerit.org>
 */
public class MarkdownBasicDocFacade extends DocTypeFacadeDefault {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183772778800073010L;
	
	private PrintWriter writer;

	protected PrintWriter getWriter() {
		return writer;
	}

	public MarkdownBasicDocFacade(PrintWriter writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void handleDoc(DocBase docBase) throws Exception {
		// just comment to the generated output :
		this.getWriter().print( "[//]: # (generator : " );
		this.getWriter().print( this.getClass().getName() );
		this.getWriter().println( " )" );
		this.getWriter().print( "[//]: # (generated on " );
		this.getWriter().print( new Date() );
		this.getWriter().println( " )  " );
		this.getWriter().println();
		// actual document handling :we will treat only the body
		DocTypeFacadeHelper helper = new DocTypeFacadeHelper( docBase );
		this.handleElements( docBase.getDocBody(), helper );
		// flush content
		this.getWriter().flush();	
	}

	private void addStyle( DocStyle docStyle, int textStyle ) {
		if ( textStyle == DocPara.STYLE_BOLD || textStyle == DocPara.STYLE_BOLDITALIC ) {
			this.writer.print( "**" );
		} else if ( textStyle == DocPara.STYLE_ITALIC ) {
			this.writer.print( "*" );
		}
	}
	
	private void handleText(DocStyle docStyle, DocContainer parent, DocTypeFacadeHelper helper, String text, int textStyle) throws Exception {
		this.addStyle(docStyle, textStyle);
		this.writer.print( text );
		this.addStyle(docStyle, textStyle);
	}
	
	@Override
	public void handlePara(DocPara docPara, DocContainer parent, DocTypeFacadeHelper helper) throws Exception {
		boolean body = ( helper.getDepth() == DocTypeFacadeHelper.ROOT_DEPTH );
		int headLevel = docPara.getHeadLevel();
		while ( headLevel>0 ) {
			this.writer.print( "#" );
			headLevel--;
		}
		if ( docPara.getHeadLevel() > 0 ) {
			this.writer.print( " " );
		}
		// test
		this.handleText( docPara, parent, helper, docPara.getText(), docPara.getStyle() );
		if ( body ) {
			this.writer.println( "  " );	// endline with two white spaces	
		} else {
			this.writer.print( " " );
		}
	}

	@Override
	public void handlePhrase(DocPhrase docPhrase, DocContainer parent, DocTypeFacadeHelper helper) throws Exception {
		this.handleText( docPhrase, parent, helper, docPhrase.getText(), docPhrase.getStyle() );
		this.writer.print( " " );
	}

	@Override
	public void handleList(DocList docList, DocContainer parent, DocTypeFacadeHelper helper) throws Exception {
		this.getWriter().println();
		for ( DocElement liEl : docList.getElementList() ) {
			if ( liEl instanceof DocLi ) {
				DocLi li = (DocLi) liEl;
				this.getWriter().print( "* " );
				this.handleElements( li, helper );
				this.getWriter().println();
			}
		}
	}

	@Override
	public void handleTable(DocTable docTable, DocContainer parent, DocTypeFacadeHelper helper) throws Exception {
		this.getWriter().println();
		this.getWriter().println( "<table>" );
		this.handleDocUtilTable( docTable, parent, helper );
		this.getWriter().println( "<table>" );
	}

	protected void handleDocUtilTable( DocTable table, DocContainer parent, DocTypeFacadeHelper helper ) throws Exception {
		DocTableUtil tableUtil = new DocTableUtil( table );
		handleRowList( table, tableUtil, tableUtil.getHeaderRows() , true, helper );
		handleRowList( table, tableUtil, tableUtil.getDataRows() , false, helper );
	}
		
	protected void handleRowList( DocTable table, DocTableUtil tableUtil, List<DocElement> rowList, boolean header, DocTypeFacadeHelper helper  ) throws Exception {
		String cellType = "td";
		if ( header ) {
			cellType = "th";
		}
		for ( DocElement element: rowList ) {
			DocRow row = (DocRow) element;
			this.getWriter().println( "<tr>" );
			for ( DocElement cellEl : row.getElementList() ) {
				DocCell cell = (DocCell) cellEl;
				this.getWriter().print( "<" );
				this.getWriter().print( cellType );
				this.getWriter().print( ">" );
				this.handleElements( cell, helper );
				this.getWriter().print( "</" );
				this.getWriter().print( cellType );
				this.getWriter().println( ">" );
			}
			this.getWriter().println( "</tr>" );
		}
	}
 	
}
