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
	
	//@Test
	public void testValidlogin(){
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		//Login to the page 
		
		userName.sendKeys(validUsername);
		passWord.sendKeys(validPassword);
		loginbutton.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash success']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash success']"));
		String text = wb.getText();
		System.out.println(text);
		if(wb.isDisplayed()){
			
			Assert.assertTrue(true);
			
			
		}
		else{
			
			Assert.assertTrue(false);
		}
				
		
	}
	
	@Test
	public void testLoginWithInvalidUsername(){
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		//Login to the page 
		
		userName.sendKeys(invalidUsername);
		passWord.sendKeys(validPassword);
		loginbutton.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash error']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash error']"));
		
        if(wb.isDisplayed())
        {
			
			Assert.assertTrue(true);
			
			
		}
		else
		{
			
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testLoginWithInvalidPassword(){
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		//Login to the page 
		
		userName.sendKeys(validUsername);
		passWord.sendKeys(invalidPassword);
		loginbutton.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flash error']")));
		WebElement wb = driver.findElement(By.xpath("//div[@class='flash error']"));
		
        if(wb.isDisplayed())
        {
			
			Assert.assertTrue(true);
			
			
		}
		else
		{
			
			Assert.assertTrue(false);
		}
	}
	

}
