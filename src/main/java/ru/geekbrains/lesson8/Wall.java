package ru.geekbrains.lesson8;

// Стена
public class Wall extends Obstacle {

    public Wall(String name, int size) {
        super(name, size);
    }

    @Override
    boolean canPass(Movable participant) {
        return participant.jump(this);
    }
}
