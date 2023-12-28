package com.bridge.backoffice.services;

import com.bridge.backoffice.models.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface CourseService {
    public Iterable<Course> findAll();

    public Course save(String title, int price, MultipartFile imageFile);
    public Course update(int id, String title, int price, MultipartFile imageFile);


    public void deleteById(int id);

    public Optional<Course> findCourseById(int id);
}
