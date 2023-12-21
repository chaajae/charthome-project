package com.charthome.attachment.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    String uploadImg(MultipartFile newFile );
}
