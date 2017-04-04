package pholib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pholib.dao.FavDao;
import pholib.model.Fav;
import pholib.model.Pho;
import pholib.model.User;

import java.util.List;

/**
 * Created by melina on 4/4/17.
 */
@Service
public class FavServiceImpl implements FavService {
    @Autowired
    FavDao favDao;

    @Override
    public void toggleFavorite(Pho pho, User user) {
        favDao.toggleFavorite(pho, user);
    }

    @Override
    public List<Pho> findFav(User user) {
        return favDao.findFav(user);
    }
}
