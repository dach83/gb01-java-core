package ru.geekbrains.lesson13;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Homework {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        Semaphore tunnelSemaphore = new Semaphore(CARS_COUNT / 2);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(
                new Start(CARS_COUNT), // линия старта
                new Road(60),
                new Tunnel(tunnelSemaphore),
                new Road(40),
                new Finish(CARS_COUNT) // линия финиша
        );

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}

