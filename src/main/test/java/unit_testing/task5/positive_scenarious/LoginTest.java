package unit_testing.task5.positive_scenarious;

import org.junit.Test;
import tasks_for_weeks.task5.Login;

public class LoginTest {

    @Test
    public void login() throws Exception {
        Login login = new Login("D_Rose", "qwerty123");
        login.login();
    }
}
