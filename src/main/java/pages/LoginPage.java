package pages;

import exceptions.ShiptException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static Logger LOGGER = Logger.getLogger(LoginPage.class);
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "fancybox-close-small")
    private WebElement close;

    @FindBy(className = "button-secondary")
    private WebElement loginbutton;

    @FindBy(xpath = "//button[@data-test ='LoginForm-log-in-button']")
    private WebElement loginformButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        closePopUp();
    }



    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getLoginformButton(){
        return loginformButton;
    }

    public WebElement getShiptLogin() {
        return loginbutton;
    }

    /***
     * This method is used to close the popup in home page
     */

    public void closePopUp(){
        try {
            if (close.isDisplayed() && close.isEnabled()) {
                close.click();
            }
        }catch(RuntimeException e){
            LOGGER.info("pop up not displayed");
        }
    }


    /***
     * This method is used to click on login button in login page
     * @throws ShiptException
     */

    public void clickLogin() throws ShiptException {

        try{
            waitForElement(getLoginformButton());
        if(getLoginformButton().isDisplayed() && getLoginformButton().isDisplayed()){
            getLoginformButton().click();
        }else {
            LOGGER.error("Unable to click on login button");
            throw new ShiptException("Unable to click the login button as it is not displayed or enabled");
        }
    } catch(NoSuchElementException e) {
            LOGGER.error("Unable to find the element", e);
        throw new ShiptException("Unable to click the login button as it is not displayed or enabled",e);
    }
    }



    /***
     * This method is used to click on login button to enter login page
     * @throws ShiptException
     */
    public void enterLogin(){
        waitForElement(getShiptLogin());
        if(getShiptLogin().isDisplayed() && getShiptLogin().isEnabled()){
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click()", getShiptLogin());
        }else {
            LOGGER.error("Unable to click on enter login button");
            throw new ShiptException("Unable to click on enter login button as it is not displayed or enabled");
        }
    }

    public void enterUsername(String username){
        getUsername().sendKeys(username);
    }

    public void enterPassword(String password){
        getPassword().sendKeys(password);
    }
}
