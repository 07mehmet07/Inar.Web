import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_009_OP_04 extends Hooks {

	/**
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 3-) Enter valid username "Inar" and password
	 * "Academy". 4-) Navigate to the order page. 5-) Select "SportsEquipment" from
	 * Product dropdown. 6-) Enter "1" as quantity number. 7-) Enter "10" as discount
	 * percentage. 8-) Click on the "Calculate" button. 9-) Enter "Inar Academy" as Name.
	 * 10-) Enter "1100 Congress Ave" as Street. 11-) Enter "Austin" as City. 12-) Enter
	 * "TX" State. 13-) Enter "78701" as Zip Code(number). 14-) Enter "4938220192845" as
	 * Card Number. 15-) Enter "09/26" Expire Date(mm/yy format). 16-) Click "Process""
	 * button. 17-) Verify the Card Type error message is displayed.
	 */
	public static final int NUMBER_OF_QUANTITY = 1;

	public static final int NUMBER_OF_DISCOUNT = 10;

	@Test
	void testOrderPlacementWithoutCardType() {
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

		// 5-) Select "SportsEquipment" from Product dropdown.
		Select select = new Select(driver.findElement(By.id("productSelect")));
		select.selectByValue("SportsEquipment");

		// 6-) Enter "1" as quantity number.
		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys(NUMBER_OF_QUANTITY + "");

		// 7-) Enter "10" as discount percentage.
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys(NUMBER_OF_DISCOUNT + "");

		// 8-) Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[@type='submit']"));
		calculateButton.click();

		// 9-) Enter "Inar Academy" as Name
		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("Inar");

		// 10-) Enter "1100 Congress Ave" as Street.
		WebElement streetBox = driver.findElement(By.id("street"));
		streetBox.sendKeys("1100 Congress Ave");

		// 11-) Enter "Austin" as City.
		WebElement cityBox = driver.findElement(By.id("city"));
		cityBox.sendKeys("Austin");

		// 12-) Enter "TX" State.
		WebElement stateBox = driver.findElement(By.id("state"));
		stateBox.sendKeys("TX");

		// 13-) Enter "78701" as Zip Code(number).
		WebElement zipBox = driver.findElement(By.id("zip"));
		zipBox.sendKeys("78701");

		// 14-) Enter "4938220192845" as Card Number.
		WebElement cardNo = driver.findElement(By.id("cardNumber"));
		cardNo.sendKeys("4938281746192845");

		// 15-) Enter "09/26" Expire Date(mm/yy format).
		WebElement expireDateBox = driver.findElement(By.id("expiryDate"));
		expireDateBox.sendKeys("09/26");

		// 16-) Click "Process"" button
		WebElement processButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		processButton.click();

		// 17-) Verify the Card Type error message is displayed.
		WebElement cardType = driver.findElement(By.xpath("//em[contains(text(),'Card type cannot be empty')]"));
		String cardTypeErrorMesage = cardType.getText();
		assertEquals("Card type cannot be empty", cardTypeErrorMesage,
				"should be text message when card type is not in box");

	}

}
