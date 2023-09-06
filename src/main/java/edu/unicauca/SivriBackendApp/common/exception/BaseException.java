package edu.unicauca.SivriBackendApp.common.exception;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.ResourceBundle;

public class BaseException extends RuntimeException {

    /**
     * The exceptions resource bundle.
     */
    private static final ResourceBundle messages =
            ResourceBundle.getBundle("exceptions", LocaleContextHolder.getLocale());

    // ~ Constructors
    // ====================================================================

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    BaseException(String key) {
        super(getMessage(key));
    }

    BaseException(String key, List args) {
        super(formatMessage(messages.getString(key), args));
    }

    // ~ Methods
    // ====================================================================

    /**
     * Gets a string for the given key from the exceptions resource bundle.
     *
     * @param key the key for the desired string
     * @return the string value for the given key
     */
    private static String getMessage(String key) {
        return messages.getString(key);
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
