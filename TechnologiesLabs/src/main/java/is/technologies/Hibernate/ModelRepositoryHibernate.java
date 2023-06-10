package is.technologies.Hibernate;

import is.technologies.Entities.ModelEntity;
import is.technologies.Interfaces.ModelRepository;
import is.technologies.Utilities.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ModelRepositoryHibernate implements ModelRepository {

    public ModelEntity save(ModelEntity entity) {
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

        ModelEntity entity = session.get(ModelEntity.class, id);
        session.delete(entity);

        transaction.commit();
        session.close();
    }

    public void deleteByEntity(ModelEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();
    }


    public void deleteAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM ModelEntity";

        session.createQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    public ModelEntity update(ModelEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return entity;
    }

    public ModelEntity getById(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        var entity = session.get(ModelEntity.class, id);

        transaction.commit();
        session.close();
        return entity;
    }

    public List<ModelEntity> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<ModelEntity> entities = session.createNativeQuery("SELECT * from model", ModelEntity.class).list();

        transaction.commit();
        session.close();

        return entities;
    }
}
