package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(css = ".navbar input")
    public WebElement inputSearch;

    @FindBy(css = "div[data-curation='rt-hp-text-list-popular-streaming-movies'] .dynamic-text-list__see-all-link")
    public WebElement viewAllButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillSearchBar(String movie) {
        inputSearch.sendKeys(movie);
    }

    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void selectViewAllButton() {
        viewAllButton.click();
    }
}
