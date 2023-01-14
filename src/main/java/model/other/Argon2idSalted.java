package model.other;

import controller.HashType;

import java.util.List;

public class Argon2idSalted extends HashType {

	private static final int DEFAULT_ITERATIONS = 10;
	private static final int DEFAULT_MEMORY = 65536;
	private static final int DEFAULT_PARALLELISM = 1;

	public Argon2idSalted() {

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
//		// Argon2Types.ARGON2id
//		// Salt 32 bytes
//		// Hash length 64 bytes
//		Argon2 argon2id = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id,32,64);
//
//		// Number of iterations = 10
//		// Memory usage to x kibibytes = 64m [65536k, 64M]
//		// Number of threads and compute lanes (parallelism) = 1
//		// Password to hash
//		String hashedbytes = argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, tohash);
//
//		// Output is base64 encoded
//		// Argon2 variants, Argon2 version $v, memory cost $m, iterations $t, parallelism (lane) $p, 16 bytes salt and Argon2 generated hash
//		return hashedbytes;
//	}

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

//	@Override
//	public String encrypt(List<byte[]> list) {
//
//		Argon2 argon2id = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id,32,64);
//		ArrayList<String> temp = new ArrayList<>();
//		ExecutorService threadPool = Executors.newFixedThreadPool(6);
//		List<Callable<String>> callableTasks = new ArrayList<>();
//
//		// If there is MORE THAN ONE element in the list
//		if(list.size() > 1){
//
//			list.forEach((n)->{
//				Callable<String> callableTask = () -> {
//					// Create a hash for an element
//					String hashedbytes = argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, n);
//					return (hashedbytes.split(Pattern.quote("$"))[5]);
//				};
//				callableTasks.add(callableTask);
//			});
//
//			List<Future<String>> futures = threadPool.invokeAll(callableTasks);
//			threadPool.shutdown();
//
//			for (Future<String> future : futures) {
//				temp.add(future.get());
//			}
//			// Create a master hash (root hash)
//			return argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, String.join("", temp).getBytes(StandardCharsets.UTF_8));
//
//			// If there is ONLY ONE element in the list
//		} else {
//			return argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, list.get(0));
//		}
//	}
}
