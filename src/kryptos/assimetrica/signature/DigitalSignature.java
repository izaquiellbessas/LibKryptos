/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.assimetrica.signature;

import java.security.*;

/**
 *
 * @author izaquiellopesdebessas
 */
public class DigitalSignature {

    private final Signature sig;
    private final KeyPairGenerator kpg;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    /**
     * Gerador de par de chaves (pública e privada) para assinatura digital
     * @param algoritmo algoritmo a ser utilizado para geração das chaves
     * @param size variação do campo aleatório
     * @throws NoSuchAlgorithmException 
     */
    public DigitalSignature(String algoritmo, int size) throws NoSuchAlgorithmException {
        this.sig = Signature.getInstance(algoritmo);
        this.kpg = KeyPairGenerator.getInstance(algoritmo);
        iniciar(size);
    }

    private void iniciar(int keySize) {
        SecureRandom sr = new SecureRandom();
        kpg.initialize(keySize, sr);
        KeyPair kp = kpg.generateKeyPair();

        publicKey = kp.getPublic();
        privateKey = kp.getPrivate();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public Signature getSig() {
        return sig;
    }
}
