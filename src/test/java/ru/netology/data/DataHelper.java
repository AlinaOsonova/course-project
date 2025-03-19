package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static final Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    private static String getApprovedNumberCard() {
        return "1111 2222 3333 4444";
    }

    private static String getDeclinedNumberCard() {
        return "5555 6666 7777 8888";
    }

    private static String generateRandomName() {
        Faker faker = new Faker();
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String generateRandomCvc() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }

    private static String getRandomMonth(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    private static String getRandomYear(int shift) {
        return LocalDate.now().plusYears(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static CardInfo getApprovedCard() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo(getDeclinedNumberCard(), getRandomMonth(0), getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getEmptyCardInfo() {
        return new CardInfo("", "", "", "", "");
    }

    public static CardInfo getCardWithLastMonthDate() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(-1), getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithInvalidMonth() {
        return new CardInfo(getApprovedNumberCard(), "13", getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithSingleDigitMonth() {
        return new CardInfo(getApprovedNumberCard(), "1", getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithPastYear() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(-1), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithFutureYear() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(6), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithSingleDigitYear() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), "1", generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithCyrillicName() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), "Иван", generateRandomCvc());
    }

    public static CardInfo getCardWithSpecialSymbolName() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), "!$%@#", generateRandomCvc());
    }

    public static CardInfo getCardWithNumericName() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), "12345", generateRandomCvc());
    }

    public static CardInfo getCardWithLongName() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), "а".repeat(50), generateRandomCvc());
    }

    public static CardInfo getCardWithFifteenDigits() {
        return new CardInfo("111111111111111", getRandomMonth(0), getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithAllZeros() {
        return new CardInfo("0000 0000 0000 0000", getRandomMonth(0), getRandomYear(0), generateRandomName(), generateRandomCvc());
    }

    public static CardInfo getCardWithZeroCvc() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), generateRandomName(), "000");
    }

    public static CardInfo getCardWithOneDigitCvc() {
        return new CardInfo(getApprovedNumberCard(), getRandomMonth(0), getRandomYear(0), generateRandomName(), "1");
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String name;
        String cvc;
    }
}
