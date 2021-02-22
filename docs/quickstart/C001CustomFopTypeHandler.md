[Docs Home](../../index.md)

## QuickstartC001CustomFopTypeHandler

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartC001CustomTypeHandler](../../fj-doc-quickstart-c-advanced/src/test/java/test/org/fugerit/java/doc/qs/QuickstartC001CustomTypeHandler.java) shows how is possible to create a custom doc type handler.

In this case we will create a custom version of [PdfFopTypeHandler](https://venusdocs.fugerit.org/fj-doc-mod-fop/src/main/java/org/fugerit/java/doc/mod/fop/PdfFopTypeHandler.java).

The [CustomPdfFopTypeHandler](../../fj-doc-quickstart-c-advanced/src/main/java/org/fugerit/java/doc/qs/handler/fop/CustomPdfFopTypeHandler.java):
* Add the label 'My Custom DocTypeHandler' at the start of every generated page.
* Align to left by default header row cell (while in normal PdfFopTypeHandler, header rows are aligned to center).

Here is a summary of how this type handler has been created : 
* pacakge 'org.fugerit.java.doc.mod.fop' from 'fj-doc/fj-doc-mod-fop' project had been copied an renamed to 'org.fugerit.java.doc.qs.handler.fop' (in src/main/java)
* template folder 'fm_fop' from 'fj-doc/fj-doc-mod-fop' project had been copied an renamed to 'custom_fm_fop' (in src/main/resources)
* In [FreeMarkerFopProcess](../../fj-doc-quickstart-c-advanced/src/main/java/org/fugerit/java/doc/qs/handler/fop/FreeMarkerFopProcess.java) the 'CONFIG_PATH = "cl://custom_fm_fop/fop-process-config.xml";' constant has been changed to map our custom template path
* In [Process Config File](../..//fj-doc-quickstart-c-advanced/src/main/resources/custom_fm_fop/fop-process-config.xml) the class parameter has been changed to map our new class class="org.fugerit.java.doc.qs.handler.fop.FreeMarkerFopProcess"
* In [Basic Free Marker Template](../../fj-doc-quickstart-c-advanced/src/main/resources/custom_fm_fop/template/fop_doc.ftl) we added the fo block for our first customization '<fo:block>My Custom DocTypeHandler</fo:block><!-- customization 1 -->'
* In [Free Marker Macro For Table](../..//fj-doc-quickstart-c-advanced/src/main/resources/custom_fm_fop/template/macro/doc_element.ftl) we added our second customization '<fo:table-${cellType} <#if cellType == 'header'> font-weight="bold" text-align="left"</#if>><!-- customization 2 -->'

DocTypeHandler customization disadvantages : 
* You don't automatically get fix and improvement on the original DocTypeHandler

DocTypeHandler customization advantages : 
* You can add or change features
* You can control in detail rendering
