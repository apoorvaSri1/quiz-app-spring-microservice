package com.quiz.repositories;
// to get functionality of database extend JPA repository

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entites.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>  {

	
	
	
}
