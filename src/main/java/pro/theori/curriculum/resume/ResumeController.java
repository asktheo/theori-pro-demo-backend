package pro.theori.curriculum.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.theori.curriculum.repositories.ResumeMongoRepository;

import java.util.List;


@RestController
public class ResumeController {

    @Autowired
    private ResumeMongoRepository resumeMongoRepository;

    @RequestMapping(value="/resumes", method = RequestMethod.GET)
    public List<Resume> resumes(){
        return resumeMongoRepository.findAll();
    }

}
