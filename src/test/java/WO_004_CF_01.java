import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_004_CF_01 extends Hooks {

	public static final int NUMBER_OF_QUANTITY = 5;

	public static final int NUMBER_OF_DISCOUNT = 15;

	/**
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
	 * "HomeDecor" from Product dropdown. 6-) Enter "5" as quantity number. 7-) Enter "15"
	 * as discount percentage. 8-) Click on the "Calculate" button. 9-) Verify that the
	 * total amount is successfully displayed.
	 */

	@Test
	void testFunctionalityOfCalculate() {
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

		// 5-) Select "HomeDecor" from Product dropdown.
		Select select = new Select(driver.findElement(By.id("productSelect")));
		select.selectByIndex(4);

		// 6-) Enter "5" as quantity number.

		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys(NUMBER_OF_QUANTITY + "");

		WebElement unitPriceBox = driver.findElement(By.id("unitPriceInput"));
		int unitPrice = Integer.parseInt(unitPriceBox.getAttribute("value"));

		// 7-) Enter "15" as discount percentage.
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys(NUMBER_OF_DISCOUNT + "");

		// 8-) Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[@type='submit']"));
		calculateButton.click();

		// 9-) Verify that the total amount is successfully displayed.
		long expectedResult = Math.round(((unitPrice * NUMBER_OF_QUANTITY) / 100.0) * (100 - NUMBER_OF_DISCOUNT));
		WebElement total = driver.findElement(By.id("totalInput"));
		long actualResult = Long.parseLong(total.getAttribute("value"));

		assertEquals(expectedResult, actualResult);
	}

}
