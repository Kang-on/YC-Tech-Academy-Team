package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.repository;

import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.Post;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> search(String query);
}
