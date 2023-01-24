package model.nonsalted;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class JCEProviderTest {
    private static JCEProvider jcepSHA1;
    private static JCEProvider jcepMD2;
    private static JCEProvider jcepMD5;


    @BeforeAll
    static void setUpTestEncrypt() {
        jcepMD2 = new JCEProvider("MD2");
        jcepMD5 = new JCEProvider("MD5");
        jcepSHA1 = new JCEProvider("SHA-1");
    }


    // Test SHA-1 encrypt
    @Test
    public void testEncryptSHA1() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("alma".getBytes());
        String expected = "5f5ea3800d9a62bc5a008759dbbece9cad5db58f";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String expected = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1SingleByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes());
        String expected = "0a0a9f2a6772942557ab5355d76af442f8f65e01";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("apple".getBytes());
        list.add("banana".getBytes());
        list.add("cherry".getBytes());
        String expected = "a163b2115d1ed751ee870b2fe8ba06fc43ce1b0b";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1RandomBytes() {
        byte[] randomBytes = new byte[1024];
        new Random().nextBytes(randomBytes);
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(randomBytes);
        String expected = "dff2a9b1c9c7d9f9a9f9c9f9c9b1a9f2dff2d9f9";
        String result = jcepSHA1.encrypt(list);
        assertNotEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1LongString() {
        String longString = "This is a very long string that contains a lot of different characters and spaces.";
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(longString.getBytes());
        String expected = "724016a758afbc4752723891db6eff773c6a921f";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1VeryLargeString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("This is a very large string that contains a lot of different characters and spaces.");
        }
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(sb.toString().getBytes());
        String expected = "ae3e83dcf29bd2486c61233ac8e7f8dc4b1676a9";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1MixedData() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes()); // 0a0a9f2a6772942557ab5355d76af442f8f65e01
        list.add(new byte[] {1, 2, 3, 4, 5});
        list.add("Goodbye, World!".getBytes()); // aa3391df2ac1ec26522a1d257a8956497485fa76
        list.add(new byte[] {6, 7, 8, 9, 10});
        String expected = "dbd0a223998980e6a84b592fd47aa5bc807116af";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String expected = "b510c3059d13cbfb277c0e9f0f9de510e8e2c0b2";
        String result = jcepSHA1.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptSHA1ThrowsException() {
        List<byte[]> list = null;
        assertThrows(NullPointerException.class,()->jcepSHA1.encrypt(list));
    }

    // Test MD2 encrypt
    @Test
    public void testEncryptMD2() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("alma".getBytes());
        String expected = "cb990a034ef7b969e2e333438070fa6f";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String expected = "8350e5a3e24c153df2275c9f80692773";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2SingleByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes());
        String expected = "1c8f1e6a94aaa7145210bf90bb52871a";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("apple".getBytes());
        list.add("banana".getBytes());
        list.add("cherry".getBytes());
        String expected = "71129d7020d73ebe229ee7c27835bdb0";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2RandomBytes() {
        byte[] randomBytes = new byte[1024];
        new Random().nextBytes(randomBytes);
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(randomBytes);
        String expected = "dff2a9b1c9c7d9f9a9f9c9f9c9b1a9f2dff2d9f9";
        String result = jcepMD2.encrypt(list);
        assertNotEquals(expected, result);
    }

    @Test
    public void testEncryptMD2LongString() {
        String longString = "This is a very long string that contains a lot of different characters and spaces.";
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(longString.getBytes());
        String expected = "8ba3a1851e7264c44d6e95093d89d95c";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2VeryLargeString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("This is a very large string that contains a lot of different characters and spaces.");
        }
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(sb.toString().getBytes());
        String expected = "ff7beb0123a96129bf6598bd227c5c95";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2MixedData() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes()); // 0a0a9f2a6772942557ab5355d76af442f8f65e01
        list.add(new byte[] {1, 2, 3, 4, 5});
        list.add("Goodbye, World!".getBytes()); // aa3391df2ac1ec26522a1d257a8956497485fa76
        list.add(new byte[] {6, 7, 8, 9, 10});
        String expected = "6e6b841241746851a45387df9ea81b84";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String expected = "97955571f7362e82ea749523fa946223";
        String result = jcepMD2.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD2ThrowsException() {
        List<byte[]> list = null;
        assertThrows(NullPointerException.class,()->jcepMD2.encrypt(list));
    }

    // Test MD5 encrypt
    @Test
    public void testEncryptMD5() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("alma".getBytes());
        String expected = "ebbc3c26a34b609dc46f5c3378f96e08";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String expected = "d41d8cd98f00b204e9800998ecf8427e";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5SingleByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes());
        String expected = "65a8e27d8879283831b664bd8b7f0ad4";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("apple".getBytes());
        list.add("banana".getBytes());
        list.add("cherry".getBytes());
        String expected = "45c41496b1798fe64c4279896600e5e6";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5RandomBytes() {
        byte[] randomBytes = new byte[1024];
        new Random().nextBytes(randomBytes);
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(randomBytes);
        String expected = "dff2a9b1c9c7d9f9a9f9c9f9c9b1a9f2dff2d9f9";
        String result = jcepMD5.encrypt(list);
        assertNotEquals(expected, result);
    }

    @Test
    public void testEncryptMD5LongString() {
        String longString = "This is a very long string that contains a lot of different characters and spaces.";
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(longString.getBytes());
        String expected = "604a39c8e79140d0c4d839cf741c8a15";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5VeryLargeString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("This is a very large string that contains a lot of different characters and spaces.");
        }
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(sb.toString().getBytes());
        String expected = "0eaae2a0345aa7328eb95753788742bc";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5MixedData() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("Hello, World!".getBytes()); // 0a0a9f2a6772942557ab5355d76af442f8f65e01
        list.add(new byte[] {1, 2, 3, 4, 5});
        list.add("Goodbye, World!".getBytes()); // aa3391df2ac1ec26522a1d257a8956497485fa76
        list.add(new byte[] {6, 7, 8, 9, 10});
        String expected = "75cb07bc4e8d4cb346e720fda9ca861e";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String expected = "d7ab0bede5d4ab6b7957785e3edeeea9";
        String result = jcepMD5.encrypt(list);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptMD5ThrowsException() {
        List<byte[]> list = null;
        assertThrows(NullPointerException.class,()->jcepMD5.encrypt(list));
    }
}