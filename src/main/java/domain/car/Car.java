package domain.car;

import domain.random.RandomValueGenerator;

public class Car {
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private final RandomValueGenerator randomValueGenerator;
    private final String name;
    private int location;

    private Car(RandomValueGenerator randomValueGenerator, String name) {
        this.randomValueGenerator = randomValueGenerator;
        this.name = name;
    }

    public static Car of(RandomValueGenerator randomValueGenerator, String name) {
        return new Car(randomValueGenerator, name);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void attemptToMove() {
        if (meetConditionToMove()) {
            move();
        }
    }

    public boolean hasSameLocation(int location) {
        return this.location == location;
    }

    private boolean meetConditionToMove() {
        return generateRandomNumber() >= MINIMUM_VALUE_TO_MOVE;
    }

    private int generateRandomNumber() {
        return randomValueGenerator.generate();
    }

    private void move() {
        ++location;
    }
}
