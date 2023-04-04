package domain.car;

import domain.random.RandomValueGenerator;
import domain.wrapper.Location;
import domain.wrapper.Name;

public class Car {
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private final RandomValueGenerator randomValueGenerator;
    private final Name name;
    private final Location location = Location.createWithZero();

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
        return location.getLocation();
    }

    public void attemptToMove() {
        if (canMove()) {
            move();
        }
    }

    public boolean hasSameLocation(int locationValue) {
        return location.hasSameLocation(locationValue);
    }

    private boolean canMove() {
        return generateRandomNumber() >= MINIMUM_VALUE_TO_MOVE;
    }

    private int generateRandomNumber() {
        return randomValueGenerator.generate();
    }

    private void move() {
        location.addOne();
    }
}
