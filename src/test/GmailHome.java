package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHome implements LoginPage {

	@FindBy(id = "Email")
	WebElement emailLocator;

	@FindBy(id = "next")
	WebElement nextButton;

	@FindBy(id = "Passwd")
	WebElement passLocator;

	@FindBy(id = "signIn")
	WebElement signInLocator;

	@Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	@Override
	public void login(String email, String password) {
		emailLocator.sendKeys(email);
		nextButton.click();
		passLocator.sendKeys(password);
		signInLocator.click();
		
	}
	

}
