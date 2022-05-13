package datagenerator;

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

        private String firstSecretCardId = "**** **** **** 0001";
        private String secondSecretCardId = "**** **** **** 0002";
        private String firstCardId = "5559 0000 0000 0001";
        private String secondCardId = "5559 0000 0000 0002";
    }

    public static UserAuth getUserHardCode() {
        return new UserAuth("vasya", "qwerty123", "12345");
    }

    public static String getFirstCardId() {
        return new Card().firstCardId;
    }

    public static String getSecondCardId() {
        return new Card().secondCardId;
    }

    public static String getFirstSecretId() {
        return new Card().firstSecretCardId;
    }

    public static String getSecondSecretId() {
        return new Card().secondSecretCardId;
    }
}
