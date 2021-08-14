package com.bredit.params;

import com.bredit.bean.LoginBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Login Params class will have all the properties and
 *         data of Login page, which would be in Login Bean class. Example:
 *         device, browser, mode
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParams {
	private LoginBean loginBean;
	private String deviceName = "Desktop";
	private String browserName = "chrome";
	private String mode;
}