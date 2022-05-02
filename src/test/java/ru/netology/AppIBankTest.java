package ru.netology;

import DataGenerator.DataGen;
import Pages.DashboardPage;
import Pages.LoginPage;
//import Pages.VerificatoinPage;
import Pages.TransferPage;
import com.codeborne.selenide.Condition;
import lombok.val;

//import lombok.var;
//import lombok.var;
import org.codehaus.groovy.antlr.java.JavaRecognizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class AppIBankTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSuccesslogin(){

        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authUser = DataGen.getUserHardCode();
        var verificationPge = loginPage.validLogin(authUser);
        var page=verificationPge.validVerify(authUser);
        var firstCardBal = page.getCardBalance("**** **** **** 0001");
        var secondCardBal = page.getCardBalance("**** **** **** 0002");
        System.out.println(firstCardBal);
        System.out.println(secondCardBal);
    }

    @Test
    public void shouldOpenTransferPage(){
        open("http://localhost:9999");
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authUser = DataGen.getUserHardCode();
        var verificationPge = loginPage.validLogin(authUser);
        var page=verificationPge.validVerify(authUser);
        var firstCardBal = page.getCardBalance("**** **** **** 0001");
        var secondCardBal = page.getCardBalance("**** **** **** 0002");
        System.out.println(firstCardBal);
        System.out.println(secondCardBal);
        var moneyTransfer = page.upToMoneyOnThisCard("**** **** **** 0001");
        var enterAmount = moneyTransfer.transferMoney("1000","000000000000 0002");
        $(withText("Ваши карты")).shouldBe(visible);
    }


}
