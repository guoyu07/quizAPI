package com.group15.category;

import com.group15.core.BaseEntityModel;
import com.group15.question.Question;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends BaseEntityModel {

    @NotNull(message = "You must enter a category title")
    @Size(min = 3, max = 30, message = "The title must be between 3 - 30 characters")
    private String title; // the name of the category

    @NotNull(message = "Please enter a category description")
    @Size(min = 10, max = 140 ,message = "Description must be between 10 - 140 characters ")
    private String description; // A short description of what the category contains
    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
    private List<Question> questions; // Every category has a list of questions

    protected Category(){
        super();
        questions = new ArrayList<>();
    }

    public Category(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }


    /*** Getters and Setters  ***/

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question){
        question.setCategory(this);
        questions.add(question);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
