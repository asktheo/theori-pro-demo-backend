package pro.theori.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.theori.demo.projects.Project;
import pro.theori.demo.repositories.ProjectMongoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProjectMongoRepositoryTests {


    @Autowired
    private ProjectMongoRepository projectMongoRepository;


    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        List<Project> resumes = projectMongoRepository.findAll();
        assertTrue(resumes.size() >= 11);
    }
}