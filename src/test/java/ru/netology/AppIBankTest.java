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
        int startValueCardOne = DataGen.getBalanceCard("**** **** **** 0001");
        int startValueCardTwo = DataGen.getBalanceCard("**** **** **** 0002");
        var moneyTransfer = page.upToMoneyOnThisCard("**** **** **** 0001");
        var enterAmount = moneyTransfer.transferMoney(String.valueOf(amountToTransfer), "5559 0000 0000 0002");
        $(withText("Ваши карты")).shouldBe(visible);
        int expectedCardOne = startValueCardOne + amountToTransfer;
        int expectedCardTwo = startValueCardTwo - amountToTransfer;
        assertEquals(expectedCardOne, DataGen.getBalanceCard("**** **** **** 0001"));
        assertEquals(expectedCardTwo, DataGen.getBalanceCard("**** **** **** 0002"));

    }


}
