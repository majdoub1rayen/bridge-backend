package com.bridge.backoffice.repositories;

import com.bridge.backoffice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
