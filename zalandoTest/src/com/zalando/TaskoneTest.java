package com.zalando;



import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TaskoneTest {
	
	public static String baseUrl = "http://zalando-edinc.rhcloud.com/login";
	private static String validUsername = "zalando-lounge";
	private static String validPassword = "SuperSecretPassword!";
	private static String invalidUsername = "wrongName";
	private static String invalidPassword = "wrongPassword";
	
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@Before
	public  final void setup()
	{
		
		//load URL before every test case and wait till page is completely loaded.
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("username")));
		
		
		
	}
	
	@After
	public void teardown(){
		
		
		//close Webdriver after every test cases 
		driver.close();
	}
	
	@Test
	public void testValidloginSuccessful(){
		
		
		dologin(validUsername, validPassword);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash success']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash success']"));
		String text = wb.getText();
		
		if(wb.isDisplayed() && text.contains("You logged into a secure area!")){
			
			Assert.assertTrue(true);
			
			
		}
		else{
			
			Assert.assertTrue(false);
		}
				
		
	}
	
	@Test
	public void testValidlogoutSuccessful()
	{
		
		dologin(validUsername, validPassword);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash success']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash success']"));
		WebElement logOutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		String text = wb.getText();
		logOutbutton.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("username")));
		WebElement logOutmessage = driver.findElement(By.xpath("//div[@class='flash success']"));
		String logoutText = logOutmessage.getText();
		
        if(logOutmessage.isDisplayed() && logoutText.contains("You logged out of the secure area!"))
        {
			
			Assert.assertTrue(true);
			
			
		}
		else{
			
			Assert.assertTrue(false);
		}
		
		
				
		
	}
	
	@Test
	public void testLoginWithInvalidUsername()
	{
				
		dologin(invalidUsername, validPassword);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash error']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash error']"));
		String text = wb.getText();
		
        if(wb.isDisplayed() && text.contains("Your username is invalid!"))
        {
			
			Assert.assertTrue(true);
			
			
		}
		else
		{
			
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testLoginWithInvalidPassword()
	{
		
		
		dologin(validUsername, invalidPassword);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash error']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash error']"));
		String text = wb.getText();
		
        if(wb.isDisplayed() && text.contains("Your password is invalid!"))
        {
			
			Assert.assertTrue(true);
			
			
		}
		else
		{
			
			Assert.assertTrue(false);
		}
	}
	
	public void dologin(String userName, String password)
	{
		
		WebElement userNametext = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		//Login to the page 
		
		userNametext.sendKeys(userName);
		passWord.sendKeys(password);
		loginbutton.click();
		
		
		
	}
	

}
