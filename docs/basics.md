[Docs Home](../index.md)

## Basic Concepts

*version : 001*

*Venus* is an A.P.I. to produces documents in various formats.

**To do so, a minimum of three entities are needed :**
* A Renderer for the output format (implementing org.fugerit.java.doc.base.config.DocTypeHandler)
* A XML source document (in the format specified by https://www.fugerit.org/data/java/doc/xsd/doc-1-4.xsd)
* The output destination (for instance a File our OutputStream)

The simpliest way to do so is by SimpleDocFacade seen in [QuickstartA001HelloWorld](quickstart/001HelloWorld.md).

Of course it's possible to compose the XML source document in any way.  
*Venus* provides facilities to dynamically produces the XML source by a template engine (apache freemarker).


![SimpleDocFacade workflow](https://venusdocs.fugerit.org/docs/img/001_type_handler.gif)