package com.tripkit.lighthouse.data.dto;

import com.tripkit.lighthouse.data.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineBasicDto {
    // 라인의 기본 정보를 내려주는 객체

    // 라인을 만든 유저 이름
    private String userName;
    // 라인에 포함된 항목들
    private List<SpotBasicDto> spots;
    // 라인의 이미지들
    private List<Image> images;
}
