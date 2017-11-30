package communityWardrobe.tiacloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
@Configuration
@PropertySource("classpath:aws.properties")
public class S3Config {
	@Value("${aws.access_key_id}")
	private String awsId;
 
	@Value("${aws.secret_access_key}")
	private String awsKey;
	
	@Value("${s3.region}")
	private String region;
 
	@Bean
	@Scope("prototype")
	public AmazonS3 s3client() {
		
//		System.setProperty("http.proxyHost","194.138.0.26");
//		System.setProperty("http.proxyPort","9400");
//		
		ClientConfiguration configuration = new ClientConfiguration();
		configuration.setMaxErrorRetry(3);
		configuration.setConnectionTimeout(501000);
		configuration.setSocketTimeout(501000);
		configuration.setProtocol(Protocol.HTTP);
//		configuration.setProxyHost("194.138.0.26");
//		configuration.setProxyPort(9400);
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
								.withRegion(region)
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .withClientConfiguration(configuration)
		                        .build();
		
		return s3Client;
	}
}
