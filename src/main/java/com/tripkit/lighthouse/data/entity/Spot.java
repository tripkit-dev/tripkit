package com.tripkit.lighthouse.data.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "spot")
@Entity(name = "Spot")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;

    private Integer mapx;
    private Integer mapy;
}
