package DashboardPage;

import DataGenerator.DataGen;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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
