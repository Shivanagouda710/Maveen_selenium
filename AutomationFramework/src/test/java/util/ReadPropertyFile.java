package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//C:\Users\kalasapp\eclipse-workspace\AutomationFramework

		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\config.properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.println(p.getProperty("testUrl"));
		
	}

}
