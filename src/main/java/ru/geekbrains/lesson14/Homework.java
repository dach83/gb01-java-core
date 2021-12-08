package ru.geekbrains.lesson14;


// 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
// идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
// необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
// Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

// 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
// то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
// [ 1 1 1 4 4 1 4 4 ] -> true [ 1 1 1 1 1 1 ] -> false [ 4 4 4 4 ] -> false [ 1 4 4 1 1 4 3 ] -> false

import java.util.Arrays;

public class Homework {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(copyAfterFour(1, 2, 4, 4, 2, 3, 4, 1, 7)));
        System.out.println(checkOneAndFour(1, 1, 1, 4, 4, 1, 4, 4));
        System.out.println(checkOneAndFour(1, 1, 1, 1, 1, 1));
        System.out.println(checkOneAndFour(4, 4, 4, 4));
        System.out.println(checkOneAndFour(1, 4, 4, 1, 1, 4, 3));
    }

    public static int[] copyAfterFour(int... nums) throws RuntimeException {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4)
                return Arrays.copyOfRange(nums, i + 1, nums.length);
        }
        throw new RuntimeException("Массив не содержит 4");
    }

    public static boolean checkOneAndFour(int... nums) {
        boolean containOne = false;
        boolean containFour = false;
        for (int num : nums) {
            if (num == 1) {
                containOne = true;
            } else if (num == 4) {
                containFour = true;
            } else {
                return false;
            }
        }

        return containOne && containFour;
    }

}
