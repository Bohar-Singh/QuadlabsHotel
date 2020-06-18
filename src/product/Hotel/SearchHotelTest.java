package product.Hotel;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Generic.BaseLib;
import utilities.QaExcelRead;
import utilities.QaRobot;

public class SearchHotelTest extends TestBase{
	
	
	public static QaExcelRead reader;
	
	@BeforeTest
	public static void Before_Test() throws Exception {
        System.out.println("@Before");
		TestBase.Login();
	}
	
	
	  @DataProvider 
	  public static Object[][] getExceldata() throws Exception {
	  reader = new QaExcelRead("F:\\Quadlabs Automation\\midOffice\\src\\files\\HotelSearch.xlsx");
	  int row = reader.getrowCount("Sheet1"); 
	  int column =reader.getColumnCount("Sheet1"); 
	  Object[][] data = new Object[row][column]; 
	  for (int i = 0; i < row; i++) {
		  for (int j = 0; j <column; j++) { 
			  data[i][j] = reader.getData("Sheet1", i + 1, j); }
		  }
	  return data;
	  }
	  
	  @Test(dataProvider="getExceldata")
	  public void searchHotelByBusinessTrip(String CorpUserOptions, String EmpName, String TripType, String Destination, String CheckinDate , String CheckOutDate, String roomValue, String adultValue) throws Exception {
	 
	  QaRobot.getWebElement("SelectProduct").click();
	  BaseLib.selectTravelType(CorpUserOptions, EmpName, TripType);
	  QaRobot.getWebElement("Destination").clear();
	  QaRobot.PassValue("Destination", Destination, "Entered Destination city");
	  Thread.sleep(2000);
	  QaRobot.getWebElement("Destination").sendKeys(Keys.ENTER);
	 
	 BaseLib.selectCalendarDates(driver,CheckinDate, "txtCheckIn");
	 BaseLib.selectCalendarDates(driver,CheckOutDate, "txtCheckOut");
	 // BaseLib.selectValues(CorpUserOptions, TripType, roomValue, adultValue, "0", "0");
	 
	 if(QaRobot.getWebElement("IUnderstand").isDisplayed())
	 {
		 QaRobot.getWebElement("IUnderstand").click();
		 QaRobot.getWebElement("SearchHotelBtn").click();
	 }
	 else
	 {
		 QaRobot.getWebElement("SearchHotelBtn").click();
	 }
	 
	
	  
	  
	  }
	 

}
