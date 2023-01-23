package com.tripkit.lighthouse.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import com.tripkit.lighthouse.data.dto.GoogleAPIDto.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotBasicDto implements Serializable {
    // 위치의 기본적인 정보를 내려주는 객체
    // Google Location
    private Geometry geometry;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private String name;
    @JsonProperty("place_id")
    private String placeId;

    // 네이버 데이터베이스를 참고하여 만들었던 모델
    // 네이버 검색 >> 위치 정보 api 응답 모델을 참고하여 구현하였다.
//    private String title;
//    private String link;
//    private String category;
//    private String description;
//    private String telephone;
//    private String address;
//    private String roadAddress;
//
//    private Integer mapx;
//    private Integer mapy;
}
