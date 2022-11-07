package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import FabrikMethode.ConcreteCreator;
import FabrikMethode.Creator;
import FabrikMethode.Product;

public class FreizeitbadModel {
	private Freizeitbad freizeitbad ;
	
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}


	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}


	public void schreibFreizeitbaederInCsvDatei() throws IOException {
		/*BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();*/
		Creator creator = new ConcreteCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliessDatei();
		
		
	}
	public void schreibFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new ConcreteCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliessDatei();
	}
	
}
