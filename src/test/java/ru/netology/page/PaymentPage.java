package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private final SelenideElement paymentButton = $("button");
    private final SelenideElement cardNumberForm = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthForm = $("[placeholder='08']");
    private final SelenideElement yearForm = $("[placeholder='22']");
    private final SelenideElement nameForm = $$("span.input__top").findBy(Condition.text("Владелец")).sibling(0).$("input");
    private final SelenideElement cvcForm = $("[placeholder='999']");
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement successfulNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement errorNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement wrongFormat = $(byText("Неверный формат"));
    private final SelenideElement wrongCardDate = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpired = $(byText("Истёк срок действия карты"));

    public void clickBuy() {
        paymentButton.click();
    }

    // Метод для заполнения формы
    public void fillForm(DataHelper.CardInfo cardInfo) {
        cardNumberForm.setValue(cardInfo.getCardNumber());
        monthForm.setValue(cardInfo.getMonth());
        yearForm.setValue(cardInfo.getYear());
        nameForm.setValue(cardInfo.getName());
        cvcForm.setValue(cardInfo.getCvc());
        continueButton.click();
    }

    // Метод для очистки всех полей формы
    public void clearForm() {
        clearField(cardNumberForm);
        clearField(monthForm);
        clearField(yearForm);
        clearField(nameForm);
        clearField(cvcForm);
    }

    // Универсальный метод для очистки поля
    private void clearField(SelenideElement field) {
        field.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    }

    // Методы для ожидания уведомлений
    public void waitForSuccessfulNotification() {
        successfulNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void waitForErrorNotification() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    // Методы для проверки ошибок
    public void waitForEmptyField() {
        emptyField.shouldBe(visible);
    }

    public void waitForWrongFormat() {
        wrongFormat.shouldBe(visible);
    }

    public void waitForWrongCardDate() {
        wrongCardDate.shouldBe(visible);
    }

    public void waitForCardExpired() {
        cardExpired.shouldBe(visible);
    }

    // Методы для работы с отдельными полями
    public void fillCardField(DataHelper.CardInfo cardInfo) {
        cardNumberForm.setValue(cardInfo.getCardNumber());
    }

    public void checkCardFieldEmpty() {
        cardNumberForm.shouldBe(Condition.empty);
    }

    public void fillMonthField(DataHelper.CardInfo cardInfo) {
        monthForm.setValue(cardInfo.getMonth());
    }

    public void checkMonthFieldEmpty() {
        monthForm.shouldBe(Condition.empty);
    }

    public void fillYearField(DataHelper.CardInfo cardInfo) {
        yearForm.setValue(cardInfo.getYear());
    }

    public void checkYearFieldEmpty() {
        yearForm.shouldBe(Condition.empty);
    }

    public void fillCVCField(DataHelper.CardInfo cardInfo) {
        cvcForm.setValue(cardInfo.getCvc());
    }

    public void checkCVCFieldEmpty() {
        cvcForm.shouldBe(Condition.empty);
    }

}