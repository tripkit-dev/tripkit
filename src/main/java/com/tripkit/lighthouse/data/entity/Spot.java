package com.tripkit.lighthouse.data.entity;

import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.images.SpotImage;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 장소 이름
    private String title;
    // 장소 사이트
    private String link;
    // 장소 분류 - 대략적
    private String category;
    // 장소 분류 - 자세히
    private String tag;
    // 장소 설명
    private String description;
    // 장소 전화번호
    private String telephone;
    // 장소 주소
    private String address;
    // 장소 도로명 주소
    private String roadAddress;

    // NAVER API 사용할 때 지도 위치 좌표값
    // X값
    private Integer mapx;
    // Y값
    private Integer mapy;

    @ManyToOne
    @JoinColumn(name = "lineId")
    private Line line;

    // 장소 메뉴
    @OneToMany(fetch = FetchType.EAGER)
    private List<SpotDetail> spotDetails;


//    @OneToMany(mappedBy = "spot")
//    private List<SpotImage> images = new ArrayList<>();
}
