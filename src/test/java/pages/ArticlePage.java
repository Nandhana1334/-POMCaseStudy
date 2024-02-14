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
	
	@FindBy(xpath="//h1[contains(text(),'Article1')]")
    WebElement chk;
	
	
	
	public ArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void publishArticle()
	{
		newArticle.click();
		
		title.sendKeys("Article1");
		desc.sendKeys("This is a sample article");
		textArea.sendKeys("This is a sample article");
		tags.sendKeys("");
		btn.click();
		
		Assert.assertEquals(chk.getText(),"Article1");
		}
	
	
}
