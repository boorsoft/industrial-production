package com.boorsoft;

import java.util.ArrayList;

import com.boorsoft.components.AccountTypeHandler;
import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.Person;
import com.boorsoft.models.AccountType;
// 3 типа аккаунтов: salesman, delivery, provider
// Для каждого типа реализуем свой класс, который будет наследовать класс AccountType


// План действий
// 1. Сделать модели для аккаунтов и т.д
// 2. СДелать класс для работы с файлами
// 3. Реализовать систему авторизации 

public class App {
    public static void main(String[] args) throws Error {
        ArrayList<Person> accounts = new ArrayList<Person>();
        ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();

        new AccountTypeHandler(accountTypes);

        accountTypes.forEach((at) -> {
            System.out.println(at.id + " " + at.name);
        });

        // accounts.forEach((person) -> {
        // });

        FileHandler fileHandler = new FileHandler();
        fileHandler.init();
        
    }
}
