import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import support.PropertiesReader;
import support.TestData;
import support.XmlTestData;

import java.util.List;

import static support.XmlTestData.WriteXml;

public class FirstCaseTest extends BaseTest {
    TestData testData = XmlTestData.ReadXml(XmlTestData.path);
    final static Logger logger = Logger.getLogger(FirstCaseTest.class);
    PropertiesReader properties = new PropertiesReader();

    @Test
    public void checkExpensiveGoods(){
        getStartPage().searchByKeyword(testData.getProduct());
        getSearchPage().implicitWait(5);
        getSearchPage().clickCheckBoxMsi();
        getSearchPage().implicitWait(5);
        getSearchPage().clickPopUp();
        getSearchPage().clickPopUpExpensive();
        List<WebElement> listAddToBucket =  getSearchPage().getListAddToBucket();
        getBucketPage().implicitWait(5);
        listAddToBucket.get(0).click();
        getBucketPage().implicitWait(5);
        getSearchPage().clickGoToBucket();
        Integer price = getBucketPage().getStringPrice();
        testData.setRealPrice(price);
        Assert.assertTrue(price > testData.getMinPrice());
        WriteXml(testData, properties.getResultData());
        logger.info("Test work!");

    }
}
