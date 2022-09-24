package com.tripkit.lighthouse.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotDetailed {

    @Id
    private Integer id;

    private Integer spotId;

    private String title;
    private Integer price;
    private Byte[] head;
    private String description;

}
