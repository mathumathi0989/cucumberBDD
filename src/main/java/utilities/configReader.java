package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configReader {

	private Properties prop;
	
	public Properties init_prop() throws Exception {
		prop = new Properties();
		FileInputStream f = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(f);
		
		return prop;
		
	}
	
}
