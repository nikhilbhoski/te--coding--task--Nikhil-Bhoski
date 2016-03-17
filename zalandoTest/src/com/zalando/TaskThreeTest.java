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

public class TaskThreeTest {
	
	public static String baseUrl = "http://zalando-edinc.rhcloud.com/shifting_content/menu";
	private static String aboutPage = "About Page";
	private static String contactUsPage = "Contact Us Page";
	private static String portfolioPage = "Portfolio Page";
	
	
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@Before
	public  final void setup()
	{
		
		//load URL before every test case and wait till page is completely loaded.
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Home")));
		
		
		
	}
	
	@After
	public void teardown(){
		
		
		//close Webdriver after every test cases 
		driver.close();
	}
	
	@Test
	public void testHomePageMenuNavigation()
	{
		WebElement homeMenu = driver.findElement(By.linkText("Home"));
		homeMenu.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Task 1")));
		WebElement homepageTask1link = driver.findElement(By.linkText("Task 1"));
		
		Assert.assertTrue(homepageTask1link.isDisplayed());
				
		
	}
	
	@Test
	public void testAboutPageMenuNavigation()
	{
		
		WebElement homeMenu = driver.findElement(By.linkText("About"));
		homeMenu.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='example']")));
		WebElement aboutPageheader = driver.findElement(By.xpath("//div[@class='example']"));
		
		Assert.assertTrue(aboutPageheader.getText().contains(aboutPage));
        
		
				
		
	}
	
	@Test
	public void testContactUsPageMenuNavigation()
	{
		
		
		WebElement contactUsmenu = driver.findElement(By.linkText("Contact Us"));
		contactUsmenu.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='example']")));
		WebElement contactusPageheader = driver.findElement(By.xpath("//div[@class='example']"));
		
		Assert.assertTrue(contactusPageheader.getText().contains(contactUsPage));
		
		
		
	}
	
	@Test
	public void testPortFolioPageMenuNavigation()
	{
		
		WebElement portfoliomenu = driver.findElement(By.linkText("Portfolio"));
		portfoliomenu.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='example']")));
		WebElement portfolioPageheader = driver.findElement(By.xpath("//div[@class='example']"));
		
		Assert.assertTrue(portfolioPageheader.getText().contains(portfolioPage));
		
		
		
	}
	

}
