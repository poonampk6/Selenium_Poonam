package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLogin 
{
	
	public DwsLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginLink() {
		loginLink.click();
	}

	public void Username(String user) 
	{
		username.sendKeys(user);
	}

	public void Password(String pass) 
	{
		password.sendKeys(pass);
	}

	public void LoginBtn() {
		loginBtn.click();
	}

	private @FindBy(className="ico-login")
	WebElement loginLink;
	
	private @FindBy(id="Email")
	WebElement username;
	
	private @FindBy(id="Password")
	WebElement password;
	
	private @FindBy(xpath="//input[@value='Log in']")
	WebElement loginBtn;
	
}
