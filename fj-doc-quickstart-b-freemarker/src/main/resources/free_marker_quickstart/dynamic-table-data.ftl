<?xml version="1.0" encoding="utf-8"?>
<doc
	xmlns="http://javacoredoc.fugerit.org"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://javacoredoc.fugerit.org https://www.fugerit.org/data/java/doc/xsd/doc-1-1.xsd" > 

  <!-- 
  	Sample Apache FreeMarker template for Fugerit Doc.
  	Note : this example has no intention of being a guidr to FreeMarker
  			(In case check FreeMarker documentation https://freemarker.apache.org/docs/index.html)
   -->

  <meta>
  </meta>
 
  <body>
  
  		<h head-level="1" style="bold" size="16">Dynamic data table example based on apache free marker template</h>
  
    	<table columns="3" colwidths="30;30;40"  width="100" id="excel-table" padding="2">
    		<row>
    			<cell header="true"><para style="bold">Name</para></cell>
    			<cell header="true"><para style="bold">Surname</para></cell>
    			<cell header="true"><para style="bold">Title</para></cell>
    		</row>
			<#list characterList as character>
       		<row>
    			<cell><para><#if (character.name)??>${character.name}</#if></para></cell>
    			<cell><para><#if (character.surname)??>${character.surname}</#if></para></cell>
    			<cell><para><#if (character.birthDate)??>${character.birthDate}</#if></para></cell>
    		</row>
			</#list>   		
    	</table>
    	
  </body>
  
</doc>