package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'buy + sell')]")
    WebElement buySellTab;
    public void mouseHoverOnBuySellTab() {
        log.info("Hover mouse over Buy + Sell Tab" + buySellTab.toString());
        mouseHoverToElement(buySellTab);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Search Cars')]")
    WebElement searchCarsLink;
    public void clickOnSearchCarsLink() {
        log.info("Click on the 'Search Cars' link " + searchCarsLink.toString());
        clickOnElement(searchCarsLink);
    }

    @CacheLookup
    @FindBy(xpath = "//header/div[@id='u_H']/div[1]/div[1]" +
            "/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement usedLink;
    public void clickOnUsedLink() {
        log.info("Click on the 'Used' link " + usedLink.toString());
        clickOnElement(usedLink);
    }

}
