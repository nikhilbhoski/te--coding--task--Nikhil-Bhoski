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

public class TaskTwoTest {
	
	public static String baseUrl = "http://zalando-edinc.rhcloud.com/status_codes";
	
	
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@Before
	public  final void setup()
	{
		
		//load URL before every test case and wait till page is completely loaded.
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='status_codes/200']")));
		
		
		
	}
	
	@After
	public void teardown(){
		
		
		//close Webdriver after every test cases 
		driver.close();
	}
	
	@Test
	public void teststatusCode200()
	{
		WebElement statusCode200 = driver.findElement(By.xpath("//a[@href='status_codes/200']"));
		
		statusCode200.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']/div/p")));
		WebElement statusCodeMessage = driver.findElement(By.xpath("//div[@id='content']/div/p"));
		String text = statusCodeMessage.getText();
		
		
		Assert.assertTrue(text.contains("200"));
	
		
			
			
		
	}
	
	@Test
	public void teststatusCode301()
	{
		
        WebElement statusCode301 = driver.findElement(By.xpath("//a[@href='status_codes/301']"));
		
        statusCode301.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']/div/p")));
		WebElement statusCodeMessage = driver.findElement(By.xpath("//div[@id='content']/div/p"));
		String text = statusCodeMessage.getText();
		
		Assert.assertTrue(text.contains("301"));
		
		 
				
		
	}
	
	@Test
	public void teststatusCode404()
	{
				
		WebElement statusCode404 = driver.findElement(By.xpath("//a[@href='status_codes/404']"));
		
		statusCode404.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']/div/p")));
		WebElement statusCodeMessage = driver.findElement(By.xpath("//div[@id='content']/div/p"));
		String text = statusCodeMessage.getText();
		
		Assert.assertTrue(text.contains("404"));
				
		
	}
	
	@Test
	public void teststatusCode500()
	{
		
		WebElement statusCode500 = driver.findElement(By.xpath("//a[@href='status_codes/500']"));
		
		statusCode500.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='content']/div/p")));
		WebElement statusCodeMessage = driver.findElement(By.xpath("//div[@id='content']/div/p"));
		String text = statusCodeMessage.getText();
		
		Assert.assertTrue(text.contains("500"));
		
			
		
		
	}
	

}
