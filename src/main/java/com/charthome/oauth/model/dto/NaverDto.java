package com.charthome.oauth.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NaverDto {
    private String id;
    private String email;
    private String name;
}
