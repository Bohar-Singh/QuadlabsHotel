package product.Flight;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import utilities.QaDataProvider;

public class owFlightSearch {

	@DataProvider
	public Object[][] getexceldata() throws Exception {

		return QaDataProvider.getTestdata("Flight", "Oneway");
	}

	@BeforeTest
	public static void Before_Test() throws Exception {

		TestBase.Login();
	}

	@Test(dataProvider = "getexceldata")
	public static void flight_Search() {

	}

	@AfterTest
	public static void After_Test() {

	}
}
