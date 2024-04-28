package com.example.postsservice.Models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    private Long id;
    private String username;
    private Base64 photo;
    private String content;
    private Long likes;

}
