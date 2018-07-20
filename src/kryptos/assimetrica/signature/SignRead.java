/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.assimetrica.signature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import sun.security.provider.DSAPublicKey;


/**
 *
 * @author izaquiellopesdebessas
 */
public class SignRead {

    /**
     * Verifica a validade de uma texto e uma chave pública gerados a partir de
     * um algoritmo DSA
     *
     * @param pubSing chave pública
     * @param msg texto criptografado
     * @return verdadeiro se a chave pública lê o arquivo, falso caso contrário.
     * Em caso verdadeiro a identidade do rementente é assegurada
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     */
    public boolean ReadSignDSA(byte[] pubSing, String msg) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
        Signature cli = Signature.getInstance("DSA");
        PublicKey pk = new DSAPublicKey(pubSing);

        cli.initVerify(pk);
        cli.update(msg.getBytes());

        return (cli.verify(pubSing));
    }
}
