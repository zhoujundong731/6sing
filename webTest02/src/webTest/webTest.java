package webTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class webTest {
	
	private HttpServletRequest request;

	public webTest(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getString(){
		String str=null;
		/*		System.getProperty("catalina.base");
		System.out.println("catalina.base:"+System.getProperty("catalina.base"));
		System.out.println("catalina.home:"+System.getProperty("catalina.home"));
		System.out.println("user.dir:"+System.getProperty("user.dir"));
		System.out.println("request.getContextPath()"+request.getContextPath());
		System.out.println("request.getServletPath()"+request.getServletPath());
		System.out.println("getSession().getServletContext().getRealPath()"+request.getSession().getServletContext().getRealPath(""));*/
		File file=new File(request.getSession().getServletContext().getRealPath("")+"/configer/mail.xml");
		Properties properties=new Properties();
		try {
			properties.loadFromXML(new FileInputStream(file));
			str=properties.getProperty("name");
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
		return str;
	} 
}
