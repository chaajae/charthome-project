package com.charthome.user.model.dto;


import com.charthome.user.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userNo;
    private String userId;
    private String userEmail;
    private String userNick;
    private String userProfile;
    private String userStatus;

    public static UserDto toUserDTO(UserEntity loginEntity){
        UserDto loginUser = new UserDto();
        loginUser.setUserNo(loginEntity.getUserNo());
        loginUser.setUserNick(loginEntity.getUserNick());
        loginUser.setUserProfile(loginEntity.getUserProfile());
        loginUser.setUserEmail(loginEntity.getUserEmail());
        loginUser.setUserId(loginEntity.getUserId());

        return loginUser;
    }

}
