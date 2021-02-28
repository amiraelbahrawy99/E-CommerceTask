package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BlousesPage {


	WebDriver driver;

	//Constructor

	public BlousesPage(WebDriver driver){

		this.driver=driver;
	}

	//Elements

	private By blouse_img=By.className("product_img_link");
	private By more_btn=By.cssSelector(".button.lnk_view.btn.btn-default");
	private By size_menu=By.id("group_1");
	private By colour_field=By.id("color_8");
	private By add_to_cart_btn=By.name("Submit");
	private By proceed_To_checkout_btn=By.cssSelector("a[title*='Proceed']");



	//Methods
	
	public void AddItemToCart(String size,String colour){
		
		selectMoreDetailsOfProduct();
		selectProductSize(size);
		selectProductColour(colour);
		clickOnAddToCartButton();
		proceedToCheckout();
	}
	
	
	public void selectMoreDetailsOfProduct(){

		Actions action=new Actions(driver);
		WebElement Blouse=driver.findElement(blouse_img);
		action.moveToElement(Blouse).build().perform();
		driver.findElement(more_btn).click();
	}

	
	public void selectProductSize(String size){
		
		WebElement SizeMenu=driver.findElement(size_menu);
		Select sizeMenudropdown=new Select(SizeMenu);
		sizeMenudropdown.selectByVisibleText(size);
	}

	
	
	public void selectProductColour(String colour){
		
		driver.findElement(colour_field).click();
	}
	
	

	public void clickOnAddToCartButton(){
		
		driver.findElement(add_to_cart_btn).click();
	}
	
	
	public void proceedToCheckout(){
		
		driver.findElement(proceed_To_checkout_btn).click();	
	}

}
