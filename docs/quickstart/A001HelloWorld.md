[Docs Home](../../index.md)

## QuickstartA001HelloWorld

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartA001HelloWorld](../../src/test/java/test/org/fugerit/java/doc/qs/QuickstartA001HelloWorld.java) is a basic example of *Venus* usage, starting from a [static XML doc source](../../src/main/resources/sample-doc-xml/QuickstartA001/hello-world.xml)

It shows how to generate document in PDF and HTML formats with a [SimpleDocFacade](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/SimpleDocFacade.java) (provided in core fj-doc-base maven project)

![SimpleDocFacade workflow](https://venusdocs.fugerit.org/docs/img/002_simple_doc_facade.gif)

Which is the most basic option for producing *Venus* documents, via a DocTypeHandler.