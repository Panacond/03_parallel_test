package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage{

    @FindBy(css = "input[class^='search']")
    private WebElement searchInput;

    public StartPage(WebDriver driver){super(driver);}

    public void searchByKeyword(final String keyWord){
        searchInput.sendKeys(keyWord + Keys.ENTER);
    }
}
