package br.com.seguro.unimed.exception;

public class GlobalException extends RuntimeException {
    public GlobalException(String msg) {
        super(msg);
    }

    public GlobalException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
