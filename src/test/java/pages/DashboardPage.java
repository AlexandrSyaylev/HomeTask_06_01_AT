package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import dataGenerator.DataGen;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");

    public TransferPage upToMoneyOnThisCard(String id) {
        val cssind = cards.findBy(Condition.text(id));
        cssind.$("button[data-test-id='action-deposit']").click();
        return page(TransferPage.class);
    }

}
