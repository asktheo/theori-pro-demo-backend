package pro.theori.demo.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.theori.demo.repositories.ResumeMongoRepository;
import pro.theori.demo.repositories.SkillsMongoRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class ResumeController {

    @Autowired
    private ResumeMongoRepository resumeMongoRepository;

    @RequestMapping(value="/resumes", method = RequestMethod.GET)
    public List<Resume> resumes(){
        return resumeMongoRepository.findAll();
    }

}
