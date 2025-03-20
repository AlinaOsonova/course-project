package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDataBase;

public class AuthTest {

    PaymentPage paymentPage = new PaymentPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void clean() {
        cleanDataBase();
    }


    @Test
    public void shouldShowErrorForExpiredCard() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardInfo = DataHelper.getCardWithPastYear();
        paymentPage.fillForm(cardInfo);
        paymentPage.waitForCardExpired();
    }

    @Test
    public void shouldDisplaySuccessNotificationWhenCardIsApproved() {
        paymentPage.clickBuy();
        DataHelper.CardInfo approvedCard = DataHelper.getApprovedCard();
        paymentPage.fillForm(approvedCard);
        paymentPage.waitForSuccessfulNotification();
        SQLHelper.getPaymentStatus();
    }

    @Test
    public void shouldDisplayErrorNotificationWhenCardIsDeclined() {
        paymentPage.clickBuy();
        DataHelper.CardInfo declinedCard = DataHelper.getDeclinedCard();
        paymentPage.fillForm(declinedCard);
        paymentPage.waitForErrorNotification();
        SQLHelper.getPaymentStatus();
    }

    @Test
    public void shouldDisplayErrorWhenFieldsAreEmpty() {
        paymentPage.clickBuy();
        paymentPage.clearForm();
        paymentPage.fillForm(DataHelper.getEmptyCardInfo());
        paymentPage.waitForEmptyField();
    }

    @Test
    public void shouldDisplayWrongFormatNotificationForInvalidCardFormat() {
        paymentPage.clickBuy();
        DataHelper.CardInfo invalidCardFormat = DataHelper.getCardWithFifteenDigits();
        paymentPage.fillForm(invalidCardFormat);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForInvalidMonth() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithInvalidMonth = DataHelper.getCardWithInvalidMonth();
        paymentPage.fillForm(cardWithInvalidMonth);
        paymentPage.waitForWrongCardDate();
    }

    @Test
    public void shouldDisplayErrorForLastMonthDate() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithLastMonth = DataHelper.getCardWithLastMonthDate();
        paymentPage.fillForm(cardWithLastMonth);
        paymentPage.waitForWrongCardDate();
    }

    @Test
    public void shouldDisplayErrorForPastYear() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithPastYear = DataHelper.getCardWithPastYear();
        paymentPage.fillForm(cardWithPastYear);
        paymentPage.waitForCardExpired();
    }

    @Test
    public void shouldAllowCardWithFutureYear() {
        paymentPage.clickBuy();
        DataHelper.CardInfo CardWithFutureYear = DataHelper.getCardWithFutureYear();
        paymentPage.fillForm(CardWithFutureYear);
        paymentPage.waitForSuccessfulNotification();
    }

    @Test
    public void shouldAllowSingleDigitMonth() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithSingleDigitMonth = DataHelper.getCardWithSingleDigitMonth();
        paymentPage.fillForm(cardWithSingleDigitMonth);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForCyrillicName() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithCyrillicName = DataHelper.getCardWithCyrillicName();
        paymentPage.fillForm(cardWithCyrillicName);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForSpecialSymbolName() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithSpecialSymbolName = DataHelper.getCardWithSpecialSymbolName();
        paymentPage.fillForm(cardWithSpecialSymbolName);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForNumericName() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithNumericName = DataHelper.getCardWithNumericName();
        paymentPage.fillForm(cardWithNumericName);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForLongName() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithLongName = DataHelper.getCardWithLongName();
        paymentPage.fillForm(cardWithLongName);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForZeroCVC() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithZeroCVC = DataHelper.getCardWithZeroCvc();
        paymentPage.fillForm(cardWithZeroCVC);
        paymentPage.waitForWrongFormat();
    }

    @Test
    public void shouldDisplayErrorForOneDigitCVC() {
        paymentPage.clickBuy();
        DataHelper.CardInfo cardWithOneDigitCVC = DataHelper.getCardWithOneDigitCvc();
        paymentPage.fillForm(cardWithOneDigitCVC);
        paymentPage.waitForWrongFormat();
    }


    @Test
    public void shouldCheckCardFieldIsEmptyAfterClear() {
        paymentPage.clickBuy();
        paymentPage.clearForm();
        paymentPage.checkCardFieldEmpty();
    }

    @Test
    public void shouldCheckMonthFieldIsEmptyAfterClear() {
        paymentPage.clickBuy();
        paymentPage.clearForm();
        paymentPage.checkMonthFieldEmpty();
    }

    @Test
    public void shouldCheckYearFieldIsEmptyAfterClear() {
        paymentPage.clickBuy();
        paymentPage.clearForm();
        paymentPage.checkYearFieldEmpty();
    }

    @Test
    public void shouldCheckCVCFieldIsEmptyAfterClear() {
        paymentPage.clickBuy();
        paymentPage.clearForm();
        paymentPage.checkCVCFieldEmpty();
    }
}


