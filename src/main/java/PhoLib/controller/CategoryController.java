package PhoLib.controller;

import PhoLib.data.CategoryRepository;
import PhoLib.data.PhoRepository;
import PhoLib.model.Category;
import PhoLib.model.Pho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PhoRepository phoRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String listCategories(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Pho> phos = phoRepository.findByCategoryId(id);
        modelMap.put("phos", phos);

        return "category";
    }
}
