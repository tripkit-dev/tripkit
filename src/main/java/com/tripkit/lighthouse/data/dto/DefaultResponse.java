package com.tripkit.lighthouse.data.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse<T>  implements Serializable {
    private String message;
    private T data;
    private String error;
}
