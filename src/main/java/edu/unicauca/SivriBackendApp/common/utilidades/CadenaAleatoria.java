package edu.unicauca.SivriBackendApp.common.utilidades;
import java.security.SecureRandom;

public class CadenaAleatoria {

    private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generarStringAleatorio(int longitud) {
        StringBuilder sb = new StringBuilder(longitud);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(CARACTERES_PERMITIDOS.length());
            char caracterAleatorio = CARACTERES_PERMITIDOS.charAt(index);
            sb.append(caracterAleatorio);
        }

        return sb.toString();
    }

}
