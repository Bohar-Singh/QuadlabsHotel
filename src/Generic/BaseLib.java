package Generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.QaRobot;

public class BaseLib {
	
	
	
	public static void selectEmployee(String EmpName) throws Exception
	{
		
			QaRobot.getWebElement("SelectEmployeeRadio").click();
			QaRobot.PassValue("SearchEmp", EmpName, "Entered Emp Name");
			QaRobot.getWebElement("SearchBtn").click();
			Thread.sleep(2000);
			QaRobot.getWebElement("PickEmpFrmSearchRadio").click();
			
			
	}
	
	 public static void selectCalendarDates(WebDriver driver, String value,String domValue)
	 	{
	     	((JavascriptExecutor)driver).executeScript ("document.getElementById('"+domValue+"').value='"+value+"';"); 
			
	 	}
	
	public static void selectTravelType(String CorpUserOptions, String EmpName, String TripType) throws Exception
	{
		if(CorpUserOptions.equalsIgnoreCase("Select Employee"))
		{
			selectEmployee(EmpName);
			
			if(TripType.equalsIgnoreCase("Business Trip"))
			{
				QaRobot.ClickOnElement("BusinessTrip", "Selected Business Trip Radio Button");
			}
			else if(TripType.equalsIgnoreCase("Book For Family"))
			{
				QaRobot.ClickOnElement("BookForFamily", "Selected Book For Family Trip Radio Button");
			}
			else if(TripType.equalsIgnoreCase("Personal"))
			{
				QaRobot.ClickOnElement("PersonalTrip", "Selected Personal Trip Radio Button");
			}
			else
			{
				System.out.println("Other Options are not available yet");
			}
		}
		else if(CorpUserOptions.equalsIgnoreCase("Guest User"))
		{
			QaRobot.ClickOnElement("GuestUser", "Selected Guest User Option Radio Button");
		}
		else if(CorpUserOptions.equalsIgnoreCase("Multiple Passengers"))
		{
			QaRobot.ClickOnElement("MultiPax", "Selected Multiple Passengers Trip Radio Button");
		}
		else
		{
			System.out.println("Please Select Valid Options !");
		}
	}
	

	// ** This method is used to select No of rooms, adults, child & child age // **
	
	public static void selectValues(String CorpUserOptions, String TripType, String roomValue, String adultValue, String childValue, String chdAgeValue) throws Exception
	{
		
		if(CorpUserOptions.equalsIgnoreCase("Select Employee"))
		{
			if(TripType.equalsIgnoreCase("Business Trip"))
			{
				String Rooms="//select[@id='ddlRoom']";
				String Adults="//select[@id='ddlHHLAdultR1']";
				QaRobot.selectTextFromDropdown(Rooms, roomValue, "Selected Room");
				QaRobot.selectTextFromDropdown(Adults, adultValue, "Selected Adult");
			}
			else
			{
				System.out.println("Selecting Rooms and Pax Function is not ready yet");
			}
			}
			
		
	else if(TripType.equalsIgnoreCase("Book ForFamily"))
		{
			String	roomx="//*[@id='HtlRooms']";
			QaRobot.selectTextFromDropdown(roomx, roomValue, "Selected Rooms");
			int	room = Integer.parseInt(roomValue);
			String[] childvalues= childValue.split(",");
			String[] chdAgeValues= chdAgeValue.split(",");
			
			
		for(int i=0;i<room;i++)
		 {
				String[] adultvalues= adultValue.split(",");
				String adultx= "//*[@id='htlsltadult"+(i+1) +"']";
				QaRobot.selectTextFromDropdown(adultx, adultvalues[i],"Selected Adults");
				
				String childx= "//*[@id='HtlChildSlt"+(i+1)+"']";
				QaRobot.selectTextFromDropdown(childx, childvalues[i], "Selected Childs");
				
		 }
		int size=childvalues.length;
		 int [] arr = new int [size];
		 System.out.println("size+++++"+size);
		for(int j = 0; j<size;j++ )
		{
			
			   arr[j] = Integer.parseInt(childvalues[j]);
	    }

		for(int j = 0; j<arr.length; j++)
		{
			   for(int k=0;k < arr[j]; k++)
			   {
				   if(j==0){
					   String childagex= "//*[@id='htl" +(j+1) +"child" +(k+1) +"age']";
					   QaRobot.selectTextFromDropdown(childagex, chdAgeValues[k], "Selected Child Age");
				   }
				   else if(j==1) {
					   String childagex= "//*[@id='htl" +(j+1) +"child" +(k+1) +"age']";
					   
					   QaRobot.selectTextFromDropdown(childagex, chdAgeValues[k+arr[size-(size-(j-1))]],"Selected Child Age");  
					   
				   }
				   else if(j==2) {
					   String childagex= "//*[@id='htl" +(j+1) +"child" +(k+1) +"age']";
					   
					   QaRobot.selectTextFromDropdown(childagex, chdAgeValues[k+arr[size-(size-(j-1))]+arr[(size-(size-(j-2)))]],"Selected");  
					   
				   }
				   else if(j==3) {
					   String childagex= "//*[@id='htl" +(j+1) +"child" +(k+1) +"age']";
					   
					   QaRobot.selectTextFromDropdown(childagex, chdAgeValues[k+arr[size-(size-(j-1))]+arr[(size-(size-(j-2)))]+arr[(size-(size-(j-3)))]],"Selected");  
					   
				   }
				   else if(j==4) {
					   String childagex= "//*[@id='htl" +(j+1) +"child" +(k+1) +"age']";
					   
					   QaRobot.selectTextFromDropdown(childagex, chdAgeValues[k+arr[size-(size-(j-1))]+arr[(size-(size-(j-2)))]+arr[(size-(size-(j-3)))]+arr[(size-(size-(j-4)))]],"Selected");  
					   
				   }
				
			   }
			   
		}
		

		}
		
	else
	{
		System.out.println("Invalid Selection");
	}
				
	}

	


	

	
	
	
	
	/*
	 * public static void selectCalendarDates(WebDriver driver, String value,
	 * WebElement calLocator, String domValue) {
	 * ((JavascriptExecutor)driver).executeScript
	 * ("document.getElementById('"+domValue+"').removeAttribute('readonly',0);");
	 * calLocator.clear(); calLocator.sendKeys(value); }
	 */
	 
	/*
	 * public static void setDateUsingJavaScriptInCalendar(WebDriver driver) {
	 * JavascriptExecutor jsExecutor =(JavascriptExecutor) driver;
	 * 
	 * jsExecutor.executeScript("$(\"input[id=txtCheckIn]\").value('02-Aug-2020')");
	 * }
	 */
}
