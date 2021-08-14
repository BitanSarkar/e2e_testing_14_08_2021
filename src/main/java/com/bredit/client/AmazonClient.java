package com.bredit.client;

import java.util.ResourceBundle;

import lombok.Data;

@Data
public class AmazonClient {
	private String endpointUrl;
	private String bucketName;
	private String accessKey;
	private String secretKey;
	private ResourceBundle resourceBundle;

	public AmazonClient() {
		resourceBundle = ResourceBundle.getBundle("config");
		endpointUrl = resourceBundle.getString("ENDPOINT_URL");
		bucketName = resourceBundle.getString("BUCKET_NAME");
		accessKey = resourceBundle.getString("ACCESS_KEY");
		secretKey = resourceBundle.getString("SECRET_KEY");
	}
}
