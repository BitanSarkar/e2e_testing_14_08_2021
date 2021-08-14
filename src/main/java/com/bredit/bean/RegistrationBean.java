package com.bredit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationBean {
	private String firstName;
	private String lastName;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String nameOnCard;
    private String password;
    private String confirmPassword;
}
