package edu.unicauca.SivriBackendApp.common.ResourceBundleMessages;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.ResourceBundle;

public class BundleMessage {

    private static final ResourceBundle exceptionMessages =
            ResourceBundle.getBundle("exceptions", LocaleContextHolder.getLocale());

    private static final ResourceBundle responseMessages =
            ResourceBundle.getBundle("response", LocaleContextHolder.getLocale());

    public static String getExceptionMessage(String key){
        return exceptionMessages.getString(key);
    }

    public static String getExceptionMessage(String key, List args){
        return formatMessage(exceptionMessages.getString(key),args);
    }

    public static String getResponseMessage(String key){
        return responseMessages.getString(key);
    }

    public static String getResponsenMessage(String key, List args){
        return formatMessage(responseMessages.getString(key),args);
    }

    /**
     * Formats the message and fills multiple missing parts using the argument list.
     *
     * @param message the message to format
     * @param args list the arguments
     * @return the formatted and filled message
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
