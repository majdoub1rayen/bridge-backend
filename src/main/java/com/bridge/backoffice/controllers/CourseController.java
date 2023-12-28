package com.bridge.backoffice.controllers;

import com.bridge.backoffice.models.Course;
import com.bridge.backoffice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping()
    public Iterable<Course> getAllCourse() {
        return courseService.findAll();
    }

    @PostMapping("/add")
    public void saveCourse(
            @RequestParam("title") String title,
            @RequestParam("price") int price,
            @RequestParam("image") MultipartFile imageFile
    ) {
        courseService.save(title, price, imageFile);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @GetMapping("{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.findCourseById(id).orElse(null);
    }

    @PutMapping("/update")
    public void Update(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("price") int price,
            @RequestParam("image") MultipartFile imageFile
    ) {
        courseService.update(id,title, price, imageFile);
    }


}
