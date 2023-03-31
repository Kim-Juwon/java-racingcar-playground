package exception;

public class CustomException extends RuntimeException {
    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
