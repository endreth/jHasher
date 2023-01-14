package model.other;

import controller.HashType;
import io.github.rctcwyvrn.blake3.Blake3;

import java.util.List;

public class Blake3util extends HashType {

	private StringBuilder sb;
	private Blake3 blk3;

	public Blake3util() {
		this.sb = new StringBuilder();
		this.blk3 = Blake3.newInstance();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		this.blk3.update(bytes);
//		String hashedByteArray = this.blk3.hexdigest();
//
//		return hashedByteArray;
//	}

//	@Override
//	public String encrypt(List<byte[]> list, int nthr) throws ExecutionException, InterruptedException {
//
//		ExecutorService threadPool = Executors.newFixedThreadPool(nthr);
//		List<Callable<String>> callableTasks = new ArrayList<>();
//
//		ArrayList<String> temp = new ArrayList<>();
//
//		// If there is MORE THAN ONE element in the list
//		if(list.size() > 1){
//
//			list.forEach((n)->{
//				Callable<String> callableTask = () -> {
//
//					this.sb.setLength(0);
//					Blake3 blk3 = Blake3.newInstance();
//					blk3.update(n);
//					return blk3.hexdigest();
//
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
//
//			// Create a master hash (root hash)
//			this.sb.setLength(0);
//			Blake3 blk3 = Blake3.newInstance();
//
//			blk3.update(String.join("", temp).getBytes());
//			return blk3.hexdigest();
//
//			// If there is ONLY ONE element in the list
//		} else {
//
//			this.sb.setLength(0);
//			Blake3 blk3 = Blake3.newInstance();
//
//			blk3.update(list.get(0));
//			return blk3.hexdigest();
//		}
//	}

}
