
package com.crm.listeners1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register 
{
	public Register(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	private @FindBy(className = "ico-register")
	WebElement Registration_link;
	
	private @FindBy(xpath = "//label[text()='Female']")
	WebElement femaleRadioButton ;
	
	private @FindBy(id  = "FirstName")
	WebElement FirstName;
	
	private @FindBy(id  = "LastName")
	WebElement LastName;
	
	private @FindBy(id  = "Email")
	WebElement Email;
	
	private @FindBy(id  = "register-button")
	WebElement register_button;
	
	private @FindBy(id  = "Password")
	WebElement Password;
	
	private @FindBy(id  = "ConfirmPassword")
	WebElement ConfirmPassword;
	
	public void Registration_link()
	{
		Registration_link.click();
	}
	
	public void femaleRadioButton()
	{
		femaleRadioButton.click();
	}
	
	public void FirstName(String Fname)
	{
		FirstName.sendKeys(Fname);
	}
	
	public void LastName(String Lname)
	{
		LastName.sendKeys(Lname);
	}
	
	public void Email(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void register_button()
	{
		register_button.click();
	}
	
	public void Password(String passs)
	{
		Password.sendKeys(passs);
	}
	
	public void ConfirmPassword(String cpasss)
	{
		ConfirmPassword.sendKeys(cpasss);
	}	
  }

