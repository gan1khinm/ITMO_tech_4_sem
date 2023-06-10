package is.technologies.Interfaces.SpringData;

import is.technologies.Entities.EngineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineRepositoryDAO extends JpaRepository<EngineEntity, Long> {

    public List<EngineEntity> getAllById(long id);

    public List<EngineEntity> getAllByName(String name);
}
