package exceptions;

public class ShiptException extends RuntimeException {

    public ShiptException() {

        super();
    }

    public ShiptException(String message) {

        super(message);
    }

    public ShiptException(String message, Throwable cause) {
        super(message, cause);
    }
}
