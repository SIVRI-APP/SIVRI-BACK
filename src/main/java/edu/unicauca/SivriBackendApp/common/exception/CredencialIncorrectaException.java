package edu.unicauca.SivriBackendApp.common.exception;

import java.util.List;

public class CredencialIncorrectaException extends BaseException{

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    public CredencialIncorrectaException(String key) {
        super(key);
    }

    public CredencialIncorrectaException(String key, List args) {
        super(key, args);
    }
}
