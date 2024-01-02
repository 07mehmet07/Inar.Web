import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_008_OP_03 extends Hooks {
    /**
     * 1-) Open the URL.
     * 2-) Click "WebOrder" button on top bar.
     * 3-) Enter valid username "Inar" and password "Academy".
     * 4-) Navigate to the order page.
     * 5-) Select "MyMoney" from Product dropdown.
     * 6-) Enter "8" as quantity number.
     * 7-) Enter "20" as discount percentage.
     * 8-) Click on the "Calculate" button.
     * 9-) Enter "Inar Academy" as Name.
     * 10-) Enter "1100 Congress Ave" as Street.
     * 11-) Enter "Austin" as City.
     * 12-) Enter "TX" State.
     * 13-) Enter "92@#83" as Zip Code.
     * 14-) Select "American Express" as Card Type.
     * 15-) Enter "342738261027163" as Card Number.
     * 16-) Enter "01/28" Expire Date(mm/yy format).
     * 17-) Click "Process"" button.
     * 18-) Verify the invalid Zip Code error message is displayed.
     */

    public static final int NUMBER_OF_QUANTITY = 8;
    public static final int NUMBER_OF_DISCOUNT = 20;

    @Test
    void testOrderPlacementwithInvalidZipCode() {

        // 2-) Click "WebOrder" button on top bar.
        WebElement webOrderTag = driver.findElement(By.cssSelector("[href='/weborder']"));
        webOrderTag.click();

        // 3-) Enter "Inar" as username and "Academy" password.
        WebElement userNameText = driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar");
        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // 4-) Navigate to the order page.
        WebElement orderPageTab = driver.findElement(By.cssSelector("[href='/weborder/order']"));
        orderPageTab.click();

        // 5-)  Select "MyMoney" from Product dropdown.
        Select select = new Select(driver.findElement(By.id("productSelect")));
        select.selectByValue("MyMoney");

        // 6-) Enter "8" as quantity number.

        WebElement quantityBox = driver.findElement(By.id("quantityInput"));
        quantityBox.sendKeys(NUMBER_OF_QUANTITY + "");


        // 7-) Enter "20" as discount percentage.
        WebElement discountBox = driver.findElement(By.id("discountInput"));
        discountBox.sendKeys(NUMBER_OF_DISCOUNT + "");

        // 8-) Click on the "Calculate" button.
        WebElement calculateButton = driver.findElement(By.xpath("//button[@type='submit']"));
        calculateButton.click();

        //9-) Enter "Inar Academy" as Name
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys("Inar");

        //10-) Enter "1100 Congress Ave" as Street.
        WebElement streetBox = driver.findElement(By.id("street"));
        streetBox.sendKeys("1100 Congress Ave");

        //11-) Enter "Austin" as City.
        WebElement cityBox = driver.findElement(By.id("city"));
        cityBox.sendKeys("Austin");

        //12-) Enter "TX" State.
        WebElement stateBox = driver.findElement(By.id("state"));
        stateBox.sendKeys("TX");

        //13-) Enter "92@#83" as Zip Code(number).
        WebElement zipBox = driver.findElement(By.id("zip"));
        zipBox.sendKeys("92@#83");

        //14-) Select "American Express" as Card Type.
        WebElement cardBox = driver.findElement(By.id("amex"));
        cardBox.click();

        //15-)Enter "342738261027163" as Card Number.
        WebElement cardNo = driver.findElement(By.id("cardNumber"));
        cardNo.sendKeys("342738261027163");

        //16-) Enter "01/28" Expire Date(mm/yy format)
        WebElement expireDateBox = driver.findElement(By.id("expiryDate"));
        expireDateBox.sendKeys("01/28");


        //17-) Click "Process"" button
        WebElement processButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        processButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.get("https://test.inar-academy.com/weborder/order");
//        Alert alert = driver.switchTo().alert();
//        alert.accept();


        //18-) Verify the invalid Zip Code error message is displayed.
        WebElement errorMessageElement = driver
                .findElement(By.id("zip"));
        String errorMessage = errorMessageElement.getText();
        assertEquals("your Zip Code is invalid", errorMessage);

    }
}
