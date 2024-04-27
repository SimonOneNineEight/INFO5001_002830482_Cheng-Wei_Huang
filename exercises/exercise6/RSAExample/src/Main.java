import java.security.*;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        // Generate a RSA key pair for Alice (used for signing the message)
        KeyPair aliceKeyPair = generateKeyPair();
        PrivateKey alicePrivateKey = aliceKeyPair.getPrivate();
        PublicKey alicePublicKey = aliceKeyPair.getPublic();

        // Alice signs her message
        String message = "Hello Bob, this is Alice!";
        byte[] signature = createDigitalSignature(message.getBytes(), alicePrivateKey);

        // Bob verifies the signature using Alice's public key
        boolean isSignatureValid = verifyDigitalSignature(message.getBytes(), signature, alicePublicKey);

        // Print out the result of signature verification
        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(signature));
        System.out.println("Signature valid: " + isSignatureValid);
    }

    // Helper method to generate a RSA key pair
    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    // Helper method to create a digital signature
    private static byte[] createDigitalSignature(byte[] inputData, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(inputData);
        return signature.sign();
    }

    // Helper method to verify a digital signature
    private static boolean verifyDigitalSignature(byte[] inputData, byte[] signatureToVerify, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(inputData);
        return signature.verify(signatureToVerify);
    }
}
