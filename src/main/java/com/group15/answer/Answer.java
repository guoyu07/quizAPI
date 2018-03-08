package com.group15.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group15.core.BaseEntityModel;
import com.group15.question.Question;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Answer extends BaseEntityModel{


    @NotNull(message = "You must enter a answer")
    @Size(min = 2, max = 50, message = "The answer must be between 2 - 50 characters")
    private String text; // This is a answer to the question both correct and incorrect

    @ManyToOne
    private Question question;

    // encrypted in db and also not exposed to api
    @JsonIgnore
    private Boolean correctAnswer;


    protected Answer() {
        super();
    }

    public Answer(String text, Boolean correctAnswer) {
        this();
        this.text = text;
        this.correctAnswer = correctAnswer;
    }


    /*** Getters and Setters ***/

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
