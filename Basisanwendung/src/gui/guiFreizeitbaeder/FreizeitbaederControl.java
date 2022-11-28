package gui.guiFreizeitbaeder;

import java.io.IOException;

import MyObserver.MyObserver;
import business.FreizeitbadModel;
import javafx.stage.Stage;

public class FreizeitbaederControl implements MyObserver {
	
	private  FreizeitbaederView view ;
	private FreizeitbadModel model ;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		model = model.getIntanz();
		view = new FreizeitbaederView(this ,primarystage,model);
		model.addObserver(this);
		
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
	@Override
	public void update() {
		view.zeigeFreizeitbaederAn();
	}
}
