package com.tripkit.lighthouse.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpotResponse {
    String name;
    String placeId;
    Integer rating;
    Float locationLat;
    Float locationLng;
}
