package com.tripkit.lighthouse.data.entity.images;

import com.tripkit.lighthouse.data.entity.Line;
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
public class LineImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Line line;

    // 이미지 생성 일자
    private LocalDateTime created_at;

    //TODO
    private String fileName;
    private String fileOriName;
    private String fileUrl;
}
