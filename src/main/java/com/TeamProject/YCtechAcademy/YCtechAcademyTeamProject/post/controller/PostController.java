package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.controller;

import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.Post;
import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.dto.PostDto;
import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.dto.ResultDto;
import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/posts")
@Tag(name = "Post API", description = "Post 기능 API")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("")
    @Operation(summary = "add post", description = "Post 를 추가하는 API")
    public ResultDto<PostDto> addPost(
            @Parameter(name = "dto", description = "post dto")
            @RequestBody PostDto dto) {
        return new ResultDto<>(200, "", postService.addPost(dto.title(), dto.content()).convert2DTO());
    }

    @GetMapping("")
    public ResultDto<List<PostDto>> getPostList() {
        List<PostDto> postDtos = postService.getPostList()
                .stream()
                .map(Post::convert2DTO)
                .toList();

        return new ResultDto<>(200, "ok", postDtos);
    }

    @GetMapping("/{postId}")
    public ResultDto<PostDto> getPost(@PathVariable("postId") long postId) {
        Optional<PostDto> optPost = postService.getPost(postId)
                .map(Post::convert2DTO);

        if (optPost.isEmpty()) {
            throw new IllegalArgumentException("not exist post : %s".formatted(postId));
        } else {
            return new ResultDto<>(200, "ok", optPost.get());
        }

    }

    @DeleteMapping("/{postId}")
    public ResultDto deletePost(@PathVariable("postId") long postId) {
        postService.getPost(postId)
                .ifPresentOrElse(post -> postService.deletePost(postId),
                        () -> {
                            throw new IllegalArgumentException("not exist post : %s".formatted(postId));
                        });

        return new ResultDto<>(200, "ok", null);
    }

}
