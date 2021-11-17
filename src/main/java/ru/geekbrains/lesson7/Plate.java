package ru.geekbrains.lesson7;

public class Plate {

    private static final int MAX_FOOD_AMOUNT = 500;

    private int foodAmount;

    public Plate(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    // Увеличиваем количество еды в тарелке, но не превышаем макс. возможное количество.
    // Возвращает остаток еды, которая не вошла в тарелку
    public int increaseFood(int amount) {
        int oldFoodAmount = foodAmount;
        foodAmount = Math.max(foodAmount + amount, MAX_FOOD_AMOUNT);
        return amount - (foodAmount - oldFoodAmount);
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount - amount < 0)
            return false;

        this.foodAmount -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "В тарелке осталось " + foodAmount;
    }
}
