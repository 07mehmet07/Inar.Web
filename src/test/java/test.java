import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	void testSelenium() {
		driver.get("https://www.google.com/");
		String currentUrl = driver.getCurrentUrl();
		assertEquals("https://www.google.com/", currentUrl);

	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

}
