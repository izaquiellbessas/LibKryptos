/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.MD5.base64;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author izaquiellopesdebessas
 */
public class MD5base64 {

    /**
     * Deve-se passar uma string para se obeter seu MD5 em base 64
     * 
     * @param s String que irá ter seu MD5 gerado
     * @return MD5 da string passada em base 64 encode
     * @throws NoSuchAlgorithmException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public String gerar(String s) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        md.update(s.getBytes());

        byte[] digest = md.digest();
        return new BASE64Encoder().encode(digest);
    }
}
