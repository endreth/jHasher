package model.salted;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JCEProviderSaltedTest {

    private static JCEProviderSalted jcepSHA1;
    private static JCEProviderSalted jcepMD2;
    private static JCEProviderSalted jcepMD5;

    @BeforeAll
    static void setUpTestEncrypt() {
        jcepMD2 = new JCEProviderSalted("MD2");
        jcepMD5 = new JCEProviderSalted("MD5");
        jcepSHA1 = new JCEProviderSalted("SHA-1");
    }

    // Test SHA-1 encrypt
    @Test
    public void testEncryptSHA1SingleWord() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("test".getBytes());
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1MultipleWords() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("Another test".getBytes());
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1EmptyByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(new byte[0]);
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1MultipleEmptyByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(new byte[0]);
        }
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1NullByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(null);
        assertThrows(NullPointerException.class,()->jcepSHA1.encrypt(list));
    }

    @Test
    public void testEncryptSHA1MultipleNullByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(null);
        }
        assertThrows(NullPointerException.class,()->jcepSHA1.encrypt(list));
    }

    @Test
    public void testEncryptSHA1EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
        assertNotEquals(0, result.length());
    }

    @Test
    public void testEncryptSHA1LengthOfHash() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
        assertEquals(40, result.length());
    }

    @Test
    public void testEncryptSHA1SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptSHA1MixEncodings() throws UnsupportedEncodingException {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("こんにちは世界".getBytes("UTF-8"));
        list.add("你好世界".getBytes("UTF-16"));
        String result = jcepSHA1.encrypt(list);
        assertNotNull(result);
    }

    // Test MD2 encrypt
    @Test
    public void testEncryptMD2SingleWord() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("test".getBytes());
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2MultipleWords() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("Another test".getBytes());
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2EmptyByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(new byte[0]);
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2MultipleEmptyByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(new byte[0]);
        }
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2NullByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(null);
        assertThrows(NullPointerException.class,()->jcepMD2.encrypt(list));
    }

    @Test
    public void testEncryptMD2MultipleNullByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(null);
        }
        assertThrows(NullPointerException.class,()->jcepMD2.encrypt(list));
    }

    @Test
    public void testEncryptMD2EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
        assertNotEquals(0, result.length());
    }

    @Test
    public void testEncryptMD2LengthOfHash() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
        assertEquals(32, result.length());
    }

    @Test
    public void testEncryptMD2SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD2MixEncodings() throws UnsupportedEncodingException {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("こんにちは世界".getBytes("UTF-8"));
        list.add("你好世界".getBytes("UTF-16"));
        String result = jcepMD2.encrypt(list);
        assertNotNull(result);
    }

    // Test MD5 encrypt
    @Test
    public void testEncryptMD5SingleWord() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("test".getBytes());
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5MultipleWords() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5MultipleByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("Another test".getBytes());
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5EmptyByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(new byte[0]);
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5MultipleEmptyByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(new byte[0]);
        }
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5NullByteArray() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(null);
        assertThrows(NullPointerException.class,()->jcepMD5.encrypt(list));
    }

    @Test
    public void testEncryptMD5MultipleNullByteArrays() {
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < 10; i++) {
            list.add(null);
        }
        assertThrows(NullPointerException.class,()->jcepMD5.encrypt(list));
    }

    @Test
    public void testEncryptMD5EmptyList() {
        List<byte[]> list = new ArrayList<byte[]>();
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
        assertNotEquals(0, result.length());
    }

    @Test
    public void testEncryptMD5LengthOfHash() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
        assertEquals(32, result.length());
    }

    @Test
    public void testEncryptMD5SpecialCharacters() {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("!@#$%^&*()_+-=[]{};':\"\\|,.<>/?".getBytes());
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }

    @Test
    public void testEncryptMD5MixEncodings() throws UnsupportedEncodingException {
        List<byte[]> list = new ArrayList<byte[]>();
        list.add("This is a test".getBytes());
        list.add("こんにちは世界".getBytes("UTF-8"));
        list.add("你好世界".getBytes("UTF-16"));
        String result = jcepMD5.encrypt(list);
        assertNotNull(result);
    }
}