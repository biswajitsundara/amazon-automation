package com.framework.pages;

import org.openqa.selenium.By;

import com.framework.base.BaseClass;
import com.framework.base.DriverFactory;

public class MobilePage extends BaseClass{

	public MobilePage(DriverFactory driverfactory) {
		super(driverfactory);
	}
	
	private By mobileAccessories = By.xpath("//div[@id='nav-subnav']/a[@aria-label='Mobiles & Accessories']");
	private By samsungMobile = By.xpath("//h3[text()='Mobile brands']//following-sibling::ul/li/a[contains(text(),'Samsung')]");
	private By samsungStore = By.xpath("//div[contains(@class,'search-result-card')]/descendant::span[contains(text(),'Samsung Store')]");
	
	
	public void clickSamsungMobile(){
		//clickElement(mobileAccessories);
		clickSubMenu(mobileAccessories,samsungMobile);
	}
	
	public String getMobileStoreText() {
		return getElementText(samsungStore);
	}
}
