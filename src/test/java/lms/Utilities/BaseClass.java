package lms.Utilities;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass 
{
	public static ResourceBundle config = ResourceBundle.getBundle("Config");
	public static ExcelUtilis xlutils=new ExcelUtilis();
	public static Logger log = LogManager.getLogger();
	
}
