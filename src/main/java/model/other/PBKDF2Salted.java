package model.other;

import controller.HashSpice;
import controller.HashType;

import javax.crypto.SecretKeyFactory;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PBKDF2Salted extends HashType {

	private SecretKeyFactory skf;
	private StringBuilder sb;
	private HashSpice hp;
	private final int ITERATIONS = 1000;

	public PBKDF2Salted() throws NoSuchAlgorithmException {
		this.skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		this.sb = new StringBuilder();
		this.hp = new HashSpice();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		char[] tohash = bytecharconvert(bytes);
//
//		// For iterations, check https://security.stackexchange.com/questions/3959/recommended-of-iterations-when-using-pbkdf2-sha256
//		KeySpec spec = new PBEKeySpec(tohash, this.hp.getSalt(), ITERATIONS,128);
//		byte[] hashed_bytes = null;
//
//		try {
//			hashed_bytes = this.skf.generateSecret(spec).getEncoded();
//		} catch (InvalidKeySpecException e) {
//			e.printStackTrace();
//		}
//
//		// Convert bytes[] (in decimal format) to hexadecimal
//		for (int i = 0; i < hashed_bytes.length; i++) {
//			this.sb.append(Integer.toString((hashed_bytes[i] & 0xff) + 0x100, 16).substring(1));
//		}
//		// Return hashed String in hex format
//		String hashedByteArray = this.sb.toString();
//
//		return hashedByteArray;
//	}

//	@Override
//	public String encrypt(List<byte[]> list, int nthr) throws InterruptedException, ExecutionException, InvalidKeySpecException {
//
//		ArrayList<String> temp = new ArrayList<>();
//		ExecutorService threadPool = Executors.newFixedThreadPool(nthr);
//		List<Callable<String>> callableTasks = new ArrayList<>();
//
//		// If there is MORE THAN ONE element in the list
//		if(list.size() > 1){
//
//			list.forEach((n)->{
//				Callable<String> callableTask = () -> {
//					KeySpec spec = new PBEKeySpec(bytecharconvert(n), this.hp.getSalt(), ITERATIONS,128);
//					// Create a hash for an element
//					byte[] hashed_bytes = this.skf.generateSecret(spec).getEncoded();
//					// Convert bytes[] (in decimal format) to hexadecimal
//					for (int i = 0; i < hashed_bytes.length; i++) {this.sb.append(Integer.toString((hashed_bytes[i] & 0xff) + 0x100, 16).substring(1));}
//					return this.sb.toString();
//				};
//				callableTasks.add(callableTask);
//			});
//
//			List<Future<String>> futures = null;
//			futures = threadPool.invokeAll(callableTasks);
//			threadPool.shutdown();
//
//			for (Future<String> future : futures) {
//				temp.add(future.get());
//			}
//			// Create a master hash (root hash)
//			KeySpec spec_m = new PBEKeySpec(bytecharconvert(String.join("", temp).getBytes(StandardCharsets.UTF_8)), this.hp.getSalt(), ITERATIONS,128);
//			byte[] hashed_bytes = new byte[0];
//			hashed_bytes = this.skf.generateSecret(spec_m).getEncoded();
//			StringBuilder sb_m = new StringBuilder();
//			for (byte hashed_byte : hashed_bytes) {sb_m.append(Integer.toString((hashed_byte & 0xff) + 0x100, 16).substring(1));}
//			return sb_m.toString();
//
//		// If there is ONLY ONE element in the list
//		} else {
//			KeySpec spec_m = new PBEKeySpec(bytecharconvert(list.get(0)), this.hp.getSalt(), ITERATIONS,128);
//			byte[] hashed_bytes = new byte[0];
//			hashed_bytes = this.skf.generateSecret(spec_m).getEncoded();
//			StringBuilder sb_m = new StringBuilder();
//			for (byte hashed_byte : hashed_bytes) {sb_m.append(Integer.toString((hashed_byte & 0xff) + 0x100, 16).substring(1));}
//			return sb_m.toString();
//		}
//	}
//
//	private char[] bytecharconvert(byte[] bytes) {
//
//		char[] buffer = new char[bytes.length >> 1];
//
//		for (int i = 0; i < buffer.length; i++) {
//			int bpos = i << 1;
//			char c = (char) (((bytes[bpos] & 0x00FF) << 8) + (bytes[bpos + 1] & 0x00FF));
//			buffer[i] = c;
//		}
//
//		return buffer;
//	}

}
