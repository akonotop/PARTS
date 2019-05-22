package partslist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import partslist.model.Part;

import java.util.List;

@Repository
public class PartDAOImpl implements PartDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Part> allParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part")
                .setFirstResult(10 * (page - 1))
                .setMaxResults(10)
                .list();
    }

    @Override
    public List<Part> findByName(String name) {
        List<Part> result = null;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Part where name = :name");
        query.setParameter("name", name);
        result = query.list();
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Part> allTrueParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Part WHERE importance = true")
                .setFirstResult(10 * (page - 1))
                        .setMaxResults(10).list();
    }

    @Override
    public List<Part> allFalseParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Part WHERE importance = false")
                .setFirstResult(10 * (page - 1))
                .setMaxResults(10).list();
    }

    @Override
    public void add(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(part);
    }

    @Override
    public void delete(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);
    }

    @Override
    public void edit(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.update(part);
    }

    @Override
    public Part getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Part.class, id);
    }

    @Override
    public int compsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT min(p.count) FROM Part p where p.importance = true ", Number.class)
                .getSingleResult()
                .intValue();
    }

    @Override
    public int partsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Part", Number.class)
                .getSingleResult()
                .intValue();
    }

    @Override
    public boolean checkName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Part where name = :name");
        query.setParameter("name", name);
        return query.list().isEmpty();
    }

}
