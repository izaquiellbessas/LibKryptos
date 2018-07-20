/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kryptos.convercao;

/**
 *
 * @author izaquiellopesdebessas
 */
public class HexStringToByteArray {

    /**
     * Recebe uma string de hexadecimais e retorna um vetor de bytes
     * @param hexa String de hexas
     * @return vetor de bytes
     */
    public byte[] HexStringToByteArray(String hexa) {
        String hexDigits = "0123456789abcdef";

        if (hexa.length() % 2 != 0) {
            return null;
        } else {
            byte[] vetB = new byte[hexa.length() / 2];

            for (int i = 0; i < hexa.length(); i += 2) {
                vetB[i / 2] = (byte) ((hexDigits.indexOf(hexa.charAt(i)) << 4)
                        | (hexDigits.indexOf(hexa.charAt(i + 1))));
            }

            return vetB;
        }
    }
}
