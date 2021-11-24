package ru.geekbrains.lesson10;

import java.util.*;

public class PhoneBook {

    // ключ - фамилия, значение - множество телефонов
    private final Map<String, Set<String>> phoneMap;

    public PhoneBook() {
        this.phoneMap = new HashMap<>();
    }

    public boolean add(String lastname, String phone) {
        return phoneMap
                .computeIfAbsent(lastname, k -> new HashSet<>()) // получаем множество телефонов по фамилии
                .add(phone);                                     // добавляем в множество новый телефон
    }

    public Set<String> get(String lastname) {
        return phoneMap.getOrDefault(lastname, Collections.emptySet());
    }

}
