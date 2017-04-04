package pholib.dao;

import pholib.model.Pho;
import pholib.model.User;

import java.util.List;

/**
 * Created by melina on 4/4/17.
 */
public interface FavDao {
    void toggleFavorite(Pho pho, User user);
    List<Pho> findFav(User user);
}
