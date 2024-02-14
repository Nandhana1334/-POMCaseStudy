package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdatePage {
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	WebElement edit; 
	
	@FindBy(xpath="//input[@placeholder='Article Title']") 
	WebElement articleTitle; 
	
	@FindBy(xpath="//input[@class='form-control ' and @name='description']") 
	WebElement articleAbout; 
	
	@FindBy(xpath="//textArea[@rows='8']") 
	WebElement textArea;
	
	@FindBy(xpath="//input[@placeholder='Enter tags']") 
	WebElement enterTags; 
	
	@FindBy(xpath="//button[contains(text(),'Update Article')]")
	WebElement updateBtn; 
	
	@FindBy(xpath="(//a[@href='#/'])[2]") 
	WebElement homeBtn;
	
	@FindBy(xpath="//button[@class='nav-link ']")
	WebElement globalfeed;
	
	@FindBy(xpath="//h1[contains(text(),'Article2')]")
    WebElement CheckBtn;
	
	public UpdatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void updateArticle() { 
		edit.click(); 	 	 
		articleTitle.clear(); 	 	
		articleTitle.sendKeys("Article2"); 	 	
		articleAbout.clear(); 	 	
		articleAbout.sendKeys("This is sample article2"); 	 
		updateBtn.click();
		Assert.assertEquals(CheckBtn.getText(),"Article2");
	}
}
