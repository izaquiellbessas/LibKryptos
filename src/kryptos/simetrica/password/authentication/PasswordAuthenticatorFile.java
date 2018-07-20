/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.password.authentication;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author izaquiellopesdebessas
 */
public class PasswordAuthenticatorFile {

    /**
     * Realiza a autenticação por comparação do password e salt registrados no
     * arquivo passwd no diretório da aplicação com o que é informado através de
     * parâmetros
     *
     * @param passwd Password a ser autenticado, comparado com o password
     * criptografado no arquivo passwd
     * @param padrao Padrão em que foi digitado o password a ser comparado com o
     * do arquivo passwd, é importante que esteja no mesmo formato do que foi
     * digitado no arquivo
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public boolean authenticatePassword(String passwd, String padrao) throws IOException, NoSuchAlgorithmException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fis = new FileInputStream("passwd")) {
            int Byte;
            while ((Byte = fis.read()) == -1) {
                baos.write(Byte);
            }
        }

        byte[] hashedPasswordWithSalt = baos.toByteArray();
        baos.reset();

        byte[] salt = new byte[12];
        System.arraycopy(hashedPasswordWithSalt, 0, salt, 0, 12);

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(salt);
        md.update(passwd.getBytes(padrao));
        byte[] digest = md.digest();

        byte[] digestInFile = new byte[hashedPasswordWithSalt.length - 12];
        System.arraycopy(hashedPasswordWithSalt, 12, digestInFile, 0, hashedPasswordWithSalt.length - 12);

        return (Arrays.equals(digest, digestInFile));
    }
}
