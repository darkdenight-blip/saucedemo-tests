package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorLoginText = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * В метод передается логин/пароль из теста.
     *  @param username логин
     *  @param password пароль
     */
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    /**
     * Возвращает текст ошибки авторизации.
     *
     * @return текст ошибки
     */
    public String errorLoginMessage() {
        return driver.findElement(errorLoginText).getText();
    }
}