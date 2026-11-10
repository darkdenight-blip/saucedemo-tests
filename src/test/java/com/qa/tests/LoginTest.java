package com.qa.tests;

import com.qa.pages.LoginPage;
import com.qa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void loginPositive() {
        LoginPage loginPage = new LoginPage (driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        // 2. Проверяем, что после ввода корректного логина происходит переход к нужной странице
        Assertions.assertEquals(
                "https://www.saucedemo.com/inventory.html",
                driver.getCurrentUrl(),
                "Попытка залогиниться не привела к странице https://www.saucedemo.com/inventory.html!");
    }

    @Test
    public void loginInvalidPassword() {
        LoginPage loginPage = new LoginPage (driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "wrong_sauce");
        String actualErrorText = loginPage.errorLoginMessage();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",
                actualErrorText,
                "Текст ошибки не соответствует ТЗ!");

    }


    @AfterEach
    public void tearDown() {
        // Закрываем браузер и убиваем процесс после каждого теста
        Driver.closeDriver();
    }
}