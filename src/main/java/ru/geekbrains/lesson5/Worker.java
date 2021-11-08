package ru.geekbrains.lesson5;

import java.time.Year;

public class Worker {
    private String name;   // ФИО
    private String post;   // должность
    private String email;  // почта
    private String phone;  // телефон
    private int salary;    // зарплата
    private int birthYear; // год рождения

    public Worker(String name, String post, String email, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = Year.now().getValue() - age;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: фио - %s, должность - %s, email - %s, телефон - %s, зарплата - %d, возраст - %d",
                name, post, email, phone, salary, getAge());
    }

    public void printToConsole() {
        System.out.println(this);
    }
}
