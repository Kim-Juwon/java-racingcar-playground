package exception;

public class IllegalInputException extends CustomException {
    public IllegalInputException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
