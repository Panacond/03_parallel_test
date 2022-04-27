package support;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    final static Logger logger = Logger.getLogger(PropertiesReader.class);
    Properties property = new Properties();
    final static String PATH = "src/main/resources/config.properties";

    public PropertiesReader(){
        FileInputStream fis;
        try {
            fis = new FileInputStream(PATH);
            property.load(fis);
            fis.close();
            logger.info("Read config.properties");
        } catch(IOException e){
            logger.info("ERROR: Properties file is not exist!");
        }
    }

    public String getUrl(){
        return property.getProperty("URL");
    }

    public String getInitialData(){
        return property.getProperty("READ_INITIAL_DATA");
    }

    public String getResultData(){
        return property.getProperty("WRITE_RESULT_DATA");
    }
}
