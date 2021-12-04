package ru.geekbrains.lesson12;

//        Cоздают одномерный длинный массив, например:
//
//        static final int size = 10000000;
//        static final int h = size / 2;
//        float[] arr = new float[size];
//
//        2) Заполняют этот массив единицами;
//        3) Засекают время выполнения: long a = System.currentTimeMillis();
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        5) Проверяется время окончания метода System.currentTimeMillis();
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h);
//
//        Пример обратной склейки:
//
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
//
//        Примечание:
//        System.arraycopy() – копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//
//        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Homework {

    private static final int size = 10000000;

    public static void main(String[] args) {
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];
        printFillTime(arr1, Homework::fillInOneThread);
        printFillTime(arr2, Homework::fillInTwoThread);
        System.out.println("Массивы совпадают: " + Arrays.equals(arr1, arr2));
    }

    private static void fillArray(float[] arr, int iBeg, int iEnd) {
        for (int i = iBeg; i < iEnd; i++) {
            arr[i] = 1;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
    }

    private static void fillInOneThread(float[] arr) {
        fillArray(arr, 0, arr.length);
    }

    private static void fillInTwoThread(float[] arr) {
        int half = arr.length / 2;

        // первую половину массива заполняем в новом потоке
        Thread thread = new Thread(() -> fillArray(arr, 0, half));
        thread.start();

        // вторую половину заполняем в главном потоке
        fillArray(arr, half, arr.length);

        try {
            thread.join(); // ждем когда выполнится поток
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printFillTime(float[] arr, Consumer<float[]> fillMethod) {
        long start = System.currentTimeMillis();
        fillMethod.accept(arr);
        System.out.println("Выполнено за: " + (System.currentTimeMillis() - start));
    }


}
