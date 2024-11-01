package com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forumhub.domain.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
