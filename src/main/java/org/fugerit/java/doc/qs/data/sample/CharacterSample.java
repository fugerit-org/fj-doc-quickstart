package org.fugerit.java.doc.qs.data.sample;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CharacterSample {

	public static List<CharacterModel> getDataSample() {
		List<CharacterModel> list = new ArrayList<CharacterModel>();
		list.add( new CharacterModel( "Alan", "Turing", Date.valueOf( "1912-06-23" ) ) );
		list.add( new CharacterModel( "Edsger", "Dijkstra", Date.valueOf( "1930-05-11" ) ) );
		list.add( new CharacterModel( "Linus", "Torvalds", Date.valueOf( "1969-12-28" ) ) );
		return list;
	}
	
}
