package com.qa.tests;

import com.qa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Получаем экземпляр драйвера из нашего умного класса
        driver = Driver.getDriver();
    }

    @Test
    public void shouldOpenSauceDemoAndCheckTitle() {
        // 1. Открываем сайт
        driver.get("https://www.saucedemo.com/");

        // 2. Проверяем, что заголовок страницы содержит ожидаемый текст
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Swag Labs"),
                "Заголовок страницы не совпадает! Ожидалось 'Swag Labs', а получили: " + actualTitle);
    }

    @AfterEach
    public void tearDown() {
        // Закрываем браузер и убиваем процесс после каждого теста
        Driver.closeDriver();
    }
}