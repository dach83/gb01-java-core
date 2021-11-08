package ru.geekbrains.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // характеристики поля
    private static char[][] field;
    private static int fieldWidth = 5;  // ширина поля
    private static int fieldHeight = 5; // высота поля
    private static int winLength = 4;   // длина выигрышной линии

    // кто чем ходит
    private static char dotHuman = DOT_X;
    private static char dotComputer = DOT_0;

    // счёт игры
    private static int scoreHuman = 0;
    private static int scoreComputer = 0;

    // координаты хода
    private static int xMove;
    private static int yMove;


    public static void main(String[] args) {
        initGame(); // запрашиваем размеры поля и т.д.
        do {
            playGame(); // один раунд игры до победы или ничьей
            System.out.print("Играть еще раз (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));
    }

    // печать поля
    private static void printField() {
        // печать шапки "+|1|2|3|...
        System.out.print("+");
        for (int x = 0; x < fieldWidth; x++) {
            System.out.print("|" + (x + 1));
        }
        System.out.println("|");

        // вывод текущего состояния игрового поля
        for (int y = 0; y < fieldHeight; y++) {
            System.out.print(y + 1);
            for (int x = 0; x < fieldWidth; x++) {
                System.out.print("|" + field[y][x]);
            }
            System.out.println("|");
        }

        // и еще одну пустую строчку, чтобы визуально отделить поле
        System.out.println();
    }

    // печать счета
    private static void printScore() {
        System.out.printf("Счет: человек - %d, компьютер - %d \n", scoreHuman, scoreComputer);
    }

    // заполняет поле пустыми клетками
    private static void initEmptyField() {
        for (int i = 0; i < fieldHeight; i++)
            Arrays.fill(field[i], DOT_EMPTY);
    }

    // инициализация игры
    private static void initGame() {
        do {
            System.out.print("Введите ширину и высоту поля от 3 до 9: ");
            fieldWidth = scanner.nextInt();
            fieldHeight = scanner.nextInt();
        } while (fieldWidth < 3 || fieldHeight < 3 || fieldWidth > 9 || fieldHeight > 9);

        int maxWinLength = Math.min(fieldWidth, fieldHeight);
        do {
            System.out.printf("Длина выигрышной линии от 3 до %d: ", maxWinLength);
            winLength = scanner.nextInt();
        } while (winLength < 3 || winLength > maxWinLength);

        do {
            System.out.print("За кого будете играть X или 0: ");
            dotHuman = scanner.next().toUpperCase().charAt(0);
        } while (dotHuman != DOT_0 && dotHuman != DOT_X);

        dotComputer = (dotHuman == DOT_0) ? DOT_X : DOT_0; // за кого играет компьютер
        field = new char[fieldHeight][fieldWidth];         // создаем поле
    }

    // проверяет, что клетка находится в пределах игрового поля
    private static boolean isValidCell(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < fieldWidth) && (y < fieldHeight);
    }

    // проверяет, что клетка свободна
    private static boolean isEmptyCell(int x, int y) {
        return isValidCell(x, y) && (field[y][x] == DOT_EMPTY);
    }

    // проверяет, что на игровом поле закончились свободные клетки
    private static boolean noEmptyCell() {
        for (int y = 0; y < fieldHeight; y++)
            for (int x = 0; x < fieldWidth; x++)
                if (isEmptyCell(x, y))
                    return false;

        return true;
    }

    // проверяет выигрышную линию из символов dotKind в указанном направлении (dx, dy) с началом в клетке (xBeg, yBeg)
    private static boolean checkWinLine(char dotKind, int xBeg, int yBeg, int dx, int dy) {
        int xEnd = xBeg + dx * (winLength - 1);
        int yEnd = yBeg + dy * (winLength - 1);
        if (!isValidCell(xEnd, yEnd))
            return false; // конец линии выходит за пределы поля

        // проверяем, что линия состоит только из символов dotKind
        int x, y;
        for (int i = 0; i < winLength; i++) {
            x = xBeg + dx * i;
            y = yBeg + dy * i;
            if (field[y][x] != dotKind)
                return false;
        }

        return true; // эта линия целиком состоит из dotKind
    }

    // проверяет выигрышную горизонталь, вертикаль и две диагонали с началом в клетке (xBeg, yBeg)
    private static boolean checkWinStartFromCell(char dotKind, int xBeg, int yBeg) {
        if (field[yBeg][xBeg] != dotKind)
            return false; // в этой клетке не может начинаться выигрышная линия для dotKind

        return checkWinLine(dotKind, xBeg, yBeg, 1, 0) || // горизонталь
                checkWinLine(dotKind, xBeg, yBeg, 0, 1) || // вертикаль
                checkWinLine(dotKind, xBeg, yBeg, 1, 1) || // диагональ
                checkWinLine(dotKind, xBeg, yBeg, 1, -1);  // обратная диагональ
    }

    // проверяет победу игрока играющего за dotKind
    private static boolean checkWin(char dotKind) {
        for (int y = 0; y < fieldHeight; y++)
            for (int x = 0; x < fieldWidth; x++)
                if (checkWinStartFromCell(dotKind, x, y))
                    return true;

        return false;
    }

    // игра окончена если один из игроков победил или закончились пустые клетки
    private static boolean checkGameOver() {
        if (checkWin(dotHuman)) {
            System.out.println("Победил человек");
            scoreHuman++;
            return true;
        }

        if (checkWin(dotComputer)) {
            System.out.println("Победил компьютер");
            scoreComputer++;
            return true;
        }

        if (noEmptyCell()) {
            System.out.println("Ничья");
            return true;
        }

        return false;
    }

    // будет ли достигнута победа после одного хода в указанную клетку?
    private static boolean checkWinAfterOneMove(char dotKind, int x, int y) {
        if (!isEmptyCell(x, y))
            return false; // в занятую клетку нельзя сходить

        field[y][x] = dotKind;
        try {
            return checkWin(dotKind);
        } finally {
            field[y][x] = DOT_EMPTY; // восстанавливаем значение в клетке
        }
    }

    // запрашивает координаты хода у пользователя
    private static void getHumanMoveCoord() {
        do {
            System.out.print("Введите координаты хода x и y: ");
            xMove = scanner.nextInt() - 1;
            yMove = scanner.nextInt() - 1;
        } while (!isEmptyCell(xMove, yMove));
    }

    // координаты хода вычисляет компьютер
    private static void calcComputerMoveCoord() {
        // можно ли победить после одного хода компа
        for (int y = 0; y < fieldHeight; y++)
            for (int x = 0; x < fieldWidth; x++)
                if (checkWinAfterOneMove(dotComputer, x, y)) {
                    xMove = x;
                    yMove = y;
                    return;
                }

        // можно ли заблокировать победный ход человека
        for (int y = 0; y < fieldHeight; y++)
            for (int x = 0; x < fieldWidth; x++)
                if (checkWinAfterOneMove(dotHuman, x, y)) {
                    xMove = x;
                    yMove = y;
                    return;
                }

        // выбираем случайную клетку
        do {
            xMove = random.nextInt(fieldWidth);
            yMove = random.nextInt(fieldHeight);
        } while (!isEmptyCell(xMove, yMove));
    }

    // сделать ход
    private static char makeMove(char dotKind) {
        // получаем координаты хода
        if (dotKind == dotHuman) {
            getHumanMoveCoord();
        } else {
            calcComputerMoveCoord();
        }

        // здесь координаты хода должны быть уже вычислены,
        // использую глобальные переменные xMove и yMove, т.к. классы еще не проходили
        field[yMove][xMove] = dotKind;
        printField();

        // передаем ход другому игроку
        return (dotKind == dotHuman) ? dotComputer : dotHuman;
    }

    // играть до победы или ничьей
    private static void playGame() {
        initEmptyField(); // делаем все клетки пустыми

        char dotKind = DOT_X; // начинают крестики

        // если первым играет человек, то напечатаем пустое поле, чтобы показать координаты,
        // если первым играет комп, то поле напечатается после его хода
        if (dotHuman == dotKind)
            printField();

        // делаем ходы до победы или ничьей
        do {
            dotKind = makeMove(dotKind);
        } while (!checkGameOver());

        printScore(); // печатаем счет
    }

    // 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь
    // не подглядывать в методичку.

    // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
    // например, с использованием циклов.

    // 3. Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
    // количества фишек 4. Очень желательно не делать это просто набором условий для каждой
    // из возможных ситуаций;

    // 4. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.


}
