package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage  extends BasePage{

    private static Logger LOGGER = Logger.getLogger(AccountPage.class);
    private WebDriver driver;


    @FindBy(xpath="//button[@data-test='nav-logout']")
    private WebElement logout;

    @FindBy(xpath="//span[@data-test='Confirmation-modal-accept-button-text']")
    private WebElement logoutConfirmation;

    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForElement(logout);
    }


    /***
     * This method is used to click on logout link
     */

    public void logout(){
        logout.click();
        logoutConfirmation.click();
    }



}
