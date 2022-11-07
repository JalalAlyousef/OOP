package FabrikMethode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvProduct extends Product {

	
	
	BufferedWriter aus;
	
	
	public ConcreteCsvProduct() throws IOException {
		aus  = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
		
		aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		
		
	}

	

	
	
	@Override
	public void schliessDatei() throws IOException {
		aus.close();
		
	}


}
