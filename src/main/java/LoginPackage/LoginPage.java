package LoginPackage;

import BaseClassPackage.BaseClass;
import HomePagePackage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    //Data provider
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWard;

    @FindBy(xpath = "//input[contains(text(),'login')]")
    WebElement logInBtn;

    @FindBy(className="img-responsive")
    WebElement logoOFCRM;

    @FindBy(xpath = "//a[contains(text(),'Sign Up']")
    WebElement signInLink;

    public LoginPage() {

        PageFactory.initElements(driver,this);
    }

    public String signInLinkMethod(){
        signInLink.click();
        String signInTitle = driver.getTitle();
        return signInTitle;
    }
    public boolean logoTestMethod(){
        boolean flag = logoOFCRM.isDisplayed();
        return flag;
    }
    public HomePage logIn() {
        userName.sendKeys(prop.getProperty("username"));
        passWard.sendKeys(prop.getProperty("passward"));
        logInBtn.click();
        return new HomePage();
    }
}






