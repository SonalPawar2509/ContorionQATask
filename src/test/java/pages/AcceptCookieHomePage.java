package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

public class AcceptCookieHomePage extends BaseTest {
    public AcceptCookieHomePage(String browserProperties) {
        super(browserProperties);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="popin_tc_privacy_button")
    WebElement cookieBtn;

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
}
