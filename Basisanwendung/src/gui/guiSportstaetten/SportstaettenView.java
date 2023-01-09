package gui.guiSportstaetten;

import business.Freizeitbad;
import businessFreizeitbad.FreizeitbadModel;
import businessSporthallen.Sporthalle;
import businessSporthallen.SporthallenModel;
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

	private FreizeitbadModel modelFreizeitbad;
	private SportstaettenControl Sportcontrol;
	private SporthallenModel sportModel;
	
	private Pane pane = new Pane();

	private Label lblAnzeige = new Label("Anzeige");
	private TextField txtName = new TextField();

	private TextArea txtAnzeige = new TextArea();

	private Button btnAnzeige = new Button("Anzeige");
	
	private Label lblAnzeigeSporthalle = new Label("Anzeige Sporthallen");
	private TextField txtNameSporthalle = new TextField();

	private TextArea txtAnzeigeSporthalle  = new TextArea();
	private Button btnAnzeigeSporthalle = new Button("csv-Import und Anzeige");



	public SportstaettenView(SportstaettenControl control, Stage primaryStage, FreizeitbadModel model,SporthallenModel sportModel) {
		this.Sportcontrol = control;
		this.modelFreizeitbad = model;
		this.sportModel=sportModel;
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstaetten");
		primaryStage.show();
		this.initKomponenten();
		this.initListenerFreizeitbad();
		this.initKomponentenSporthallen();
		this.initListenerSporthallen();
	}

	private void initKomponenten() {

		Font font = new Font("Arial", 24);

		lblAnzeige.setLayoutX(310);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");

		pane.getChildren().addAll(lblAnzeige);

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
		pane.getChildren().addAll(btnAnzeige);

	}
	
	public void initKomponentenSporthallen()  {
		Font font = new Font("Arial", 24);
		lblAnzeigeSporthalle.setLayoutX(20);
		lblAnzeigeSporthalle.setLayoutY(40);
		lblAnzeigeSporthalle.setFont(font);
		lblAnzeigeSporthalle.setStyle("-fx-font-weight: bold;");

		pane.getChildren().addAll(lblAnzeigeSporthalle);
		
		txtAnzeigeSporthalle.setEditable(false);
		txtAnzeigeSporthalle.setLayoutX(20);
		txtAnzeigeSporthalle.setLayoutY(90);
		txtAnzeigeSporthalle.setPrefWidth(220);
		txtAnzeigeSporthalle.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthalle);
		
		btnAnzeigeSporthalle.setLayoutX(20);
		btnAnzeigeSporthalle.setLayoutY(290);
		pane.getChildren().addAll(btnAnzeigeSporthalle);
	}

	private void initListenerFreizeitbad() {
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});
	

	}
	private void initListenerSporthallen() {
		btnAnzeigeSporthalle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSporthallenAn();
			}
		});
	}
	public void zeigeFreizeitbaederAn() {
	
		if (modelFreizeitbad.getFreizeitbad().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Freizeitbad fzb : modelFreizeitbad.getFreizeitbad()) {
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
			}
			txtAnzeige.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	public void zeigeSporthallenAn() {
		Sportcontrol.leseSporthallenAusCsv();	
		if (sportModel.getSporthalleList().size() > 0) {
			StringBuffer text = new StringBuffer();
			// Ergaenzen: for each – Schleife ueber ArrayList
			for (Sporthalle sh : sportModel.getSporthalleList()){
				text.append(sh.gibSporthalleZurueck(' ') + "\n");
			}
			this.txtAnzeigeSporthalle.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Sporthallen aufgenommen!");
		}
	}	

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}
}
