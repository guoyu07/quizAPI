package com.group15.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @RequestMapping("")
    public String listQuestionsByCategory(){
        return "";
    }
}
