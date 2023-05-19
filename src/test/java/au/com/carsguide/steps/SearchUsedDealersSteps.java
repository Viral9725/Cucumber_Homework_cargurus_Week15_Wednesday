package au.com.carsguide.steps;

import au.com.carsguide.pages.DealersPage;
import au.com.carsguide.pages.HomePage;
import au.com.carsguide.pages.NewAndUsedCarPages;
import au.com.carsguide.pages.UsedCarForSale;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchUsedDealersSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @When("^I mouse hover on “buy\\+sell” tab$")
    public void iMouseHoverOnBuySellTab() {
        new HomePage().mouseHoverOnBuySellTab();
    }

    @And("^I click ‘Search Cars’ link$")
    public void iClickSearchCarsLink() {
        new HomePage().clickOnSearchCarsLink();
    }

    @And("^I navigate to new and used car search page \"([^\"]*)\"$")
    public void iNavigateToNewAndUsedCarSearchPage(String newUsedCars) {
        Assert.assertEquals(newUsedCars, new NewAndUsedCarPages().getTextNewAndUsedCarsSearch(), "New and Used Cars not displayed");
    }

    @And("^I select make \"([^\"]*)\"$")
    public void iSelectMake(String make) {
        new NewAndUsedCarPages().setSelectMake(make);
    }

    @And("^I select model \"([^\"]*)\"$")
    public void iSelectModel(String model) {
        new NewAndUsedCarPages().setSelectModel(model);

    }

    @And("^I select location \"([^\"]*)\"$")
    public void iSelectLocation(String location) {
        new NewAndUsedCarPages().setSelectLocation(location);
    }

    @And("^I select price \"([^\"]*)\"$")
    public void iSelectPrice(String price) {
        new NewAndUsedCarPages().setSelectPrice(price);
    }

    @And("^I click on Find My Next Car tab$")
    public void iClickOnFindMyNextCarTab() {
        new NewAndUsedCarPages().clickOnFindMyNextCarTab();
    }

    @Then("^I should see the make \"([^\"]*)\" in results$")
    public void iShouldSeeTheMakeInResults(String make) {
        Assert.assertEquals(make, new NewAndUsedCarPages().getSearchTextFromProduct(), "Car not found");
    }

    @And("^I click ‘Used’ link$")
    public void iClickUsedLink() {
        new HomePage().clickOnUsedLink();
    }

    @Then("^I navigate to ‘Used Cars For Sale’ page$")
    public void iNavigateToUsedCarsForSalePage(String used) {
        Assert.assertEquals(used, new UsedCarForSale().getTitleTextOfUsedCarsForSalePage(), "Not on Used car page");
    }

    @And("^I navigate to 'car-dealers' page$")
    public void iNavigateToCarDealersPage() {
        new DealersPage().clickOnFindADealer();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSee(String page) {
        Assert.assertEquals(page, new DealersPage().getTextFindACarDealershipNearYou(), "On Wrong Page");
    }

    @And("^I should see dealers names in result$")
    public void iShouldSeeDealersNamesInResult(DataTable dataTable) {
        List<String> dealerName = dataTable.asList(String.class);
        SoftAssert softAssertions = new SoftAssert();
        for (int i = 1; i <= dealerName.size() - 1; i++) {
            softAssertions.assertTrue(new DealersPage().isDealerDisplayed(dealerName.get(i)), "'" + dealerName.get(i) + "' dealer not found");
        }
        softAssertions.assertAll();
    }
}





