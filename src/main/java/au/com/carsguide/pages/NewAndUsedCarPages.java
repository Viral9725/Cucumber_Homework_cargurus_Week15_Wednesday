package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAndUsedCarPages extends Utility {
    private static final Logger log = LogManager.getLogger(NewAndUsedCarPages.class.getName());

    public NewAndUsedCarPages() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'New & Used Car Search - carsguide')]")
    WebElement newAndUsedCars;

    public String getTextNewAndUsedCarsSearch() {
        log.info("Get Text New And Used Cars Search" + newAndUsedCars.toString());
        return getTextFromElement(newAndUsedCars);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='makes']")
    WebElement selectMake;

    public void setSelectMake(String make) {
        log.info("select make ' " + make + " ' " + "<br>");
        selectByVisibleTextFromDropDown(selectMake, make);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='models']")
    WebElement selectModel;

    public void setSelectModel(String model) {
        log.info(" select model ' " + model + " ' " + "<br>");
        selectByVisibleTextFromDropDown(selectModel, model);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='locations']")
    WebElement selectLocation;

    public void setSelectLocation(String location) {
        log.info("select location ' " + location + " ' " + "<br>");
        selectByVisibleTextFromDropDown(selectLocation, location);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='priceTo']")
    WebElement selectPrice;

    public void setSelectPrice(String price) {
        log.info("select price ' " + price + " ' " + "<br>");
        selectByVisibleTextFromDropDown(selectPrice, price);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='search-submit']")
    WebElement findMyNextCarTab;

    public void clickOnFindMyNextCarTab() {
        log.info(" clicking on find my next car tab " + findMyNextCarTab.getText());
        clickOnElement(findMyNextCarTab);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[@class='listing-search-title']")
    WebElement searchTitleText;

    public String getSearchTextFromProduct() {
        waitUntilVisibilityOfElementLocated(By.xpath("//h1[@class='listing-search-title']"), 20);
        log.info(" get search text from product " + searchTitleText.getText());
        return searchTitleText.getText();
    }
}
