package gui.guiSportstaetten;

import business.FreizeitbadModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportstaettenView {
	
	private FreizeitbadModel model;
	private SportstaettenControl control ;
	
	private Pane pane = new  Pane();
	
	
    private Label lblAnzeige   	 	    = new Label("Anzeige");
    private TextField txtName 	 		= new TextField();
    
    private TextArea txtAnzeige  		= new TextArea();
   
    private Button btnAnzeige 		 	= new Button("Anzeige");
	
	public SportstaettenView(SportstaettenControl control,  Stage primaryStage ,  FreizeitbadModel model) {
		this.control=control;
		this.model=model;
		
		Scene scene = new Scene(this.pane, 560, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Anzeige von Sportstaetten");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
		
	}
	private void initKomponenten(){
		
    	Font font = new Font("Arial", 24); 
    	
    	lblAnzeige.setLayoutX(310);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 

    	pane.getChildren().addAll( lblAnzeige);
       	
       	txtName.setLayoutX(130);
    	txtName.setLayoutY(90);
    	
    	txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(310);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(220);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
      
        btnAnzeige.setLayoutX(310);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll( btnAnzeige); 
       	
       	
    
	}

	private void initListener() {
		 btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeFreizeitbaederAn();
		        } 
	   	    });  
		
	}
	public void zeigeFreizeitbaederAn(){
    	if(model.getFreizeitbad() != null){
    		txtAnzeige.setText(
    			model.getFreizeitbad().gibFreizeitbadZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
    	}
    }	
	 void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
}
