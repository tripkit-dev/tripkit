package com.tripkit.lighthouse.data.entity.images;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
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
