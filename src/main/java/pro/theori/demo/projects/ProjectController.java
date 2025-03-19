package pro.theori.demo.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.theori.demo.repositories.ProjectMongoRepository;
import pro.theori.demo.resume.Resume;

import java.util.List;


@RestController
public class ProjectController {

    @Autowired
    private ProjectMongoRepository projectMongoRepository;

    @RequestMapping(value="/projects", method = RequestMethod.GET)
    public List<Project> projects(){
        return projectMongoRepository.findAll();
    }

}
