package com.tripkit.lighthouse.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpotFullDto {
    // 스팟의 모든 정보를 한번에 다 내려주는 객체

    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;

    private Integer mapx;
    private Integer mapy;
}
