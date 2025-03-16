package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement codeInputField = $("[data-test-id='code'] input");
    private final SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public VerificationPage() {
        codeInputField.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verify(int verifyCode) {
        codeInputField.setValue("" + verifyCode);
        verifyButton.click();
    }

    public DashBoardPage validVerify(int verifyCode) {
        verify(verifyCode);
        return new DashBoardPage();
    }
}