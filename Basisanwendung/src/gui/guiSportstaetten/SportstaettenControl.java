package gui.guiSportstaetten;

import java.io.IOException;

import MyObserver.MyObserver;
import businessFreizeitbad.FreizeitbadModel;
import businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.PlausiException;

public class SportstaettenControl implements MyObserver {
	private FreizeitbadModel modelFreizeitbad ;
	private SportstaettenView Sportview ;
	private SporthallenModel sportModel;
	
	
	
	public SportstaettenControl(Stage stage) {
		modelFreizeitbad= modelFreizeitbad.getIntanz();
		sportModel=sportModel.getIntanz();
		Sportview = new SportstaettenView(this,stage,modelFreizeitbad,sportModel);
		modelFreizeitbad.addObserver(this);
	}
	
	public void leseSporthallenAusCsv()  {
		System.out.println("SportControl");

		try {
			sportModel.leseSporthalleAusCsv();
		} catch (IOException | PlausiException e) {
			// TODO Auto-generated catch block
			Sportview.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");		
			}
	}




	@Override
	public void update() {
		// TODO Auto-generated method stub
		Sportview.zeigeFreizeitbaederAn();
		
	}

}
