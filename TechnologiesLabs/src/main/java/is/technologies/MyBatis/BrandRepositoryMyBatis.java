package is.technologies.MyBatis;

import is.technologies.Interfaces.Mappers.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import is.technologies.Entities.BrandEntity;
import is.technologies.Interfaces.BrandRepository;

import java.util.List;

public class BrandRepositoryMyBatis implements BrandRepository {
    public SqlSession session;
    public BrandMapper mapper;
    public BrandRepositoryMyBatis(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(BrandMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BrandEntity save(BrandEntity entity) {
        mapper.save(entity);
        session.commit();
        return entity;
    }

    public void deleteById(long id) {
        mapper.deleteById(id);
        session.commit();
    }

    public void deleteByEntity(BrandEntity entity) {
        mapper.deleteByEntity(entity);
        session.commit();
    }


    public void deleteAll() {
        mapper.deleteAll();
        session.commit();
    }

    public BrandEntity update(BrandEntity entity) {
        mapper.update(entity);
        session.commit();
        return entity;
    }

    public BrandEntity getById(long id) {
        BrandEntity entity = mapper.getById(id);
        session.commit();
        return entity;
    }

    public List<BrandEntity> getAll() {
        List<BrandEntity> entities = mapper.getAll();
        session.commit();
        return entities;
    }
}
