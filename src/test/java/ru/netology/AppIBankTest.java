package ru.netology;

import dataGenerator.DataGen;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppIBankTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldOpenTransferPage() {
        int amountToTransfer = 1000;
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authUser = DataGen.getUserHardCode();
        var verificationPge = loginPage.validLogin(authUser);
        var page = verificationPge.validVerify(authUser);
        int startValueCardOne = DataGen.getFirstCard();
        int startValueCardTwo = DataGen.getSecondCard();
        var moneyTransfer = page.upToMoneyOnThisCard(DataGen.getFirstSecretId());
        var enterAmount = moneyTransfer.transferMoney(String.valueOf(amountToTransfer), DataGen.getSecondCardId());
        $(withText("Ваши карты")).shouldBe(visible);
        int expectedCardOne = startValueCardOne + amountToTransfer;
        int expectedCardTwo = startValueCardTwo - amountToTransfer;
        assertEquals(expectedCardOne, DataGen.getFirstCard());
        assertEquals(expectedCardTwo, DataGen.getSecondCard());

    }


}
