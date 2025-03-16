package ru.netology.web.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataHelper {

    public String hiddenCardNumber(String cardNumber) {
        return cardNumber.replaceFirst("\\d{4} \\d{4} \\d{4}", "**** **** ****");
    }
}