package com.tripkit.lighthouse.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.tripkit.lighthouse.data.dto.GoogleAPIDto.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpotDetailDto {
    // 한 Spot의 자세한 정보들을 모아서 내려주는 dto
    private Geometry geometry;
    private String name;
//    private String title;
//    private String link;
//    private String category;
    private String description;
    @JsonProperty("formatted_phone_number")
    private String formattedPhoneNumber;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("opening_hours")
    private OpeningHours openingHours;

//    private String roadAddress;
//
//    private Integer mapx;
//    private Integer mapy;
}
