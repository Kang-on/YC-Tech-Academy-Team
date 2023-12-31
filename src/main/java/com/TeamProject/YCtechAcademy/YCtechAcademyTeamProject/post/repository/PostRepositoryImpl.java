package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.repository;

import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.Post;
import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain.QPost;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Post> search(String query) {
        return queryFactory.from(QPost.post)
                .select(Projections.constructor(
                        Post.class
                ))
                .where(QPost.post.content.like(query))
                .fetch();
    }
}
