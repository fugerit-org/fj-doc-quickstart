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
  
  		<h head-level="1" style="bold" size="16">Custom free marker method example</h>
 
 		<para>In this example : </para>
 
 		<list>
 			<li><para>'messageFormat' is the custom freemarker method : org.fugerit.java.doc.freemarker.fun.SimpleMessageFun</para></li>
 			<li><para>'messageData' is a property object mapped in this chain with two keys : 'message.01' and 'message.custom'</para></li>
 			<li><para>.now?string.iso is just a freemarker build in date function</para></li>
 			<li><para>'sumLong' is the custom freemarker method : org.fugerit.java.doc.freemarker.fun.SimpleSumLongFun</para></li>
 		</list>
 
 		<para>Here is te output : </para>

  		<list>
 			<li><para>${messageFormat( messageData['message.01'], .now?string.iso )}</para></li>
 			<li><para>${messageFormat( messageData['message.custom'], '2', 'Second test message' )}</para></li>
 			<li><para>2 plus 2 = ${sumLong( 2, 2 )}</para></li>
 		</list>

  </body>
  
</doc>