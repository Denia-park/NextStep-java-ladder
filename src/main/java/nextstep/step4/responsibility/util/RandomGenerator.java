package nextstep.step4.responsibility.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }
}