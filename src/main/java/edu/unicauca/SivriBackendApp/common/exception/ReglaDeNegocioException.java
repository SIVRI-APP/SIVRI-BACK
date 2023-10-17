package edu.unicauca.SivriBackendApp.common.exception;

import java.util.List;

public class ReglaDeNegocioException extends BaseException{

    /**
     * Constructs a BaseException with the specified detail key message.
     *
     * @param key the detailed key message
     */
    public ReglaDeNegocioException(String key) {
        super(key);
    }

    public ReglaDeNegocioException(String key, List args) {
        super(key, args);
    }

}
