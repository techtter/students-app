package net.techtter.demo.student.controller;


import java.util.List;
import java.util.Optional;

import net.techtter.demo.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.techtter.demo.student.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
	
	@PostMapping("/addStudent")
	public String saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student added successfully::"+student.getId();
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/findStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Long id) {
		return studentRepository.findById(id);
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
		return "Deleted Student Successfully::"+id;
	}
	

}