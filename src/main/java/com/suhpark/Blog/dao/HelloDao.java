package com.suhpark.Blog.dao;

import com.suhpark.Blog.Entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloDao extends JpaRepository<Hello, Integer> {

}