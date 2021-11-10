package ru.geekbrains.lesson6;

public class Animal {

    private static int animalCounter = 0; // счетчик созданных животных

    protected String name;         // имя животного
    protected int maxRunLength;    // ограничение на дистанцию бега
    protected int maxSwimLength;   // ограничение на дистанцию плавания

    public Animal(String name, int maxRunLength, int maxSwimLength) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        animalCounter++;
    }

    public void run(int length) {
        if (length > 0 && length < maxRunLength) {
            System.out.printf("%s пробежал %d метров\n", name, length);
        } else {
            System.out.printf("%s не может пробежать %d метров\n", name, length);
        }
    }

    public void swim(int length) {
        if (length > 0 && length < maxSwimLength) {
            System.out.printf("%s проплыл %d метров\n", name, length);
        } else {
            System.out.printf("%s не может проплыть %d метров\n", name, length);
        }
    }

    public static void printAnimalCounter() {
        System.out.println("Животных : " + animalCounter);
    }
}
