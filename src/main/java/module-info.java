module hu.jhasher {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.crypto;
    requires org.bouncycastle.provider;
    requires darculafx;
    requires de.mkammerer.argon2.nolibs;
    requires com.sun.jna;
    requires blake3;
    requires jdk.management;
    requires com.github.oshi;
    requires org.slf4j;
    requires org.slf4j.simple;
    requires spring.jcl;
    requires org.apache.commons.io;
    requires spring.core;
    requires java.desktop;
    requires commons.codec;

    opens controller to javafx.fxml;
    opens view to javafx.graphics;
    exports controller;
}
