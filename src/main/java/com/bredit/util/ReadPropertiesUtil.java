package com.bredit.util;

import java.util.ResourceBundle;

public class ReadPropertiesUtil {
	private static ResourceBundle resourceBundle;
	static {
		resourceBundle = ResourceBundle.getBundle("elements");
	}

	public static String getProperty(String property) {
		return resourceBundle.getString(property);
	}

}
