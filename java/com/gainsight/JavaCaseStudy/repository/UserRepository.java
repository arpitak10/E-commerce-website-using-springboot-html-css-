package com.gainsight.JavaCaseStudy.repository;

import com.gainsight.JavaCaseStudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
