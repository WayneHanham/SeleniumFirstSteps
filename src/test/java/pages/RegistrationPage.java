package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(css="input[type='text']")
    WebElement usernameInput;

    @FindBy(css="input[type='email']")
    WebElement mailInput;

    @FindBy(css="input[type='password']")
    WebElement passwordInput;

    @FindBy(css = "button.btn-primary")
    WebElement button;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registerAs(String username, String mail, String password) {
        usernameInput.sendKeys(username);
        mailInput.sendKeys(mail);
        passwordInput.sendKeys(password);
        button.click();
    }

    public String getLoggedUserName() {
        WebElement username = driver.findElement(By.cssSelector("#main > div > nav > div > ul > li:nth-child(4) > a"));
        return username.getText();
    }
}
