/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.convercao;

/**
 *
 * @author izaquiellopesdebessas
 */
public class ByteArrayToHexString {

    /**
     * Recebe um array de bytes e retorna uma string de hexadecimais
     * @param b array de bytes
     * @return string de hexas
     */
    public String ByteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        String hexDigits = "0123456789abcdef";

        for (int i = 0; i < b.length; i++) {
            int j = ((int) b[i]) & 0xFF;
            sb.append(hexDigits.charAt(j / 16));
            sb.append(hexDigits.charAt(j % 16));
        }

        return sb.toString();
    }
}
