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
	
	@FindBy(xpath="//ul[@class='error-messages']//li[text()='Wrong email/password combination']")
    WebElement invalidmsg;
	
//	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean nameAfterLogin()
	{
		boolean nameDisplayed= chckName.isDisplayed();
		
		return nameDisplayed;
	}
	public void login(String mailId,String pwd)
	{
		loginButton.click();
		email.clear();
		
		email.sendKeys(mailId);
		password.clear();
		password.sendKeys(pwd);
		login.click();

	}
	
	public String inValidMsg()
		{
			return invalidmsg.getText();
		}
	

}
