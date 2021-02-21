[Docs Home](../../index.md)

## QuickstartA003DocHandlerFacade

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartA003DocHandlerFacade](../../fj-doc-quickstart-a-basic/src/test/java/test/org/fugerit/java/doc/qs/QuickstartA003DocHandlerFacade.java) show how to create and use a [DocHandlerFacade](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/DocHandlerFacade.java).

The main advantage of a DocHandlerFacade is to register a [DocTypeHandler](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/config/DocTypeHandler.java) for every needed output types instead of naming the handler type every time it's needed.

DocProcessFacade is created by a [DocHandlerFactory](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/DocHandlerFactory.java).
Here is a sample [configuration file](../../fj-doc-quickstart-a-basic/src/main/resources/doc-facade/doc-handler-quickstart.xml)

![DocHandlerFacade workflow](https://venusdocs.fugerit.org/docs/img/003_doc_handler_facade.gif)