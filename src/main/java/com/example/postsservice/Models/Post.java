package com.example.postsservice.Models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private  byte[] photo;
    private String content;
    private Long likes;

}
