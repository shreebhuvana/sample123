package org.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\eclipse-workspace\\Bhuvana\\Sample\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtSearch.sendKeys("i phones7plus");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		WebElement btnClick = driver.findElement(By.xpath("//h2[contains(text(),'Apple iPhone 7 Plus (Jet Black, 3GB RAM, 128GB Storage)')]"));
		btnClick.click();
		String pWindow = driver.getWindowHandle();
		System.out.println(pWindow);
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		for (String x : allWindow) {
			if(!x.equals(pWindow))
			{
				driver.switchTo().window(x);
			}
			}
		WebElement addCart = driver.findElement(By.name("submit.add-to-cart"));
		addCart.click();
		driver.switchTo().defaultContent();
		// driver.quit();
	}


}
