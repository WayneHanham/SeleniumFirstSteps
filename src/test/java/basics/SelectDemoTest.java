package basics;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectDemoTest {
    @Test
    public void registrationTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        WebElement selectDropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectDropdown);
        select.selectByIndex(4);

    }
}
