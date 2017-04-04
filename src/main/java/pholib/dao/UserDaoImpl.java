package pholib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pholib.model.Pho;
import pholib.model.User;



/**
 * Created by melina on 4/3/17.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, username);
        session.close();
        return user;
    }
}
