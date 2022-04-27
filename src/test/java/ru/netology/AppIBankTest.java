package ru.netology;

import DashboardPage.DashboardPage;
import DataGenerator.DataGen;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class AppIBankTest {

    public class LoginPage {
        @FindBy(css = "input[name='login']")
        private SelenideElement loginField;
        @FindBy(css = "[name='password'] input")
        private SelenideElement passwordField;
        @FindBy(css = "button [data-test-id='action-login']")
        private SelenideElement buttonLogin;
        @FindBy(css = "[name='code'] input")
        private SelenideElement codeField;
        @FindBy(css = "button [data-test-id='action-login']")
        private SelenideElement buttonSubmitCode;

        public void verificationPage(DataGen.UserAuth user) {
            loginField.setValue(user.getLogin());
            passwordField.setValue(user.getPassword());
            buttonLogin.click();
            codeField.setValue(user.getVerificationCode());
            buttonSubmitCode.click();
        }
    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSuccesslogin(){

        /*new LoginPage().verificationPage(DataGen.getUserHardCode());
        DashboardPage page = new DashboardPage();
        val firstCardBal = page.getCardBalance("**** **** **** 0001");
        val secondCardBal = page.getCardBalance("**** **** **** 0002");
        System.out.println(firstCardBal);
        System.out.println(secondCardBal);*/

    }


}
