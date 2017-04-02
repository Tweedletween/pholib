package pholib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pholib.model.Pho;

import java.util.List;

/**
 * Created by melina on 4/1/17.
 */
@Repository
public class PhoDaoImpl implements PhoDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Pho> findAll() {
        Session session = sessionFactory.openSession();
        List<Pho> phos = session.createCriteria(Pho.class).list();
        session.close();
        return phos;
    }

    @Override
    public Pho findById(Long id) {
        Session session = sessionFactory.openSession();
        Pho pho = session.get(Pho.class, id);
        session.close();
        return pho;
    }

    @Override
    public void save(Pho pho) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(pho);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Pho pho) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(pho);
        session.getTransaction().commit();
        session.close();
    }
}
