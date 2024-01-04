import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WO_012_VAO_03 extends Hooks {

	/**
	 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
	 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click
	 * "Add More Data" "8" times. 6-) Click 1st, 3rd and 5th orders checkbox's. 7-) Click
	 * "Delete All" button. 8-) Verify the orders are deleted.
	 */

	@Test
	void testVerifyDeleteFunctionalityInViewAllOrderPage() {
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

		// 4-) Navigate to the view all order page.
		WebElement viewAllOrdersLink = driver.findElement(By.xpath("//div[@id='view-orders-tab']/a"));
		viewAllOrdersLink.click();

		// 5-) Click "Add More Data" "8" times.
		WebElement addMoreData = driver.findElement(By.xpath("//button[text()='Add More Data']"));
		for (int i = 0; i < 8; i++) {
			addMoreData.click();
		}
		// Click 1st, 3rd and 5th orders checkbox's.
		List<WebElement> allOrders = driver.findElements(By.xpath("//tbody/tr"));
		List<String> linksOfDeletedOrders = new ArrayList<>();
		for (int i = 0; i <= 4; i += 2) {
			allOrders.get(i).findElement(By.tagName("input")).click();
			linksOfDeletedOrders.add(allOrders.get(i).findElement(By.cssSelector("td > a")).getAttribute("href"));
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 1000)");

		// Click "DeleteAll" button.
		driver.findElement(By.xpath("//button[text()='Delete']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Delete']")));
		js.executeScript("window.scroll(0, -1000)");

		// Verify the orders are deleted.
		allOrders = driver.findElements(By.xpath("//tbody/tr"));
		ArrayList<String> linksOfRemainingOrders = new ArrayList<>();

		for (WebElement allOrder : allOrders) {
			linksOfRemainingOrders.add(allOrder.findElement(By.cssSelector("td > a")).getAttribute("href"));
		}
		System.out.println(linksOfDeletedOrders);
		System.out.println(linksOfRemainingOrders);

		for (String s : linksOfDeletedOrders) {
			assertFalse(linksOfRemainingOrders.contains(s));
		}
	}

}
