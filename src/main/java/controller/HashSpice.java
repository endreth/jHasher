package controller;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class HashSpice {

	public byte[] getSalt() {

		SecureRandom sr;
		byte[] salt = null;

		try {
			sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
			salt = new byte[16];
			sr.nextBytes(salt);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		return salt;
	}

	// Peppers stored elsewhere
	public byte[] getPepper(String secureRandomString) {
		byte[] pepper = null;

		pepper = new byte[16];
		pepper = secureRandomString.getBytes();
		
		return pepper;
	}

}
