import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class SymmetricCryptoExample {

    private static final String AES = "AES";
    private static final String AES_CIPHER = "AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256;
    private static final int GCM_TAG_LENGTH = 128;
    private static final int GCM_NONCE_LENGTH = 12; // 12 bytes for GCM IV

    public static void main(String[] args) throws Exception {
        // Generate AES key for Alice and Bob
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        keyGen.init(AES_KEY_SIZE);
        SecretKey sharedSecretKey = keyGen.generateKey();

        // Generate IV
        byte[] iv = new byte[GCM_NONCE_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

        // Alice encrypts a message to Bob
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, sharedSecretKey, gcmSpec);

        String message = "Hello Bob, this is Alice!";
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encryptedMessage));

        // Bob decrypts the message
        cipher.init(Cipher.DECRYPT_MODE, sharedSecretKey, gcmSpec);
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
        System.out.println("Decrypted Message: " + new String(decryptedMessage));
    }
}
