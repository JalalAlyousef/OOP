package gui;

import java.io.IOException;

import business.FreizeitbadModel;
import javafx.stage.Stage;

public class FreizeitbaederControl {
	
	private  FreizeitbaederView view ;
	private FreizeitbadModel model ;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		model = new FreizeitbadModel();
		view = new FreizeitbaederView(this ,primarystage,model);
		
	}
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				model.schreibFreizeitbaederInCsvDatei();
			}
			else {
			//view.zeigeInformationsfensterAn("noch nicht implementiert");	
			model.schreibFreizeitbaederInTxtDatei();
			}
			
		}catch(IOException exc) {
			view.zeigFehlermeldungAn("IOEXception beim Speichern !");
		}catch (Exception exc) {
			view.zeigFehlermeldungAn("unbekannter Fehler");
			
		}
		
	}
}
