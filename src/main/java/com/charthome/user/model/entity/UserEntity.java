package com.charthome.user.model.entity;

import com.charthome.common.entity.BaseTimeEntity;
import com.charthome.oauth.model.dto.NaverDTO;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "user")
@ToString
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(unique = true)
    private String userId;

    @Column
    private String userEmail;

    @Column
    private String userNick;

    @Column
    private String userProfile;

    @Column
    private String userStatus;

    public static UserEntity toUserEntity(NaverDTO naverDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(naverDTO.getId());
        userEntity.setUserEmail(naverDTO.getEmail());
        userEntity.setUserNick(naverDTO.getName());
        return userEntity;
    }

    @PrePersist
    public void prePersist() {
        this.userProfile = this.userProfile == null ? "none" : this.userProfile;
        this.userStatus = this.userStatus == null ? "y" : this.userStatus;
    }

}
