package POJO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utility;

public class SearchHotel extends Utility{
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	WebElement Location;
	
	@FindBy(id="hotels")
	WebElement Hotels;
	
	@FindBy(id="room_type")
	WebElement Room_type;
	
	
	@FindBy(xpath="//select[@id='room_nos' and  @name='room_nos']")
	WebElement Nummber_of_rooms;

	@FindBy(id="datepick_in")
	WebElement Check_in_date;
	
	@FindBy(id="datepick_out")
	WebElement Check_out_date;
	
	
	@FindBy(id="adult_room")
	WebElement Adult_per_room;
	
	@FindBy(id="child_room")
	WebElement child_per_room;
	
	@FindBy(id="Submit")
	WebElement Submit;

	public WebElement getLocation() {
		return Location;
	}

	public WebElement getHotels() {
		return Hotels;
	}

	public WebElement getRoom_type() {
		return Room_type;
	}


	public WebElement getNummber_of_rooms() {
		return Nummber_of_rooms;
	}



	public WebElement getCheck_in_date() {
		return Check_in_date;
	}

	public WebElement getCheck_out_date() {
		return Check_out_date;
	}

	public WebElement getAdult_per_room() {
		return Adult_per_room;
	}

	public WebElement getChild_per_room() {
		return child_per_room;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	
	
	
	
}
