package Test;

import Base.BaseTest;
import Page.Login;
import org.testng.annotations.Test;

public class login extends BaseTest {
    @Test
    public void loginpage(){
        Login loginTest = new Login(page);
        loginTest.LoginPage();
        System.out.println("Test completed");
    }

}
