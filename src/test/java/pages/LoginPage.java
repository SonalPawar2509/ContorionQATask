package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

public class LoginPage extends BaseTest {
    public LoginPage(String browserProperties) {
        super(browserProperties);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="popin_tc_privacy_button")
    WebElement cookieBtn;

    @FindBy(xpath="//span[contains(text(),'Anmelden')]")
    WebElement loginBtn;

    @FindBy(id="login_email")
    WebElement userName;

    @FindBy(id="login_password")
    WebElement password;

    @FindBy(xpath="//span[contains(text(),'Jetzt anmelden')]")
    WebElement jetztLogin;

    public boolean isHomePageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("popin_tc_privacy_button"))).isDisplayed();
    }
    public void acceptCookies(){
        if(isHomePageLoaded()==true)
        {
            driver.findElement(By.id("popin_tc_privacy_button")).click();
            System.out.println("Accept cookie clicked########");
        }
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }


    public void validateLogin() {

        String uname = prp.getProperty("username");
        String pwd = prp.getProperty("password");
        acceptCookies();
        sleep(3000);
        loginBtn.click();
        sleep(3000);
        userName.sendKeys(uname);
        password.sendKeys(pwd);
        jetztLogin.click();
        sleep(5000);
        System.out.println("##### login done ########");

    }
}