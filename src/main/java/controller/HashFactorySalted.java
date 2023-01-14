package controller;

import model.salted.*;

public class HashFactorySalted extends AbstractFactory {

	@Override
	public HashType getHashType(String HashType) {

		//JCA-JCE PROVIDER
		if (HashType.equalsIgnoreCase("MD2")) {
			return new JCEProviderSalted("MD2");
		} else if (HashType.equalsIgnoreCase("MD5")) {
			return new JCEProviderSalted("MD5");
		} else if (HashType.equalsIgnoreCase("SHA-1")) {
			return new JCEProviderSalted("SHA-1");
		} else if (HashType.equalsIgnoreCase("SHA-224")) {
			return new JCEProviderSalted("SHA-224");
		} else if (HashType.equalsIgnoreCase("SHA-256")) {
			return new JCEProviderSalted("SHA-256");
		} else if (HashType.equalsIgnoreCase("SHA-384")) {
			return new JCEProviderSalted("SHA-384");
		} else if (HashType.equalsIgnoreCase("SHA-512")) {
			return new JCEProviderSalted("SHA-512");
		} else if (HashType.equalsIgnoreCase("SHA3-224")) {
			return new JCEProviderSalted("SHA3-224");
		} else if (HashType.equalsIgnoreCase("SHA3-256")) {
			return new JCEProviderSalted("SHA3-256");
		} else if (HashType.equalsIgnoreCase("SHA3-384")) {
			return new JCEProviderSalted("SHA3-384");
		} else if (HashType.equalsIgnoreCase("SHA3-512")) {
			return new JCEProviderSalted("SHA3-512");
		//BOUNCY CASTLE PROVIDER
		}else if (HashType.equalsIgnoreCase("Blake2b")) {
			return new BCProviderSalted("Blake2b");
		}else if (HashType.equalsIgnoreCase("TIGER")) {
			return new BCProviderSalted("TIGER");
		// Rctcwyvrn's imp. Blake3
		} else if (HashType.equalsIgnoreCase("Blake3")) {
			return new RctcwyvrnSalted();
		// DeKammerer's imp. Argon2id
		} else if (HashType.equalsIgnoreCase("Argon2id")) {
			return new DeKammererSalted();
		// JCA-JCE PBE PROVIDER
		} else if (HashType.equalsIgnoreCase("PBKDF2")) {
			return new JCEProviderPBKDFSalted();
		// Spring Security PROVIDER
		} else if (HashType.equalsIgnoreCase("BCrypt")) {
			return new SSProviderSalted("BCrypt");
		} else if (HashType.equalsIgnoreCase("SCrypt")) {
			return new SSProviderSalted("SCrypt");
		}

		return null;
	}

}
