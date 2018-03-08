package com.group15.question;

import com.group15.answer.Answer;
import com.group15.category.Category;
import com.group15.core.BaseEntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question extends BaseEntityModel {


    // This is the question that we ask the user
    // For example "What is the capital city of Scotland?"
    @NotNull(message = "You must enter a question title")
    @Size(min = 2 , max = 140, message = "The question title must be between 2 - 140 characters")
    private String title;

    @OneToMany(mappedBy = "question" , cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    private Category category;


    /*** Constructors ***/

    // JPA requires a constructor with no params this is coming from super()
    // Which calls BaseEntityModel
    // I have made it protected as we do not need to use this outside of its package
    protected Question(){
        super();
        answers = new ArrayList<>();
    }

    // This is a public constructor so people can easily create these objects
    public Question(String title) {
        this(); // calls the above parameter-less constructor for the id.
        this.title = title;
    }


    /*** Getters and Setters ***/


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer){
        answer.setQuestion(this);
        answers.add(answer);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
