package domain;

public class Car {
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private final RandomValueGenerator randomValueGenerator;
    private String name;
    private int location;

    private Car(RandomValueGenerator randomValueGenerator, String name) {
        this.randomValueGenerator = randomValueGenerator;
        this.name = name;
    }

    public static Car of(RandomValueGenerator randomValueGenerator, String name) {
        return new Car(randomValueGenerator, name);
    }

    public int getLocation() {
        return location;
    }

    public void attemptToMove() {
        if (meetConditionToMove()) {
            move();
        }
    }

    private boolean meetConditionToMove() {
        return randomValueGenerator.generate() >= MINIMUM_VALUE_TO_MOVE;
    }

    private void move() {
        ++location;
    }
}
