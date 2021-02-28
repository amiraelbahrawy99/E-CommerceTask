package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.BlousesPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.OrderHistoryPage;
import pages.OrderPage;
import pages.RegisterPage;

public class E2ESteps {

	WebDriver driver;
	HomePage homePageObject;
	RegisterPage registerPageObject;
	MyAccountPage myAccountPageObject;
	AuthenticationPage authenticationPageObject;
	BlousesPage blousePageObject;
	OrderPage orderPageObject;
	OrderHistoryPage orderHistoryPageObject;

	@Before
	public void MainSetupForBrowserAndWebsite() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver1.exe");
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Navigate to Website HomePage
		driver.navigate().to("http://automationpractice.com/index.php");

	}

	@Given("user is on Authentication Page")
	public void user_is_on_authentication_page() {

		homePageObject=new HomePage(driver);
		homePageObject.clickOnSignInLink();	
		Assert.assertTrue(driver.getTitle().contains("Login"));
	}



	@When("user fill required registeration data {string},{string} , {string} , {string} ,{string} , {string} ,{string} ,{string} ,{string} ,{string} ,{string}")
	public void user_fill_required_registeration_data(String email,String firstName, String lastName, String password, String address, String city, String state, String postalCode, String country, String mobilePhone, String addressAlias) {

		authenticationPageObject=new AuthenticationPage(driver);
		registerPageObject=new RegisterPage(driver);
		authenticationPageObject.enterEmailToRegister(email);
		authenticationPageObject.clickOnCreateAccountButton();
		registerPageObject.userFillRegistrationData(firstName, lastName, password, address, city, state, postalCode, country, mobilePhone, addressAlias);

	}

	@Then("My account page is displayed succesfully")
	public void my_account_page_is_displayed_succesfully() {

		Assert.assertTrue(driver.getTitle().contains("My account"));
		myAccountPageObject=new MyAccountPage(driver);
		myAccountPageObject.userCanLogout();
	}



	//Login Step
	@When("user login with his registerd credentials {string},{string}")
	public void user_login_with_his_registerd_credentials(String email, String password) {

		myAccountPageObject=new MyAccountPage(driver);
		authenticationPageObject=new AuthenticationPage(driver);

		myAccountPageObject.userCanLogout();
		authenticationPageObject.userCanSignIn(email, password);

	}

	//Cart Checkout Steps

	@When("user select {string} to buy with specific criteria {string} and {string}")
	public void user_select_to_buy_with_specific_criteria_and(String item, String size, String colour) {

		myAccountPageObject=new MyAccountPage(driver);
		blousePageObject=new BlousesPage(driver);

		myAccountPageObject.selectBlouse();
		blousePageObject.AddItemToCart(size, colour);


	}

	@When("user proceed to checkout with specific {string}")
	public void user_proceed_to_checkout_with_specific(String paymentMethod) {

		orderPageObject=new OrderPage(driver);
		orderPageObject.productCheckoutToPlaceOrder();
	}

	@Then("order placed successfully and shown in order history Tab")
	public void order_placed_successfully_and_shown_in_order_history_tab() {

		orderPageObject=new OrderPage(driver);
		orderHistoryPageObject=new OrderHistoryPage(driver);

		Assert.assertEquals(orderPageObject.getOrderConfirmationText(),"Your order on My Store is complete.");		
		orderPageObject.openOrderHistoryPage();
		orderHistoryPageObject.openOrderDetails();
		Assert.assertEquals(orderHistoryPageObject.getOrderDetails(),"Blouse - Color : White, Size : M");		

	}



		@After
		public void teardown() {
			driver.close();
			driver.quit();
		}



}
