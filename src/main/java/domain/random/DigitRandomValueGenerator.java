package domain.random;

import java.util.Random;

public class DigitRandomValueGenerator implements RandomValueGenerator {
    private static final int MAX = 9;

    private final Random random = new Random();

    public static DigitRandomValueGenerator create() {
        return new DigitRandomValueGenerator();
    }

    @Override
    public int generate() {
        return generateRandomValueInRange();
    }

    public int generateRandomValueInRange() {
        return random.nextInt(MAX + 1);
    }
}
