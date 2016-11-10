package com.training.lab.exception;

/**
 * Created by USER on 02.11.2016.
 */
public class EmptyTextDataException extends  Exception{
    public EmptyTextDataException() {
    }

    public EmptyTextDataException(String message) {
        super(message);
    }

    public EmptyTextDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTextDataException(Throwable cause) {
        super(cause);
    }
}
