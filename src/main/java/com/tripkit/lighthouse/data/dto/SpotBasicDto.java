package com.tripkit.lighthouse.data.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotBasicDto {
    // 위치의 기본적인 정보를 내려주는 객체
    // 네이버 검색 >> 위치 정보 api 응답 모델을 참고하여 구현하였다.

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
