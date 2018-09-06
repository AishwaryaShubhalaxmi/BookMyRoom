package com.bookmyroom.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Reusable {
	
	static org.apache.log4j.Logger log = Logger.getLogger(Reusable.class.getName());
	static WebDriver driver;
	
	public Reusable(WebDriver driver)
	{
		Reusable.driver=driver;
	}
	
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	//Open URL
	public void navigateTo(String url)
	{
		System.out.println("Url:"+url);
		driver.get(url);
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Constants.timeInt, TimeUnit.SECONDS);
	}
	
	/*public void explicitWait() {
		WebDriverWait wait= new WebDriverWait(driver,Constants.timeInt);
		
	}*/
	
	public By Locator(String type, String value) {
		By by;
		switch(type) {
		case "id":
			by= By.id(value);
			break;
		case "name":
			by=By.name(value);
			break;
		case "xpath":
			by=By.xpath(value);
			break;
		case "css":
			by=By.cssSelector(value);
			break;
		case "linktext":
			by=By.linkText(value);
			break;
        default:
        	by= null;
        	break;
		}
		return by;
		}
	
	//Enter values in text field
	public void enterText(String type,String value, String text) {
		By locator;
		locator=Locator(type, value);
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
	//Click on a particular element
	public void click(String type,String value) {
		By locator;
		locator=Locator(type,value);
		WebElement element=driver.findElement(locator);
		element.click();
	}
	//Get text
	public String selectAndGetText(String type,String value)
	{
		By locator;
		locator= Locator(type,value);
		WebElement element=driver.findElement(locator);
		return element.getText();
	}
	//Selects and clears the text field
	public void selectAndClear(String type,String value)
	{
		By locator;
		locator= Locator(type,value);
		WebElement element=driver.findElement(locator);
		element.clear();
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyTitle(String message) {
		Assert.assertEquals(driver.getTitle(), message);
	}
	
	//verify
	public void verify(String type,String value,String message)
	{
		Assert.assertEquals(selectAndGetText(type,value), message);
		
	}
	//select from drop down boxes 
	public void selectFromDropDownBox(String type,String value,String text) {
		By locator;
		locator=Locator(type,value);
		Select select= new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
	}
	//Take Screenshot
	public void takeSnapShot(String name) throws IOException{
    TakesScreenshot scrShot =((TakesScreenshot)driver);
    File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
    File destFile=new File("D:\\OxygenWorkspace\\bookmyroom\\output\\"+name+".png");
    FileUtils.copyFile(srcFile, destFile);
    System.out.println("Done!");           
     }
	
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}
	
	
	
		
	
}
		
