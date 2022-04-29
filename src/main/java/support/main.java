package support;

import java.util.Arrays;
import java.util.logging.Logger;

import static support.XmlTestData.ReadXml;

public class main {
    /**
     * It is not supporting file. It is simple test work file
     */
    public static void main(String[] args) {
//        Logger.getGlobal() .info("File->Open menu item selected");
//        String actual = "a[data-id='1']";
//        actual = actual.replace("1", "MSI");
//        System.out.println(actual);
        System.out.println(Arrays.deepToString(getData()));
        System.out.println(Arrays.deepToString(getDataRead()));
    }

    public static Object[][] getDataRead() {
        PropertiesReader properties = new PropertiesReader();
        String path = properties.getInitialListData();
        ListTestData listTestData =  new ListTestData(ReadXml(path));
        int row = listTestData.getListTestData().size();
        Object[][] data = new Object[row][3];
        for (int i = 0; i < row; i++) {
            TestData item = listTestData.getListTestData().get(i);
            data[i][0] = item.getProduct();
            data[i][1] = item.getBrand();
            data[i][2] = item.getMinPrice();
        }
        return data;
    }

    public static Object[][] getData() {
        return new Object[][]{
                {"ноутбук", "MSI", 5000}
                , {"стиральная машина", "Samsung", 14000}
                , {"посудомоечная машина", "Bosch", 50000}
        };
    }
}
