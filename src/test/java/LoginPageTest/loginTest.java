package LoginPageTest;

import BaseClassPackage.BaseClass;
import LoginPackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest extends BaseClass {
    public static LoginPage logInPageObj;

    public loginTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
         logInPageObj = new LoginPage();
    }
    @Test
    public static void signInTitleTest(){
        String signInTitleT = logInPageObj.signInLinkMethod();
        Assert.assertEquals(signInTitleT,"Free CRM - CRM Pro for customer relationship management, sales, and support");
    }
    @Test
    public static void crmLogoTest(){
        boolean flag1 = logInPageObj.logoTestMethod();
        Assert.assertTrue(flag1);
    }
    @Test
    public static void logInToHomePageTest(){
        logInPageObj.logIn();
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO");
    }

    @AfterMethod
    public void quitProgram(){
        driver.quit();
    }

}
