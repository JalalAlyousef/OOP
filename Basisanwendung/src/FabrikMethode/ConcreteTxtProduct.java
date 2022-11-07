package FabrikMethode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtProduct extends Product {
	
	BufferedWriter austxt;
	
	public ConcreteTxtProduct() throws IOException {
		
		austxt =new BufferedWriter(new FileWriter("Freizeitbaeder.txt",true));
	}
	@Override
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
		austxt.write("Daten des Freizeitbades\n ");
		austxt.write("Name des Freizeitbades\t"+ freizeitbad.getName() );
		austxt.write("\nöffnungszeit des Freizeitbades:\t "+ freizeitbad.getGeoeffnetVon() + " "+ freizeitbad.getGeoeffnetBis());
		austxt.write("\nBeckenlänge des Freizeitbades:\t"+freizeitbad.getBeckenlaenge());
		austxt.write("nwassertemperatur des Freizeitbades:\t"+ freizeitbad.getTemperatur());
		
		
	}

	@Override
	public void schliessDatei() throws IOException {
		austxt.close();
		
	}



}
