package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

	WebDriver driver;


	//Constructor

	public OrderPage(WebDriver driver){

		this.driver=driver;
	}


	//Elements
	private By proceed_checkout_summary_btn=By.xpath("//*[@id='center_column']/p[2]/a[1]/span");
	private By proceed_checkout_address_btn=By.name("processAddress");
	private By agreement_checkbox=By.id("cgv");
	private By proceed_checkout_shipping_btn=By.name("processCarrier");
	private By bank_Wire_option=By.className("bankwire");
	private By confirm_order_btn=By.xpath("//*[@id='cart_navigation']/button/span");
	private By order_confirmation_label=By.className("cheque-indent");
	private By back_to_orders_history_link=By.xpath("//*[@id='center_column']/p/a");

	
	//Methods

	public void productCheckoutToPlaceOrder(){

		proceedToSummaryCheckout();
		proceedToAddressCheckout();
		acceptAgreementTerms();
		proceedToShippingCheckout();
		selectPaymentMethod();
		confirmOrder();
	}



	public void proceedToSummaryCheckout(){

		driver.findElement(proceed_checkout_summary_btn).click();
	}


	public void proceedToAddressCheckout(){

		driver.findElement(proceed_checkout_address_btn).click();
	}


	public void acceptAgreementTerms(){

		driver.findElement(agreement_checkbox).click();	
	}


	public void proceedToShippingCheckout(){

		driver.findElement(proceed_checkout_shipping_btn).click();
	}

	public void selectPaymentMethod(){

		driver.findElement(bank_Wire_option).click();
	}


	public void confirmOrder(){

		driver.findElement(confirm_order_btn).click();
	}


	public String getOrderConfirmationText(){
		
		String confirmationText=driver.findElement(order_confirmation_label).getText();
		return confirmationText;
	}

	
	public void openOrderHistoryPage(){
		
		driver.findElement(back_to_orders_history_link).click();	
	}
}
