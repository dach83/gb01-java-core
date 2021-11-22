package ru.geekbrains.lesson9;


// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
// MyArrayDataException и вывести результат расчета.

public class Homework {

    private static final int EXPECT_SIZE = 4;

    public static void main(String[] args) {
        // правильная матрица
        String[][] m1 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };

        // три строки
        String[][] m2 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };

        // три элемента в строке
        String[][] m3 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };

        // нечисловые данные
        String[][] m4 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "f", "1", "1"},
                {"1", "1", "1", "1"},
        };

        printSumMatrix(m1);
        printSumMatrix(m2);
        printSumMatrix(m3);
        printSumMatrix(m4);
    }

    public static void printSumMatrix(String[][] m1) {
        try {
            System.out.println("Сумма: " + sumMatrix(m1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumMatrix(String[][] matrix) throws MyArrayDataException, MyArraySizeException {
        if (matrix.length < EXPECT_SIZE)
            throw new MyArraySizeException("Недопустимое количество строк");

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length < EXPECT_SIZE)
                throw new MyArraySizeException("Недопустимое количество элементов в строке " + (row+1));

            for (int col = 0; col < matrix[row].length; col++) {
                try {
                    sum += Integer.parseInt(matrix[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Нечисловые данные '%s' в ячейке (%d, %d)", matrix[row][col], row+1, col+1));
                }
            }
        }

        return sum;
    }

}
