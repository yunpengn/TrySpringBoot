package org.yunpeng.tryspringboot.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.yunpeng.tryspringboot.exceptions.FileStorageException;

public class FileStorageService {
    private final Path fileStorageLocation;

    public FileStorageService(String uploadDir) {
        fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();

        try {
            Files.createDirectory(fileStorageLocation);
        } catch (IOException e) {
            throw new FileStorageException("Could not create the required directory.", e);
        }
    }

    public void storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path targetLocation = fileStorageLocation.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException("Unable to get input stream.", e);
        }
    }
}
