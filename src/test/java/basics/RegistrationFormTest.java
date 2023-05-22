package basics;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class RegistrationFormTest {
    @Test
    public void registrationTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        // enter email

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("something@example.com");

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("something@example.com");

        String whateverITypedIntoEmail = emailInput.getAttribute("placeholder");
        System.out.println("I typed into email: " + whateverITypedIntoEmail);


        // select gender
        WebElement genderSelect = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));



        // print all label texts
        List<WebElement> allLabelsOnPage = driver.findElements(By.cssSelector("label.custom-control-label"));

        for (WebElement element : allLabelsOnPage) {
            System.out.println(element.getText());
        }

        genderSelect.click();



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
    }
}
