package com.shop.project.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService
{
    void saveImageFile(Long productId, MultipartFile file);
}
