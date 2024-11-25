package com.example.aws.repository;

import com.example.aws.entity.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface StudentRepository extends CrudRepository<Student,String> {

}