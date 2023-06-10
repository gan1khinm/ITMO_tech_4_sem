package is.technologies.Hibernate;

import is.technologies.Entities.BrandEntity;
import is.technologies.Interfaces.BrandRepository;
import is.technologies.Utilities.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BrandRepositoryHibernate implements BrandRepository {

    public BrandEntity save(BrandEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return entity;
    }

    public void deleteById(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        BrandEntity entity = session.get(BrandEntity.class, id);
        session.delete(entity);

        transaction.commit();
        session.close();
    }

    public void deleteByEntity(BrandEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM BrandEntity";

        session.createQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    public BrandEntity update(BrandEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return entity;
    }

    public BrandEntity getById(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        var entity = session.get(BrandEntity.class, id);

        transaction.commit();
        session.close();
        return entity;
    }

    public List<BrandEntity> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<BrandEntity> entities = session.createNativeQuery("SELECT * from brand", BrandEntity.class).list();

        transaction.commit();
        session.close();

        return entities;
    }
}
