package ru.geekbrains.lesson7;

public class Cat {

    private final String name;
    private int appetite;
    private boolean satiety; // сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (!satiety && plate.decreaseFood(appetite))
            satiety = true;
    }

    @Override
    public String toString() {
        return "Кот " + name + " " + (satiety ? "сыт" : "голоден");
    }
}
