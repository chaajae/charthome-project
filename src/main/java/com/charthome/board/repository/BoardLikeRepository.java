package com.charthome.board.repository;

import com.charthome.board.model.entity.BoardLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardLikeRepository extends JpaRepository<BoardLikeEntity,Long> {
//    Optional<BoardLikeEntity> findByUserNo(Long userNo);
}
