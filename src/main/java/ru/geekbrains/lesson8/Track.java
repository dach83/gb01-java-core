package ru.geekbrains.lesson8;

// Беговая дорожка
public class Track extends Obstacle {

    public Track(String name, int size) {
        super(name, size);
    }

    @Override
    boolean canPass(Movable participant) {
        return participant.run(this);
    }
}
