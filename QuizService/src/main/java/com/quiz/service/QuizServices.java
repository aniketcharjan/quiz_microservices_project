package com.quiz.service;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizServices 
{
	Quiz add(Quiz quiz);
	List<Quiz> get();
	Quiz get(Long id);
}
