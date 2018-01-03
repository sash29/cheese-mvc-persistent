package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model){
        //retrieve the list of categories, and then pass the list into the view by adding it to model.
         model.addAttribute("categories",categoryDao.findAll());
         model.addAttribute("title", "Cheese Categories");

         //This view should display an unordered list (that is, a <ul>) of category names.
                return "/category/index";
    }

    @RequestMapping(value = "/add")
    public String add(Model model){

        model.addAttribute(new Category());
        model.addAttribute("title", "Add Category");
        return "/category/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Category");
            return "category/add";
        }
        categoryDao.save(category);
        return "/category/index";
    }

}

