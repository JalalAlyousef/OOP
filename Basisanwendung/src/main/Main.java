package main;


import gui.guiFreizeitbaeder.FreizeitbaederControl;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override	public void start(Stage primaryStage) {
		new FreizeitbaederControl(primaryStage);
		
		Stage fesnterSport=new Stage();
		new SportstaettenControl(fesnterSport);
	}	
	
	public static void main(String[] args){
		launch(args);
		
		//
	
	}
}
