package edu.unicauca.SivriBackendApp.common.exception;

import edu.unicauca.SivriBackendApp.common.ResourceBundleMessages.BundleMessage;

import java.util.List;

public class BaseException extends RuntimeException {

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    BaseException(String key) {
        super(BundleMessage.getExceptionMessage(key));
    }

    BaseException(String key, List args) {
        super(BundleMessage.getExceptionMessage(key, args));
    }

}
