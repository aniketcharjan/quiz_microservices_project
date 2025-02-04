package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController
{
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	//create
	@PostMapping
	public Question create(@RequestBody Question question)
	{
		return questionService.create(question);
	}
	
	//get all
	@GetMapping
	public List<Question> getAll(){
		return questionService.get();
	}
	
	//get one
	@GetMapping("/{questionId}")
	public Question getById(@PathVariable Long questionId) {
		return questionService.getOne(questionId);
	}
	
	//get all question of specific quiz
	@GetMapping("/quiz/{quizId}")
	public List<Question> getByQuizId(@PathVariable Long quizId) {
		return questionService.getQustionsOfQuiz(quizId);
	}
	
}
