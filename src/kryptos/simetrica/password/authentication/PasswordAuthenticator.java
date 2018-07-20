/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.password.authentication;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kryptos.simetrica.password.storage.PasswordStorage;
import sun.misc.BASE64Decoder;

/**
 *
 * @author izaquiellopesdebessas
 */
public class PasswordAuthenticator {

    /**
     * Passe uma senha digitada pelo usuário, o formato dessa senha e a senha do usuário correspondente na base de dados
     * @param passwd Senha a ser comparada com a gravada na base de dados
     * @param padrao Padrão em que a senha foi digitado, exemplo: ISO8859-1, UTF8
     * @param ps PasswordStorage contendo a senha e o salt a serem comparados
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public boolean authenticatePassword(String passwd, String padrao, PasswordStorage ps) throws IOException, NoSuchAlgorithmException {
        byte[] salt = new BASE64Decoder().decodeBuffer(ps.getSsalt());
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(salt);
        md.update(passwd.getBytes(padrao));
        byte[] digest = md.digest();
        byte[] digestTrue = new BASE64Decoder().decodeBuffer(ps.getSdigest());

        return (Arrays.equals(digest, digestTrue));
    }
}
