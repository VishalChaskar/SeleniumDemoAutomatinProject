package common.classess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyFile {

	static Properties prop = new Properties();

	public PropertyFile() throws Exception {
		InputStream input = new FileInputStream(
				"C:\\Users\\Anonymous\\eclipse-workspace\\Selenium-assignment\\src\\main\\java\\common\\classess\\PropertyFile");
		prop.load(input);

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * getUrl(); writePropertyFile();
	 * 
	 * }
	 */

	public static String getUrl() {

		try {

			prop.getProperty("Url");
			System.out.println(prop.getProperty("Url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("Url");
	}

	public static String emailId() {

		try {

			prop.getProperty("emailId");
			System.out.println(prop.getProperty("emailId"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("emailId");
	}

	public static String firstName() {

		try {

			prop.getProperty("firstName");
			System.out.println(prop.getProperty("firstName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("firstName");
	}

	public static String lastName() {

		try {

			prop.getProperty("lastName");
			System.out.println(prop.getProperty("lastName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("lastName");
	}

	public static String company() {

		try {

			prop.getProperty("company");
			System.out.println(prop.getProperty("company"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("company");
	}

	public static String passWord() {

		try {

			prop.getProperty("passWord");
			System.out.println(prop.getProperty("passWord"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("passWord");
	}

	public static String address() {

		try {

			prop.getProperty("address");
			System.out.println(prop.getProperty("address"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("address");
	}

	public static String city() {

		try {

			prop.getProperty("city");
			System.out.println(prop.getProperty("city"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("city");
	}

	public static String state() {

		try {

			prop.getProperty("state");
			System.out.println(prop.getProperty("state"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("state");
	}

	public static String zipCode() {

		try {

			prop.getProperty("zipCode");
			System.out.println(prop.getProperty("zipCode"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("zipCode");
	}

	public static String mobilePhone() {

		try {

			prop.getProperty("mobilePhone");
			System.out.println(prop.getProperty("mobilePhone"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("mobilePhone");
	}

	public static String genderMr() {

		try {

			prop.getProperty("genderMr");
			System.out.println(prop.getProperty("genderMr"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("genderMr");
	}

	public static String genderMrs() {

		try {

			prop.getProperty("genderMrs");
			System.out.println(prop.getProperty("genderMrs"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("genderMrs");
	}

	public static void writePropertyFile() {

		try {
			OutputStream output = new FileOutputStream(
					"C:\\Users\\Anonymous\\eclipse-workspace\\Selenium-assignment\\src\\main\\java\\common\\classess\\PropertyFile");
			prop.setProperty("honey", "money");
			prop.put("abc", "xyz");

			prop.store(output, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
