package pholib.web.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ui.Model;
import pholib.model.Category;
import pholib.model.Pho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Controller
public class CategoryController {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        // TODO: Get all categories
        Session session = sessionFactory.openSession();

        List<Category> categories = session.createCriteria(Category.class).list();

        model.addAttribute("categories",categories);
        return "category/index";
    }
}
