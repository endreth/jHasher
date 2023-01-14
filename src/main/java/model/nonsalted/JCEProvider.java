package model.nonsalted;

import controller.HashType;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class JCEProvider extends HashType {

    private String algorithm;

    public JCEProvider(String algorithm) {
        this.algorithm = algorithm;
    }

//    @Override
//    public String encrypt(List<byte[]> list) {
//        try {
//            MessageDigest md = MessageDigest.getInstance(this.algorithm);
//            StringBuilder sb = new StringBuilder();
//
//            list.parallelStream().sequential().forEach((n) -> {
//                ByteArrayInputStream bai = new ByteArrayInputStream(n);
//                DigestInputStream dis = new DigestInputStream(new BufferedInputStream(bai), md);
//                try (bai) {
//                    byte[] buffer = new byte[1048576];  //  1 MiB chunk
//                    while (true) {
//                        int readCount = dis.read(buffer);
//                        if (readCount < 0) {
//                            break;
//                        }
//                    }
//                    byte[] hash = md.digest();
//                    for (byte hashed_byte : hash) {
//                        sb.append(String.format("%02x", hashed_byte));
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            md.reset();
//            byte[] masterhash = md.digest(sb.toString().getBytes());
//            StringBuilder sb2 = new StringBuilder();
//            for (byte hashed_byte : masterhash) {
//                sb2.append(String.format("%02x", hashed_byte));
//            }
//            return sb2.toString();
//        } catch (NoSuchAlgorithmException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    @Override
    public String encrypt(List<byte[]> list) {
        try {
            MessageDigest md = MessageDigest.getInstance(this.algorithm);

            list.parallelStream().sequential().forEach((n) -> {
                ByteArrayInputStream bai = new ByteArrayInputStream(n);
                DigestInputStream dis = new DigestInputStream(new BufferedInputStream(bai), md);
                try (bai) {
                    byte[] buffer = new byte[1048576];  //  1 MiB chunk
                    while (true) {
                        int readCount = dis.read(buffer);
                        if (readCount < 0) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            byte[] hash = md.digest();
            return byteArrayToHexString(hash);

        } catch (NoSuchAlgorithmException | DecoderException ex) {
            throw new RuntimeException(ex);
        }
    }

    // byte[] to hexadecimal String converter
    public static String byteArrayToHexString(byte[] bytes)
            throws DecoderException {
        return new String(Hex.encodeHex(bytes));
    }

}
