/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.assimetrica.signature;

import java.security.InvalidKeyException;
import java.security.SignatureException;

/**
 *
 * @author izaquiellopesdebessas
 */
public class Sign {

    /**
     * Retorna uma assinatura digital através da chave privada, para ser
     * descriptografada a partir da chave publica
     *
     * @param msg Mensagem, string a ser criptografada
     * @param ds DigitalSignature, classe que contém as chaves e assinaturas
     * @return Criptografia assinada com uma chave privada em forma de um array
     * de bytes
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public byte[] SignString(String msg, DigitalSignature ds) throws InvalidKeyException, SignatureException {
        ds.getSig().initSign(ds.getPrivateKey());
        ds.getSig().update(msg.getBytes());
        return ds.getSig().sign();
    }
}
