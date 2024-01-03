import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_007_OP_02 extends Hooks {

	/**
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "FamilyAlbum" from Product dropdown. 6-) Enter "3" as quantity number. 7-) Enter
	 * "17" as discount percentage. 8-) Enter "Inar Academy" as Name. 9-) Enter "1100
	 * Congress Ave" as Street. 10-) Enter "Austin" as City. 11-) Enter "TX" State. 12-)
	 * Enter "78701" as Zip Code(number). 13-) Select "Mastercard" as Card Type. 14-)
	 * Enter "5162738261027163" as Card Number. 15-) Enter "11/28" Expire Date(mm/yy
	 * format). 16-) Click "Process"" button. 17-) Verify the invalid Product Information
	 * error message is displayed.
	 */

	public static final int NUMBER_OF_QUANTITY = 3;

	public static final int NUMBER_OF_DISCOUNT = 17;

	@Test
	void testVerifyOrderPlacementwithoutCalculation() {
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

		// 5-) Select "FamilyAlbum" from Product dropdown.
		Select select = new Select(driver.findElement(By.id("productSelect")));
		select.selectByValue("FamilyAlbum");

		// 6-) Enter "3" as quantity number.

		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys(NUMBER_OF_QUANTITY + "");

		// 7-) Enter "17" as discount percentage.
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys(NUMBER_OF_DISCOUNT + "");

		// 8-) Enter "Inar Academy" as Name
		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("Inar");

		// 9-) Enter "1100 Congress Ave" as Street.
		WebElement streetBox = driver.findElement(By.id("street"));
		streetBox.sendKeys("1100 Congress Ave");

		// 10-) Enter "Austin" as City.
		WebElement cityBox = driver.findElement(By.id("city"));
		cityBox.sendKeys("Austin");

		// 11-) Enter "TX" State.
		WebElement stateBox = driver.findElement(By.id("state"));
		stateBox.sendKeys("TX");

		// 12-) Enter "78701" as Zip Code(number).
		WebElement zipBox = driver.findElement(By.id("zip"));
		zipBox.sendKeys("78701");

		// * 13-) Select "Mastercard" as Card Type.
		WebElement cardType = driver.findElement(By.id("mastercard"));
		cardType.click();

		// 14-) Enter "5162738261027163" as Card Number.
		WebElement cardNo = driver.findElement(By.id("cardNumber"));
		cardNo.sendKeys("5162738261027163");

		// 15-) Enter "11/28" Expire Date(mm/yy format).
		WebElement expireDateBox = driver.findElement(By.id("expiryDate"));
		expireDateBox.sendKeys("11/28");

		// 16-) Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		processButton.click();

		// 17-) Verify the invalid Product Information error message is displayed.
		WebElement errorMessage = driver.findElement(By.xpath("//em[contains(text(),'Fix errors')]"));
		String actualMessage = errorMessage.getText();
		assertEquals("Fix errors in Product Information", actualMessage,
				"should be error message when calculate button is not pressed");
	}

}
