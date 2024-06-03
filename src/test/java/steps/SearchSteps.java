package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.CelebrityDetailsPage;
import page.objects.MainPage;
import page.objects.MovieDetailsPage;
import page.objects.SearchResultsPage;

public class SearchSteps {

    DriverFactory driver = new DriverFactory();
    WebDriver driverChrome;
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    MovieDetailsPage movieDetailsPage;
    CelebrityDetailsPage celebrityDetailsPage;

    @Before("@Search")
    public void startingTest() {
        driverChrome = driver.getChromeDriver();
        mainPage = new MainPage(driverChrome);
    }

    @Given("the user searches for {string}")
    public void theUserSearchesFor(String searchValue) {
        mainPage.fillSearchBar(searchValue);
        mainPage.pressEnter();
    }

    @When("the user selects it inside the tv shows area")
    public void theUserSelectsItInsideTheTvShowsArea() {
        searchResultsPage = new SearchResultsPage(driverChrome);
        searchResultsPage.selectTvSeriesFirstLinkResult();
    }

    @Then("tomatoes average should be {string}")
    public void tomatoesAverageShouldBe(String string) {
        movieDetailsPage = new MovieDetailsPage(driverChrome);
        Assert.assertEquals(string, movieDetailsPage.getCriticsScore());
    }

    @When("the user selects the actress name inside the celebrities section")
    public void theUserSelectsTheActressNameInsideTheCelebritiesSection() {
        searchResultsPage = new SearchResultsPage(driverChrome);
        searchResultsPage.selectCelebrityFirstLinkResult();
    }

    @Then("the highest rated movie starred by her should be {string}")
    public void theHighestRatedMovieStarredByHerShouldBe(String string) {
        celebrityDetailsPage = new CelebrityDetailsPage(driverChrome);
        Assert.assertEquals(string, celebrityDetailsPage.getCelebrityBioHighestRated());
    }

    @After("@Search")
    public void finishingTest() {
        driverChrome.close();
    }
}
