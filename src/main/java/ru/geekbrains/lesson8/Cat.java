package ru.geekbrains.lesson8;

public class Cat implements Movable {
    private final String name;
    private final int runLength;
    private final int jumpHeight;
    private boolean inRace = true; // участвует в прохождении препятствий

    public Cat(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean run(Obstacle obstacle) {
        if (runLength < obstacle.getSize()) {
            System.out.println("Кот " +  this.name + " не смог пробежать " + obstacle);
            return false;
        } else {
            System.out.println("Кот " +  this.name + " успешно пробежал " + obstacle);
            return true;
        }
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        if (jumpHeight < obstacle.getSize()) {
            System.out.println("Кот " +  this.name + " не смог перепрыгнуть " + obstacle);
            return false;
        } else {
            System.out.println("Кот " +  this.name + " успешно перепрыгнул " + obstacle);
            return true;
        }
    }

    @Override
    public void pass(Obstacle obstacle) {
        if (inRace && !obstacle.canPass(this)) {
            inRace = false; // если участник не смог пройти одно из препятствий, то дальше по списку препятствий он не идет
            System.out.println("Кот " + name + " выбыл!");
        }
    }
}
