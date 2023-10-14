package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.domain;



import com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.dto.PostDto;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();


    public Post() {
        super();
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public PostDto convert2DTO() {
        return new PostDto(this.getTitle(), this.getContent());
    }
}
