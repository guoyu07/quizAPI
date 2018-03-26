package com.group15.core;

import com.group15.answer.Answer;
import com.group15.category.Category;
import com.group15.category.CategoryRepository;
import com.group15.question.Question;
import com.group15.question.QuestionRepository;
import com.group15.user.User;
import com.group15.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CategoryRepository categories;
    private final QuestionRepository questions;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CategoryRepository categories, QuestionRepository questions, UserRepository users) {
        this.categories = categories;
        this.questions = questions;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /** test data only **/

        /*** Test users list ***/
        // these users have standard permissions of read only
        List<User> standardUsers = Arrays.asList(
                new User("Christopher","Hunter","chunty12","chunty@email.com","password2" , "ROLE_USER"),
                new User("Jim","Devin","jdevin201","jd@email.com","password3" , "ROLE_USER"),
                new User("Sarah","Gillan","sgillan1","sgill@email.com","password4" , "ROLE_USER")
        );
        users.save(standardUsers);
        // this user has admin permissions of create read update delete
        users.save(new User("Michael","Lynch","mlynch202","mlynch@email.com","password1" , "ROLE_ADMIN"));

        /*** Test Users List end **/

        /*** Category 1 ***/
        Category category = new Category("Geography", "City and Country Trivia","#b39ddb");
        categories.save(category);
        // ------------------- //
        /*** Question 1 ***/
        Question question = new Question("What is the capital city of Scotland?");
        question.addAnswer(new Answer("Glasgow" , true));
        question.addAnswer(new Answer("Edinburgh", false));
        question.addAnswer(new Answer("Livingston", false));
        question.addAnswer(new Answer("Dundee",false));
        category.addQuestion(question);
        questions.save(question);
        /*** Question 1 end **/

        /*** Question 2 ***/
        Question question2 = new Question("What is the largest country in the world?");
        question2.addAnswer(new Answer("France", false));
        question2.addAnswer(new Answer("China", false));
        question2.addAnswer(new Answer("Russia" , true));
        question2.addAnswer(new Answer("Canada",false));
        category.addQuestion(question2);
        questions.save(question2);
        /*** Question 2 end **/

        /*** Question 3 ***/
        Question question3 = new Question("What is the smallest country in the world?");
        question3.addAnswer(new Answer("Malta" ,false));
        question3.addAnswer(new Answer("Japan",false));
        question3.addAnswer(new Answer("Iceland", false));
        question3.addAnswer(new Answer("Vatican City",true));
        category.addQuestion(question3);
        questions.save(question3);
        /*** Question 3 end **/
        /*** Category 1 end ***/

        /*** Category 2 ***/
        Category category2 = new Category("Animals", "Animal Trivia","#ffb74d");
        categories.save(category2);

        /*** Question 1 of Category 2 ***/
        Question question4 = new Question("What is the largest mammal in the world?");
        question4.addAnswer(new Answer("Elephant" , false));
        question4.addAnswer(new Answer("Blue Whale", true));
        question4.addAnswer(new Answer("Rhino", false));
        question4.addAnswer(new Answer("Giraffe",false));
        category2.addQuestion(question4);
        questions.save(question4);
        /*** Question 1 end **/

        /*** Question 2 ***/
        Question question5 = new Question("What is the fastest Animal on Earth?");
        question5.addAnswer(new Answer("Peregrine Falcon", true));
        question5.addAnswer(new Answer("Cheetah", false));
        question5.addAnswer(new Answer("Antelope" , true));
        question5.addAnswer(new Answer("Brown Hare",false));
        category2.addQuestion(question5);
        questions.save(question5);
        /*** Question 2 end **/

        /*** Question 3 ***/
        Question question6 = new Question("How many legs does a centipede have?");
        question6.addAnswer(new Answer("150" ,false));
        question6.addAnswer(new Answer("50",false));
        question6.addAnswer(new Answer("1000", false));
        question6.addAnswer(new Answer("100",true));
        category2.addQuestion(question6);
        questions.save(question6);
        /*** Question 3 end **/

        /*** Category 2 end ***/





    }
}
