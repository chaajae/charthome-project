package com.charthome.board.model.entity;

import com.charthome.board.model.dto.BoardLikeDto;
import com.charthome.user.model.entity.UserEntity;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Data
@Table(name = "board_like")
public class BoardLikeEntity {

    @Id
    @Column(name = "boardlike_no")
    private Long id;

//    @Column
//    private Long boardNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_no")
    private BoardEntity board;

    public static BoardLikeEntity toBoardLikeEntity(BoardLikeDto boardLikeDto){
        BoardLikeEntity boardLikeEntity = new BoardLikeEntity();
        UserEntity userEntity = new UserEntity();
        BoardEntity boardEntity = new BoardEntity();
        userEntity.setId(boardLikeDto.getUserNo());
        boardEntity.setId(boardLikeDto.getBoardNo());
        boardLikeEntity.setUser(userEntity);
        boardLikeEntity.setBoard(boardEntity);
//        boardLikeEntity.setId(boardLikeDto.getUserNo());
//        boardLikeEntity.setBoardNo(boardLikeDto.getBoardNo());
        return boardLikeEntity;
    }

}
