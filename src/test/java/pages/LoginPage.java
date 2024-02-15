package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	@FindBy(css =".nav.navbar-nav.pull-xs-right li:nth-child(2) a")
	WebElement loginButton;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath ="//button[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//img[@alt='Nandhana']")
	WebElement chckName;
	
	
//	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean loginName()
	{
		boolean s= chckName.isDisplayed();
		
		return s;
	}
	public void clickLogin(String str1,String str2)
	{
		loginButton.click();
		email.sendKeys(str1);
		password.sendKeys(str2);
		login.click();
//		boolean check = chck.isDisplayed();
//		Assert.assertTrue(check);  "nandhana@gmail.com"  "nandh"
		
		
		
	}
	

}
