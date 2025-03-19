package pro.theori.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.demo.resume.Resume;

public interface ResumeMongoRepository extends MongoRepository<Resume, Integer> {

}
