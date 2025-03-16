package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginInputField = $("[data-test-id='login'] input");
    private final SelenideElement passwordInputField = $("[data-test-id='password'] input");
    private final SelenideElement actionButton = $("[data-test-id='action-login']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void auth(String login, String password) {
        loginInputField.setValue(login);
        passwordInputField.setValue(password);
        actionButton.click();
    }

    public VerificationPage validAuth(String login, String password) {
        auth(login, password);
        return new VerificationPage();
    }
}