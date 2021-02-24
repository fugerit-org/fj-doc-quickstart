[Docs Home](../../index.md)

## QuickstartB004ComplexProcessStep

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartB004ComplexProcessStep](../../fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB004ComplexProcessStep.java) show how to use custom free marker methods.

This example is very similar to [QuickstartB003EmbedBase64Image](B003EmbedBase64Image.md), but use a more compact chain configuration.

Here is the simple [freemarker template](../../fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/complex-process-step.ftl)

Here is the chain from [doc process configuration](../../fj-doc-quickstart-b-freemarker/src/main/resources/doc-facade/doc-process-quickstart.xml)

```
	<chain id="complex-process-step" extends="config">
		<step id="step-process" defaultBehaviour="CONTINUE"
			description="Apply FreeMarker template to get the full XML" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerComplexProcessStep">
			<!-- 
				template-path, allow for inline definition of template to use, with chainId variable available
				map-atts, is a list of comma separated attributes to map from doc process context to freemarker map
				map-all, if '1' or 'true' all doc process context attributes are mapped
			-->
			<properties 
				template-path="${chainId}.ftl" 
				map-atts="imgDynamicPipelineBase64"/>		
		</step>
	</chain>			
```
