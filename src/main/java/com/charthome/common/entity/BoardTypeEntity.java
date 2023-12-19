package com.charthome.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "board_type")
public class BoardTypeEntity {

    @Id
    @Column
    private String boardCode;

    @Column
    private String boardName;
}
