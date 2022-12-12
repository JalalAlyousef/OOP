package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import FabrikMethode.ConcreteCreator;
import FabrikMethode.ConcreteCreatorCsv;
import FabrikMethode.Creator;
import FabrikMethode.Product;
import MyObserver.MyObservable;
import MyObserver.MyObserver;

public class FreizeitbadModel implements MyObservable {
	//private Freizeitbad freizeitbad ;
	private static FreizeitbadModel instanz = null;
	
	private LinkedList<MyObserver> list = new LinkedList<MyObserver>();
	private ArrayList<Freizeitbad> freizeitbadList = new  ArrayList<Freizeitbad>();
	
	private FreizeitbadModel() {
		
	}
	
	public static FreizeitbadModel getIntanz() {
		if(instanz == null) {
			instanz= new FreizeitbadModel();
		}
		return instanz;
	}
	
	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbadList;
	}


	public void addFreizeitbad(Freizeitbad freizeitbad) {
		freizeitbadList.add(freizeitbad);
		notifyObservers();
	}


	public void schreibFreizeitbaederInCsvDatei() throws IOException {
		/*BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();*/
		Creator creator = new ConcreteCreatorCsv();
		Product writer = creator.factoryMethod();
		for (Freizeitbad fzb : freizeitbadList) {
		
			
		writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliessDatei();
		
		
	}
	public void schreibFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new ConcreteCreator();
		Product writer = creator.factoryMethod();
		for (Freizeitbad fzb : freizeitbadList) {
		writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliessDatei();
	}

	@Override
	public void addObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		list.add(obs);
		
	}

	@Override
	public void removeObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		list.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
		for(MyObserver o:list) {
			o.update();
		}
		
	}
	
}
