package pages;

import exceptions.ShiptException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage extends BasePage{


    private static Logger LOGGER = Logger.getLogger(ShoppingPage.class);
    private WebDriver driver;


    @FindBy(xpath = "//div/span[@data-test='ShoppingStoreSelect-storeView-storeName']")
    private WebElement selectShoppingStore;

    @FindBy(xpath = "//a[@aria-label='Account']")
    private WebElement account;


    public ShoppingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForElement(selectShoppingStore);

    }


    public String getSelectedStoreName() {

        return selectShoppingStore.getText();
    }

    /***
     * This method is used to select store based on the storeName
     * @param storeName
     * @throws ShiptException
     */

    public void selectStore(String storeName)  {
        selectShoppingStore.click();

        String locator = "//div[@data-test='loading-indicator']";

        waitForElementInvisibility(By.xpath(locator),10);
        WebElement ele = driver.findElement(By.cssSelector("[aria-label='"+storeName+"']"));
        ele.click();
        waitForElementInvisibility(By.xpath(locator),10);
    }


    /***
     * This method is clicks on Account and returns the account page
     */

    public AccountPage selectAccount(){
        account.click();
        return new AccountPage(driver);
    }

}
