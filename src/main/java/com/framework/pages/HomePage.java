package com.framework.pages;

import org.openqa.selenium.By;

import com.framework.base.BaseClass;
import com.framework.base.DriverFactory;

public class HomePage extends BaseClass {
	
	public HomePage(DriverFactory driverfactory) {
		super(driverfactory);
	}
	
	private By mobilesCategory = By.xpath("//a[contains(text(),'Mobiles')]");
	
	public void clickMobiles() {
		clickElement(mobilesCategory);
	}
}
