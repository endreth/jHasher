package controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashInput {

private final String input;

	public HashInput(String input) {
		this.input = input;
	}

	public List<byte[]> inputparser(String datatype) throws IOException {
		List<byte[]> temp = new ArrayList<>();
		if("TXT".equals(datatype)){
			ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
			byte[] buffer; // 1 MiB chunk
			int len;
			while ((len = in.read(buffer = new byte[1048576])) > 0) {
				temp.add(Arrays.copyOfRange(buffer, 0, len));
			}
			return temp;
		} else if("FILE".equals(datatype)){
			try (FileInputStream fis = new FileInputStream(input)) {
				byte[] buffer = new byte[1048576]; //  1 MiB chunk
				int len;
				while ((len = fis.read(buffer = new byte[1048576])) > 0) {
					temp.add(Arrays.copyOfRange(buffer, 0, len));
				}
				return temp;
			}
		}
		return null;
	}



}
