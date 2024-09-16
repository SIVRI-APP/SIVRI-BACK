package edu.unicauca.SivriBackendApp.common.exception;

import edu.unicauca.SivriBackendApp.common.resourceBundleMessages.BundleMessage;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class BaseException extends RuntimeException {

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    BaseException(String key) {
        super(BundleMessage.getExceptionMessage(key));
    }

    BaseException(String key, List<String> args) {
        super(BundleMessage.getExceptionMessage(key, args));
    }
    private static String getMessageForKey(String key) {
        try {
            return ResourceBundle.getBundle("messages").getString(key);
        } catch (MissingResourceException e) {
            return key; // En pruebas, devuelve el key si el recurso no está disponible
        }
    }
}
