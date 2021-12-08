package ru.geekbrains.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HomeworkTest {

    public static Stream<Arguments> arrayContainFourProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{5, 6, 7}),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{3, 2, 1}),
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{})
                );
    }

    public static Stream<Arguments> arrayOneAndFourProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true),
                Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false),
                Arguments.arguments(new int[]{4, 4, 4, 4}, false),
                Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false)
                );
    }

    @ParameterizedTest
    @MethodSource("arrayContainFourProvider")
    void testCopyAfterFourIfArrContainFour(int[] sourceArr, int[] expectedArr) {
        Assertions.assertArrayEquals(expectedArr, Homework.copyAfterFour(sourceArr));
    }

    @Test
    void testCopyAfterFourThrowException() {
        Assertions.assertThrows(RuntimeException.class, () -> Homework.copyAfterFour(1, 2, 3, 5, 6, 7));
    }

    @ParameterizedTest
    @MethodSource("arrayOneAndFourProvider")
    void testCheckOneAndFour(int[] sourceArr, boolean expectedRes) {
        Assertions.assertEquals(expectedRes, Homework.checkOneAndFour(sourceArr));
    }

}