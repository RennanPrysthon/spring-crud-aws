package br.prysthon.aws.project.services;




import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AmazonService {

    private static final Logger logger = LoggerFactory.getLogger(AmazonService.class);

    private AmazonS3 s3client;

    public AmazonService(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    public void uploadFile(String localFilePath) {
        File file = new File(localFilePath);
        this.uploadFile(file);
    }

    public void uploadFile(MultipartFile multipartFile) {
        try {
            File file = multipartFile.getResource().getFile();
            this.uploadFile(file);
        } catch (IOException e) {
            logger.info("IOException: Falha ao converter MultipartFile em File : " + e.getMessage());
        }
    }

    public void uploadFile(File file) {
        try {
            logger.info("Iniciando upload");
            s3client.putObject(new PutObjectRequest(bucketName, file.getName(), file));
            logger.info("Upload concluido");
        } catch (AmazonServiceException e) {
            logger.info("AmazonServiceException: " + e.getErrorMessage());
            logger.info("StatusCde: " + e.getErrorCode());
        } catch (AmazonClientException e) {
            logger.info("AmazonClientException: " + e.getMessage());
        }
    }
}
