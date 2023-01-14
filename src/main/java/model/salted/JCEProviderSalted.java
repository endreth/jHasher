package model.salted;

import controller.HashSpice;
import controller.HashType;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class JCEProviderSalted extends HashType {

    private String algorithm;
    private HashSpice hp;

    public JCEProviderSalted(String algorithm) {
        this.algorithm = algorithm;
        this.hp = new HashSpice();
    }

    @Override
    public String encrypt(List<byte[]> list) {
        try {
            MessageDigest md = MessageDigest.getInstance(this.algorithm);
            StringBuilder sb = new StringBuilder();

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
                    byte[] hash = md.digest();
                    for (byte hashed_byte : hash) {
                        sb.append(String.format("%02x", hashed_byte));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            md.reset();
            md.update(sb.toString().getBytes());
            md.update(this.hp.getSalt());
            byte[] masterhash = md.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte hashed_byte : masterhash) {
                sb2.append(String.format("%02x", hashed_byte));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

}
