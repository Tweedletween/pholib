package pholib.service;

import pholib.model.Category;

import java.util.List;

/**
 * Created by melina on 3/31/17.
 */
public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);
}
