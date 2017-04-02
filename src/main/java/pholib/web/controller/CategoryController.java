package pholib.web.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pholib.model.Category;
import pholib.model.Pho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pholib.service.CategoryService;
import pholib.web.Color;
import pholib.web.FlashMessage;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();

        model.addAttribute("categories",categories);
        return "category/index";
    }

    // Form for adding a new category
    @RequestMapping("categories/add")
    public String formNewCategory(Model model) {
        if(!model.containsAttribute("category")) {
            model.addAttribute("category",new Category());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action","/categories");
        model.addAttribute("heading","New Category");
        model.addAttribute("submit","Add");

        return "category/form";
    }

    // Form for editing an existing category
    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model) {
        if(!model.containsAttribute("category")) {
            model.addAttribute("category",categoryService.findById(categoryId));
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action", String.format("/categories/%s",categoryId));
        model.addAttribute("heading","Edit Category");
        model.addAttribute("submit","Edit");

        return "category/form";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Flash message
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category", result);
            // Save the typed data
            redirectAttributes.addFlashAttribute("category", category);
            // Redirect back to the form
            return "redirect:/categories/add";
        } else
        categoryService.save(category);

        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Category successfully added!", FlashMessage.Status.SUCCESS));

        return "redirect:/categories";
    }

    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.POST)
    public String EditCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Flash message
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category", result);
            // Save the typed data
            redirectAttributes.addFlashAttribute("category", category);
            // Redirect back to the form
            return String.format("redirect:/categories/%s/edit", category.getId());
        } else
            categoryService.save(category);

        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Category successfully updated!", FlashMessage.Status.SUCCESS));

        return "redirect:/categories";
    }
 }
