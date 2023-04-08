package domain.car;

import domain.random.RangeRandomValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    Cars cars;

    @BeforeEach
    void initialize() {
        cars = Cars.from(List.of(
                Car.of(RangeRandomValueGenerator.of(0, 3), "car1"),
                Car.of(RangeRandomValueGenerator.of(4, 9), "car2"),
                Car.of(RangeRandomValueGenerator.of(0, 3), "car3"),
                Car.of(RangeRandomValueGenerator.of(4, 9), "car4")
        ));
    }

    @Test
    @DisplayName("attemptToMove() - 랜덤 값이 4 미만이면 location 변화 불가, 4 이상이면 location 1 증가")
    void attemptToMove_ChangePositionBasedOnCondition() {
        // given
        List<Car> beforeCars = cars.getCars();
        Car beforeCar1 = beforeCars.get(0);
        Car beforeCar2 = beforeCars.get(1);
        Car beforeCar3 = beforeCars.get(2);
        Car beforeCar4 = beforeCars.get(3);
        int beforeLocationOfCar1 = beforeCar1.getLocation();
        int beforeLocationOfCar2 = beforeCar2.getLocation();
        int beforeLocationOfCar3 = beforeCar3.getLocation();
        int beforeLocationOfCar4 = beforeCar4.getLocation();

        // when
        cars.attemptToMove();

        // then
        List<Car> afterCars = cars.getCars();
        Car afterCar1 = afterCars.get(0);
        Car afterCar2 = afterCars.get(1);
        Car afterCar3 = afterCars.get(2);
        Car afterCar4 = afterCars.get(3);
        int afterLocationOfCar1 = afterCar1.getLocation();
        int afterLocationOfCar2 = afterCar2.getLocation();
        int afterLocationOfCar3 = afterCar3.getLocation();
        int afterLocationOfCar4 = afterCar4.getLocation();

        assertEquals(beforeLocationOfCar1, afterLocationOfCar1);
        assertEquals(beforeLocationOfCar2 + 1, afterLocationOfCar2);
        assertEquals(beforeLocationOfCar3, afterLocationOfCar3);
        assertEquals(beforeLocationOfCar4 + 1, afterLocationOfCar4);
    }
}
