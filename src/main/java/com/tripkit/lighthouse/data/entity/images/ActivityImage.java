package com.tripkit.lighthouse.data.entity.images;

import com.tripkit.lighthouse.data.entity.Activity;
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
public class ActivityImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activityId")
    private Activity activity;

    // 이미지 생성 일자
    private LocalDateTime created_at;

    //TODO
    private String fileName;
    private String fileOriName;
    private String fileUrl;
}
