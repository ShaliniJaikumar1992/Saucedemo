package Data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user1", "password1"},
            {"user2", "password2"}
        };
    }
}
