package controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashInputTest {

private static String testWord;
    @BeforeAll
    public static void setUpTestWord(){
        testWord = "alma";
    }
    @Test
    void inputparserTestIfList() {
        try {
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            assertTrue(result instanceof List);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestIfNull() {
        try {
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            assertTrue(result != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestIfListElementByteArray() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            result.forEach(n-> {
                try {
                    outputStream.write(n);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            byte[] concatenatedBytes = outputStream.toByteArray();
            assertTrue(concatenatedBytes instanceof byte[]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayContentNotNull() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            result.forEach(n-> {
                try {
                    outputStream.write(n);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            byte[] concatenatedBytes = outputStream.toByteArray();
            String resultString = new String(concatenatedBytes, StandardCharsets.UTF_8);
            assertNotNull(resultString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayContent() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            result.forEach(n-> {
                try {
                    outputStream.write(n);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            byte[] concatenatedBytes = outputStream.toByteArray();
            String resultString = new String(concatenatedBytes, StandardCharsets.UTF_8);
            String expected = "alma";
            assertTrue(resultString.equals(expected));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayListSize() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            result.forEach(n-> {
                try {
                    outputStream.write(n);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            byte[] concatenatedBytes = outputStream.toByteArray();
            int expectedSize = 4;
            assertEquals(4,concatenatedBytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayListNotEmpty() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            assertFalse(result.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayContentEquality() {
        try {
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            byte[] expected = {97, 108, 109, 97};
            assertArrayEquals(expected,result.get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayContentElements() {
        try {
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            byte[] expected = {97, 108, 109, 97};
            assertEquals(expected[0],result.get(0)[0]);
            assertEquals(expected[1],result.get(0)[1]);
            assertEquals(expected[2],result.get(0)[2]);
            assertEquals(expected[3],result.get(0)[3]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void inputparserTestByteArrayListCanBeCleared() {
        try {
            List<byte[]> result = new HashInput(testWord).inputparser("TXT");
            result.clear();
            assertTrue(result.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}