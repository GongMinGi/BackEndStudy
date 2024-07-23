package com.example.secondBackendProject.repository;

import com.example.secondBackendProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
