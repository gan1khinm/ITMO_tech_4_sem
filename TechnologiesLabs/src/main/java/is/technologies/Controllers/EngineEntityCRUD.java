package is.technologies.Controllers;

import is.technologies.Entities.EngineEntity;
import is.technologies.Interfaces.SpringData.EngineRepositoryDAO;
import is.technologies.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engines")
public class EngineEntityCRUD {
    private EngineRepositoryDAO engineRepository;

    public EngineEntityCRUD(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        engineRepository = applicationContext.getBean("engineRepositoryDAO", EngineRepositoryDAO.class);
    }

    @GetMapping("/get")
    public String findAll(Model model){
        List<EngineEntity> engines = engineRepository.findAll();
        model.addAttribute("engines", engines);
        return "engine-list";
    }

    @GetMapping("/get/{id}")
    public EngineEntity getById(@PathVariable("id") Long id) {
        EngineEntity engine = engineRepository.getById(id);
        return engine;
    }

    @PostMapping("/create")
    public EngineEntity createEngine(@RequestBody EngineEntity engine){
        engineRepository.save(engine);
        return engine;
    }

    @PostMapping("/update")
    public EngineEntity updateEngine(@RequestBody EngineEntity engine){
        engineRepository.save(engine);
        return engine;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEngine(@PathVariable("id") Long id){
        engineRepository.deleteById(id);
    }
}
