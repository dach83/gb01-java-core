package ru.geekbrains.lesson6;

public class Cat extends Animal {

    private static int catCounter = 0;

    private static final int RUN_MAX_LEN = 200;

    public Cat(String name) {
        super(name, RUN_MAX_LEN, 0);
        catCounter++;
    }

    @Override
    public void swim(int length) {
        System.out.printf("Кот %s не умеет плавать\n", name);
    }

    public static void printCatCounter() {
        System.out.println("Котов : " + catCounter);
    }
}

