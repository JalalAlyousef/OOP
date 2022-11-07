package FabrikMethode;

import java.io.IOException;

public class ConcreteCreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		
		return new ConcreteTxtProduct();
	}

}
