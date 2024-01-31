package com.quiz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entites.Quiz;
import com.quiz.repositories.QuizRepo;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;


@Service// for autowire 

public class QuizServiceImpl  implements QuizService{
	
	// to add quiz we need repository
	private QuizRepo quizRepo;
	
    private QuestionClient questionClient;
    
    
	public QuizServiceImpl(QuizRepo quisRepo, QuestionClient questionClient) {
		super();
		this.quizRepo = quisRepo;
		this.questionClient =questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = quizRepo.findAll();
		
 List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}).collect(Collectors.toList());
	
	return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz= quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
	quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
	return quiz;
	}

	
}
