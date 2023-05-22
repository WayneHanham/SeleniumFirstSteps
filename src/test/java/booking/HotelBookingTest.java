package booking;

import helpers.EmailHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelBookingTest {

    @Test
    public void shouldBeAbleToBookHotel() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // first page

        WebElement selectHotelDropdown = driver.findElement(By.id("hotel_cat_name"));
        // not gonna work
        // Select hotelDropdown = new Select(selectHotelDropdown);
        // hotelDropdown.selectByVisibleText("The Hotel Prime");

        selectHotelDropdown.click();
        WebElement hotelName = driver.findElement(By.cssSelector("li[data-id-hotel='1']"));
        hotelName.click();


        WebElement checkInTime = driver.findElement(By.id("check_in_time"));
        checkInTime.sendKeys("01-09-2023");

        WebElement checkOutTime = driver.findElement(By.id("check_out_time"));
        checkOutTime.sendKeys("10-09-2023");

        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
        searchNowButton.click();

        // now we are on results page

        // get all blue buttons
        List<WebElement> bookNowButtons = driver.findElements(By.cssSelector(".ajax_add_to_cart_button"));
        // click on first one (if you want different click on get(1) or get(2))
        bookNowButtons.get(0).click();

        // find proceed to checkout
        WebElement proceedToCheckout = driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
        proceedToCheckout.click();

        // now populate new customer registration form
        WebElement email = driver.findElement(By.id("email"));
        // instead of this
        // email.sendKeys("michal1234567@gmail.com");

        email.sendKeys(EmailHelper.generateRandomEmail());

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("michal1234567@gmail.com");

        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Michal");

        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Dobrzycki");

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Blablablablabla");

        WebElement postcode = driver.findElement(By.id("postcode"));
        postcode.sendKeys("12-123");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Wroclaw");

        WebElement phoneMobile = driver.findElement(By.id("phone_mobile"));
        phoneMobile.sendKeys("123456790");

        // save account
        WebElement submitAccount = driver.findElement(By.id("submitAccount"));
        submitAccount.click();


        // agree to terms of service
        WebElement agreeCheckbox = driver.findElement(By.id("cgv"));
        agreeCheckbox.click();

        WebElement payByBankWireButton = driver.findElement(By.cssSelector(".bankwire"));
        payByBankWireButton.click();

        // now we are on order confirmation
        WebElement confirmOrderButton = driver.findElement(By.cssSelector("#cart_navigation > button"));
        confirmOrderButton.click();

        // validation
        WebElement orderSuccessAlert = driver.findElement(By.cssSelector("p.alert-success"));

        assertEquals(orderSuccessAlert.getText(), "Your order on MyBooking is complete.");
    }
}
