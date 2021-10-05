package com.boorsoft;

import com.boorsoft.helpers.FileHandler;

// 3 типа аккаунтов: salesman, delivery, provider
// Для каждого типа реализуем свой класс, который будет наследовать класс AccountType


// План действий
// 1. Сделать модели для аккаунтов и т.д
// 2. СДелать класс для работы с файлами
// 3. Реализовать систему авторизации 

public class App {
    public static void main(String[] args) throws Error {
        FileHandler fileHandler = new FileHandler();
        fileHandler.init();
        
    }
}
