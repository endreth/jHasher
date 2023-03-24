package controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;


class HashSpiceTest {

    private static byte[] testWord;
    private static HashSpice hp;

    @BeforeAll
    public static void setUpTestWord(){
        // [97, 108, 109, 97]
        testWord = "alma".getBytes();
        hp = new HashSpice();
    }

    @Test
    public void testAlgorithm() throws NoSuchAlgorithmException {
        byte[] result = hp.getSalt();
        assertEquals("SHA1PRNG", SecureRandom.getInstance("SHA1PRNG").getAlgorithm());
    }

    @Test
    public void testReturnValueNotNull() {
        byte[] result = hp.getSalt();
        assertNotNull(result);
    }

    @Test
    public void testNotEmpty() {
        byte[] result = hp.getSalt();
        assertTrue(result.length > 0);
    }

    @Test
    public void testReturnValueLength() {
        byte[] result = hp.getSalt();
        assertEquals(16, result.length);
    }

    @Test
    public void testReturnValueRange() {
        byte[] result = hp.getSalt();
        for (byte b : result) {
            assertTrue(b >= Byte.MIN_VALUE && b <= Byte.MAX_VALUE);
        }
    }

    @Test
    public void testReturnValueContent() {
        byte[] result = hp.getSalt();
        for(byte b: result) {
            assertFalse(b == 0);
        }
    }

    @Test
    public void testNoExceptionHandling() {
        assertDoesNotThrow(() -> {
            hp.getSalt();
        });
    }

//    @Test
//    public void testReturnValueContentUniqueness() {
//        byte[] result = hp.getSalt();
//        for(int i=0;i<result.length;i++) {
//            for(int j=i+1;j<result.length;j++) {
//                assertNotEquals(result[i], result[j]);
//                System.out.println(result[i]+","+result[j]);
//            }
//        }
//    }

    @Test
    public void testReturnValueContentValidity() {
        byte[] result = hp.getSalt();
        boolean isValid = false;
        for(byte b: result) {
            if (b != 0) {
                isValid = true;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testReturnValueEquality() {
        byte[] result = hp.getSalt();
        assertNotEquals(testWord, result);
    }

    @Test
    public void testReturnValueChanging() {
        byte[] result1 = hp.getSalt();
        byte[] result2 = hp.getSalt();
        assertNotEquals(result1, result2);
    }

    // Test Shannon entropy: measure of uncertainty (or variability) associated with random variables
    // How different the elements of a distribution are from each other
    @Test
    public void testReturnValueEntropy() {
        byte[] result = hp.getSalt();
        double shannonEntropy = calculateShannonEntropy(result);
        double threshold = 2.0; //example threshold value
        assertTrue(shannonEntropy >= threshold);
    }

    // Formula: H(X) = -∑(p(x) * log(p(x)))
    private double calculateShannonEntropy(byte[] data) {
        int[] frequency = new int[256];
        for (byte b : data) {
            frequency[b & 0xff]++;
        }
        double entropy = 0;
        int len = data.length;
        for (int f : frequency) {
            if (f > 0) {
                double p = (double) f / len;
                entropy -= p * (Math.log(p) / Math.log(2));
            }
        }
        return entropy;
    }



}