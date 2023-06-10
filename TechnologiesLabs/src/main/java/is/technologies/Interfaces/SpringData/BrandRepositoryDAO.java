package is.technologies.Interfaces.SpringData;

import is.technologies.Entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BrandRepositoryDAO extends JpaRepository<BrandEntity, Long> {
    public List<BrandEntity> getAllByName(String name);
}
