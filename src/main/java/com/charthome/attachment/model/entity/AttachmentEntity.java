package com.charthome.attachment.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "attachment")
@Entity
public class AttachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileNo;

    @Column
    private String filePath;

    public static AttachmentEntity toAttachmentEntity(String filePath) {
        AttachmentEntity file = new AttachmentEntity();
        file.setFilePath(filePath);
        return file;
    }
}
