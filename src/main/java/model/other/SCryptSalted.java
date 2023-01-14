package model.other;

import controller.HashType;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SCryptSalted extends HashType {

	//private SCryptPasswordEncoder scpe;
	
	public SCryptSalted() throws NoSuchAlgorithmException {
		//this.scpe = new SCryptPasswordEncoder();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		String tohash = new String(bytes, StandardCharsets.UTF_8);
//
//		String hashedByteArray = this.scpe.encode(tohash);
//
//		return hashedByteArray;
//	}

//	@Override
//	public String encrypt(List<byte[]> list, int nthr) throws InterruptedException, ExecutionException {
//
//		SCryptPasswordEncoder scpe = new SCryptPasswordEncoder();
//		ArrayList<String> temp = new ArrayList<>();
//		ExecutorService threadPool = Executors.newFixedThreadPool(nthr);
//		List<Callable<String>> callableTasks = new ArrayList<>();
//
//		// If there is MORE THAN ONE element in the list
//		if(list.size() > 1){
//
//			list.forEach((n)->{
//				Callable<String> callableTask = () -> {
//					String tohash = new String(n, StandardCharsets.UTF_8);
//					// Create a hash for an element
//					String hashedByteArray = scpe.encode(tohash);
//					return (hashedByteArray.split(Pattern.quote("$"))[3]);
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
//			return scpe.encode(String.join("", temp));
//
//			// If there is ONLY ONE element in the list
//		} else {
//			return scpe.encode(new String(list.get(0),StandardCharsets.UTF_8));
//		}
//	}

}
