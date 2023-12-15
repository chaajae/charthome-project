package com.charthome.attachment.model.service;

import com.charthome.attachment.model.entity.AttachmentEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    String uploadImg(MultipartFile newFile);
}
