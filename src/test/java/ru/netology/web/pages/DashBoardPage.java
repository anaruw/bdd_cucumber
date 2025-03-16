package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.util.DataHelper;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashBoardPage {

    private final List<SelenideElement> cardList = $$(".list__item");
    private final SelenideElement card1Info = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private final SelenideElement card2Info = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private final SelenideElement reloadButton = $("[data-test-id='action-reload']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public DashBoardPage() {
        SelenideElement dashBoardMainHeader = $("[data-test-id='dashboard']~h1");
        dashBoardMainHeader.shouldBe(Condition.allOf(
                Condition.visible,
                Condition.exactText("Ваши карты")
        ), Duration.ofSeconds(15));
    }

    public SelenideElement cardChoice(int cardIndex) {
        return cardList.get(cardIndex - 1);
    }

    public TransferPage cardToReplenishment(int cardIndex) {
        cardChoice(cardIndex).$("[data-test-id='action-deposit']").click();
        return new TransferPage();
    }

    public int cardBalance(int selectedCardIndex) {

        String beforeBalanceText = "**** **** **** ****, баланс: ";
        String afterBalanceText = " р.\nПополнить";
        String cardInfo = cardChoice(selectedCardIndex).getText();

        return Integer.parseInt(cardInfo.substring(
                beforeBalanceText.length(),
                cardInfo.length() - afterBalanceText.length()
        ));
    }

    public void checkBalance(int cardIndex, int expectedBalance) {
        cardList.get(cardIndex - 1).shouldHave(Condition.exactText(
                "**** **** **** 000" + cardIndex + ", баланс: " + expectedBalance + " р.\nПополнить"
        ));
    }
}