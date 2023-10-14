package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.repository;

import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

    List<Post> findByOrderByIdDesc();

    List<Post> findByIdInOrderByIdDesc(List<Long> postIdList);

}
