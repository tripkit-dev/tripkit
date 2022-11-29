package com.tripkit.lighthouse.data.entity;

import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.images.LineImage;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "line")
@Entity(name = "Line")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Line 생성한 유저 이름
    private String userName;

    // Line 생성 일자
    private LocalDateTime created_at;

    // 장소 node들
    @OneToMany(mappedBy = "line")
    private List<Spot> spots = new ArrayList<>();
//
//    @OneToMany(mappedBy = "line")
//    private List<LineImage> images = new ArrayList<>();
}
