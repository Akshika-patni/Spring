package com.cg.stepdef;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.bean.ConferenceRoomPageBean;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConferenceRoomStepDefination {
	private WebDriver driver;
	private ConferenceRoomPageBean bean ;
	
	//to launch the chrome driver
	@Before
	public void driverSetUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Akshika_Drivers\\Drivers\\chromedriver.exe");
	}
	
   // To Open the ConferenceRegistartion.html webpage
	@Given("^User is on Conference room booking page$")
	public void user_is_on_Conference_room_booking_page() throws Throwable {
	
		driver = new ChromeDriver();
		driver.get("file:///D:/AkshikaPatni_BDD/ConferenceRoomRegistration_152609/ConferenceRegistartion.html");
		driver.manage().window().maximize();
		bean= new ConferenceRoomPageBean();
		PageFactory.initElements(driver, bean);
		//to Verify the title of the page
		String act=driver.getTitle();
		String exp="Conference Registartion";
		Assert.assertEquals(exp, act);
		
	}
  
	@When("^User select 'Next' link without entering 'FirstName'$")
	public void user_select_Next_link_without_entering_FirstName() throws Throwable {
		bean.nextPageLink();
		
	}

   // To display the alert box for not entering the first name
	@Then("^'Please fill the First Name' message should display$")
	public void please_fill_the_First_Name_message_should_display() throws Throwable {
		String act=driver.switchTo().alert().getText();
		String exp="Please fill the First Name";
		Assert.assertEquals(exp, act);
	}

	@When("^User select 'Next' link without entering 'LastName'$")
	public void user_select_Next_link_without_entering_LastName() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setFirstName("Akshika");
		bean.nextPageLink();
		
	}
	  // To display the alert box for not entering the last name
	@Then("^'Please fill the Last Name' message should display$")
	public void please_fill_the_Last_Name_message_should_display() throws Throwable {
		String actual=driver.switchTo().alert().getText();
		String expected="Please fill the Last Name";
		Assert.assertEquals(expected, actual);
	}

	@When("^User select 'Next' link without entering 'Email'$")
	public void user_select_Next_link_without_entering_Email() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setLastName("Patni");
		bean.nextPageLink();
	
	}
	  // To display the alert box for not entering the Email
	@Then("^'Please fill the Email' message should display$")
	public void please_fill_the_Email_message_should_display() throws Throwable {
		String actual=driver.switchTo().alert().getText();
		String expected="Please fill the Email";
		Assert.assertEquals(expected, actual);
	}

	@When("^User select 'Next' link after entering invalid 'Email' address$")
	public void user_select_Next_link_after_entering_invalid_Email_address() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setEmail("akshika 0 6 @ gmail");
		bean.nextPageLink();
		
	}
	  // To display the alert box for not entering the valid Email
	@Then("^'Please enter valid Email Id\\.' message should display$")
	public void please_enter_valid_Email_Id_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please enter valid Email Id.";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without entering 'Contact No'$")
	public void user_select_Next_link_without_entering_Contact_No() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setEmail("akshika.patni@gmail.com");
		bean.nextPageLink();
	}
	  // To display the alert box for not entering the Phone Number
	@Then("^'Please fill the Contact No\\.' message should display$")
	public void please_fill_the_Contact_No_message_should_display() throws Throwable {

		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Contact No.";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link after entering invalid 'Contact No'$")
	public void user_select_Next_link_after_entering_invalid_Contact_No() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setContactNo("0190786545432");
		bean.nextPageLink();
	}
	  // To display the alert box for not entering the valid contact Number
	@Then("^'Please enter valid Contact no\\.' message should display$")
	public void please_enter_valid_Contact_no_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please enter valid Contact no.";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without selecting  'Number of people attending'$")
	public void user_select_Next_link_without_selecting_Number_of_people_attending() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setContactNo("9462811242");
		bean.nextPageLink();
	}
	
	
	  // To display the alert box for not entering the Number of people
	@Then("^'Please fill the Number of people attending' message should display$")
	public void please_fill_the_Number_of_people_attending_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Number of people attending";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@When("^User select 'Next' link without entereing  'Building Name & Room No'$")
	public void user_select_Next_link_without_entereing_Building_Name_Room_No() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setNoOfPerson("4");
		bean.nextPageLink();
	}
	  // To display the alert box for not entering the Building and Room Number
	@Then("^'Please fill the Building & Room No' message should display$")
	public void please_fill_the_Building_Room_No_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Building & Room No";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without entereing  'Area Name'$")
	public void user_select_Next_link_without_entereing_Area_Name() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setBuildingAndRoomNo("61-II, Sambhav Height");
		bean.nextPageLink();
	}
	  // To display the alert box for not entering the Area Name
	@Then("^'Please fill the Area name' message should display$")
	public void please_fill_the_Area_name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Area name";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@When("^User select 'Next' link without selecting  'City'$")
	public void user_select_Next_link_without_selecting_City() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setAreaName("Mansrover");
		bean.nextPageLink();
	}
	  // To display the alert box for not selecting the city
	@Then("^'Please select city' message should display$")
	public void please_select_city_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please select city";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link without selecting  'State'$")
	public void user_select_Next_link_without_selecting_State() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setCity("Pune");
		bean.nextPageLink();
	}
	  // To display the alert box for not selecting the state

	@Then("^'Please select state' message should display$")
	public void please_select_state_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please select state";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	
	@When("^User select 'Next' link without selecting  'MemberShip Status'$")
	public void user_select_Next_link_without_selecting_MemberShip_Status() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setState("Maharashtra");
		bean.nextPageLink();
	   
	}
	 // To display the alert box for not selecting the membership status
	@Then("^'Please Select MemeberShip status' message should display$")
	public void please_Select_MemeberShip_status_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please Select MemeberShip status";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Next' link after entering Valid set of information$")
	public void user_select_Next_link_after_entering_Valid_set_of_information() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setMemberStatus("member");
		bean.nextPageLink();
	}
	 // To display the alert box for validating the personal Details
	@Then("^'Personal details are validated\\.' message should display$")
	public void personal_details_are_validated_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Personal details are validated.";
		Thread.sleep(1000);
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Make Payment' link without entering 'Card Holder Name'$")
	public void user_select_Make_Payment_link_without_entering_Card_Holder_Name() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.paymentLink();
	}
	 // To display the alert box for not entering the card holder name
	@Then("^'Please fill the Card Holder Name' message should display$")
	public void please_fill_the_Card_Holder_Name_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Card holder name";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Make Payment' link without entering 'Debit Card Number'$")
	public void user_select_Make_Payment_link_without_entering_Debit_Card_Number() throws Throwable {
		driver.switchTo().alert().dismiss();
	  bean.setCardHolderName("Akshika");
	   bean.paymentLink();
	}
	 // To display the alert box for not  entering the Debit Card Number
	@Then("^'Please fill the Debit Card Number' message should display$")
	public void please_fill_the_Debit_Card_Number_message_should_display() throws Throwable {
		
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the Debit card Number";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@When("^User select 'Make Payment' link without entering 'CVV'$")
	public void user_select_Make_Payment_link_without_entering_CVV() throws Throwable {
		driver.switchTo().alert().dismiss();
		 bean.setDebitCardNumber("013487659");
		bean.paymentLink();
	}
	 // To display the alert box for not  entering the CVV Number
	@Then("^'Please fill the CVV' message should display$")
	public void please_fill_the_CVV_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the CVV";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Make Payment' link without entering 'Card Expiration Month'$")
	public void user_select_Make_Payment_link_without_entering_Card_Expiration_Month() throws Throwable {
		driver.switchTo().alert().dismiss();
		 bean.setCvv("312");
		bean.paymentLink();
	}
	 // To display the alert box for not  entering the expiration month of the card
	@Then("^'Please fill the Expiration Month' message should display$")
	public void please_fill_the_Expiration_Month_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill expiration month";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Make Payment' link without entering 'Card Expiration Year'$")
	public void user_select_Make_Payment_link_without_entering_Card_Expiration_Year() throws Throwable {
		driver.switchTo().alert().dismiss();
	    bean.setMonth("December");
	    bean.paymentLink();
	}
	 // To display the alert box for not  entering the Expiration year  of the card
	@Then("^'Please fill the Expiration Year' message should display$")
	public void please_fill_the_Expiration_Year_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Please fill the expiration year";
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("^User select 'Make Payment' link after entering Valid set of information$")
	public void user_select_Make_Payment_link_after_entering_Valid_set_of_information() throws Throwable {
		driver.switchTo().alert().dismiss();
		bean.setYear("2150");
		bean.paymentLink();
	}
  //To display the successsful alert box
	@Then("^'Conference Room Booking Succesfully Done!!!' message should display$")
	public void conference_Room_Booking_Succesfully_Done_message_should_display() throws Throwable {
		String actualMessage=driver.switchTo().alert().getText();
		String expectedMessage="Conference Room Booking successfully done!!!";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	// for closing the driver
	@After
	public void closeDriver()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	
	
	
	

}
