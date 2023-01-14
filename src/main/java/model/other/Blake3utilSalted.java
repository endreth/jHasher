package model.other;

import controller.HashSpice;
import controller.HashType;

import java.util.List;

public class Blake3utilSalted extends HashType {

	private StringBuilder sb;
	//private Blake3 blk3;
	private HashSpice hp;

	public Blake3utilSalted() {
		this.sb = new StringBuilder();
		//this.blk3 = Blake3.newInstance();
		this.hp = new HashSpice();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		this.blk3.update(bytes);
//		this.blk3.update(this.hp.getSalt());
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
//			// Add salt to the master hash
//			blk3.update(this.hp.getSalt());
//			return blk3.hexdigest();
//
//			// If there is ONLY ONE element in the list
//		} else {
//
//			this.sb.setLength(0);
//			Blake3 blk3 = Blake3.newInstance();
//
//			blk3.update(list.get(0));
//			// Add salt to the hash
//			blk3.update(this.hp.getSalt());
//			return blk3.hexdigest();
//		}
//	}

}
