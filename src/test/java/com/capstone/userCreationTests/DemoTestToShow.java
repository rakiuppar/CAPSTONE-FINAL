package com.capstone.userCreationTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.capstone.util.UtilityClass;

public class DemoTestToShow {
	// Maven: We need Selenium and testNG jar/packages. Maven downloads the packages
	// and store inside the project automatically.

	@Test
	public void runThisForDemo() throws InterruptedException {

		// Setting the driver path in order to create communication channel between the
		// script and the browser
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");

		// Creating a Webdriver instance of type Chrome driver, to initiate the browser
		// to open the application
		// This command will open the empty Chrome browser
		WebDriver driver = new ChromeDriver();

		// This will wait for the application to be loaded completely before performing
		// next action at every step
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// This will load the URL provided
		driver.get("http://demo.guru99.com/test/newtours/");

		// Maximise the browser window
		driver.manage().window().maximize();

		// Find the particular element by using the locator in html and click on it
		driver.findElement(By.xpath("//*[contains(text(),'REGISTER')]")).click();

		// Find the particular element by using the locator in html and types the
		// characters in it
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("DemoFNAme");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("DemoLName");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Project@CMRCollege.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("CMR College");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Yelhanka");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("560001");
		Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		country.selectByVisibleText("INDIA");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Project@CMRCollege.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("12345678");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		String successMessage = driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering.')]"))
				.getText();
		String expectedMessage = "Thank you for registering";
		Thread.sleep(5000);

		// Verify success message is displayed after user creation
		if (successMessage.contains(expectedMessage)) {
			System.out.println("User has been created successfully");
		}

		// Login to application after user creation
		driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Project@CMRCollege.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(5000);

		// Verify user is in home page after login
		if (driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).isDisplayed()) {
			System.out.println("User has logged in successfully");
			System.out.println("--------------------------------");
		}

		// Clicks on the Sign out button
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
		Thread.sleep(5000);

		// Close the browser
		driver.quit();

	}
}
