package UploadFile;

import UploadFile.storage.StorageLocationProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import UploadFile.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageLocationProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAllFiles();
            storageService.initialize();
        };
    }
}
