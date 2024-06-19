package com.camunda.avipsa.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ImageResponse {

    private String imageUrl;
    private byte[] image;
}
