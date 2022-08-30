package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadDataFromFile {

    public static List<String> getDataFromProperties(String key) {
        FileInputStream fileInputStream;
        List<String> productValuesList = null;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/product.properties");
            properties.load(fileInputStream);
            String productValuesLine = properties.getProperty(key);
            productValuesList = Stream.of(productValuesLine.split(";")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productValuesList;
    }
}
