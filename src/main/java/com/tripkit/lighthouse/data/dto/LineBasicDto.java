package com.tripkit.lighthouse.data.dto;

import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.images.LineImage;
import lombok.*;

import java.util.List;

@Getter
@Setter
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
    private List<LineImage> images;
}
