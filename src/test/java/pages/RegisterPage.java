package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	protected WebDriver driver;

	//Constructor
	public RegisterPage(WebDriver driver){

		this.driver=driver;
	}

	//Elements

	private By Mrs_title_radioBtn=By.id("id_gender2");
	private By firstName_field=By.id("customer_firstname");
	private By lastName_field=By.id("customer_lastname");
	private By password_field=By.id("passwd");
	private By address_field=By.id("address1");
	private By city_field=By.id("city");
	private By state_menu=By.id("id_state");
	private By postalCode_field=By.id("postcode");
	private By country_menu=By.id("id_country");
	private By phone_field=By.id("phone_mobile");
	private By addressAlias_field=By.id("alias");
	private By submit_btn=By.id("submitAccount");


	//Methods

	public void userFillRegistrationData(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String country, String mobilePhone, String addressAlias)
	{
		selectTitle();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPassword(password);
		enterAddress(address);
		enterCity(city);
		selectState(state);
		enterPostalCode(postalCode);
		selectCountry(country);
		enterMobilePhone(mobilePhone);
		enterAliasAddress(addressAlias);
		clickOnRegisterButton();
	}


	
	public void selectTitle(){

		driver.findElement(Mrs_title_radioBtn).click();
	}



	public void enterFirstName(String firstName){

		driver.findElement(firstName_field).sendKeys(firstName);		
	}



	public void enterLastName(String lastName){

		driver.findElement(lastName_field).sendKeys(lastName);
	}



	public void enterPassword(String password){

		driver.findElement(password_field).sendKeys(password);
	}



	public void enterAddress(String address){

		driver.findElement(address_field).sendKeys(address);
	}



	public void enterCity(String city){

		driver.findElement(city_field).sendKeys(city);
	}



	public void selectState(String state){

		WebElement stateMenuDropdown=driver.findElement(state_menu);
		Select stateMenu=new Select(stateMenuDropdown);
		stateMenu.selectByVisibleText(state);
	}



	public void enterPostalCode(String postalCode){

		driver.findElement(postalCode_field).sendKeys(postalCode);
	}



	public void selectCountry(String country){

		WebElement countryMenuDropdown=driver.findElement(country_menu);
		Select countryMenu=new Select(countryMenuDropdown);
		countryMenu.selectByVisibleText(country);
	}



	public void enterMobilePhone(String mobilePhone){

		driver.findElement(phone_field).sendKeys(mobilePhone);
	}



	public void enterAliasAddress(String addressAlias){
		
		driver.findElement(addressAlias_field).clear();
		driver.findElement(addressAlias_field).sendKeys(addressAlias);
	}


	public void clickOnRegisterButton(){

		driver.findElement(submit_btn).click();
	}


















}
