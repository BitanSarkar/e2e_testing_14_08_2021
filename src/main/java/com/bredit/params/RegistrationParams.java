package com.bredit.params;

import com.bredit.bean.RegistrationBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Registration Params class will have all the
 *         properties and data of Registration page, which would be in
 *         Registration Bean class. Example: device, browser, mode
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationParams {
	private RegistrationBean registrationBean;
	private String deviceName = "Desktop";
	private String browserName = "chrome";
	private String mode;
}
