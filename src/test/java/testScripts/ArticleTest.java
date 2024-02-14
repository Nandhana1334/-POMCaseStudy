package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ArticlePage;
import pages.DeleteArticlePage;
import pages.LoginPage;
import pages.UpdatePage;

public class ArticleTest {
	
	
	
	WebDriver driver;
	LoginPage loginPage;
	ArticlePage articlePage;
	UpdatePage updatePage;
	DeleteArticlePage deleteArticlePage;
	public ArticleTest()
	{
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		articlePage = new ArticlePage(driver);
		updatePage = new UpdatePage(driver);
		deleteArticlePage = new DeleteArticlePage(driver);
	}
	
	@BeforeTest
	public void setup()
	  {
		  TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	  }
	@Test(priority = 1)
	public void loginTest()
	{
		
		 loginPage.clickLogin();
		 
	}
	@Test(priority = 2)
	public void newArticleTest()
	{
		articlePage.publishArticle();
		
		
	}
	@Test(priority = 3)
	public void updateArticleTest()
	{
		updatePage.updateArticle();
		
	}
	@Test(priority = 4)
	public void deleteArticleTest()
	{
		deleteArticlePage.deleteArticle();
		
		
	}
	
	
	
	
  
}
