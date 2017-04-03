package pholib.service;

import org.springframework.web.multipart.MultipartFile;
import pholib.model.Pho;

import java.util.List;

/**
 * Created by melina on 4/1/17.
 */
public interface PhoService {
    List<Pho> findAll();
    Pho findById(Long id);
    void save(Pho pho, MultipartFile file);
    void delete(Pho pho);
    void toggleFavorite(Pho pho);
    List<Pho> findFav();
}
