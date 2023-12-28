package com.bridge.backoffice.servicesImp;

import com.bridge.backoffice.models.Course;
import com.bridge.backoffice.repositories.CourseRepository;
import com.bridge.backoffice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(String title, int price, MultipartFile imageFile) {
        try {
            Course course = new Course();
            course.setTitle(title);
            course.setPrice(price);
            course.setImage(imageFile.getBytes());
            return courseRepository.save(course);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Course update(int id, String title, int price, MultipartFile imageFile) {
        try {
            Course course = new Course();
            course.setId(id);
            course.setTitle(title);
            course.setPrice(price);
            course.setImage(imageFile.getBytes());
            return courseRepository.save(course);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> findCourseById(int id) {
        return courseRepository.findById(id);
    }
}
