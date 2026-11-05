package com.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    // Храним экземпляр драйвера. Пока статичен.
    private static WebDriver driver;

    public static WebDriver getDriver() {
        // Если драйвер еще не создан или был закрыт — создаем новый
        if (driver == null) {
            // 1. Пусть сам скачает и настроит chromedriver
            WebDriverManager.chromedriver().setup();

            // 2. Настройки браузера
            ChromeOptions options = new ChromeOptions();

            // options.addArguments("--headless");строка для headless-режима в будущем пайплайне.

            options.addArguments("--start-maximized"); // Разворачиваем на весь экран

            // 3. Запускаем браузер с нашими настройками
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    // Метод для закрытия браузера и очистки памяти
    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // quit() закрывает все вкладки и убивает процесс драйвера
            driver = null; // Обнуляем, чтобы при следующем вызове создался новый
        }
    }
}