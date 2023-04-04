package domain.car;

import domain.random.RandomValueGenerator;
import domain.wrapper.Name;

public class Car {
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private final RandomValueGenerator randomValueGenerator;
    private final Name name;
    private int location;

    private Car(RandomValueGenerator randomValueGenerator, String nameString) {
        this.randomValueGenerator = randomValueGenerator;
        this.name = Name.from(nameString);
    }

    public static Car of(RandomValueGenerator randomValueGenerator, String name) {
        return new Car(randomValueGenerator, name);
    }

    public String getName() {
        return name.getName();
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
