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

    @Column
    private Long boardNo;

    public static AttachmentEntity toAttachmentEntity(String filePath,Long boardNo) {
        AttachmentEntity file = new AttachmentEntity();
        file.setFilePath(filePath);
        file.setBoardNo(boardNo);
        return file;
    }
}
