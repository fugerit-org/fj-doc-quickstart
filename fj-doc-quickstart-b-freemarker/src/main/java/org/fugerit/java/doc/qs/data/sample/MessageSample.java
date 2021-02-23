package org.fugerit.java.doc.qs.data.sample;

import java.util.Properties;

public class MessageSample {

	public static Properties getMessageData() {
		Properties props = new Properties();
		props.setProperty( "message.01" , "My first message sent at {0}");
		props.setProperty( "message.custom" , "This is my message number {0} : {1}");
		return props;
	}
	
}
