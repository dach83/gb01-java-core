package ru.geekbrains.lesson5;


// 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
// 2. Конструктор класса должен заполнять эти поля при создании объекта.
// 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
// 4. Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5];
// Вначале объявляем массив объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
// потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
// 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
public class HomeWork {

    public static void main(String[] args) {
        Worker[] workers = new Worker[]{
                new Worker("Иванов Иван", "Инженер", "ivanov@mail.ru", "89023453455", 30000, 28),
                new Worker("Петров Петр", "Директор", "petrov@mail.ru", "89034556566", 60000, 41),
                new Worker("Сидорова Любовь", "Бухгалтер", "lubasha@mail.ru", "89345346645", 45000, 47),
                new Worker("Козлова Маргарита", "Уборщица", "margo@mail.ru", "89453434445", 20000, 23),
                new Worker("Кузнецов Виктор", "Водитель", "kuznecdrive@mail.ru", "89453453245", 35000, 34),
        };

        for (Worker w: workers) {
            if (w.getAge() > 40)
                w.printToConsole();
        }

    }

}
