package model.other;

import controller.HashType;

import java.util.Base64;
import java.util.List;

public class Base64util extends HashType {

	private final Base64.Encoder encoder;

	public Base64util() {
		this.encoder = Base64.getEncoder();
	}

	@Override
	public String encrypt(List<byte[]> list) {
		return null;
	}

//	@Override
//	public String encrypt(byte[] bytes) {
//
//		Base64.Encoder encoder = Base64.getEncoder();
//
//		String encodedString = encoder.encodeToString(bytes);
//
//		return encodedString;
//	}

//	//@Override
//	public String encrypt2(String PathOrText, String TYPE) {
//
//		Base64.Encoder encoder = Base64.getEncoder();
//		byte[] bytes = new byte[4096]; //4 Kilobytes
//
//		if (TYPE.equals("TXT")) {
//			return encoder.encodeToString(PathOrText.getBytes(StandardCharsets.UTF_8));
//		} else if (TYPE.equals("FILE")) {
//
//			StringBuilder sb = new StringBuilder();
//
//			try (FileInputStream fis = new FileInputStream(new File(PathOrText))) {
//				while (true) {
//					int len = fis.read(bytes);
//					if (len == -1) {
//						break;
//					}
//					String temp = encoder.encodeToString(bytes);
//					sb.append(temp);
//				}
//			} catch (IOException e) {e.printStackTrace();}
//			return sb.toString();
//		} else if (TYPE.equals("DIR")) {
//			File f = new File(PathOrText);
//			ArrayList<String> paths = listFilesForFolder(f);
//			StringBuilder sb = new StringBuilder();
//
//			paths.forEach((n)->{
//				try (FileInputStream fis = new FileInputStream(new File(n))) {
//					while (true) {
//						int len = fis.read(bytes);
//						if (len == -1) {
//							break;
//						}
//						String temp = encoder.encodeToString(bytes);
//						sb.append(temp);
//					}
//				} catch (IOException e) {e.printStackTrace();}
//			});
//			return sb.toString();
//
//		} else {
//			System.err.println("Input type cannot be recognized! Use 'TXT' for text, 'FILE' for file.");
//			return null;
//		}
//	}
//
//	public ArrayList<String> listFilesForFolder(File folder) {
//		ArrayList<String> paths = new ArrayList<>();
//		for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
//			if (!fileEntry.isDirectory()) {
//				paths.add(fileEntry.getAbsolutePath());
//			}
//		}
//		return paths;
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
//					return this.encoder.encodeToString(n);
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
//			return String.join("", temp);
//
//			// If there is ONLY ONE element in the list
//		} else {
//
//			return this.encoder.encodeToString(list.get(0));
//		}
//	}




}
