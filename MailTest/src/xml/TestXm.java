package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class TestXm {
	public static void main(String[] args) {
		Properties properties=new Properties();
		File file=new File("mail.properties");
		try {
			//properties.loadFromXML(new FileInputStream(file));
			properties.load(new FileInputStream(file));
			System.out.println(properties.getProperty("userName"));
			System.out.println(properties.getProperty("password"));
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
