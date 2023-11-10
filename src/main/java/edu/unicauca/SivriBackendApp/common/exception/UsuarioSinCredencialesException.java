package edu.unicauca.SivriBackendApp.common.exception;

import java.util.List;

public class UsuarioSinCredencialesException extends BaseException{

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    public UsuarioSinCredencialesException(String key) {
        super(key);
    }

    public UsuarioSinCredencialesException(String key, List args) {
        super(key, args);
    }
}
