package stepdefenition;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import POJO.SearchHotel;
import POJO.login_page;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utility.Utility;

public class Stepdef extends Utility {

	public static login_page login_page = new login_page();
	public static SearchHotel search_hotel = new SearchHotel();
	Properties prop;
	
	
	
	
	@After
	public void screenshot(Scenario scenario) throws Throwable {
		
		driver.quit();
	}

	@Given("login into {string}")
	public void login_into(String string) throws Throwable {

		launchBrowser(string);
		takeScreenshot();

	}

	@When("Enter the credentials {string} and {string}")
	public void enter_the_credentials_and(String username, String password)throws Throwable {

		login_page = new login_page();

		send_keys(login_page.getUsername(), username);
		send_keys(login_page.getPassword(), password);
		click_element(login_page.getLogin());
		takeScreenshot();
	}

	@Given("In search hotel Enter the deatils {string} and {string} and {string} and {string} and {string} and {string} and {string} {string}")
	public void in_search_hotel_enter_the_deatils_and_and_and_and_and_and(String location, String hotels,
			String Room_Type, String Number_of_rooms, String Check_In_Date, String Check_out_date,
			String Adults_per_room, String Children_per_room) throws Throwable {

		search_hotel = new SearchHotel();

		select_by_visible_text_in_dropDwon(search_hotel.getLocation(), read_property_file(location));
		select_by_visible_text_in_dropDwon(search_hotel.getHotels(), read_property_file(hotels));
		select_by_visible_text_in_dropDwon(search_hotel.getRoom_type(), read_property_file(Room_Type));
		select_by_visible_text_in_dropDwon(search_hotel.getNummber_of_rooms(), read_property_file(Number_of_rooms));
		send_keys(search_hotel.getCheck_in_date(), read_property_file(Check_In_Date));
		send_keys(search_hotel.getCheck_out_date(), read_property_file(Check_out_date));
		select_by_visible_text_in_dropDwon(search_hotel.getAdult_per_room(), read_property_file(Adults_per_room));
		select_by_visible_text_in_dropDwon(search_hotel.getChild_per_room(), read_property_file(Children_per_room));

		click_element(search_hotel.getSubmit());
		takeScreenshot();
	}
	
	@When("Take a screenshot of landing page")
	public void take_a_screenshot_of_landing_page() throws Throwable{
		takeScreenshot();
		
		Thread.sleep(5000);
		
		List<WebElement> Tbody = driver.findElements(By.xpath("//form[@id='select_form']//tr//tr[2]//td"));
		for (WebElement Tdata : Tbody) {
			
			List<WebElement> data = Tdata.findElements(By.tagName("td"));
			
			for (WebElement td : data) {
				System.out.println(td.getText());
				
			}
			
		}
		
		
		
	}
	

}
