package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsedCarForSale extends Utility {

    private static final Logger log = LogManager.getLogger(UsedCarForSale.class.getName());

    public UsedCarForSale() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Used Cars For Sale')]")
    WebElement usedCarsForSaleTitleText;

    public String getTitleTextOfUsedCarsForSalePage() {
        log.info("get title text of used cars for sale page " + usedCarsForSaleTitleText.getText());
        return usedCarsForSaleTitleText.getText();
    }
}


