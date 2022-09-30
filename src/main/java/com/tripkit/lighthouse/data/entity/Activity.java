package com.tripkit.lighthouse.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "activity")
@Entity(name = "Activity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 행사 제목
    private String title;
    // 행사 설명
    private String description;
    // 행사 기간
    private String duration;
    // 행사 개최 여부 TODO 진행 중, 개최 중, 개최 끝 3가지로 나뉘어야됨, boolean은 한계가 있음.
    private Boolean isOpen;

    // 행사 위치
    @OneToMany
    private List<Spot> spots = new ArrayList<>();

    // 행사 사진
    @OneToMany
    private List<Image> images = new ArrayList<>();
}
