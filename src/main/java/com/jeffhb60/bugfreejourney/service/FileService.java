package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadImage(String path, MultipartFile image) throws IOException;
}
