import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_001_LP_01 extends Hooks {

	/*
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter "Inar" as
	 * username and "Academy" password. 4-) Click on the "Login" button. 5-) Verify that
	 * the user is successfully logged in.
	 */

	@Test
	void testVerifyLoginFunctionality() {

		// 2-) Click "WebOrder" button on top bar.

		WebElement webOrderTag = driver.findElement(By.cssSelector("[href='/weborder']"));
		webOrderTag.click();

		// 3-) Enter "Inar" as username and "Academy" password.

		WebElement userNameText = driver.findElement(By.id("login-username-input"));
		userNameText.sendKeys("Inar");
		WebElement passwordText = driver.findElement(By.id("login-password-input"));
		passwordText.sendKeys("Academy");

		// 4-) Click on the "Login" button.

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));

		// 5-) Verify that the user is successfully logged in.

		WebElement welcomeText = driver.findElement(By.xpath("//h1[@id='welcome-heading']"));
		String message = welcomeText.getText();
		assertEquals("Welcome, Inar!", message);

	}

}
