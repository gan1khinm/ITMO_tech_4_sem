package is.technologies.Controllers;

import is.technologies.Entities.BrandEntity;
import is.technologies.Interfaces.SpringData.BrandRepositoryDAO;
import is.technologies.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandEntityCRUD {

    private final BrandRepositoryDAO brandRepository;

    public BrandEntityCRUD(BrandRepositoryDAO brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping("/get")
    public List<BrandEntity> findAll(){
        List<BrandEntity> brands = brandRepository.findAll();
        return brands;
    }

    @GetMapping("/get/{id}")
    public Optional<BrandEntity> getById(@PathVariable("id") Long id) {
        Optional<BrandEntity> brand = brandRepository.findById(id);
        return brand;
    }

    @PostMapping("/create")
    public BrandEntity createBrand(@RequestBody BrandEntity brand){
        brandRepository.save(brand);
        return brand;
    }

    @PutMapping("/update")
    public BrandEntity updateBrand(@RequestBody BrandEntity brand){
        brandRepository.save(brand);
        return brand;
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteBrand(@PathVariable("id") Long id){
        brandRepository.deleteById(id);
    }
}

