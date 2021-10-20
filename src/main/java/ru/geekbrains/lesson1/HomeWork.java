package ru.geekbrains.lesson1;

public class HomeWork {

    public static void main(String[] args) {
        // 1. вычисление выражения a * (b + (c / d))
        System.out.println("5 * (4 + (3 / 2)) = " + calcFormula(5, 4, 3, 2)); // 27.5

        // 2. проверка, что сумма двух целых чисел лежит в диапазоне 10..20
        System.out.println("checkSum(2, 3)  " + checkSum(2, 3));    // false
        System.out.println("checkSum(5, 5)  " + checkSum(5, 5));    // true
        System.out.println("checkSum(9, 5)  " + checkSum(9, 5));    // true
        System.out.println("checkSum(10, 10) " + checkSum(10, 10)); // true
        System.out.println("checkSum(12, 15) " + checkSum(12, 15)); // false

        // 3. положительное или отрицательное число
        printNumSign(-10);  // отрицательное
        printNumSign(0);    // положительное
        printNumSign(10);   // положительное

        // 4. метод должен вернуть false, если число отрицательное, и true, если положительное
        System.out.println("-10 отрицательное? " + isNegativeNum(-10));
        System.out.println("+10 отрицательное? " + isNegativeNum(+10));
        System.out.println("0 отрицательное? " + isNegativeNum(0));

        // 5. вывести «Привет, указанное_имя!»
        helloName("указанное_имя");

        // 6. определение високосного года
        isLeapYear(2000);
        isLeapYear(2028);
        isLeapYear(2100);
        isLeapYear(2400);
    }

    // 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – аргументы этого метода, имеющие тип float
    public static float calcFormula(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // 2. Написать метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean checkSum(int a, int b) {
        int sum = a+b;
        return (10 <= sum) && (sum <= 20);
    }

    // 3. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void printNumSign(int num) {
        if (num >= 0) {
            System.out.println(num + " положительное число");
        } else {
            System.out.println(num + " отрицательное число");
        }
    }

    // 4. Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    public static boolean isNegativeNum(int num) {
        return num < 0;
    }

    // 5. Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // 6. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isLeapYear(int year) {
        boolean result = (year % 4 == 0) && (year % 100 > 0) || (year % 400 == 0);
        if (result) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - невисокосный год");
        }
        return result;

    }

}
