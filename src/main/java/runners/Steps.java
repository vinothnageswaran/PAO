package runners;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {
	WebDriver driver;
	


	@When("^he search for \"(.*?)\"$")
	public void he_search_for(String product)  {
		HomePage home = new HomePage(driver);
		home.perform_Search(product);
	}

	

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fill_PersonalDetails();	
	}
	
	//test321321
	
	@When("^select same delivery address$")
	public void select_same_delivery_address() throws InterruptedException{
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("^select payment method as \"(.*?)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() throws InterruptedException {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		
		driver.quit();
	}	
}