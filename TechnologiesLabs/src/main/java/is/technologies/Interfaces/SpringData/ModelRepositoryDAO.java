package is.technologies.Interfaces.SpringData;

import is.technologies.Entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepositoryDAO extends JpaRepository<ModelEntity, Long> {
    public List<ModelEntity> getAllById(long id);

    public List<ModelEntity> getAllByName(String name);
}
