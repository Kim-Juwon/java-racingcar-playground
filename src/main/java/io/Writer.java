package io;

import domain.car.Car;
import domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class Writer {
    private static final String CARS_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ATTEMPT_COUNT_QUESTION_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE_SUFFIX = "(이)가 최종 우승했습니다.";
    private static final String UNPREDICTED_ERROR_MESSAGE = "예상치 못한 에러가 발생하였습니다. (message: %s)";
    private static final String CAR_NAME_AND_COLON = "%s : ";
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    private static final String WHITESPACE_CHARACTER = " ";

    public static Writer create() {
        return new Writer();
    }

    public void write(String string) {
        System.out.println(string);
    }

    public void writeMessageAboutRequestCarsName() {
        write(CARS_NAME_REQUEST_MESSAGE);
    }

    public void writeMessageAboutAttemptCount() {
        write(ATTEMPT_COUNT_QUESTION_MESSAGE);
    }

    public void writeCurrentStatusFrom(Cars cars) {
        write(makeCurrentStatusStringFrom(cars));
    }

    public void writeResultFrom(Cars cars) {
        List<String> mostMovedCarNames = cars.getMostMovedCarNames();
        write(makeResultStringFrom(mostMovedCarNames));
    }

    public void writeUnpredictedErrorMessage(Throwable throwable) {
        write(String.format(UNPREDICTED_ERROR_MESSAGE, throwable.getMessage()));
    }

    private String makeCurrentStatusStringFrom(Cars cars) {
        return cars.getCars().stream()
                .map(this::makeCurrentStatusString)
                .collect(Collectors.joining());
    }

    private String makeCurrentStatusString(Car car) {
        return merge(
                String.format(CAR_NAME_AND_COLON, car.getName()),
                HYPHEN.repeat(car.getLocation()),
                NEWLINE
        );
    }

    private String makeResultStringFrom(List<String> carNames) {
        return merge(makeCarNamesStringFrom(carNames), RESULT_MESSAGE_SUFFIX);
    }

    private String makeCarNamesStringFrom(List<String> carNames) {
        StringBuilder stringBuilder = new StringBuilder();

        carNames.forEach(carName -> {
            if (isLengthPositive(stringBuilder)) {
                stringBuilder.append(COMMA);
                stringBuilder.append(WHITESPACE_CHARACTER);
            }
            stringBuilder.append(carName);
        });

        return stringBuilder.toString();
    }

    private boolean isLengthPositive(StringBuilder stringBuilder) {
        return stringBuilder.length() > 0;
    }

    private String merge(String... strings) {
        return String.join("", strings);
    }
}
