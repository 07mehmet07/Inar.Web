import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_005_CF_02 extends Hooks {
    /**
     * 1-) Open the URL.
     * 2-) Click "WebOrder" button on top bar.
     * 3-) Enter valid username "Inar" and password "Academy".
     * 4-) Navigate to the order page.
     * 5-) Select "ScreenSaver" from Product dropdown.
     * 6-) Leave blank the quantity box.
     * 7-) Enter "20" as discount percentage.
     * 8-) Click on the "Calculate" button.
     * 9-) Verify the invalid Quantity error message is displayed.
     */

    public static final int NUMBER_OF_QUANTITY = 0;

    public static final int NUMBER_OF_DISCOUNT = 20;

    @Test
    void testVerifyFunctionalityOfCalculatewithInvalidInput() {
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

        //5-) Select "ScreenSaver" from Product dropdown.
        Select select = new Select(driver.findElement(By.id("productSelect")));
        select.selectByValue("ScreenSaver");

        //6-) Leave blank the quantity box / 7-) Enter "20" as discount percentage.
        WebElement discountBox = driver.findElement(By.id("discountInput"));
        discountBox.sendKeys(NUMBER_OF_DISCOUNT + "");

        //8-) Click on the "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("//button[@type='submit']"));
        calculateButton.click();

        //9-) Verify the invalid Quantity error message is displayed.
        WebElement quantityBox = driver.findElement(By.id("quantityValidateError"));
        String errorMessageOfQuantity = quantityBox.getText();
        assertEquals("Field 'Quantity' must be greater than zero.", errorMessageOfQuantity , "should be error message when quantity number is not in the box");

    }


}
