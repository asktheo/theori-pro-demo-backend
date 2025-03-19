package pro.theori.curriculum.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.theori.curriculum.repositories.SkillsMongoRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class SkillController {

    @Autowired
    private SkillsMongoRepository skillsMongoRepository;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/skills", method = RequestMethod.GET)
    public List<Skill> skills(){
        return skillsMongoRepository.findAll();
    }

    @RequestMapping(value="/skills/{kat}", method = RequestMethod.GET)
    public List<Skill> skill(@PathVariable int kat){
        return skillsMongoRepository.findBySkillKategori(kat);
    }

}
