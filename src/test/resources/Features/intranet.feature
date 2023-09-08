Feature: Book the hotel


  @Sanity
  Scenario Outline: Validate the Login functionality
    Given login into "https://adactinhotelapp.com/"
    When Enter the credentials "<username>" and "<password>"
    Given In search hotel Enter the deatils "Location" and "Hotels" and "Room_Type" and "Number_of_rooms" and "Check_In_Date" and "Check_out_date" and "Adults_per_room" "Children_per_room"
    When Take a screenshot of landing page
 

Examples: 
|username      |password      |
|Prabhu1305|Prabhu1305|



