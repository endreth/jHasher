package model.salted;

import controller.HashType;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;
import java.util.List;

public class DeKammererSalted extends HashType {

    private String algorithm;
    private static final int DEFAULT_ITERATIONS = 10;
    private static final int DEFAULT_MEMORY = 65536;
    private static final int DEFAULT_PARALLELISM = 1;

    public DeKammererSalted() {

    }

    @Override
    public String encrypt(List<byte[]> list) {

        // Moritz Halbritter (born Kammerer) implementation of Argon2id; https://github.com/phxql; https://github.com/mhalbritter/; https://www.mkammerer.de/about/
        Argon2 argon2id = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id,32,64);

        List<String> masterHashStrings = new ArrayList<>();
        list.parallelStream().sequential().forEach((n) -> {

            String hashedbytes = argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, n);
            masterHashStrings.add(hashedbytes);

        });

        StringBuilder sb = new StringBuilder();
        // Create a master hash (root hash)
        for (int i = 0; i < masterHashStrings.size(); i++) {
            sb.append(masterHashStrings.get(i));
        };
        return argon2id.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY,DEFAULT_PARALLELISM, sb.toString());

    }

}
