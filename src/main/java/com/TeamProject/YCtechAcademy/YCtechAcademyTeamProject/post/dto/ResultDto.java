package com.TeamProject.YCtechAcademy.YCtechAcademyTeamProject.post.dto;

public record ResultDto<T>(
        int code,
        String message,
        T data
) {

}
