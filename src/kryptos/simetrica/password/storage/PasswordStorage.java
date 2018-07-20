/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.password.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import sun.misc.BASE64Encoder;

/**
 *
 * @author izaquiellopesdebessas
 */
public class PasswordStorage {

    private String ssalt, sdigest;

    /**
     * Gera a criptografia de senha, a qual deve ser armazenada em duas
     * variáveis, salt e digest, podendo serem recuperadas através de seus
     * métodos GET
     *
     * @param passwd String pura a qual será retornada como duas strings
     * criptografadas
     * @param padrao Padrão em que a string passada está, tal como ISO8859-1,
     * UTF8...
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void createPassword(String passwd, String padrao) throws NoSuchAlgorithmException, UnsupportedEncodingException, FileNotFoundException, IOException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[12];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(salt);
        md.update(passwd.getBytes(padrao));
        byte[] digest = md.digest();

        this.ssalt = new BASE64Encoder().encode(salt);
        this.sdigest = new BASE64Encoder().encode(digest);
    }

    public String getSdigest() {
        return sdigest;
    }

    public String getSsalt() {
        return ssalt;
    }
}
