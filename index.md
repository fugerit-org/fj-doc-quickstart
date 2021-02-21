## Quickstart for fj-doc project (Venus)

*Version : 0.3.5.5 (fj-mod-quickstart version always refers to fj-mod-doc version used too)*

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
* Advanced customization examples (fj-mod-quickstart-c-advanced module): 
    * [QuickstartC001CustomFopTypeHandler](docs/quickstart/C001CustomFopTypeHandler.md) - [java source](fj-doc-quickstart-c-advanced/src/test/java/test/org/fugerit/java/doc/qs/QuickstartC001CustomFopTypeHandler.java) - [xml doc source](fj-doc-quickstart-c-advanced/src/main/resources/sample-doc-xml/QuickstartC001/static-data-sample-01.xml)
    * [QuickstartC002CustomMarkdownTypeHandler](docs/quickstart/C002CustomMarkdownTypeHandler.md) - [java source](fj-doc-quickstart-c-advanced/src/test/java/test/org/fugerit/java/doc/qs/QuickstartC002CustomMarkdownTypeHandler.java) - [xml doc source](fj-doc-quickstart-c-advanced/src/main/resources/sample-doc-xml/QuickstartC001/static-data-sample-01.xml)    

**Other useful resources :**
* [XSD specification of Venus doc format](https://www.fugerit.org/data/java/doc/xsd/doc-1-4.xsd)
* [Venus Documentation Home](https://venusdocs.fugerit.org/)
* [fj-mod-doc-quickstart Release Notes](docs/release-notes.md)
