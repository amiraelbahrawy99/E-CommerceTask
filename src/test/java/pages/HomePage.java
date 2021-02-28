package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	//Constructor
	public HomePage(WebDriver driver){

		this.driver=driver;
	}
	
	
	
	//Elements

	private By signin_link=By.className("login");
	

	public void clickOnSignInLink()
	{
		driver.findElement(signin_link).click();
	}


	

}
