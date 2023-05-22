package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAs(String username, String mail, String password) {
        WebElement usernameInput = driver.findElement(By.cssSelector("input[type='text']"));
        usernameInput.sendKeys(username);

        WebElement mailInput = driver.findElement(By.cssSelector("input[type='email']"));
        mailInput.sendKeys(mail);

        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);

        WebElement button = driver.findElement(By.cssSelector("button.btn-primary"));
        button.click();
    }

    public String getLoggedUserName() {
        WebElement username = driver.findElement(By.cssSelector("#main > div > nav > div > ul > li:nth-child(4) > a"));
        return username.getText();
    }
}
