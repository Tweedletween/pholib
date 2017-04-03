package pholib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pholib.dao.PhoDao;
import pholib.model.Pho;

import java.io.IOException;
import java.util.List;

/**
 * Created by melina on 4/1/17.
 */
@Service
public class PhoServiceImpl implements PhoService {
    @Autowired
    private PhoDao phoDao;

    @Override
    public List<Pho> findAll() {
        return phoDao.findAll();
    }

    @Override
    public Pho findById(Long id) {
        return phoDao.findById(id);
    }

    @Override
    public void save(Pho pho, MultipartFile file) {
        try {
            pho.setBytes(file.getBytes());
            phoDao.save(pho);
        } catch (IOException e) {
            System.err.println("Unable to get byte array form from uploaded file");
        }

    }

    @Override
    public void delete(Pho pho) {
        phoDao.delete(pho);
    }

    @Override
    public void toggleFavorite(Pho pho) {
        pho.setFavorite(!pho.isFavorite());
        phoDao.save(pho);
    }

    @Override
    public List<Pho> findFav() {
        return phoDao.findFav();
    }
}
