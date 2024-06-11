package edu.unicauca.SivriBackendApp.common.resourceBundleMessages;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Clase para manejar mensajes desde archivos de recursos (bundles).
 * Proporciona métodos para obtener mensajes de excepción y respuesta,
 * formateando estos mensajes con argumentos si es necesario.
 */
public class BundleMessage {

    // Bundle para mensajes de excepciones
    private static final ResourceBundle exceptionMessages =
            ResourceBundle.getBundle("exceptions", LocaleContextHolder.getLocale());

    // Bundle para mensajes de respuesta
    private static final ResourceBundle responseMessages =
            ResourceBundle.getBundle("response", LocaleContextHolder.getLocale());

    /**
     * Obtiene un mensaje de excepción basado en la clave proporcionada.
     *
     * @param key la clave del mensaje de excepción
     * @return el mensaje de excepción correspondiente a la clave
     */
    public static String getExceptionMessage(String key){
        return exceptionMessages.getString(key);
    }

    /**
     * Obtiene un mensaje de excepción formateado con argumentos basado en la clave proporcionada.
     *
     * @param key la clave del mensaje de excepción
     * @param args la lista de argumentos para formatear el mensaje
     * @return el mensaje de excepción formateado con los argumentos
     */
    public static String getExceptionMessage(String key, List<String> args){
        return formatMessage(exceptionMessages.getString(key), args);
    }

    /**
     * Obtiene un mensaje de respuesta basado en la clave proporcionada.
     *
     * @param key la clave del mensaje de respuesta
     * @return el mensaje de respuesta correspondiente a la clave
     */
    public static String getResponseMessage(String key){
        return responseMessages.getString(key);
    }

    /**
     * Obtiene un mensaje de respuesta formateado con argumentos basado en la clave proporcionada.
     *
     * @param key la clave del mensaje de respuesta
     * @param args la lista de argumentos para formatear el mensaje
     * @return el mensaje de respuesta formateado con los argumentos
     */
    public static String getResponseMessage(String key, List<String> args){
        return formatMessage(responseMessages.getString(key), args);
    }

    /**
     * Formatea el mensaje y llena múltiples partes faltantes usando la lista de argumentos.
     *
     * @param message el mensaje a formatear
     * @param args la lista de argumentos
     * @return el mensaje formateado y completado
     */
    private static String formatMessage(String message, List<String> args) {
        int argIndex = 0; // Inicializamos un índice para recorrer la lista de argumentos
        StringBuilder result = new StringBuilder(); // Usamos un StringBuilder para construir el resultado

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '{' && i + 1 < message.length() && message.charAt(i + 1) == '}') {
                // Si encontramos "{}", reemplazamos con el siguiente argumento de la lista
                if (argIndex < args.size()) {
                    result.append(args.get(argIndex));
                    argIndex++;
                }
                i++; // Saltamos el segundo carácter "}" para evitar reemplazos duplicados
            } else {
                // Si no encontramos "{}", copiamos el carácter original al resultado
                result.append(message.charAt(i));
            }
        }

        return result.toString();
    }
}
