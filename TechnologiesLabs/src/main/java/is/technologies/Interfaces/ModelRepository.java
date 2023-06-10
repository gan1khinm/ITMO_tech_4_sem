package is.technologies.Interfaces;

import is.technologies.Entities.ModelEntity;

import java.util.List;

public interface ModelRepository {
    ModelEntity save(ModelEntity entity);
    void deleteById(long id);
    void deleteByEntity(ModelEntity entity);
    void deleteAll();
    ModelEntity update(ModelEntity entity);
    ModelEntity getById(long id);
    List<ModelEntity> getAll();
}
