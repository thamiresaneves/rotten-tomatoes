package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoviesAtHomePage {

    WebDriver driver;

    @FindBy(css = "where-to-watch-bubble:nth-child(3)")
    public WebElement netflixBubble;

    @FindBy(css = ".flex-container:nth-child(1) .p--small")
    public WebElement firstMovieListed;

    @FindBy(css = "[data-qa=\"discovery-filter-genres\"]")
    public WebElement genresListFilter;

    @FindBy(css = "[data-qa=\"option-animation\"]")
    public WebElement optionAnimation;

    @FindBy(css = "[data-qa=\"apply-btn\"]")
    public WebElement applyFilterButton;

    @FindBy(css = "[data-qa=\"discovery-media-list-item\"]")
    public List<WebElement> mediaListItem;

    public MoviesAtHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> element.isDisplayed());
    }

    public void selectNetflixBubble() {
        this.waitForElementToAppear(netflixBubble);
        netflixBubble.click();
    }

    public void selectFirstMovieListed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        firstMovieListed.click();
    }

    public void selectGenresListFilter() {
        genresListFilter.click();
    }

    public void filterByAnimation() {
        optionAnimation.click();
        applyFilterButton.click();
    }

    public void filterByGenre(String genre) {
        optionAnimation.click();
        driver.findElement(By.cssSelector(String.format("[data-qa=\"option-%s\"]", genre))).click();
    }

    public int getMoviesListSize() {
        return mediaListItem.size();
    }

    public String getMovieName(int index) {
        return mediaListItem.get(index).findElement(By.cssSelector("[data-qa=\"discovery-media-list-item-title\"]")).getText();
    }

    public boolean isMovieListed(String movieName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        boolean isMovieListed = false;
        for(int i = 0; i < getMoviesListSize(); i++) {
            if(getMovieName(i).equals(movieName)) {
                isMovieListed = true;
                break;
            }
        }
        return isMovieListed;
    }
}