/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.password.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author izaquiellopesdebessas
 */
public class PasswordStorageFile {

    /**
     * Forneça uma string juntamente com seu padrão de digitação para obter sua
     * criptografia com MD5 e salt Random. No fim da execução deste algoritmo a
     * senha criptografada será escrita em um arquivo denominado passwd, sem
     * extenção no diretório da aplicação
     *
     * @param passwd Fornece-se uma string pura para se obter sua encriptação
     * @param padrao Fornece-se o padrão em que a String fornecida se encontra,
     * tais como UTF8, ISO8859-1...
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

        try (FileOutputStream fos = new FileOutputStream("passwd")) {
            fos.write(salt);
            fos.write(digest);
        }
    }
}
