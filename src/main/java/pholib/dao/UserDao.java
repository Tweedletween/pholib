package pholib.dao;

import pholib.model.User;

/**
 * Created by melina on 4/3/17.
 */
public interface UserDao {
    User findByUsername(String username);
}
