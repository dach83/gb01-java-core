package ru.geekbrains.lesson6;


// 1. Создать классы Собака и Кот с наследованием от класса Животное.
// 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150);->'Бобик пробежал 150 м.    ');
// 3. У каждого животного есть ограничения на действия(бег:кот 200м.,собака 500м.;плавание:кот не умеет плавать,собака 10м.).
// 4. *Добавить подсчет созданных котов, собак и животных.


import java.util.Random;

public class HomeWork {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Шарик"),
                new Cat("Тиша"),
                new Dog("Макс"),
                new Cat("Мурка"),
                new Dog("Пальма"),
        };

        // бегаем и плаваем
        for (int i = 0; i < 10; i++) {
            Animal randomAnimal = animals[random.nextInt(animals.length)];
            randomAnimal.run(random.nextInt(700));
            randomAnimal.swim(random.nextInt(20));
        }

        // количество созданных котов, собак и животных
        Animal.printAnimalCounter();
        Dog.printDogCounter();
        Cat.printCatCounter();
    }

}
