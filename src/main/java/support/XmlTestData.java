package support;

import dev.failsafe.internal.util.Assert;
import org.apache.log4j.Logger;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlTestData<T> {
    final static Logger logger = Logger.getLogger(XmlTestData.class);
    static PropertiesReader properties = new PropertiesReader();
    public static final String path = properties.getInitialListData();
    public static final String pathList = properties.getInitialListData();
    public static <T> void WriteXml(T data, String path) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(path)))) {
            xmlEncoder.writeObject(data);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("ERROR: Not read file XML!");
        }
    }

    public static <T> T ReadXml(String path) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream(path)))) {
            T data = (T) xmlDecoder.readObject();
            System.out.println(data);
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("ERROR: Not write file XML!");
        }
        return null;
    }

    public static void main(String[] args) {
        TestData data = new TestData("Ноутбук", "MSI", 5000);

        WriteXml(data, path);
        TestData dataRead = ReadXml(path);
        Assert.isTrue(5000 == dataRead.getMinPrice(), "error test!");

        List<TestData> listData = new ArrayList<>();
        listData.add(new TestData("ноутбук", "MSI", 5000));
        listData.add(new TestData("стиральная машина", "Samsung", 14000));
        listData.add(new TestData("посудомоечная машина", "Bosch", 50000));
        listData.add(new TestData("робот пылесос", "Electrolux", 20000));
        listData.add(new TestData("смартфон", "Xiaomi", 17000));
        ListTestData listDataObject = new ListTestData(listData);
        WriteXml(listDataObject.getListTestData(), pathList);

        ListTestData listDataO = new ListTestData(ReadXml(pathList));
        TestData itemOne = listDataO.getListTestData().get(4);
        String a =  itemOne.getBrand();
        Assert.isTrue(17000 == itemOne.getMinPrice(), "error test!");
    }
}