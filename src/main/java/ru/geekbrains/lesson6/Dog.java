package ru.geekbrains.lesson6;

public class Dog extends Animal {

    private static int dogCounter = 0;

    private static final int RUN_MAX_LEN = 500;
    private static final int SWIM_MAX_LEN = 10;

    public Dog(String name) {
        super(name, RUN_MAX_LEN, SWIM_MAX_LEN);
        dogCounter++;
    }

    public static void printDogCounter() {
        System.out.println("Собак : " + dogCounter);
    }
}
