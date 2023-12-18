package com.charthome.board.repository;

import com.charthome.attachment.model.entity.AttachmentEntity;
import com.charthome.board.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    Optional<BoardEntity> findByBoardNo(Long boardNo);
}
