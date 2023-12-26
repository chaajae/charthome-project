package com.charthome.attachment.model.entity;

import com.charthome.board.model.entity.BoardEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "attachment")
@Entity
public class AttachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_no")
    private Long id;

    @Column
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_no")
    private BoardEntity board;
    public static AttachmentEntity toAttachmentEntity(String filePath,Long boardNo) {
        AttachmentEntity file = new AttachmentEntity();
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardNo);
        file.setBoard(boardEntity);
        file.setFilePath(filePath);
//        file.setBoardNo(boardNo);
        return file;
    }
}
