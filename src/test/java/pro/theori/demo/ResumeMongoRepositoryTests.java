package pro.theori.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.theori.demo.repositories.ResumeMongoRepository;
import pro.theori.demo.skills.Resume;
import pro.theori.demo.skills.Skill;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResumeMongoRepositoryTests {


    @Autowired
    private ResumeMongoRepository resumeMongoRepository;


    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        List<Resume> resumes = resumeMongoRepository.findAll();
        assertFalse(resumes.isEmpty());
    }
}