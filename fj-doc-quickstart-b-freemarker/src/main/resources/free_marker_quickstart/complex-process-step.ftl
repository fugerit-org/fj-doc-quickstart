<?xml version="1.0" encoding="utf-8"?>
<doc
	xmlns="http://javacoredoc.fugerit.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://javacoredoc.fugerit.org https://www.fugerit.org/data/java/doc/xsd/doc-1-4.xsd" > 

  <!-- 
  	Sample Apache FreeMarker template for Fugerit Doc.
  	Note : this example has no intention of being a guidr to FreeMarker
  			(In case check FreeMarker documentation https://freemarker.apache.org/docs/index.html)
   -->

  <meta>
  </meta>
 
  <body>
  
  		<table columns="1" colwidths="100" width="100">
  			<row header="true">
  				<cell border-width="0">
  					<h head-level="1" style="bold" size="16">Embed base64 image sample</h>
  				</cell>
  			</row>
  			<row>
  				<cell border-width="0" align="center">
  					<image alt="Dynamic Doc Pipeline Workflow" type="png" base64="${imgDynamicPipelineBase64}" scaling="50"/>
  				</cell>
  			</row>
  		</table>
  
  </body>
  
</doc>