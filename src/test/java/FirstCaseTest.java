import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.BucketPage;
import page.SearchPage;
import page.StartPage;
import support.PropertiesReader;
import support.TestData;
import support.XmlTestData;

import java.util.List;

import static support.XmlTestData.WriteXml;

@Listeners(ConvertTestListener.class)
public class FirstCaseTest extends BaseTest {

    final static Logger logger = Logger.getLogger(FirstCaseTest.class);
    PropertiesReader properties = new PropertiesReader();
    TestData testData = XmlTestData.ReadXml(properties.getInitialData());

    @Test (description = "run one test from file testData.xml")
    public void checkExpensiveGoods() throws InterruptedException {
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(testData.getProduct());
        SearchPage searchPage = getSearchPage();
        searchPage.waitForPageLoadComplete(5);
        searchPage.clickCheckBoxMsi(testData.getBrand());
        Thread.sleep(1000);
        searchPage.implicitWait(10);
        searchPage.waitForPageLoadComplete(10);
        searchPage.waitVisibilityOfElement(10,getSearchPage().getSelectPopUp());
        searchPage.clickPopUp();
        searchPage.clickPopUpExpensive();
        List<WebElement> listAddToBucket =  searchPage.getListAddToBucket();
        searchPage.implicitWait(10);
        Thread.sleep(1000);
        listAddToBucket.get(0).click();
        searchPage.implicitWait(5);
        searchPage.clickGoToBucket();
        BucketPage bucketPage = getBucketPage();
        Integer price = bucketPage.getStringPrice();
        testData.setRealPrice(price);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(price > testData.getMinPrice(), "Price in page low data price");
        softAssert.assertAll();
        WriteXml(testData, properties.getResultData());
        logger.info("Test work!");
    }

    @Test (description = "input hard coding data")
    public void checkExpensiveGood() throws InterruptedException {
        String[] data = {"Ноутбук", "MSI" };
        int priceAssert = 5000;
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(data[0]);
        SearchPage searchPage = getSearchPage();
        searchPage.waitForPageLoadComplete(5);
        searchPage.clickCheckBoxMsi(data[1]);
        searchPage.implicitWait(5);
        Thread.sleep(1000);
        searchPage.waitForPageLoadComplete(5);
        searchPage.waitVisibilityOfElement(5,searchPage.getSelectPopUp());
        searchPage.clickPopUp();
        searchPage.clickPopUpExpensive();
        searchPage.waitForPageLoadComplete(10);
        List<WebElement> listAddToBucket =  getSearchPage().getListAddToBucket();
        searchPage.waitForPageLoadComplete(10);
        listAddToBucket.get(0).click();
        searchPage.implicitWait(5);
        searchPage.clickGoToBucket();
        BucketPage bucketPage = getBucketPage();
        Integer price = bucketPage.getStringPrice();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(price > priceAssert, "Price in page low data price");
        softAssert.assertAll();
        logger.info("Test work!");
    }

    @Test (description = "test is ignored because test work data", enabled = false)
    public void checkExpensiveGood2() throws InterruptedException {
        String[] data = {"стиральная машина", "Samsung" };
        int priceAssert = 14000;
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(data[0]);
        SearchPage searchPage = getSearchPage();
        searchPage.waitForPageLoadComplete(5);
        searchPage.clickCheckBoxMsi(data[1]);
        searchPage.implicitWait(5);
        Thread.sleep(1000);
        searchPage.waitForPageLoadComplete(5);
        searchPage.waitVisibilityOfElement(5,searchPage.getSelectPopUp());
        searchPage.clickPopUp();
        searchPage.clickPopUpExpensive();
        searchPage.waitForPageLoadComplete(10);
        List<WebElement> listAddToBucket =  getSearchPage().getListAddToBucket();
        searchPage.waitForPageLoadComplete(10);
        listAddToBucket.get(0).click();
        searchPage.implicitWait(5);
        searchPage.clickGoToBucket();
        BucketPage bucketPage = getBucketPage();
        Integer price = bucketPage.getStringPrice();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(price > priceAssert, "Price in page low data price");
        softAssert.assertAll();
        logger.info("Test work!");
    }
}
