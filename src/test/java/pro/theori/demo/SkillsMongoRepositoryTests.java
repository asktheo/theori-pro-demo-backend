package pro.theori.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.theori.demo.repositories.SkillsMongoRepository;
import pro.theori.demo.skills.Skill;
import pro.theori.demo.skills.SkillKategori;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillsMongoRepositoryTests {


    @Autowired
    private SkillsMongoRepository skillsMongoRepository;


    @Test
    public void testFetchData(){
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