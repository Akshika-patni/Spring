package com.cg.bean;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ConferenceRoomPageBean {
	@FindBy(how=How.ID,id="txtFirstName")
	private WebElement fName;
	
	@FindBy(how=How.ID,id="txtLastName")
	private WebElement lName;
	
	@FindBy(how=How.ID,id="txtEmail")
	private WebElement email;

	@FindBy(how=How.ID, id="txtPhone")
	private WebElement contactNo;
	
	@FindBy(how=How.NAME,name="size")
	private WebElement noOfPerson;
	
	@FindBy(how=How.ID,id="txtAddress1")
	private WebElement buildingAndRoomNo;
	
	@FindBy(how=How.ID,id="txtAddress2")
	private WebElement areaName;
	
	@FindBy(how=How.NAME,name="city")
	private WebElement city;
	
	@FindBy(how=How.NAME,name="state")
	private WebElement state;
	
	
	@FindBy(how=How.NAME,name="memberStatus")
	private List<WebElement> memberStatus;
	
	
	@FindBy(how=How.LINK_TEXT,linkText="Next")
	private WebElement nextLink;
	
	@FindBy(how=How.NAME,name="txtFN")
	private WebElement cardHolderName;
	
	@FindBy(how=How.NAME,name="debit")
	private WebElement debitCardNumber;
	
	@FindBy(how=How.NAME,name="cvv")
	private WebElement cvv;
	
	@FindBy(how=How.NAME,name="month")
	private WebElement month;
	
	@FindBy(how=How.NAME,name="year")
	private WebElement year;
	
	@FindBy(how=How.ID,id="btnPayment")
	private WebElement payment;
	
	public String getFirstName() {
		return fName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.fName.sendKeys(firstName);
	}
	public String getLastName() {
		return lName.getAttribute("value");
	}

	public void setLastName(String lastName) {
		this.lName.sendKeys(lastName);
	}
	
	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void paymentLink()
	{
		payment.click();
	}
	
	public void nextPageLink() {
		nextLink.click();
	}
	
	public String  getMemberStatus() {
		for (WebElement webElement : memberStatus) {
			if(webElement.isSelected()) {
				return webElement.getAttribute("value");}
		}return null;
	}

	public void setMemberStatus(String memberStatus) {
		if(memberStatus.equals("member"))
			this.memberStatus.get(0).click();
		else if(memberStatus.equals("non-member"))
			this.memberStatus.get(1).click();
	}

	public String getState() {
		return new Select(this.state).getFirstSelectedOption().getText();
	}

	public void setState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	public String getCity() {
		return new Select(this.city).getFirstSelectedOption().getText();
	}

	public void setCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

	public String getAreaName() {
		return areaName.getAttribute("value");
	}

	public void setAreaName(String areaName) {
		this.areaName.sendKeys(areaName);
	}

	public String getBuildingAndRoomNo() {
		return this.buildingAndRoomNo.getAttribute("value");
	}

	public void setBuildingAndRoomNo(String buildingAndRoomNo) {
		this.buildingAndRoomNo.sendKeys(buildingAndRoomNo);
	}

	public int getNoOfPerson() {
		return Integer.parseInt(new Select(noOfPerson).getFirstSelectedOption().getText());
	}

	public void setNoOfPerson(String noOfPerson) {
		 new Select(this.noOfPerson).selectByVisibleText(noOfPerson);
	}

	public String getContactNo() {
		return contactNo.getAttribute("value");
	}

	public void setContactNo(String contactNo) {
		this.contactNo.clear(); 
		this.contactNo.sendKeys(contactNo);
	}

	
	public String getCardHolderName() {
		return cardHolderName.getAttribute("value");
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName.sendKeys(cardHolderName);
	}

	public String getDebitCardNumber() {
		return debitCardNumber.getAttribute("value");
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber.sendKeys(debitCardNumber);
	}

	public String getCvv() {
		return cvv.getAttribute("value");
	}

	public void setCvv(String cvv) {
		this.cvv.sendKeys(cvv);;
	}

	public String getMonth() {
		return month.getAttribute("value");
	}

	public void setMonth(String month) {
		this.month.sendKeys(month);
	}

	public String getYear() {
		return year.getAttribute("value");
	}

	public void setYear(String year) {
		this.year.sendKeys(year);
	}

}
