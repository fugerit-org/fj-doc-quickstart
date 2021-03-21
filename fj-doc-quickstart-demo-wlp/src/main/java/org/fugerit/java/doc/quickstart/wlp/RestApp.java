package org.fugerit.java.doc.quickstart.wlp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestApp extends javax.ws.rs.core.Application {

	   public Set<Class<?>> getClasses() {
		      Set<Class<?>> s = new HashSet<Class<?>>();
		      s.add(TestPdfService.class);
		      return s;
		}
	
}