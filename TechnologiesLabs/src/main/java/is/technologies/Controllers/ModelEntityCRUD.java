package is.technologies.Controllers;

import is.technologies.Entities.EngineEntity;
import is.technologies.Entities.ModelEntity;
import is.technologies.Interfaces.SpringData.ModelRepositoryDAO;
import is.technologies.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelEntityCRUD {
    private ModelRepositoryDAO modelRepository;

    public ModelEntityCRUD(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        modelRepository = applicationContext.getBean("modelRepositoryDAO", ModelRepositoryDAO.class);
    }

    /*@GetMapping("/get")
    public List<ModelEntity> findAll(){
        List<ModelEntity> models = modelRepository.findAll();
        return models;
    }*/

    @GetMapping("/get")
    public List<ModelEntity> findAll(Model model){
        List<ModelEntity> models = modelRepository.findAll();
        model.addAttribute("models", models);
        return models;
    }

    @GetMapping("/get/{id}")
    public ModelEntity getById(@PathVariable("id") Long id) {
        ModelEntity modelEntity = modelRepository.getById(id);
        return modelEntity;
    }

    @PostMapping("/create")
    public ModelEntity createModel(@RequestBody ModelEntity model){
        modelRepository.save(model);
        return model;
    }

    @PostMapping("/update")
    public ModelEntity updateModel(@RequestBody ModelEntity model){
        modelRepository.save(model);
        return model;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModel(@PathVariable("id") Long id){
        modelRepository.deleteById(id);
    }
}
