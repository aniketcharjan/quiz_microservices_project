package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
