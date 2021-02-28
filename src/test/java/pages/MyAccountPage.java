package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage {

	WebDriver driver;

	//Constructor

	public MyAccountPage(WebDriver driver){

		this.driver=driver;
	}


	//Elements
	private By logout_btn=By.className("logout");
	private By Women_category_link=By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");


	//Methods

	public void userCanLogout(){

		driver.findElement(logout_btn).click();
	}


	public void selectBlouse(){

		selectWomenCategory();
		selectBlouseSubCategory();
	}


	public void selectWomenCategory(){

		Actions action=new Actions(driver);		
		WebElement womenLink=driver.findElement(Women_category_link);
		action.moveToElement(womenLink).build().perform();
	}


	public void selectBlouseSubCategory(){

		driver.findElement(By.linkText("Blouses")).click();

	}

}
