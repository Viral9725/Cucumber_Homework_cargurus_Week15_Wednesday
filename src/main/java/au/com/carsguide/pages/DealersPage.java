package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DealersPage extends Utility {
    private static final Logger log = LogManager.getLogger(DealersPage.class.getName());

    public DealersPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Find a Dealer')]")
    WebElement dealer;
    public void clickOnFindADealer(){
        clickOnElement(dealer);

    }
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Find a Car Dealership Near You')]")
    WebElement dealers;
    public String getTextFindACarDealershipNearYou(){
        return getTextFromElement(dealers);

    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='dealerListing--name']//a")
    List<WebElement> dealerNames;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement nextButton;

    public boolean isDealerDisplayed(String dealer) {
        boolean myBreak = true;
        boolean isDisplayed = false;
        while (myBreak) {
            for (WebElement e : dealerNames) {
                if (e.getText().equalsIgnoreCase(dealer)) {
                    System.out.println(e.getText());
                    isDisplayed = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page363")) {
                    nextButton.click();
                } else {
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
            }
        }
        driver.navigate().to("https://www.carsguide.com.au/car-dealers");
        return isDisplayed;
    }
}
