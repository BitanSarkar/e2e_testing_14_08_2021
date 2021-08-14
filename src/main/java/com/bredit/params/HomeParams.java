package com.bredit.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bitan Sarkar
 * 
 *         Description: The Home Params class will have all the properties and
 *         data of Home Page class. Example: device, browser, mode
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeParams {
	private String deviceName = "Desktop";
	private String browserName = "chrome";
	private String mode;
}