package io;

import domain.constant.GameConstant;
import exception.ExceptionMessage;
import exception.IllegalInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reader {
    private static final String SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static Reader create() {
        return new Reader();
    }

    public List<String> readCarNames() {
        String string = readOneLine().trim();
        String[] dividedStrings = getDividedStringsFrom(string);

        return Arrays.stream(dividedStrings)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readAttemptCount() {
        return toInt(readOneLine().trim());
    }

    private String readOneLine() {
        return scanner.nextLine();
    }

    private String[] getDividedStringsFrom(String string) {
        return string.split(SEPARATOR);
    }

    private int toInt(String string) {
        validateConvertible(string);
        return Integer.parseInt(string);
    }

    private void validateConvertible(String string) {
        validateLength(string);
        validateFormat(string);
        validateRange(string);
    }

    private void validateLength(String string) {
        if (Objects.isNull(string) || string.isEmpty() || string.length() > GameConstant.MAXIMUM_DIGITS_OF_ATTEMPT_COUNT) {
            throw new IllegalInputException(ExceptionMessage.ATTEMPT_COUNT_IS_INVALID);
        }
    }

    private void validateFormat(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            throw new IllegalInputException(ExceptionMessage.ATTEMPT_COUNT_IS_INVALID);
        }
    }

    private void validateRange(String string) {
        if (Objects.isNull(string)) {
            throw new IllegalInputException(ExceptionMessage.ATTEMPT_COUNT_IS_INVALID);
        }

        int attemptCount = Integer.parseInt(string);
        if (attemptCount <= 0 || attemptCount > GameConstant.MAXIMUM_VALUE_OF_ATTEMPT_COUNT) {
            throw new IllegalInputException(ExceptionMessage.ATTEMPT_COUNT_IS_INVALID);
        }
    }
}
