package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.UtilsExcel;

@Listeners(com.tests.ListenerDemoblaze.class)
public class LoginPageTest extends BaseTest {

	Logger log = LogManager.getLogger(LoginPageTest.class);

	@Test(priority = 1)
	@Parameters({ "username", "password" })
	public void validloginTest(String username, String password) {
		objLoginpage.login(username, password);

		String logout = objLoginpage.logout();
		String result = "Log out";

		Assert.assertEquals(result, logout, "log in not success");
		Assert.fail();

		log.info("Log in Success ");
	}

	@Test(dataProvider = "validData", dataProviderClass = UtilsExcel.class, priority = 2)
	public void validLoginExcel(String username, String password) {

		objLoginpage.login(username, password);

		String logout = objLoginpage.logout();
		String result = "Log out";

		Assert.assertEquals(result, logout);
		log.info("Excel Data log in success");

	}

	@Test(dataProvider = "invalidData", dataProviderClass = UtilsExcel.class, priority = 3)
	public void invalidLoginExcel(String username, String password) {

		objLoginpage.login(username, password);
		log.info("Invalid Data log in not success");

	}

}
