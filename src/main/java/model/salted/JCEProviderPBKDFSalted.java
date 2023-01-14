package model.salted;

import controller.HashSpice;
import controller.HashType;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.List;

public class JCEProviderPBKDFSalted extends HashType {

    private HashSpice hp;
    private SecretKeyFactory skf;
    private final int ITERATIONS = 1000;

    public JCEProviderPBKDFSalted() {
        this.hp = new HashSpice();
        try {this.skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");} catch (NoSuchAlgorithmException e) {throw new RuntimeException(e);}
    }

    @Override
    public String encrypt(List<byte[]> list) {
        try {
            StringBuilder sb = new StringBuilder();
            List<String> masterHashStrings = new ArrayList<>();

            list.parallelStream().sequential().forEach((n) -> {
                try {

                    KeySpec spec = new PBEKeySpec(byteToCharConvert(n), this.hp.getSalt(), ITERATIONS,128);
                    // Create a hash for an element
                    byte[] hashed_bytes = this.skf.generateSecret(spec).getEncoded();
					// Convert bytes[] (in decimal format) to hexadecimal
					for (int i = 0; i < hashed_bytes.length; i++) {
                        sb.append(Integer.toString((hashed_bytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    masterHashStrings.add(sb.toString());

                } catch (InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                }
            });

            StringBuilder masterSB = new StringBuilder();
            // Create a master hash (root hash)
            for (int i = 0; i < masterHashStrings.size(); i++) {
                masterSB.append(masterHashStrings.get(i));
            };
            KeySpec masterSpec = new PBEKeySpec(masterSB.toString().toCharArray(), this.hp.getSalt(), ITERATIONS,128);
            byte[] hashedMasterBytes = this.skf.generateSecret(masterSpec).getEncoded();
            char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[hashedMasterBytes.length * 2];
            for (int j = 0; j < hashedMasterBytes.length; j++) {
                int v = hashedMasterBytes[j] & 0xFF;
                hexChars[j * 2] = HEX_ARRAY[v >>> 4];
                hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
            }
            return new String(hexChars);

        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    	private char[] byteToCharConvert(byte[] bytes) {

		char[] buffer = new char[bytes.length >> 1];

		for (int i = 0; i < buffer.length; i++) {
			int bpos = i << 1;
			char c = (char) (((bytes[bpos] & 0x00FF) << 8) + (bytes[bpos + 1] & 0x00FF));
			buffer[i] = c;
		}

		return buffer;
	}

}
