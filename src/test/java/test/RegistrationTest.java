package test;

import helpers.EmailHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    @Test
    public void userWithValidDataShouldBeRegistered() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://react-redux.realworld.io/#/register");
        String username = EmailHelper.generateRandomEmail();

        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.registerAs(username, EmailHelper.generateRandomEmail(), "password");

        assertEquals(username, regPage.getLoggedUserName());
    }
}
