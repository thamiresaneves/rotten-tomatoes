package steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.objects.MainPage;
import page.objects.MovieDetailsPage;
import page.objects.MoviesAtHomePage;

public class PopularStreamingMoviesSteps {

    DriverFactory driver = new DriverFactory();
    WebDriver driverChrome;
    MainPage mainPage;
    MoviesAtHomePage moviesAtHomePage;
    MovieDetailsPage movieDetailsPage;

    @Before("@PopularStreamingMovies")
    public void startingTest() {
        driverChrome = driver.getChromeDriver();
        mainPage = new MainPage(driverChrome);
    }

    @Given("the user clicks on view all button of popular streaming movies section")
    public void theUserClicksOnViewAllButtonOfPopularStreamingMoviesSection() {
        mainPage.selectViewAllButton();
    }

    @Given("the user clicks on the Netflix bubble button")
    public void theUserClicksOnTheNetflixBubbleButton() {
        moviesAtHomePage = new MoviesAtHomePage(driverChrome);
        moviesAtHomePage.selectNetflixBubble();
    }

    @Given("the user filters by the genre {string}")
    public void filtersByTheGenreAnimation(String genre) {
        moviesAtHomePage = new MoviesAtHomePage(driverChrome);
        moviesAtHomePage.selectGenresListFilter();
        moviesAtHomePage.filterByGenre(genre.toLowerCase());
    }

    @When("selects the first movie listed")
    public void selectsTheFirstMovieListed() {
        moviesAtHomePage.selectFirstMovieListed();
    }

    @Then("{string} bubble button must be displayed as the list of where to watch")
    public void netflixBubbleButtonMustBeDisplayedAsTheListOfWhereToWatch(String streaming) {
        movieDetailsPage = new MovieDetailsPage(driverChrome);
        boolean isVisible = movieDetailsPage.isStreamingVisible(streaming);
        Assert.assertTrue(isVisible);
    }

    @When("filters by the genre animation")
    public void filtersByTheGenreAnimation() {
        moviesAtHomePage.selectGenresListFilter();
        moviesAtHomePage.filterByAnimation();
    }

    @Then("the movie {string} should be displayed")
    public void theMovieShouldBeDisplayed(String string) {
        assert moviesAtHomePage.isMovieListed(string);
    }

    @Then("the {string} must be displayed on the movie info")
    public void the_must_be_displayed_on_the_movie_info(String string) {
        movieDetailsPage = new MovieDetailsPage(driverChrome);
        assert movieDetailsPage.isGenreTheSameAsFiltered(string);
    }

    @After("@PopularStreamingMovies")
    public void finishingTest() {
        driverChrome.close();
    }
}
