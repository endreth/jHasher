package controller;

public class FactoryProducer {

	public static AbstractFactory getFactory(boolean salted) {
		
		if (salted) {
			return new HashFactorySalted();
		} else {
			return new HashFactory();
		}
	}

}
