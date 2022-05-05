package dataGenerator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.Value;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class DataGen {

    private DataGen() {
    }

    @Value
    public static class UserAuth {
        String login;
        String password;
        String verificationCode;
    }

    @Value
    public static class Card {

        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private ElementsCollection cards = $$(".list__item div");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        /*private String firstCardId = "**** **** **** 0001";
        private String secondCardId = "**** **** **** 0002";*/
        private String firstCardId = "5559 0000 0000 0001";
        private String secondCardId = "5559 0000 0000 0002";


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

        public int getFirstCardBal() { return getCardBalance(firstCardId); }
        public int getSecondCardBal(){ return getCardBalance(secondCardId);}



    }

    public static UserAuth getUserHardCode() {
        return new UserAuth("vasya", "qwerty123", "12345");
    }
    public static int getFirstCard() { return new Card().getFirstCardBal(); }
    public static int getSecondCard(){ return new Card().getSecondCardBal();}
    public static String getFirstCardId(){ return new Card().firstCardId;}
    public static String getSecondCardId(){ return new Card().secondCardId;}
}
