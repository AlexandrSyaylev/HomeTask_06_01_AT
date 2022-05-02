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

}
