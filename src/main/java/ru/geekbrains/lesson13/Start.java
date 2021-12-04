package ru.geekbrains.lesson13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Start extends Stage {

    private final CyclicBarrier barrier;

    public Start(int carCount) {
        this.barrier = new CyclicBarrier(carCount, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
    }

    @Override
    public void go(Car c) {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
