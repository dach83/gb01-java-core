package ru.geekbrains.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public Box(T... fruits) {
        this();
        for (T fruit : fruits) {
            add(fruit);
        }
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    // вес коробки
    public float getWeight() {
        return (float) fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    // сравнение коробок по весу
    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight()-box.getWeight()) < 0.00001;
    }

    // пересыпать из другой коробки
    public void putFrom(Box<T> box) {
        fruits.addAll(box.fruits);
        box.fruits.clear();
    }
}
