package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
	
	WebDriver driver;

	//Constructor

	public OrderHistoryPage(WebDriver driver){

		this.driver=driver;
	}


	//Elements

	private By order_reference_link=By.xpath("//*[@id='order-list']/tbody/tr[1]/td[1]/a");
	private By order_details_label=By.xpath("//*[@id='order-detail-content']/table/tbody/tr/td[2]/label");

	
	//Methods
	
	public void openOrderDetails(){
		
		driver.findElement(order_reference_link).click();
	}
	
	
	public String getOrderDetails(){
		
	String orderDetails=driver.findElement(order_details_label).getText();
	return orderDetails;

		
	}
	

}
