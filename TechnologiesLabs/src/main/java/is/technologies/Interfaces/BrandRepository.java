package is.technologies.Interfaces;

import is.technologies.Entities.BrandEntity;

import java.util.List;

public interface BrandRepository {
    BrandEntity save(BrandEntity entity);
    void deleteById(long id);
    void deleteByEntity(BrandEntity entity);
    void deleteAll();
    BrandEntity update(BrandEntity entity);
    BrandEntity getById(long id);
    List<BrandEntity> getAll();
}
