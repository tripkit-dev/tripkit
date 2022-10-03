package com.tripkit.lighthouse.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "image")
@Entity(name = "Image")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이미지 생성 일자
    private LocalDateTime created_at;

    //TODO
    private String fileName;
    private String fileOriName;
    private String fileUrl;
}
