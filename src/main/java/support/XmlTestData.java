package support;

import dev.failsafe.internal.util.Assert;
import org.apache.log4j.Logger;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlTestData {
    final static Logger logger = Logger.getLogger(XmlTestData.class);
    public static final String path = "src/main/resources/testData.xml";
    public static void WriteXml(TestData data, String path) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(path)))) {
            xmlEncoder.writeObject(data);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public static TestData ReadXml(String path) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream(path)))) {
            TestData data = (TestData) xmlDecoder.readObject();
            System.out.println(data);
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("ERROR: Not write file XML!");
        }
        return null;
    }

    public static void main(String[] args) {
        TestData data = new TestData("Laptop", "MSI", 5000);

        WriteXml(data, path);
        TestData dataRead = ReadXml(path);
        Assert.isTrue(5000 == dataRead.getMinPrice(), "error test!");
    }
}