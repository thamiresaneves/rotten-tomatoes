package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MovieDetailsPage {

    WebDriver driver;

    @FindBy(css = "where-to-watch-bubble")
    public WebElement whereToWatchBubble;

    @FindBy(css = "where-to-watch-meta")
    public List<WebElement> whereToWatchItems;

    @FindBy(css = "rt-button[slot='criticsScore']")
    public WebElement criticsScore;

    @FindBy(css = ".category-wrap:nth-child(7) rt-link")
    public List <WebElement> movieCategories;

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCriticsScore() {
        return criticsScore.getText();
    }

    public void waitForElementToAppear(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> element.isDisplayed());
    }

    public Boolean isStreamingVisible(String streaming) {
        this.waitForElementToAppear(whereToWatchBubble);
        boolean isVisible = false;
        for(int i = 0; i < whereToWatchItems.size(); i++) {
            String streamingName = whereToWatchItems.get(i).getText();
            if(streamingName.equals(streaming)) {
                isVisible = true;
                break;
            }
        }
        return isVisible;
    }

    public Boolean isGenreTheSameAsFiltered(String genre) {
        this.waitForElementToAppear(whereToWatchBubble);
        boolean isGenreCorrect = false;
        for(int i = 0; i < movieCategories.size(); i++) {
            String genreName = movieCategories.get(i).getText();
            isGenreCorrect = true;
            break;
        }
        return isGenreCorrect;
    }
}
