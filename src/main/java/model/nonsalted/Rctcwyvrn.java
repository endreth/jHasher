package model.nonsalted;

import controller.HashType;
import io.github.rctcwyvrn.blake3.Blake3;

import java.util.ArrayList;
import java.util.List;

public class Rctcwyvrn extends HashType {

    private final Blake3 blk3;

    public Rctcwyvrn() {
        // Implementation of Blake3 by Rctcwyvrn; https://github.com/rctcwyvrn/blake3
        this.blk3 = Blake3.newInstance();
    }

//    @Override
//    public String encrypt(List<byte[]> list) {
//
//        List<String> masterHashStrings = new ArrayList<>();
//
//        list.parallelStream().sequential().forEach((n) -> {
//
//            this.blk3.update(n);
//            String hashedByteArray = this.blk3.hexdigest();
//            masterHashStrings.add(hashedByteArray);
//
//        });
//
//        Blake3 masterBlk3 = Blake3.newInstance();
//        masterHashStrings.forEach(h ->masterBlk3.update(h.getBytes()));
//        return masterBlk3.hexdigest();
//
//    }

    @Override
    public String encrypt(List<byte[]> list) {

        List<String> masterHashStrings = new ArrayList<>();

        list.parallelStream().sequential().forEach((n) -> {

            this.blk3.update(n);

        });

        String hashedByteArray = this.blk3.hexdigest();
        return hashedByteArray;

    }

}
