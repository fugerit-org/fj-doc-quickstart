## Quickstart for fj-doc project (Venus)

*Version : 0.3.5.9 (fj-mod-quickstart version is always the fj-doc version used)*

*Date : 2021-03-22*

*Venus* primary goal is to provide a simple xml doc template to render documents in various formats

**Documentation index:**
* [README](README.md)
* [Basic Concepts](docs/basics.md)
* Static XML Source examples (fj-mod-quickstart-a-basic module):
    * [QuickstartA001HelloWorld](docs/quickstart/A001HelloWorld.md) - [java source](fj-doc-quickstart-a-basic/src/test/java/test/org/fugerit/java/doc/qs/QuickstartA001HelloWorld.java) - [xml doc source](fj-doc-quickstart-a-basic/src/main/resources/sample-doc-xml/QuickstartA001/hello-world.xml)
    * [QuickstartA002DocReference](docs/quickstart/A002DocReference.md) - [java source](fj-doc-quickstart-a-basic/src/test/java/test/org/fugerit/java/doc/qs/QuickstartA002DocReference.java) - [xml doc source](fj-doc-quickstart-a-basic/src/main/resources/sample-doc-xml/QuickstartA002/doc-reference.xml)
    * [QuickstartA003DocHandlerFacade](docs/quickstart/A003DocHandlerFacade.md) - [java source](fj-doc-quickstart-a-basic/src/test/java/test/org/fugerit/java/doc/qs/QuickstartA003DocHandlerFacade.java) - [xml doc source](fj-doc-quickstart-a-basic/src/main/resources/sample-doc-xml/QuickstartA003/static-data-table.xml)
* Dynamic free marker template examples (fj-mod-quickstart-b-freemarker module): 
    * [QuickstartB001ProcessDocFacade](docs/quickstart/B001ProcessDocFacade.md) - [java source](fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB001ProcessDocFacade.java) - [free marker template](fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/dynamic-table-data.ftl)
    * [QuickstartB002CustomFreeMarkerMethod](docs/quickstart/B002CustomFreeMarkerMethod.md) - [java source](fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB002CustomFreeMarkerMethod.java) - [free marker template](fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/custom-free-marker-method.ftl)
    * [QuickstartB003EmbedBase64Image](docs/quickstart/B003EmbedBase64Image.md) - [java source](fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB003EmbedBase64Image.java) - [free marker template](fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/base64-image.ftl)    
    * [QuickstartB004ComplexProcessStep](docs/quickstart/B004ComplexProcessStep.md) - [java source](fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB004ComplexProcessStep.java) - [free marker template](fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/complex-process-step.ftl)    
    * [QuickstartB005DocMetaData](docs/quickstart/B005DocMetaData.md) - [java source](fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB005DocMetaData.java) - [free marker template](fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/doc-meta-data.ftl)        
* Advanced customization examples (fj-mod-quickstart-c-advanced module): 
    * [QuickstartC001CustomFopTypeHandler](docs/quickstart/C001CustomFopTypeHandler.md) - [java source](fj-doc-quickstart-c-advanced/src/test/java/test/org/fugerit/java/doc/qs/QuickstartC001CustomFopTypeHandler.java) - [xml doc source](fj-doc-quickstart-c-advanced/src/main/resources/sample-doc-xml/QuickstartC001/static-data-sample-01.xml)
    * [QuickstartC002CustomMarkdownTypeHandler](docs/quickstart/C002CustomMarkdownTypeHandler.md) - [java source](fj-doc-quickstart-c-advanced/src/test/java/test/org/fugerit/java/doc/qs/QuickstartC002CustomMarkdownTypeHandler.java) - [xml doc source](fj-doc-quickstart-c-advanced/src/main/resources/sample-doc-xml/QuickstartC001/static-data-sample-01.xml)    

**Project structure (maven modules) :**
* *fj-doc-quickstart-a-basic* , basic examples with static xml doc source
* *fj-doc-quickstart-b-freemarker* , dynamic examples which generates xml doc source using freemarker temaples (probably the most common usage)
* *fj-doc-quickstart-c-advanced* , advanced features examples (for instance custom type handler) 
* *custom-type-handler-fop* , sample custom type handler changing behaviour of fj-doc-mod-fop type handler
* *custom-type-handler-markdown* , sample custom type handlers from scratch, for markdown output format (both basic and extended)
* *fj-doc-quickstart-demo-springboot*, demo application running on spring boot (see [readme](fj-doc-quickstart-demo-springboot/readme.md))
* *fj-doc-quickstart-demo-quarkus*, demo application running on quarkus (see [readme](fj-doc-quickstart-demo-quarkus/readme.md))
* *fj-doc-quickstart-demo-wlp*, demo application running on web sphere liberty (see [readme](fj-doc-quickstart-demo-wlp/readme.md))

**Other useful resources :**
* [XSD specification of Venus doc format](https://www.fugerit.org/data/java/doc/xsd/doc-1-4.xsd)
* [Venus Documentation Home](https://venusdocs.fugerit.org/)
* [fj-mod-doc-quickstart Release Notes](docs/release-notes.md)
