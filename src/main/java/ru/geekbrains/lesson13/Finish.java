package ru.geekbrains.lesson13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Finish extends Stage {

    private final int carCount;
    private final CyclicBarrier barrier;

    public Finish(int carCount) {
        this.carCount = carCount;
        this.barrier = new CyclicBarrier(carCount, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));
    }

    @Override
    public void go(Car c) {
        try {

//            так может быть несколько победителей, т.к. другой поток может прийти к финишу
//            после печати победителя, но перед вызовом await()
//            if (barrier.getNumberWaiting() == 0)
//                System.out.println(c.getName() + " - WIN");
//
//            barrier.await()

            // а так имя победителя будет печататься после
            // объявления об окончании гонки
            if (barrier.await() == carCount-1)
                System.out.println(c.getName() + " - WIN");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
