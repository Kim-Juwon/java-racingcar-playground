package exception;

public enum ExceptionMessage {
    ATTEMPT_COUNT_IS_INVALID("시도할 횟수는 10000 이하의 자연수여야 합니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
