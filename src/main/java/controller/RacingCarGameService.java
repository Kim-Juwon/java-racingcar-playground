package controller;

import domain.car.Cars;
import exception.IllegalInputException;
import service.GameService;
import view.Reader;
import view.Writer;

import java.util.stream.IntStream;

public class RacingCarGameService implements GameService {
    private final Writer writer = Writer.create();
    private final Reader reader = Reader.create();
    private Cars cars;
    private int attemptCount;
    private boolean illegalInput;

    public static RacingCarGameService create() {
        return new RacingCarGameService();
    }

    @Override
    public void run() {
        try {
            inputCarNames();
            inputAttemptCount();
            attemptToMoveAndShowStatus();
            showResult();
        } catch (Throwable throwable) {
            showUnpredictedErrorMessageFrom(throwable);
        }
    }

    private void inputCarNames() {
        writer.writeMessageAboutRequestCarsName();
        cars = Cars.fromNames(reader.readCarNames());
    }

    private void inputAttemptCount() {
        do {
            try {
                writer.writeMessageAboutAttemptCount();
                attemptCount = reader.readAttemptCount();
                changeToNonIllegalInput();
            } catch (IllegalInputException exception) {
                showIllegalInputErrorMessageFrom(exception);
                changeToIllegalInput();
            }
        } while (illegalInput);
    }

    private void attemptToMoveAndShowStatus() {
        IntStream.range(0, attemptCount).forEach(count -> {
            cars.attemptToMove();
            writer.writeCurrentStatusFrom(cars);
        });
    }

    private void showResult() {
        writer.writeResultFrom(cars);
    }

    private void changeToIllegalInput() {
        illegalInput = true;
    }

    private void changeToNonIllegalInput() {
        illegalInput = false;
    }

    private void showIllegalInputErrorMessageFrom(IllegalInputException exception) {
        writer.write(exception.getMessage());
    }

    private void showUnpredictedErrorMessageFrom(Throwable throwable) {
        writer.writeUnpredictedErrorMessage(throwable);
    }
}
