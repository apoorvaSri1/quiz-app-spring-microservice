package com.quiz.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entites.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	//create
	
	private QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService=quizService;
	}
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	
	//get all
	
	@GetMapping
	public List<Quiz> get(){
		return quizService.get();
	}
	
	// get by Id
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable Long id){
		return quizService.get(id);
	}
	
}
