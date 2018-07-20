/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.blowfish;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

/**
 *
 * @author izaquiellopesdebessas
 */
public class Blowfish {

    /**
     * Passa-se uma string para ser criptografada, recebendo seu conteúdo
     * criptografado em bytes.
     *
     * @param encriptar String a ser criptografada
     * @param key Chave secreta
     * @return array de bytes gerado pelo algoritmo Blowfish
     */
    public byte[] Encript(String encriptar, SecretKey key) {
        try {
            Cipher encriptado = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            encriptado.init(Cipher.ENCRYPT_MODE, key);

            return encriptado.doFinal(encriptar.getBytes("UTF8"));
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Passa-se um array de bytes a ser descriptografado, recebendo seu conteúdo
     * descriptografado em uma string.
     *
     * @param decriptar array de bytes a ser descriptografado
     * @param key Chave secreta
     * @return string descriptografada pelo algoritmo Blowfish
     */
    public String Decript(byte[] decriptar, SecretKey key) {
        try {
            Cipher decriptado = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            decriptado.init(Cipher.DECRYPT_MODE, key);

            return new String(decriptado.doFinal(decriptar), "UTF8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Blowfish.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
