[Docs Home](../../index.md)

## Quickstart003DocHandlerFacade

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[Quickstart003DocHandlerFacade](../../src/test/java/test/org/fugerit/java/doc/qs/Quickstart003DocHandlerFacade.java) show how to create and use a [DocHandlerFacade](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/DocHandlerFacade.java).

The main advantage of a DocHandlerFacade is to register a [DocTypeHandler](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/config/DocTypeHandler.java) for every needed output types instead of naming the handler type every time it's needed.

DocProcessFacade is created by a [DocHandlerFactory](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/DocHandlerFactory.java).
Here is a sample [configuration file](../../src/main/resources/doc-facade/doc-handler-quickstart.xml)

![DocHandlerFacade workflow](https://venusdocs.fugerit.org/docs/img/003_doc_handler_facade.gif)