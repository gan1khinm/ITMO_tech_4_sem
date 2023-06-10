package is.technologies.MyBatis;

import is.technologies.Entities.ModelEntity;
import is.technologies.Interfaces.Mappers.ModelMapper;
import is.technologies.Interfaces.ModelRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ModelRepositoryMyBatis implements ModelRepository {

    public SqlSession session;
    public ModelMapper mapper;
    public ModelRepositoryMyBatis(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(ModelMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ModelEntity save(ModelEntity entity) {
        mapper.save(entity);
        session.commit();
        return entity;
    }

    public void deleteById(long id) {
        mapper.deleteById(id);
        session.commit();
    }

    public void deleteByEntity(ModelEntity entity) {
        mapper.deleteByEntity(entity);
        session.commit();
    }


    public void deleteAll() {
        mapper.deleteAll();
        session.commit();
    }

    public ModelEntity update(ModelEntity entity) {
        mapper.update(entity);
        session.commit();
        return entity;
    }

    public ModelEntity getById(long id) {
        ModelEntity entity = mapper.getById(id);
        session.commit();
        return entity;
    }

    public List<ModelEntity> getAll() {
        List<ModelEntity> entities = mapper.getAll();
        session.commit();
        return entities;
    }
}
