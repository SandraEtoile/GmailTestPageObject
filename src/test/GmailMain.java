package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailMain implements MainPage{
	
	@FindBy(xpath = "//span[@class='gb_P gb_R']")
    WebElement usernameLocator;
	
	@FindBy(xpath = "//div[contains(text(),'Õ¿œ»—¿“‹')]")
    WebElement newEmailButton;
 
	
	@Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	@Override
	public String checkLogin(){
		return usernameLocator.getText();
	}
	
	@Override
	public void clickNewEmail() {	
		newEmailButton.click();
	}

}
