package pro.theori.curriculum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.theori.curriculum.repositories.SkillsMongoRepository;
import pro.theori.curriculum.skills.Skill;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SkillsMongoRepositoryTests {


    @Autowired
    private SkillsMongoRepository skillsMongoRepository;


    @Test
    public void testFetchData() {

        /*Test data retrieval*/
        List<Skill> skillsA = skillsMongoRepository.findBySenestAar(2018);
        assertFalse(skillsA.isEmpty());
        List<Skill> skillsB = skillsMongoRepository.findBySkillKategori(1);
        assertFalse(skillsB.isEmpty());
    }

    @Test
    public void testDataUpdate(){
        /*Test update*/
        Skill skillA = skillsMongoRepository.findByNavn("GIT");
        assertNotNull(skillA);
        skillA.setAntalAar(3);
        skillsMongoRepository.save(skillA);
        Skill skillB = skillsMongoRepository.findByNavn("GIT");
        assertNotNull(skillB);
        assertEquals(3,skillB.getAntalAar(), 0);
    }


}