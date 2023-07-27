package fp.property.file.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import fp.constants.ProjectPaths;


/**
 * In this class we are having all the methods w.r.t. PropertyFile
 * Actions like reading data,writing data from property file
 * @author Pavan
 *
 */
public class PropertyFileUtility {

	public String  getData(String key)// throws IOException 
	{

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(ProjectPaths.CONFIG_PROPERTY));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return (String) properties.get(key);


		
	}

}
