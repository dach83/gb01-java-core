package ru.geekbrains.lesson3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
//        guessNumber();
        guessFood();
    }

    // 1. Написать программу, которая загадывает случайное число от 0 до 9 и
    // пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
    // чем загаданное, или меньше. После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
    public static void guessNumber() {
        do {
            playGuessNumberRound(10);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (scanner.nextInt() == 1);
    }

    // Один раунд игры в угадай число
    public static void playGuessNumberRound(int maxGuessNum) {
        System.out.println("Угадайте число от 0 до " + (maxGuessNum - 1));

        int secretNum = random.nextInt(maxGuessNum);
        int userNum;

        // на угадывание дается три попытки
        for (int i = 1; i <= 3; i++) {
            System.out.print("Попытка " + i + ": ");

            userNum = scanner.nextInt();
            if (userNum == secretNum) {
                System.out.println("Вы победили");
                return;
            }

            // даем подсказку
            if (userNum < secretNum)
                System.out.println("Загаданное число больше");
            else
                System.out.println("Загаданное число меньше");
        }

        // закончились попытки
        System.out.println("Вы проиграли");
    }

    // 2. Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
    // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    // apple – загаданное apricot - ответ игрока ap############# (15 символов, чтобы пользователь
    // не мог узнать длину слова) Для сравнения двух слов посимвольно можно пользоваться:
    // String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    // Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    public static void guessFood() {
        String[] foodArr = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        String secretStr = foodArr[random.nextInt(foodArr.length)];
        String userStr;

        System.out.println(secretStr);
        do {
            System.out.print("Отгадайте слово: ");
            userStr = scanner.next().toLowerCase();
            if (userStr.equals(secretStr)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                printHint(secretStr, userStr);
            }

        } while (!userStr.equals("stop"));
    }

    // Вывод подсказки
    public static void printHint(String secretStr, String userStr) {
        String hint = "";
        for (int i = 0; i < 15; i++) {
            if (i < secretStr.length() && i < userStr.length() && secretStr.charAt(i) == userStr.charAt(i)) {
                hint += userStr.charAt(i);
            } else {
                hint += '#';
            }
        }
        System.out.println(hint);
    }

}
