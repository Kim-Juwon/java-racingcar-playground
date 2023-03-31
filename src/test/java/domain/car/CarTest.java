package domain.car;

import domain.random.RangeRandomValueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @RepeatedTest(3)
    @DisplayName("attemptToMove() - 랜덤 값이 4 미만이면 location 변화 불가")
    void attemptToMove_LocationShouldNotChangeWhenRandomValueLessThanFour() {
        // given
        Car car = Car.of(RangeRandomValueGenerator.from(0, 3), "test car");
        int beforeLocation = car.getLocation();

        // when
        car.attemptToMove();

        // then
        int afterLocation = car.getLocation();
        assertEquals(beforeLocation, afterLocation);
    }

    @RepeatedTest(3)
    @DisplayName("attemptToMove() - 랜덤 값이 4 이상이면 location 1 증가")
    void attemptToMove_LocationShouldIncreaseByOneWhenRandomValueFourOrHigher() {
        // given
        Car car = Car.of(RangeRandomValueGenerator.from(4, 9), "test car");
        int beforeLocation = car.getLocation();

        // when
        car.attemptToMove();

        // then
        int afterLocation = car.getLocation();
        assertEquals(beforeLocation + 1, afterLocation);
    }
}