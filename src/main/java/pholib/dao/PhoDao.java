package pholib.dao;

import pholib.model.Pho;

import java.util.List;

/**
 * Created by melina on 4/1/17.
 */
public interface PhoDao {
    List<Pho> findAll();
    Pho findById(Long id);
    void save(Pho pho);
    void delete(Pho pho);
}
