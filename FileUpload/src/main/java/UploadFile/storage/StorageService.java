package UploadFile.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void initialize();

    void deleteAllFiles();

    void store(MultipartFile file);

    Stream<Path> loadAll();





}
