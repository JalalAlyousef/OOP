package gui.guiSportstaetten;

import MyObserver.MyObserver;
import business.FreizeitbadModel;
import javafx.stage.Stage;

public class SportstaettenControl implements MyObserver {
	private FreizeitbadModel model ;
	private SportstaettenView view ;
	
	
	
	
	public SportstaettenControl(Stage stage) {
		model= model.getIntanz();
		view = new SportstaettenView(this,stage,model);
		model.addObserver(this);
	}




	@Override
	public void update() {
		// TODO Auto-generated method stub
		view.zeigeFreizeitbaederAn();
		
	}

}
