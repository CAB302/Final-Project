package tradestore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    public static void main(String[] args){
        Properties prop = new Properties();
        String fileName = "E:\\Java projects\\Final-Project-Basic_Code\\src\\tradestore\\app.config";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(prop.getProperty("app.ip"));
        System.out.println(prop.getProperty("app.port"));

    }
}
