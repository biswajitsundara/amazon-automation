package com.application.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.base.DriverFactory;
import com.framework.pages.HomePage;
import com.framework.pages.MobilePage;

public class MobileTest {

	DriverFactory driverfactory;
	HomePage homepage;
	MobilePage mobilepage;

	@Before
	public void setupTest() {
		driverfactory = new DriverFactory();
		homepage = new HomePage(driverfactory);
		homepage.launchApplication();
	}

	@Test
	public void checkSamsungMobiles() {
		homepage.clickMobiles();
		mobilepage = new MobilePage(driverfactory);
		mobilepage.clickSamsungMobile();

		String storeName = mobilepage.getMobileStoreText();
		assert (storeName).equals("Samsung Store");
	}

	@After
	public void tearDown() {
		homepage.closeApplication();
	}
}
