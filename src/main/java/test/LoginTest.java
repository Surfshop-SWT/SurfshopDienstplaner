package test;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 23.12.2020
 */
public class LoginTest {

    public boolean isValid(String username, String password) {

        if (username.equals("Tim") && password.equals("123")) {
            return true;
        } else {
            return false;
        }
    }
}
