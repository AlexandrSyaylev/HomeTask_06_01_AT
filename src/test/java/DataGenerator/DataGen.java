package DataGenerator;

import lombok.Value;

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
        String number;
        String balance;
    }

    public static UserAuth getUserHardCode() {
        return new UserAuth("vasya", "qwerty123", "12345");
    }

    /*public Card CardFirst() {
        return new Card("5559 0000 0000 0001", "10 000");
    }

    public Card CardSecond() {
        return new Card("5559 0000 0000 0002", "10 000");
    }*/




    /*login: 'vasya'
     * password: 'qwerty123'
     * verification code (hardcoded): '12345'
     * cards:
     *
     * first:
     * number: '5559 0000 0000 0001'
     * balance: 10 000 RUB
     * second:
     * number: '5559 0000 0000 0002'
     * balance: 10 000 RUB*/
}
