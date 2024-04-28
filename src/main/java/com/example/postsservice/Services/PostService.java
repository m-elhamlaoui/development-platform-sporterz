package com.example.postsservice.Services;

import com.example.postsservice.DTOs.PostRequest;
import com.example.postsservice.DTOs.PostResponse;
import com.example.postsservice.Models.Post;
import com.example.postsservice.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostRequest postRequest) {
        Post post = Post.builder()
                .username(postRequest.getUsername())
                .photo(postRequest.getPhoto())
                .content(postRequest.getContent())
                .likes(postRequest.getLikes())
                .build();
        postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return PostResponse.builder()
                .id(post.getId())
                .username(post.getUsername())
                .photo(post.getPhoto())
                .content(post.getContent())
                .likes(post.getLikes())
                .build();
    }

    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(
                        post -> PostResponse.builder()
                                .id(post.getId())
                                .username(post.getUsername())
                                .photo(post.getPhoto())
                                .content(post.getContent())
                                .likes(post.getLikes())
                                .build()
                )
                .collect(Collectors.toList());
    }

}
