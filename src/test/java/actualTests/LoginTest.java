package actualTests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends LoginPage {

    //LoginTest ln;
    String browserProperties = "chrome_mac64.properties";
    LoginPage ln;
    public LoginTest() {
        super("chrome_mac64.properties");
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        ln = new LoginPage(browserProperties);
        //ln.initialization();
    }

    @Test(priority=1)
    public void verifyPageTitle() {
        Assert.assertEquals("Contorion: Der smarte Shop fürs Handwerk", ln.getHomePageTitle());
    }

    @Test(priority=1)
    public void verifyAcceptCookie() {
        ln.acceptCookies();
        Assert.assertEquals("Contorion: Der smarte Shop fürs Handwerk", ln.getHomePageTitle());
    }

    @Test(priority=1)
    public void testLogin() {
        ln.validateLogin();
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
