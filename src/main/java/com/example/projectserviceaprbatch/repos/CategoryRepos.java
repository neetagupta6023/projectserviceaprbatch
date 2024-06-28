package com.example.projectserviceaprbatch.repos;

import com.example.projectserviceaprbatch.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepos extends JpaRepository<Category, Integer> {
}
