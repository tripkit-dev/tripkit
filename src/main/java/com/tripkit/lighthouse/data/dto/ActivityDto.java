package com.tripkit.lighthouse.data.dto;

import com.tripkit.lighthouse.data.IsOpen;
import com.tripkit.lighthouse.data.entity.images.ActivityImage;
import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.Spot;

import java.util.List;

public class ActivityDto {
    // 축제 정보들을 내려주는 객체

    // 행사 제목
    private String title;
    // 행사 설명
    private String description;
    // 행사 기간
    private String duration;
    // 행사 개최 여부
    private IsOpen isOpen;

    // 행사 위치
    private List<Spot> spots;

    // 행사 사진
    private List<ActivityImage> images;
}
