//package com.example.SpringMongoProject.Controller;
//import com.example.SpringMongoProject.Entity.Student;
//import com.example.SpringMongoProject.Service.StudentServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("api/v1/student")
//public class StudentController {
//	
//	@Autowired
//	private StudentServices  studentServices;
//	
//	@PostMapping(value = "/save")
//	public String saveStudent(@RequestBody Student students) {
//		
//		
//		studentServices.saveorUpdate(students);
//		
//		return students.get_id();
//	}
//	
//	
//	@GetMapping(value = "/getAll")
//	public Iterable<Student> getStudents() {
//		
//		
//		return studentServices.listAll();
//	}
//	
//	
//	@PutMapping(value = "/edit/{id}")
//	private Student update(@RequestBody Student student, @PathVariable(name="id")String _id) {
//		
//		
//		student.set_id(_id);
//		
//		studentServices.saveorUpdate(student);
//		
//		return student;
//		
//	}
//	
//	
//	@DeleteMapping("/delete/{id}")
//	private void deleteStudent(@PathVariable("id")String _id) {
//	
//		studentServices.deleteStudent(_id);
//	
//	}
//	
//	
//	@RequestMapping("/search/{id}")
//	private Student getStudents(@PathVariable(name="id")String _studentid) {
//		return studentServices.getStudentByID(_studentid);
//	}
//}
	
package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Student;
import com.example.SpringMongoProject.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students) {

        studentServices.saveorUpdate(students);
        return students.get_id();
    }
    
    @GetMapping(value = "/getall")
    public Iterable<Student> getStudents() {
        return studentServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String _id) {
        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id) {
        studentServices.deleteStudent(_id);
    }


    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name = "id") String studentid) {
        return studentServices.getStudentByID(studentid);
    }

}
	
