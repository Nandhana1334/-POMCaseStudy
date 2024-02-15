package testScripts;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import commonUtils.*;
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
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
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
	public void setupExtent() {
		extentReports=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/Sparkreport.html")
				   .viewConfigurer()
				   .viewOrder()
				   .as(new ViewName[] {
						 ViewName.DASHBOARD,
						 ViewName.TEST,
						 ViewName.AUTHOR,
						 ViewName.DEVICE,
						 ViewName.LOG
				   }).apply();
	    extentReports.attachReporter(spark);
	}
	@BeforeTest
	public void setup()
	  {
		  TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	  }
	@Test(priority = 1)
	public void loginTest()
	{
		extentTest = extentReports.createTest("Login Test");
		 loginPage.clickLogin("nandhana@gmail.com","nandh");
		 boolean s= loginPage.loginName();
		 
		 Assert.assertTrue(s);
		 
	}
	@Test(priority = 2)
	public void newArticleTest()
	{
		extentTest = extentReports.createTest("Publish Article Test");
		articlePage.publishArticle("Article4","This is a sample article","This is a sample article");
 		Assert.assertEquals(articlePage.articleName(),"Article4"); //"Article4"  "This is a sample article"   "This is a sample article"
		
		
	}
	@Test(priority = 3)
	public void updateArticleTest()
	{
		extentTest = extentReports.createTest("Update Article Test1");
		updatePage.updateArticle("Article2","This is sample article2");
		Assert.assertEquals(updatePage.updatedName(),"Article2");
		
	}
	@Test(priority = 4)
	public void deleteArticleTest()
	{
		extentTest = extentReports.createTest("Delete Article Test");
		
		deleteArticlePage.deleteArticle();
		Assert.assertEquals(deleteArticlePage.deleteCheck(), "Articles not available.");
		
		
	}
	
	@AfterMethod
	  public void teardown(ITestResult result) {
		  extentTest.assignAuthor("Nandhana")
		  .assignCategory("Sample Test")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		  
		  if(ITestResult.FAILURE==result.getStatus()) {
			  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
			  String strPath=Utility.getScreenshotPath(driver);
			   extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		  }
	}
	@AfterTest
	   public void finishExtent() {
		  extentReports.flush();
	  }
	
	
	
	
  
}
