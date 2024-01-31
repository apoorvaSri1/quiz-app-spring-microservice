package com.quiz.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entites.Question;

import java.util.List;


//@FeignClient(url = "http://localhost:8083", value= "Question-Client")   // it calls the service
@FeignClient(name = "QUESTION-SERVICESS")   // it calls the service
public interface QuestionClient {

	// method which call the public service
	
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
	
}
