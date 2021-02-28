package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

	protected WebDriver driver;

	//Constructor
	public AuthenticationPage(WebDriver driver){
		this.driver=driver;
	}


	//Elements

	private By email_txt= By.id("email_create");
	private By create_account_btn= By.id("SubmitCreate");
	private By email_login_field= By.id("email");
	private By password_field= By.id("passwd");
	private By signin_btn= By.id("SubmitLogin");



	//Methods
	
	public void userCanSignIn(String email,String password){

		enterEmailToLogin(email);
		enterPasswordToLogin(password);
		clickOnSignInButton();
	}
	

	public void enterEmailToRegister(String email){

		driver.findElement(email_txt).sendKeys(email);
	}



	public void clickOnCreateAccountButton(){

		driver.findElement(create_account_btn).click();
	}



	public void enterEmailToLogin(String email){

		driver.findElement(email_login_field).sendKeys(email);
	}



	public void enterPasswordToLogin(String password){

		driver.findElement(password_field).sendKeys(password);
	}



	public void clickOnSignInButton(){

		driver.findElement(signin_btn).click();
	}

}
