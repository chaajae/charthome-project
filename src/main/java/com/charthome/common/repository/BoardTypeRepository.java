package com.charthome.common.repository;

import com.charthome.common.entity.BoardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTypeRepository extends JpaRepository<BoardTypeEntity,String> {
}
