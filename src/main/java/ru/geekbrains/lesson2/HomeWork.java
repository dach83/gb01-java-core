package ru.geekbrains.lesson2;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        System.out.println("\n1. Задать целочисленный массив, состоящий из элементов 0 и 1.\n" +
                "Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0");
        invertBinArray();

        System.out.println("\n2. Задать пустой целочисленный массив размером 8.\n" +
                "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21");
        fillArrayInCycle();

        System.out.println("\n3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,\n" +
                "и числа меньшие 6 умножить на 2");
        changeArrayElement();

        System.out.println("\n4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),\n" +
                "и с помощью цикла(-ов) заполнить его диагональные элементы единицами");
        fillMatrixDiagonal(7);

        System.out.println("\n5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)");
        findMinAndMaxInArray();

        System.out.println("\n6. Написать метод, в который передается не пустой одномерный целочисленный массив,\n" +
                "метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.\n" +
                "Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,\n" +
                "граница показана символами ||, эти символы в массив не входят.");
        int[] testArr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] testArr2 = {1, 1, 1, 2, 1};
        checkBalance(testArr1);
        checkBalance(testArr2);

        System.out.println("\n7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,\n" +
                "или отрицательным), при этом метод должен сместить все элементы массива на n позиций.\n" +
                "Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.\n" +
                "Примеры:\n" +
                "[ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];\n" +
                "[ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].\n" +
                "При каком n в какую сторону сдвиг можете выбирать сами.");
        int[] testArr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Исходный массив "  + Arrays.toString(testArr3));
        shiftArray(testArr3.clone(), -2);
        shiftArray(testArr3.clone(), 2);
    }

    // Создает массив длины len и заполняет его случайными значениями от minValue до maxValue
    public static int[] newRandomArray(int len, int minValue, int maxValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minValue + (int) Math.round(Math.random()*(maxValue-minValue));
        }
        return arr;
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void invertBinArray() {
        int[] arr = newRandomArray(10, 0, 1); // создание массива из 10 элементов содержащего 0 и 1

        System.out.println("Исходный массив из 0 и 1 " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        System.out.println("Инвертированный массив   " + Arrays.toString(arr));
    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArrayInCycle() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    public static void changeArrayElement() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Исходный массив " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Результат       " + Arrays.toString(arr));
    }


    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillMatrixDiagonal(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size-i-1] = 1;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findMinAndMaxInArray() {
        int[] arr = newRandomArray(15, 1, 99);
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (min > i)
                min = i;
            if (max < i)
                max = i;
        }
        System.out.printf("min = %d, max = %d\n", min, max);
    }

    // 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {
        int pos = -1;       // пусть граница находится перед первым элементом, тогда
        int leftSum = 0;    // сумма левой части - это 0
        int rightSum = 0;   // сумма правой части - это сумма всех элементов
        for (int n: arr){
            rightSum += n;
        }

        // будем двигать границу вправо пока суммы не совпадут
        for (int i = 0; i < arr.length; i++) {
            leftSum  += arr[i];
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                pos = i;
                break;
            }
        }

        // выводим результат
        if (pos != -1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                if (i == pos)
                    System.out.print("|| ");
            }
            System.out.println();
        }

        return pos != -1;
    }

    // 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры:
    // [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void shiftArray(int[] arr, int n) {
        int shift = -n % arr.length;
        if (shift < 0)
            shift += arr.length;

        if (shift != 0) {
            reverseArray(arr, 0, shift-1);
            reverseArray(arr, shift, arr.length - 1);
            reverseArray(arr, 0, arr.length - 1);
        }

        System.out.printf("Сдвиг на %d - %s\n", n, Arrays.toString(arr));
    }

    // меняет порядок элементов на обратный для части массива от leftInd до rightInd
    public static void  reverseArray(int[] arr, int leftInd, int rightInd) {
        int temp;
        while (leftInd <= rightInd) {
            temp = arr[leftInd];
            arr[leftInd] = arr[rightInd];
            arr[rightInd] = temp;
            leftInd++;
            rightInd--;
        }
    }

}

//  Вывод в консоль:
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
//        Исходный массив из 0 и 1 [1, 0, 0, 0, 0, 1, 1, 1, 1, 1]
//        Инвертированный массив   [0, 1, 1, 1, 1, 0, 0, 0, 0, 0]
//
//        2. Задать пустой целочисленный массив размером 8.
//        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
//        [0, 3, 6, 9, 12, 15, 18, 21]
//
//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
//        и числа меньшие 6 умножить на 2
//        Исходный массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]
//        Результат       [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
//
//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами
//        [1, 0, 0, 0, 0, 0, 1]
//        [0, 1, 0, 0, 0, 1, 0]
//        [0, 0, 1, 0, 1, 0, 0]
//        [0, 0, 0, 1, 0, 0, 0]
//        [0, 0, 1, 0, 1, 0, 0]
//        [0, 1, 0, 0, 0, 1, 0]
//        [1, 0, 0, 0, 0, 0, 1]
//
//        5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
//        [76, 66, 44, 40, 83, 83, 9, 90, 86, 84, 86, 62, 65, 48, 61]
//        min = 9, max = 90
//
//        6. Написать метод, в который передается не пустой одномерный целочисленный массив,
//        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.
//        2 2 2 1 2 2 || 10 1
//        1 1 1 || 2 1
//
//        7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//        или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
//        Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//        Примеры:
//        [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//        [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//        При каком n в какую сторону сдвиг можете выбирать сами.
//        Исходный массив [1, 2, 3, 4, 5, 6, 7]
//        Сдвиг на -2 - [3, 4, 5, 6, 7, 1, 2]
//        Сдвиг на 2 - [6, 7, 1, 2, 3, 4, 5]
//
