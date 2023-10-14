package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.service;

import java.util.List;
import java.util.Optional;

import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.Post;

public interface PostService {

    Post addPost(String title, String content);

    Optional<Post> getPost(long id);

    List<Post> getPostListByUserId();

    List<Post> getPostList();

    void deletePost(long id);
}
