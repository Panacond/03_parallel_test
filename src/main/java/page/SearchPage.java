package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(css = "input[class^='sidebar-search']")
    private WebElement searchTitle;

    @FindBy(css = "a.checkbox-filter__link")
    private List<WebElement> listCheckBoxTitle;

//    @FindBy(css = "select[class]")
    @FindBy(css = "select[class^='select']")
    private WebElement selectPopUp;

    @FindBy(css = "option[value='2: expensive']")
    private WebElement selectExpensive;

    @FindBy(css = "div[class^='goods-tile ng-star']")
    private List<WebElement> listGoods;

    @FindBy(css = "button[class^='buy-button']")
    private List<WebElement> listAddBucket;

    @FindBy(css = "button[class^='header__button ng-star-inserted header']")
    private WebElement goToBucket;

    final static Logger logger = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver){super(driver);}

    public String getCorrectCss(String brand){
        return "a[data-id='"+ brand + "']";
    }

    public void searchByTitle(final String keyWord){
        searchTitle.sendKeys(keyWord + Keys.ENTER);
    }

    public void clickCheckBoxMsi(String brand){
        for (WebElement i: listCheckBoxTitle) {
            String attributeText =  i.getAttribute("data-id");
            if (attributeText.equals(brand)) {
                i.click();
                break;
            }
        }
        logger.info("Not search item");
    }

    public WebElement getSelectPopUp() {
        return selectPopUp;
    }

    public void clickPopUp(){
//        waitPresenceOfElement(1000, selectPopUp);
//        waitVisibilityOfElement(50000,selectPopUp);
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
