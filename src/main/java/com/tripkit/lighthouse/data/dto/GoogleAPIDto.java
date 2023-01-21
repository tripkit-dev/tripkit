package com.tripkit.lighthouse.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class GoogleAPIDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CoordinateValue implements Serializable {
        private Float lat;
        private Float lng;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Viewport implements Serializable {
        @JsonProperty("northeast")
        private CoordinateValue northEast;
        @JsonProperty("southwest")
        private CoordinateValue southWest;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Geometry implements Serializable {
        private CoordinateValue location;
        private Viewport viewport;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OpeningHours implements Serializable {
        @JsonProperty("weekday_text")
        private List<String> weekDayText;
    }
}
