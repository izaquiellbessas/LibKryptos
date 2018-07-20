/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.simetrica.MD5.base64;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author izaquiellopesdebessas
 */
public class MD5base64File {

    private String MD5base64;
    private FileInputStream input;

    /**
     * Construtor de Classe
     * @param diretorio url onde encontra-se o arquivo, deve-se ter o cuidado de acrescentar a '/' ao fim do diretório
     * @param arquivo nome do arquivo juntamente com sua extenção, caso o tenha
     * @throws FileNotFoundException
     */
    public MD5base64File(String diretorio, String arquivo) throws FileNotFoundException {
        this.MD5base64 = "";
        this.input = new FileInputStream(diretorio + arquivo);
    }

    /**
     * Gera o MD5 em base 64 do arquivo passado por parâmetro
     * @throws NoSuchAlgorithmException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void create() throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BufferedInputStream bis = new BufferedInputStream(input);

        int Byte;
        while ((Byte = bis.read()) != -1) {
            md.update((byte) Byte);
        }
        bis.close();

        byte[] digest = md.digest();
        this.MD5base64 = new BASE64Encoder().encode(digest);
    }

    /**
     * Recupere o MD5 em base 64 do arquivo passado
     * @return Retorna-se o código MD5 em base 64 do arquivo em questão
     */
    public String getMD5base64() {
        return MD5base64;
    }

    /**
     * Passe o arquivo a ser medido pelo MD5
     * @param input Arquivo a ser medido
     */
    public void setInput(FileInputStream input) {
        this.input = input;
    }
}
