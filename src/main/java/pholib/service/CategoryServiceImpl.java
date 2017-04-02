package pholib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pholib.dao.CategoryDao;
import pholib.model.Category;

import java.util.List;

/**
 * Created by melina on 3/31/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
