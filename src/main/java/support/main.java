package support;

import java.util.logging.Logger;

public class main {
    /** It is not supporting file. It is simple test work file
     */
    public static void simpleCode(String[] args) {
        Logger.getGlobal() .info("File->Open menu item selected");
        String actual = "a[data-id='1']";
        actual = actual.replace("1", "MSI");
        System.out.println(actual);
    }
}
