package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.util.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private final SelenideElement amountInputField = $("[data-test-id='amount'] input");
    private final SelenideElement cardFromInputField = $("[data-test-id='from'] input");
    private final SelenideElement cardToInputField = $("[data-test-id='to'] input");
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private final SelenideElement cancelButton = $("[data-test-id='action-cancel']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public TransferPage() {
        SelenideElement dashBoardTransferHeader = $("[data-test-id='dashboard']~h1");
        dashBoardTransferHeader.shouldBe(Condition.allOf(
                Condition.visible,
                Condition.exactText("Пополнение карты")
        ), Duration.ofSeconds(15));
    }

    public void inputAmount(int amount) {
        amountInputField.setValue("" + amount);
    }

    public void inputCardFrom(String cardFromNumber) {
        cardFromInputField.setValue(cardFromNumber);
    }

    public void inputValues(int amount, String cardFromNumber) {
        inputAmount(amount);
        inputCardFrom(cardFromNumber);
    }
    public DashBoardPage validTransfer(int amount, String cardFromNumber) {
        inputValues(amount, cardFromNumber);
        transferButton.click();
        return new DashBoardPage();
    }

    public DashBoardPage canceledTransfer() {
        cancelButton.click();
        return new DashBoardPage();
    }
}