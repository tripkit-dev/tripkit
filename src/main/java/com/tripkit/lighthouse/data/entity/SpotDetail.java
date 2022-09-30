package com.tripkit.lighthouse.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Spot spotId;

    // 메뉴 제목
    private String title;
    // 메뉴 가격
    private Integer price;
    // 메뉴 설명
    private String description;

    // 메뉴 이미지
    @OneToOne
    private Image head;


}
