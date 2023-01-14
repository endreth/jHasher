package model.salted;

import controller.HashSpice;
import controller.HashType;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Security;
import java.util.List;

public class BCProviderSalted extends HashType {

    private String algorithm;
    private HashSpice hp;
    private BouncyCastleProvider bcp;
    private ExtendedDigest md;

    public BCProviderSalted(String algorithm) {
        this.algorithm = algorithm;
        this.bcp = new BouncyCastleProvider();
        Security.addProvider(this.bcp);
        if(this.algorithm.equals("Blake2b")){
            //Blake2bDigest md = new Blake2bDigest(256); // 32,64,128,256,512;
            this.md = new Blake2bDigest(256);
        } else if(this.algorithm.equals("TIGER")) {
            //MessageDigest md = MessageDigest.getInstance("TIGER", "BC");
            this.md = new TigerDigest();
        }
        this.hp = new HashSpice();
    }

    @Override
    public String encrypt(List<byte[]> list) {
        StringBuilder sb = new StringBuilder();

        list.parallelStream().sequential().forEach((n) -> {
            ByteArrayInputStream bai = new ByteArrayInputStream(n);
            BufferedInputStream is = new BufferedInputStream(bai);
            try (bai) {
                byte[] buffer = new byte[1048576];  //  1 MiB chunk
                while (true) {
                    int readCount = is.read(buffer);
                    if (readCount < 0) {
                        break;
                    }
                    this.md.update(buffer,0,buffer.length);
                }
                byte[] hash = new byte[this.md.getDigestSize()];
                this.md.doFinal(hash,0);

                for (byte hashed_byte : hash) {
                    sb.append(String.format("%02x", hashed_byte));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        this.md.reset();
        this.md.update(sb.toString().getBytes(),0,sb.toString().getBytes().length);
        this.md.update(this.hp.getSalt(),0,this.hp.getSalt().length);
        byte[] masterhash = new byte[this.md.getDigestSize()];
        this.md.doFinal(masterhash,0);

        StringBuilder sb2 = new StringBuilder();
        for (byte hashed_byte : masterhash) {
            sb2.append(String.format("%02x", hashed_byte));
        }
        return sb2.toString();
    }
}
