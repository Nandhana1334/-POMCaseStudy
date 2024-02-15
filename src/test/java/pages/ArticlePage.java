package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlePage {

//	@FindBy(css = ".nav.navbar-nav.pull-xs-right li:nth-child(2) a")
//	WebElement newArticle;
	@FindBy(xpath="//a[text()='New Article']")
	WebElement newArticle;
	
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@name='description']")
	WebElement desc;
	
	@FindBy(xpath = "//textarea[@name='body']")
	WebElement textArea;
	
	@FindBy(xpath = "//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[@type='submit']") 	 
	WebElement btn;
//	
	
	@FindBy(xpath="//h1[contains(text(),'Article4')]")
    WebElement chkHeader;
	
	
	public ArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void publishArticle(String str1,String str2,String str3)
	{
		newArticle.click();
		title.sendKeys(str1);
		desc.sendKeys(str2);
		textArea.sendKeys(str3);
		tags.sendKeys("");
		btn.click();
		//return chk.getText();
		//Assert.assertEquals(chk.getText(),"Article1"); "Article4"  "This is a sample article"   "This is a sample article"
	}
	
	
	
	public String articleName()
	{
		return chkHeader.getText();
	}
	
	
}
