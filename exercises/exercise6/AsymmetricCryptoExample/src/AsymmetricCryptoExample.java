import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class AsymmetricCryptoExample {

    private static final String RSA = "RSA";
    private static final String RSA_CIPHER = "RSA/ECB/PKCS1Padding";
    private static final int RSA_KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {
        // Generate RSA key pair for Alice
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        KeyPair aliceKeyPair = keyPairGenerator.generateKeyPair();
        PrivateKey alicePrivateKey = aliceKeyPair.getPrivate();
        PublicKey alicePublicKey = aliceKeyPair.getPublic();

        // Generate RSA key pair for Bob
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        KeyPair bobKeyPair = keyPairGenerator.generateKeyPair();
        PrivateKey bobPrivateKey = bobKeyPair.getPrivate();
        PublicKey bobPublicKey = bobKeyPair.getPublic();

        // Alice encrypts a message to Bob using Bob's public key
        Cipher cipher = Cipher.getInstance(RSA_CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, bobPublicKey);
        String message = "Hello Bob, this is Alice!";
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encryptedMessage));

        // Bob decrypts the message using his private key
        cipher.init(Cipher.DECRYPT_MODE, bobPrivateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
        System.out.println("Decrypted Message: " + new String(decryptedMessage));

        // Message Signing by Alice
        cipher.init(Cipher.ENCRYPT_MODE, alicePrivateKey);
        byte[] signature = cipher.doFinal(message.getBytes());
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));

        // Signature Validation by Bob
        cipher.init(Cipher.DECRYPT_MODE, alicePublicKey);
        byte[] verified = cipher.doFinal(signature);
        if (message.equals(new String(verified))) {
            System.out.println("Signature verified by Bob!");
        } else {
            System.out.println("Signature verification failed!");
        }
    }
}
