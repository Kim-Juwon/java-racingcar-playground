package domain.car;

import domain.random.DigitRandomValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars fromNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> Car.of(DigitRandomValueGenerator.create(), name))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getMostMovedCarNames() {
        if (cars.isEmpty()) {
            return new ArrayList<>();
        }

        int maximumLocation = getMaximumLocationFromCars();
        return getCarNamesWithLocation(maximumLocation);
    }

    public void attemptToMove() {
        cars.forEach(Car::attemptToMove);
    }

    private int getMaximumLocationFromCars() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    private List<String> getCarNamesWithLocation(int location) {
        return cars.stream()
                .filter(car -> car.hasSameLocation(location))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
