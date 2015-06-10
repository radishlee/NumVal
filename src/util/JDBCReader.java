package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class JDBCReader {
	private final static JDBCReader jdbcReader = new JDBCReader();
	private JDBCReader(){}

	private final static String filePath = "c:" + File.separator + "jdbc.properties";
	public static String username = "";
	public static String password = "";
	public static String driverUrl = "";
	
	public static JDBCReader getInstance(){
		Properties properties = new Properties();
        try{
            InputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            inputStream.close();
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driverUrl = properties.getProperty("driverUrl");
        }catch (Exception e){
            e.printStackTrace();
        }
		return jdbcReader;
	}
}
