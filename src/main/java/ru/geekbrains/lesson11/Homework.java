package ru.geekbrains.lesson11;


// 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
// 2. Написать метод, который преобразует массив в ArrayList;
// 3. Задача: Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
// Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
// Для хранения фруктов внутри коробки можно использовать ArrayList;
// Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
// Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
// true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
// Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
// Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
// Не забываем про метод добавления фрукта в коробку.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework {

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"a", "b", "c", "d", "e"};

        // меняем два элемента массива местами
        swapArrElem(intArr, 0, 4);
        swapArrElem(strArr, 1, 3);
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(strArr));

        // массив в ArrayList
        List<Integer> intList = convertToList(intArr);
        List<String> strList = convertToList(strArr);
        System.out.println("intArr: " + intList);
        System.out.println("strList: " + strList);

        // коробки с фруктами
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange(), new Orange(), new Orange());

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Вес orangeBox1: " + orangeBox1.getWeight());
        System.out.println("appleBox1.compare(appleBox2): " + appleBox1.compare(appleBox2));
        System.out.println("appleBox1.compare(orangeBox1): " + appleBox1.compare(orangeBox1));

        appleBox1.putFrom(appleBox2); // пересыпаем яблоки в одну коробку

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("appleBox1.compare(appleBox2): " + appleBox1.compare(appleBox2));
        System.out.println("appleBox1.compare(orangeBox1): " + appleBox1.compare(orangeBox1));
    }

    // Метод, который меняет два элемента массива местами
    private static <T> void swapArrElem(T[] arr, int i, int j) {
        T tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    // Метод, который преобразует массив в ArrayList;
    private static <E> List<E> convertToList(E... arr) {
        List<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }


}
