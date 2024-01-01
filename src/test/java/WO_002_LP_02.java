import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_002_LP_02 extends Hooks {

	/**
	 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter invalid
	 * username "InvalidUserName" and/or password "InvalidPassword". 4-) Click on the
	 * "Login" button 5-) Verify that the appropriate error message is displayed
	 */

	@Test

	void testVerifyLoginFailure() {

		// Click "WebOrder" button on top bar
		WebElement webOrderTag = driver.findElement(By.cssSelector("[href='/weborder']"));
		webOrderTag.click();

		// 3-) Enter "Inar" as username and "Academy" password.

		WebElement userNameText = driver.findElement(By.id("login-username-input"));
		userNameText.sendKeys("InvalidUserName");
		WebElement passwordText = driver.findElement(By.id("login-password-input"));
		passwordText.sendKeys("InvalidPassword");

		// 4-) Click on the "Login" button.

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 5-) Verify that the appropriate error message is displayed

		WebElement alertMessageTab = driver.findElement(By.id("username-error-alert"));
		String alertMessage = alertMessageTab.getText();
		assertEquals("Invalid username", alertMessage);

		WebElement alertPasswordTab = driver.findElement(By.id("password-error-alert"));
		String alertPassMessage = alertPasswordTab.getText();
		assertEquals("Invalid password", alertPassMessage);

	}

}
