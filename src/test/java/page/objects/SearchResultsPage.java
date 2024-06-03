package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(css = "[type=\"tvSeries\"] [data-qa=\"data-row\"]:nth-child(1) [data-qa=\"info-name\"]")
    public WebElement tvSeriesFirstLinkResult;

    @FindBy(css = "[type=\"celebrity\"] [data-qa=\"data-row\"]:nth-child(1) [data-qa=\"info-name\"]")
    public WebElement celebrityFirstLinkResult;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectTvSeriesFirstLinkResult() {
        tvSeriesFirstLinkResult.click();
    }

    public void selectCelebrityFirstLinkResult() {
        celebrityFirstLinkResult.click();
    }
}
