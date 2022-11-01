package com.tripkit.lighthouse.data.entity;

import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.images.SpotDetailImage;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spotId")
    private Spot spotId;

    // 메뉴 제목
    private String title;
    // 메뉴 가격
    private Integer price;
    // 메뉴 설명
    private String description;

    // 메뉴 이미지
    @OneToOne(mappedBy = "spotDetail")
    private SpotDetailImage head;


}
