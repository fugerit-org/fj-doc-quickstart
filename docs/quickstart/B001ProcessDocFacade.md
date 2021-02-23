[Docs Home](../../index.md)

## QuickstartB001DocProcessFacade

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartA004ProcessDocFacade](../../fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB001ProcessDocFacade.java) show how to create and use a [ProcessDocFacade](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/ProcessDocFacade.java).

**DocProcessConfig** can be configured to handle a chain of steps, ultimately producing a XML doc source, this source can be then used to produce the actual output document throws **DocHandlerFacade**

**ProcessDocFacade** combines the functionalities of [DocHandlerFacade](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/facade/DocHandlerFacade.java) (seen in [QuickstartA003DocHandlerFacade](003DocHandlerFacade.md)) to a [DocProcessConfig](https://venusdocs.fugerit.org/fj-doc-base/src/main/java/org/fugerit/java/doc/base/process/DocProcessConfig.java).

*HINT: In a way DocProcessConfig is similar to a servlet engine. the processing steps can be compared to a a Filter/Servlet chain, while the free marker template to a JSP.*

Here is a simple [configuration file](../../fj-doc-quickstart-b-freemarker/src/main/resources/doc-facade/doc-process-quickstart.xml) for DocProcessConfig: 

```
	<chain id="config">
		<!-- 
			free marker configuration step
			param01 is the id of the configuration (every different configuration will be cached)
			properties are FreeMarker configurations params. 
		-->
		<step id="step-01" defaultBehaviour="CONTINUE"
			description="FreeMarker Configuration step, only one FreeMarker configuration instance is created for every key under 'param01'" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerConfigStep"
			param01="QUICKSTART_CONFIG">
			<properties 
				version="2.3.30"
				path="/free_marker_quickstart"
				mode="class" 
				class="org.fugerit.java.doc.qs.facade.QuickstartDocFacade"
				exception-handler="RETHROW_HANDLER"
				log-exception="false"
				wrap-unchecked-exceptions="true"
				fallback-on-null-loop-variable="false" />
		</step>		
	</chain>

	<!--
		A chain can extends one or more other chains (in this case 'config' chain)
	-->
	<chain id="character-table" extends="config">
		<!--
			This step map attributes provided in the DocProcessContext to Free Marker Root Map.
			In this case 'characterList' attributes is mapped to an entry with the same name : characterList="characterList"
		-->
		<step id="step-data" defaultBehaviour="CONTINUE"
			description="Map items from DocContext to FreeMarker Data" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerMapStep">		
			<properties characterList="characterList"/>		
		</step>
		<!--
			This step apply the actual free marker template and produce the static XML source.
			This XML source is then available to be rendered.
		-->					
		<step id="step-process" defaultBehaviour="CONTINUE"
			description="Apply FreeMarker template to get the full XML" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerProcessStep"
			param01="dynamic-table-data.ftl"/>
	</chain>
```

Here is the [freemarker template](../../fj-doc-quickstart-b-freemarker/src/main/resources/free_marker_quickstart/dynamic-table-data.ftl)

### Dynamix Doc workflow : 

![Dynamix Doc workflow](https://venusdocs.fugerit.org/docs/img/102_dynamic_pipeline.gif)

### DocProcessConfig workflow : 

![DocProcessConfig workflow](https://venusdocs.fugerit.org/docs/img/004_doc_process_config.gif)

### ProcessDocFacade workflow : 

![ProcessDocFacade workflow](https://venusdocs.fugerit.org/docs/img/005_process_doc_facade.gif)