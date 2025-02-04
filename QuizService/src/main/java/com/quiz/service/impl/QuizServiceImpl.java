package com.quiz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizServices;

@Service
public class QuizServiceImpl implements QuizServices{

	private QuizRepository quizRepository;
	
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz){
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get(){
		
		List<Quiz> quizzes = quizRepository.findAll();
		
		List<Quiz> newQuizList = quizzes.stream().map(quiz -> { 
					quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			        return quiz;
		}).collect(Collectors.toList());
		
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id){
		Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
