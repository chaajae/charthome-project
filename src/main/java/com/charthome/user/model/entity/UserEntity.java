package com.charthome.user.model.entity;

import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.model.entity.BoardLikeEntity;
import com.charthome.common.entity.BaseTimeEntity;
import com.charthome.oauth.model.dto.NaverDto;
import com.charthome.reply.model.entity.ReplyEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long id;

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

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<BoardEntity> board;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<ReplyEntity> reply;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<BoardLikeEntity> boardLike;



    public static UserEntity toUserEntity(NaverDto naverDTO) {
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
