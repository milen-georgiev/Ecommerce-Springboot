package com.ecommerce.admin.controller;

import com.ecommerce.library.model.Category;
import com.ecommerce.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal){
        if (principal == null) {
            return "redirect:/login";
        }
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        model.addAttribute("size", categoryList.size());
        model.addAttribute("title","Category");
        model.addAttribute("categoryNew", new Category());
        return "categories";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("categoryNew") Category category, RedirectAttributes attributes) {
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success","Added successfully");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed to add because duplicate name");
        }
        catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Error server");
        }

        return "redirect:/categories";
    }

    @RequestMapping(value = "/findById", method = {RequestMethod.PUT,RequestMethod.GET})
    @ResponseBody
    public Category getById(Long id) {
        return categoryService.findById(id);
    }
}
