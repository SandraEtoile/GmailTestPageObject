package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewEmail implements NewEmailPage{

	@FindBy(xpath = "//div[contains(text(),'Новое сообщение']")
    WebElement newEmailLocator;

	@Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	public String checkNewEmail() {
		return newEmailLocator.getText();
	}

	@Override
	public void writeEmail() {
		
	}

}
