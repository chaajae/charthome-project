package com.charthome.reply.repository;

import com.charthome.reply.model.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity,Long> {
    List<ReplyEntity> findAllByBoard(Long boardNo);
}
