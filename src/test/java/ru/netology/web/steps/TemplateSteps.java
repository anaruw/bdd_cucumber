package ru.netology.web.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import ru.netology.web.pages.DashBoardPage;
import ru.netology.web.pages.LoginPage;
import ru.netology.web.pages.TransferPage;
import ru.netology.web.pages.VerificationPage;

public class TemplateSteps {
    private static DashBoardPage dashBoardPage;

    @И("пользователь залогинен с именем {} и паролем {}")
    public void authWithValidLoginAndPassword(String login, String password) {
        LoginPage loginPage = Selenide.open("http://localHost:9999", LoginPage.class);
        VerificationPage verificationPage = loginPage.validAuth(login, password);
        dashBoardPage = verificationPage.validVerify(12345);
    }

    @И("пользователь переводит {} рублей с карты с номером {} на свою {} карту с главной страницы")
    public void validTransfer(int amount, String cardFromNumber, int cardToIndex) {
        TransferPage transferPage = dashBoardPage.cardToReplenishment(cardToIndex);
        dashBoardPage = transferPage.validTransfer(amount, cardFromNumber);
    }

    @И("баланс его {} карты из списка на главной странице должен стать {} рублей")
    public void checkBalance(int cardToIndex, int expectedBalance) {
        dashBoardPage.checkBalance(cardToIndex, expectedBalance);
    }
}