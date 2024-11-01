package com.alura.forumhub.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alura.forumhub.domain.course.Course;
import com.alura.forumhub.repository.CourseRepository;
import com.alura.forumhub.domain.course.CourseRequestDTO;
import com.alura.forumhub.domain.course.CourseResponseDTO;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CourseResponseDTO createCourse(CourseRequestDTO request){
       var entity = new Course(request);
       repository.save(entity);
       return new CourseResponseDTO(entity);
    }

    public Page<CourseResponseDTO> listCourses(Pageable pageable){
        return repository.findAll(pageable).map(CourseResponseDTO::new);
    }

}
