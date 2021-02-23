[Docs Home](../../index.md)

## B002CustomFreeMarkerMethod

*version : 001*

**Maven dependancies :**
* org.fugerit.java/fj-core
* org.fugerit.java/fj-doc-base
* org.fugerit.java/fj-doc-freemarker	(for both html and pdf fop handlers)
* org.fugerit.java/fj-doc-mod-fop	(for pdf fop handler)

[QuickstartB002CustomFreeMarkerMethod](../../fj-doc-quickstart-b-freemarker/src/test/java/test/org/fugerit/java/doc/qs/QuickstartB002CustomFreeMarkerMethod.java) show how to use custom free marker methods.

In this example will use :  
[SimpleMessageFun](https://venusdocs.fugerit.org/fj-doc-freemarker/src/main/java/org/fugerit/java/doc/freemarker/fun/SimpleMessageFun.java), a conveniente interface for java.text.MessageFormat.  
[SimpleSumLongFun](https://venusdocs.fugerit.org/fj-doc-freemarker/src/main/java/org/fugerit/java/doc/freemarker/fun/SimpleSumLongFun.java), a simple function for adding numbers as long.  

To create other custom functions for free marker see : 
[https://freemarker.apache.org/docs/pgui_datamodel_method.html](https://freemarker.apache.org/docs/pgui_datamodel_method.html)
(custom methods must be imported during chain configuration)

```
		<step id="step-01" defaultBehaviour="CONTINUE"
			description="Add custom functions" 
			type="org.fugerit.java.doc.freemarker.config.FreeMarkerFunctionStep">
			<properties 
				messageFormat="org.fugerit.java.doc.freemarker.fun.SimpleMessageFun"
				sumLong="org.fugerit.java.doc.freemarker.fun.SimpleSumLongFun"  />
		</step>	
```