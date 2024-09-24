//package com.example.SpringMongoProject.Repo;
//
//import java.util.List;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import com.example.SpringMongoProject.Entity.Student;
//
//public interface StudentRepo extends MongoRepository<Student,String> {
//
//	List<Student> findAll();
//	
//	
//
//}


package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {
}