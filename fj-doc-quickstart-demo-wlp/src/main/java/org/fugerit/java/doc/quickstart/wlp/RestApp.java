package org.fugerit.java.doc.quickstart.wlp;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class RestApp extends jakarta.ws.rs.core.Application {

	   public Set<Class<?>> getClasses() {
		      Set<Class<?>> s = new HashSet<Class<?>>();
		      s.add(TestPdfService.class);
		      return s;
		}
	
}