package com.group15.question;

import com.group15.answer.Answer;
import com.group15.category.Category;
import com.group15.core.BaseEntityModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question extends BaseEntityModel {

    // This is the question that we ask the user
    // For example "What is the capital city of Scotland?"
    @NotNull(message = "You must enter a question title")
    @Size(min = 2 , max = 140, message = "The question title must be between 2 - 140 characters")
    private String title;
    private LocalDateTime dateUploaded = LocalDateTime.now();

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

    public LocalDateTime getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDateTime dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getTimeSinceUploaded() {
        String unit = "";
        LocalDateTime now = LocalDateTime.now();
        long diff;
        if((diff = ChronoUnit.SECONDS.between(dateUploaded,now)) < 60){
            unit = "secs";
        } else if ((diff = ChronoUnit.MINUTES.between(dateUploaded,now)) < 60) {
            unit = "mins";
        } else if ((diff = ChronoUnit.HOURS.between(dateUploaded,now)) < 24) {
            unit = "hours";
        } else if ((diff = ChronoUnit.DAYS.between(dateUploaded,now)) < 30) {
            unit = "days";
        } else if ((diff = ChronoUnit.MONTHS.between(dateUploaded,now)) < 12) {
            unit = "months";
        } else{
            diff = ChronoUnit.YEARS.between(dateUploaded,now);
        }
        return String.format("%d %s",diff,unit);
    }

}
