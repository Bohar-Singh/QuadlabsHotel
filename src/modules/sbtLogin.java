package modules;

import org.testng.annotations.Test;

import utilities.QaEnvironment;
import utilities.QaRobot;

public class sbtLogin {

	@Test
	public static void Login() throws Exception {

		QaRobot.PassValue("sbt_Login", QaEnvironment.getProperty("username"), "Entered corporate username");
		QaRobot.PassValue("sbt_Pasword", QaEnvironment.getProperty("password"), "Entered corporate password ");
		QaRobot.ClickOnElement("sbt_submit", "Clicked on submit button");
	}
}
