package ru.geekbrains.lesson8;

public interface Movable {
    boolean run(Obstacle obstacle);
    boolean jump(Obstacle obstacle);
    void pass(Obstacle obstacle);
}
