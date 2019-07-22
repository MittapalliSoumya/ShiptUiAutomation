package modules;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.ShoppingPage;

public class testSelectedStore extends BaseTest {

    LoginPage login;
    ShoppingPage shoppingPage;


    @Test
    public void test_Selected_Store() throws InterruptedException {

        // Variables specific to the test case

        String storeName = "Target";

        //Perform login to the application
        login = new LoginPage(driver);
        login.enterLogin();
        login.enterUsername(props.getProperty("shipt.username"));
        login.enterPassword(props.getProperty("shipt.password"));
        login.clickLogin();


        //Navigate to shopping page and verify store Name

       shoppingPage = new ShoppingPage(driver);
       shoppingPage.selectStore(storeName);


       Assert.assertEquals(shoppingPage.getSelectedStoreName(),storeName);


    }


    @AfterMethod
    public void afterMethod(){
        shoppingPage.selectAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logout();
    }

}
