package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(css = "input[class^='sidebar-search']")
    private WebElement searchTitle;

    @FindBy(css = "a[data-id='MSI']")
    private WebElement checkBoxTitle;

    @FindBy(css = "select[class]")
    private WebElement selectPopUp;

    @FindBy(css = "option[value='2: expensive']")
    private WebElement selectExpensive;

    @FindBy(css = "div[class^='goods-tile ng-star']")
    private List<WebElement> listGoods;

    @FindBy(css = "button[class^='buy-button']")
    private List<WebElement> listAddBucket;

    @FindBy(css = "button[class^='header__button ng-star-inserted header']")
    private WebElement goToBucket;

    public SearchPage(WebDriver driver){super(driver);}

    public void searchByTitle(final String keyWord){
        searchTitle.sendKeys(keyWord + Keys.ENTER);
    }

    public void clickCheckBoxMsi(){
        checkBoxTitle.click();
    }

    public void clickPopUp(){
        selectPopUp.click();
    }

    public void clickPopUpExpensive(){
        selectExpensive.click();
    }

    public List<WebElement> getListGoods(){
        return listGoods;
    }

    public List<WebElement> getListAddToBucket(){
        return listAddBucket;
    }

    public void clickGoToBucket(){
        goToBucket.click();
    }
}
