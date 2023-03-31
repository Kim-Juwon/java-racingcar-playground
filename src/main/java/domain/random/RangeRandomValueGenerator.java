package domain.random;

import java.util.Random;

public class RangeRandomValueGenerator implements RandomValueGenerator {
    private static final int ONE = 1;

    private final int min;
    private final int max;
    private final Random random = new Random();

    private RangeRandomValueGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     *
     * @param min 랜덤으로 부여될 수 있는 최소 정수
     * @param max 랜덤으로 부여될 수 있는 최대 정수
     * @return min,max 값이 세팅된 RangeRandomValueGenerator 인스턴스
     */
    public static RangeRandomValueGenerator from(int min, int max) {
        return new RangeRandomValueGenerator(min, max);
    }

    @Override
    public int generate() {
        return generateRandomValueInRange();
    }

    private int generateRandomValueInRange() {
        return random.nextInt(max - min + ONE) + min;
    }
}
