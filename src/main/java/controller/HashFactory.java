package controller;

import model.nonsalted.BCProvider;
import model.nonsalted.JCEProvider;
import model.nonsalted.Rctcwyvrn;

public class HashFactory extends AbstractFactory {

	@Override
	public HashType getHashType(String HashType) {

		//JCA-JCE PROVIDER
		if (HashType.equalsIgnoreCase("MD2")) {
			return new JCEProvider("MD2");
		} else if (HashType.equalsIgnoreCase("MD5")) {
			return new JCEProvider("MD5");
		} else if (HashType.equalsIgnoreCase("SHA-1")) {
			return new JCEProvider("SHA-1");
		} else if (HashType.equalsIgnoreCase("SHA-224")) {
			return new JCEProvider("SHA-224");
		} else if (HashType.equalsIgnoreCase("SHA-256")) {
			return new JCEProvider("SHA-256");
		} else if (HashType.equalsIgnoreCase("SHA-384")) {
			return new JCEProvider("SHA-384");
		} else if (HashType.equalsIgnoreCase("SHA-512")) {
			return new JCEProvider("SHA-512");
		} else if (HashType.equalsIgnoreCase("SHA3-224")) {
			return new JCEProvider("SHA3-224");
		} else if (HashType.equalsIgnoreCase("SHA3-256")) {
			return new JCEProvider("SHA3-256");
		} else if (HashType.equalsIgnoreCase("SHA3-384")) {
			return new JCEProvider("SHA3-384");
		} else if (HashType.equalsIgnoreCase("SHA3-512")) {
			return new JCEProvider("SHA3-512");
		//BOUNCY CASTLE PROVIDER
		} else if (HashType.equalsIgnoreCase("TIGER")) {
			return new BCProvider("TIGER");
		} else if (HashType.equalsIgnoreCase("Blake2b")) {
			return new BCProvider("Blake2b");
		//Rctcwyvrn's imp. Blake3
		} else if (HashType.equalsIgnoreCase("Blake3")) {
			return new Rctcwyvrn();
		}

		return null;
	}

}
