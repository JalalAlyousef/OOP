package businessSporthallen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.PlausiException;

public class SporthallenModel {
	private static SporthallenModel instanz= null;
	
	private ArrayList<Sporthalle> SporthalleList = new  ArrayList<Sporthalle>();
	
	
	private SporthallenModel() {
		
	}
	public static SporthallenModel getIntanz() {
		if(instanz == null) {
			instanz= new SporthallenModel();
		}
		return instanz;
	}
	public ArrayList<Sporthalle> getSporthalleList() {
		return SporthalleList;
	}
	
	public void leseSporthalleAusCsv() throws IOException, PlausiException {
		System.out.println("SportModel");
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle > erg = new ArrayList<Sporthalle>();
		String zeileStr = ein.readLine();
		while(zeileStr != null ) {
			String[] zeile = zeileStr.split(";");
			erg.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.SporthalleList = erg;

		
		
	}
	
	
}
