package com.bredit.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.bredit.client.AmazonClient;

import java.io.File;
import java.util.ResourceBundle;

public class S3util {
    public static void saveToS3(String fileName) {
        ResourceBundle rb = ResourceBundle.getBundle("config");

        AmazonClient amazonClient = new AmazonClient();
        String path = System.getProperty("user.dir") + rb.getString("SCREENSHOT_PATH_LOCAL");

        AWSCredentials credentials = new BasicAWSCredentials(amazonClient.getAccessKey(), amazonClient.getSecretKey());
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();
        try {
            var imageDirectory = new File(path);
            for (File file : imageDirectory.listFiles()) {
                if (fileName.equalsIgnoreCase(file.getName())) {
                    var request = new PutObjectRequest(amazonClient.getBucketName(), file.getName(), file);
                    var metadata = new ObjectMetadata();
                    metadata.setContentType("image/png");
                    request.setMetadata(metadata);
                    s3client.putObject(request);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
