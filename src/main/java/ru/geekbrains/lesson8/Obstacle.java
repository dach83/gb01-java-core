package ru.geekbrains.lesson8;

// Препятствие
public abstract class Obstacle {
    protected String name; // название препятствия
    protected int size;    // размер препятствия

    public Obstacle(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // может ли участник преодолеть препятствие
    abstract boolean canPass(Movable participant);

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }
}
