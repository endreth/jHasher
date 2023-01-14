package model.other;

import controller.HashType;

import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Checksum;


public class CRC32util extends HashType {

	private final Checksum crc32;
	private final StringBuilder sb;

	public CRC32util() {
		this.crc32 = new CRC32();
		this.sb = new StringBuilder();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		this.crc32.update(bytes, 0, bytes.length);
//		String  encodedString = String.valueOf(this.crc32.getValue());
//
//		return encodedString;
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
//					this.crc32.reset();
//
//					this.crc32.update(n, 0, n.length);
//					return String.valueOf(this.crc32.getValue());
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
//			this.crc32.reset();
//
//			this.crc32.update(String.join("", temp).getBytes());
//			return String.valueOf(this.crc32.getValue());
//
//			// If there is ONLY ONE element in the list
//		} else {
//
//			this.sb.setLength(0);
//			this.crc32.reset();
//
//			this.crc32.update(list.get(0));
//			return String.valueOf(this.crc32.getValue());
//		}
//	}

}
