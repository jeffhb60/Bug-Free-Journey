package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {

        String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));

        if (originalFilename.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        String fileExtension = StringUtils.getFilenameExtension(originalFilename);

        String randomId = UUID.randomUUID().toString();
        String filename = fileExtension != null ? randomId + "." + fileExtension : randomId;

        Path uploadPath = Paths.get(path);
        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(filename);

        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

}
