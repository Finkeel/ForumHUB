package com.alura.forumhub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDTO(
        @NotBlank
        String courseName,
        @NotBlank
        String categoryName) {
}
