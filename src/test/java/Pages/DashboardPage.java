package Pages;

import DataGenerator.DataGen;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


        /*public Dashboard() {
        }*/

    public int getCardBalance(String id) {
        val text = cards.findBy(Condition.text(id)).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage upToMoneyOnThisCard(String id) {
        val cssind = cards.findBy(Condition.text(id));
        cssind.$("button[data-test-id='action-deposit']").click();
        return page(TransferPage.class);
    }

}
