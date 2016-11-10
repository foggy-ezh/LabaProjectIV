package com.training.lab.exception;

/**
 * Created by USER on 02.10.2016.
 */
public class CantReadDataFileException extends Exception {
    public CantReadDataFileException() {
    }

    public CantReadDataFileException(String message) {
        super(message);
    }

    public CantReadDataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantReadDataFileException(Throwable cause) {
        super(cause);
    }
}
