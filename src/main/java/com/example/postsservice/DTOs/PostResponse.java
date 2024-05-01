package com.example.postsservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostResponse {

    private Long id;
    private String username;
    private byte[] photo;
    private String content;
    private Long likes;

}
