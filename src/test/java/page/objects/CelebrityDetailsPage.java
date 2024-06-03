package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CelebrityDetailsPage {

    WebDriver driver;

    @FindBy(css = "[data-qa=\"celebrity-bio-highest-rated\"] .celebrity-bio__link")
    WebElement celebrityBioHighestRated;

    public CelebrityDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCelebrityBioHighestRated() {
        return celebrityBioHighestRated.getText();
    }
}
