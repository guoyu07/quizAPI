package com.group15.category;

import com.group15.answer.Answer;
import com.group15.answer.AnswerRepository;
import com.group15.question.Question;
import com.group15.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;


    // List all the categories
    @RequestMapping("/categories")
    public String listCategories(Model model){
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    // Get a single category
    @RequestMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model){
        Category category = categoryRepository.findOne(id);
        model.addAttribute("category", category);
        // get the questions
        Iterable<Question> questions = questionRepository.findByCategoryTitle(category.getTitle(),new PageRequest(1,1));
        model.addAttribute("questions", questions);
        return "category/categoryWithQuestions";
    }

    // form new category
    @RequestMapping("/categories/add")
    public String formNewCategory(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("colours", Colour.values());
        return "category/form";
    }

    // Add a category
    @RequestMapping(value = "/categories" , method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes){
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    // delete a category
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable Long id, Model model){
        Category category = categoryRepository.findOne(id);
        categoryRepository.delete(category);
        return "redirect:/categories";
    }
}
