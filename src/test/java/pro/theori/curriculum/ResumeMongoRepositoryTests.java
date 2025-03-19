package pro.theori.curriculum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.theori.curriculum.repositories.ResumeMongoRepository;
import pro.theori.curriculum.resume.Resume;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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