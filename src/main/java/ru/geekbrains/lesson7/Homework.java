package ru.geekbrains.lesson7;


public class Homework {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Мурзик", 20),
                new Cat("Барсик", 5),
                new Cat("Васька", 50),
        };

        Plate plate = new Plate(50);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }
    }

}
