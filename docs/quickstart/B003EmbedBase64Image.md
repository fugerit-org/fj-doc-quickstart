[Docs Home](../../index.md)

## QuickstartB003EmbedBase64Image

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartB003EmbedBase64Image](../../fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB003EmbedBase64Image.java) show how to use custom free marker methods.

In this example wil show how to emebed a image in a document.

Here is the simple [freemarker template](../../fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/base64-image.ftl)

The usual mapping step will be needed to map the base64 image from the [DocProcessContext](https://venusdocs.fugerit.org//fj-doc-base/src/main/java/org/fugerit/java/doc/base/process/DocProcessContext.java) to freemarker root map.

Here is the chain from [doc process configuration](../../fj-doc-quickstart-b-freemarker/src/main/resources/doc-facade/doc-process-quickstart.xml)

```
	<chain id="base64-image" extends="config">
		<!--
			This step map attributes provided in the DocProcessContext to Free Marker Root Map.
			In this case 'characterList' attributes is mapped to an entry with the same name : characterList="characterList"
		-->
		<step id="step-data" defaultBehaviour="CONTINUE"
			description="Map items from DocContext to FreeMarker Data" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerMapStep">		
			<properties imgDynamicPipelineBase64="imgDynamicPipelineBase64"/>		
		</step>
		<!--
			This step apply the actual free marker template and produce the static XML source.
			This XML source is then available to be rendered.
		-->					
		<step id="step-process" defaultBehaviour="CONTINUE"
			description="Apply FreeMarker template to get the full XML" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerProcessStep"
			param01="base64-image.ftl"/>
	</chain>			
```
