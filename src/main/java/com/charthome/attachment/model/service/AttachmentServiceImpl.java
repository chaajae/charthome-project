package com.charthome.attachment.model.service;

import com.charthome.attachment.model.entity.AttachmentEntity;
import com.charthome.attachment.repository.AttachmentRepository;
import com.charthome.common.Utils;
import com.charthome.user.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Service
@Transactional
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService{

    private final AttachmentRepository attachmentRepository;
    private final ServletContext application;
    @Override
    public String uploadImg(MultipartFile newFile) {

        String webPath = "/resources/static/images/";
        String serverFolderPath = application.getRealPath(webPath);
        File dir = new File(serverFolderPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String changeName = Utils.saveFile(newFile, serverFolderPath);

        AttachmentEntity file = AttachmentEntity.toAttachmentEntity(webPath+changeName);
        attachmentRepository.save(file);

        return webPath+changeName;
    }
}
