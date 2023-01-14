package model.salted;

import controller.HashType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SSProviderSalted extends HashType {

    private String algorithm;
    private PasswordEncoder pe;

    public SSProviderSalted(String algorithm) {
        this.algorithm = algorithm;
        encoderType(this.algorithm);
    }

    private void encoderType(String algorithm){
        if(algorithm.equalsIgnoreCase("BCrypt")){
            this.pe = new BCryptPasswordEncoder();
        } else if(algorithm.equalsIgnoreCase("SCrypt")) {
            this.pe = new SCryptPasswordEncoder();
        }
    }

    @Override
    public String encrypt(List<byte[]> list) {

        List<String> masterHashStrings = new ArrayList<>();
        list.parallelStream().sequential().forEach((n) -> {

            String hashedbytes = this.pe.encode(new String(n, StandardCharsets.UTF_8));
            masterHashStrings.add(hashedbytes);

        });

        StringBuilder sb = new StringBuilder();
        // Create a master hash (root hash)
        for (int i = 0; i < masterHashStrings.size(); i++) {
            sb.append(masterHashStrings.get(i));
        };

        return this.pe.encode(sb.toString());

    }


}
