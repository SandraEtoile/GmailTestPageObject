package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GmailTest {


	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}



	@DataProvider
	private Object[][] pageObjects() {
		return new Object[][]{
			{new GmailHome(), new GmailMain()}
		};
	}
	@DataProvider
	private Object[][] pageObjectsNew() {
		return new Object[][]{
			{new GmailMain()}
		};
	}

	@Test(dataProvider = "pageObjects")
	public void testSearch(final LoginPage loginPage, final MainPage mainPage) {
		loginPage.init(driver);
		mainPage.init(driver);
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=ru#identifier");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage.login("sandraetoile96@gmail.com", "Cyxarik28");
		Assert.assertEquals(mainPage.checkLogin(), "Aleksandra");
	}

	@Test(dataProvider = "pageObjectsNew")
	public void sendEmail(final MainPage mainPage){
		//newEmail.init(driver);
		mainPage.init(driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		mainPage.clickNewEmail();

		//Assert.assertEquals(newemail.checkNewEmail(),"Новое сообщение");
	}

}
