package pholib.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pholib.model.Fav;
import pholib.model.Pho;
import pholib.model.User;

import java.util.List;

/**
 * Created by melina on 4/4/17.
 */
@Repository
public class FavDaoImpl implements FavDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void toggleFavorite(Pho pho, User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Fav fav = (Fav)session.createCriteria(Fav.class)
                    .add(Restrictions.eq("pho", pho))
                    .add(Restrictions.eq("user", user)).uniqueResult();
        System.out.println(fav);
        if (fav == null) {
            fav = new Fav();
            fav.setPho(pho);
            fav.setUser(user);
            session.save(fav);
        } else {
            session.delete(fav);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Pho> findFav(User user) {
        Session session = sessionFactory.openSession();
        String sql = String.format("SELECT * FROM pho WHERE id in (SELECT pho_id FROM fav WHERE user_id = %d)", user.getId());
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Pho.class);
        List<Pho> phos = query.list();
        session.close();
        return phos;
    }
}
